package servlets;

import beans.Account;
import dao.AccountDAO;
import enums.Page;
import enums.PolicyholderCredential;
import processors.AccountProcessor;
import utils.ServletUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        int fromPolicyholderAccountId = (Integer) httpServletRequest.getSession().getAttribute(PolicyholderCredential.ACCOUNT_ID.getPolicyholderCredential());
        int toPolicyholderAccountId = Integer.parseInt(httpServletRequest.getParameter("toPolicyholder"));
        int transferSum = Integer.parseInt(httpServletRequest.getParameter("transferSum"));
        AccountDAO accountDAO = new AccountDAO();
        try {
            Account fromPolicyholderAccount = accountDAO.getById(fromPolicyholderAccountId);
            Account toPolicyholderAccount = accountDAO.getById(toPolicyholderAccountId);
            AccountProcessor.transferMoney(fromPolicyholderAccount, toPolicyholderAccount, transferSum);
            accountDAO.update(fromPolicyholderAccount);
            accountDAO.update(toPolicyholderAccount);
            ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.SUCCESS_TRANSACTION_PAGE.getPage());
        } catch (Exception e){
            ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.ERROR_PAGE.getPage());
        }

    }
}
