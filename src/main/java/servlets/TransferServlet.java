package servlets;

import enums.PolicyholderCredential;

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

    }
}
