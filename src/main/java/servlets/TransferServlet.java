package servlets;

import beans.Account;
import beans.Policyholder;
import beans.TransferData;
import dao.AccountDAO;
import dao.PolicyholderDAO;
import dao.TransferDataDAO;
import enums.Page;
import enums.PolicyholderCredential;
import processors.AccountProcessor;
import utils.ServletUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Сервлет для обработки перевода
 */
@WebServlet(name = "transfer", urlPatterns = "/transfer")
public class TransferServlet extends HttpServlet {
    /**
     *  Метод обработки POST-запроса
     * @param httpServletRequest запрос
     * @param httpServletResponse ответ
     */
    public void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        int fromPolicyholderId = (Integer) httpServletRequest.getSession().getAttribute(PolicyholderCredential.ID.getPolicyholderCredential());
        int fromPolicyholderAccountId = (Integer) httpServletRequest.getSession().getAttribute(PolicyholderCredential.ACCOUNT_ID.getPolicyholderCredential());
        int toPolicyholderAccountId = Integer.parseInt(httpServletRequest.getParameter("toPolicyholder"));
        String transferSum = httpServletRequest.getParameter("transferSum");
        String delimeter = ",";
        String[] subStr = transferSum.split(delimeter);
        if(subStr.length == 2 ){
            transferSum = String.join(".", subStr[0], subStr[1]);
        }
        AccountDAO accountDAO = new AccountDAO();
        TransferDataDAO transferDataDAO = new TransferDataDAO();
        PolicyholderDAO policyholderDAO = new PolicyholderDAO();
        try {
            Account fromPolicyholderAccount = accountDAO.getById(fromPolicyholderAccountId);
            Account toPolicyholderAccount = accountDAO.getById(toPolicyholderAccountId);
            Policyholder fromPolicyholder = policyholderDAO.getById(fromPolicyholderId);
            Policyholder toPolicyholder = policyholderDAO.getById(policyholderDAO.getByAccountId(toPolicyholderAccountId).getId());
            AccountProcessor.transferMoney(fromPolicyholderAccount, toPolicyholderAccount, Double.parseDouble (transferSum));
            accountDAO.update(fromPolicyholderAccount);
            accountDAO.update(toPolicyholderAccount);
            TransferData transferData = new TransferData(fromPolicyholder, toPolicyholder, Double.parseDouble (transferSum), new Date());
            transferDataDAO.insert(transferData);
            ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.SUCCESS_TRANSACTION_PAGE.getPage());
        } catch (Exception e){
            ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.ERROR_PAGE.getPage());
        }

    }
}
