package servlets;

import enums.Page;
import enums.PolicyholderCredential;
import utils.ServletUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/views/")
public class SessionFilterServlet implements Filter {
    @Override
    public void init(javax.servlet.FilterConfig filterConfig){}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        if(httpServletRequest.getSession().getAttribute(PolicyholderCredential.ID.getPolicyholderCredential()) == null){
            //TODO Добавить переход на инфо-страницу, что сессия не инициализирована с просьбой залогинитья и кнопкой перехода на главную страницу
            ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.INDEX_PAGE.getPage());
        } else {
            chain.doFilter(servletRequest, servletResponse);
        }
    }
    @Override
    public void destroy(){}
}
