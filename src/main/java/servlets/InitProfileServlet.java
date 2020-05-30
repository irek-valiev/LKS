package servlets;

import beans.Policyholder;
import dao.PolicyholderDAO;
import enums.Page;
import enums.PolicyholderCredential;
import utils.ServletUtil;
import utils.SessionUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet (name = "initProfile", urlPatterns = "/initProfile")
public class InitProfileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        try {
            PolicyholderDAO policyholderDAO = new PolicyholderDAO();
            Policyholder currentPolicyholder = policyholderDAO.getById((Integer) httpServletRequest.getSession().getAttribute(PolicyholderCredential.ID.getPolicyholderCredential()));
            SessionUtil.fillSession(httpServletRequest.getSession(), currentPolicyholder);
            ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.PROFILE_PAGE.getPage());
        } catch (Exception e){
            ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.ERROR_PAGE.getPage());
        }
    }
}
