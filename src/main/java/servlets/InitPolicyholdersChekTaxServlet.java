package servlets;

import beans.Okved;
import dao.OkvedDAO;
import enums.Page;
import utils.ServletUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Сервлет для инициализации элемента select
 */
@WebServlet(name = "initPolicyholdersChekTax", urlPatterns = "/initPolicyholdersChekTax")
public class InitPolicyholdersChekTaxServlet extends HttpServlet {
    /**
     * Метод обработки GET-запроса
     * @param httpServletRequest запрос
     * @param httpServletResponse ответ
     */
    @Override
    public void doGet (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        OkvedDAO okvedDAO = new OkvedDAO();
        List<Okved> allOkveds = okvedDAO.getAll();
        httpServletRequest.setAttribute("allOkveds", allOkveds);
        RequestDispatcher dispatcher = httpServletRequest.getRequestDispatcher("views/core/chektax.jsp");
        try {
            dispatcher.forward(httpServletRequest, httpServletResponse);
        } catch (ServletException e){
            ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.ERROR_PAGE.getPage());
        } catch (IOException e){
            ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.ERROR_PAGE.getPage());
        }
    }
    }

