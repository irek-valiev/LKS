package servlets;

import beans.Account;
import beans.Policyholder;
import beans.ReplenishData;
import dao.AccountDAO;
import dao.PolicyholderDAO;
import dao.ReplenishDataDAO;
import dao.TransferDataDAO;
import enums.AccountInfo;
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
 * Сервлет для обработки пополнения счета
 */
@WebServlet(name = "replenish", urlPatterns = "/replenish")
public class ReplenishServlet extends HttpServlet {


    /**
     * Метод обработки POST-запроса
     * @param httpServletRequest запрос
     * @param httpServletResponse ответ
     */
    @Override
    public void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        String sum = httpServletRequest.getParameter(AccountInfo.REPLENISH_SUM.getAccountInfo());
        String delimeter = ",";
        String[] subStr = sum.split(delimeter);
        if(subStr.length == 2 ){
            sum = String.join(".", subStr[0], subStr[1]);
        }
        AccountDAO accountDAO = new AccountDAO();
        ReplenishDataDAO replenishDataDAO = new ReplenishDataDAO();
        PolicyholderDAO policyholderDAO = new PolicyholderDAO();
        try {
            Account currentAccount = accountDAO.getById((Integer) httpServletRequest.getSession().getAttribute(PolicyholderCredential.ACCOUNT_ID.getPolicyholderCredential()));
            AccountProcessor.replenishAccount(currentAccount, Double.parseDouble(sum));
            accountDAO.update(currentAccount);
            Policyholder policyholder = policyholderDAO.getById((Integer) httpServletRequest.getSession().getAttribute(PolicyholderCredential.ID.getPolicyholderCredential()));
            ReplenishData replenishData = new ReplenishData(policyholder, Double.parseDouble(sum), new Date());
            replenishDataDAO.insert(replenishData);
            ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.SUCCESS_TRANSACTION_PAGE.getPage());
        } catch (Exception e){
            ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.ERROR_PAGE.getPage());
        }
    }
}
