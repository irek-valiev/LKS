package servlets;

import enums.Page;
import utils.ServletUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "logout", urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doPost ( HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        httpServletRequest.getSession().invalidate();
        ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.INDEX_PAGE.getPage());
    }
}
