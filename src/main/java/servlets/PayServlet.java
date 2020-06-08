package servlets;

import beans.PayData;
import beans.Policyholder;
import dao.AccountDAO;
import dao.PayDataDAO;
import enums.Page;
import lombok.extern.slf4j.Slf4j;
import processors.AccountProcessor;
import utils.ServletUtil;
import utils.SessionUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Сервлет для обратотки оплаты
 */
@Slf4j
@WebServlet(name = "pay", urlPatterns = "/pay")
public class PayServlet extends HttpServlet {
    /**
     * Метод обработки POST-запроса
     * @param httpServletRequest запрос
     * @param httpServletResponse ответ
     */
    @Override
    protected void doPost (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        String payTargetCount = httpServletRequest.getParameter("payTargetCount");
        String paySum = httpServletRequest.getParameter("paySum");
        PayDataDAO payDataDAO = new PayDataDAO();
        try {
            Policyholder payPolicyholder = SessionUtil.getPolicyholderFromSession(httpServletRequest.getSession());
            AccountProcessor.withdrawalAccount(payPolicyholder.getAccount(), Integer.parseInt(paySum));
            AccountDAO accountDAO = new AccountDAO();
            accountDAO.update(payPolicyholder.getAccount());
            PayData payData = new PayData(payPolicyholder, payTargetCount, Integer.parseInt(paySum), new Date());
            payDataDAO.insert(payData);
            ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.SUCCESS_TRANSACTION_PAGE.getPage());
        }catch (Exception e){
            ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.ERROR_PAGE.getPage());
        }
    }
}
