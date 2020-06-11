package servlets;

import beans.Account;
import dao.AccountDAO;
import enums.AccountInfo;
import enums.Page;
import enums.PolicyholderCredential;
import processors.AccountProcessor;
import utils.ServletUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Сервлет для обработки снятия средств
 */
@WebServlet(name = "withdrawal", urlPatterns = "/withdrawal")
public class WihtdrawalServlet extends HttpServlet {
    /**
     * Метод обработки POST-запроса
     * @param httpServletRequest запрос
     * @param httpServletResponse ответ
     */
    @Override
    public void doPost (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        String sum = httpServletRequest.getParameter(AccountInfo.WITHDRAWAL_SUM.getAccountInfo());
        String delimeter = ",";
        String[] subStr = sum.split(delimeter);
        if(subStr.length == 2 ){
            sum = String.join(".", subStr[0], subStr[1]);
        }
        AccountDAO accountDAO = new AccountDAO();
        try {
            Account currentAccount  = accountDAO.getById((Integer) httpServletRequest.getSession().getAttribute(PolicyholderCredential.ACCOUNT_ID.getPolicyholderCredential()));
            AccountProcessor.withdrawalAccount(currentAccount, Double.parseDouble(sum));
            accountDAO.update(currentAccount);
            ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.SUCCESS_TRANSACTION_PAGE.getPage());
        } catch (Exception e){
            ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.ERROR_PAGE.getPage());
        }
    }
}
