package servlets;

import beans.Policyholder;
import dao.PolicyholderDAO;
import enums.Page;
import enums.PolicyholderCredential;
import utils.ServletUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервлет для инициализации элемента select
 */
@WebServlet(name = "initPolicyholdersTransfer", urlPatterns = "/initPolicyholdersTransfer")
public class InitPolicyholdersTransferServlet extends HttpServlet {
    /**
     * Метод обработки GET-запроса
     * @param httpServletRequest запрос
     * @param httpServletResponse ответ
     */
    @Override
    public void doGet (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        PolicyholderDAO policyholderDAO = new PolicyholderDAO();
        List<Policyholder> allPolicyholders = policyholderDAO.getAll();
        List<Policyholder> policyholdersWihtoutCurrent = allPolicyholders.stream()
                .filter(x -> x.getId() != (int) httpServletRequest.getSession()
                        .getAttribute(PolicyholderCredential.ID.getPolicyholderCredential())).
                        collect(Collectors.toList());
        httpServletRequest.setAttribute("allPolicyholders", policyholdersWihtoutCurrent);
        RequestDispatcher dispatcher = httpServletRequest.getRequestDispatcher("views/core/transfer.jsp");
        try {
            dispatcher.forward(httpServletRequest, httpServletResponse);
        } catch (ServletException e){
            ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.ERROR_PAGE.getPage());
        } catch (IOException e){
            ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.ERROR_PAGE.getPage());
        }
    }
}
