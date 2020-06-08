package servlets;

import beans.Policyholder;
import dao.PolicyholderDAO;
import enums.Page;
import enums.PolicyholderCredential;
import exceptions.UnregistredAccountException;
import exceptions.UnregistredPolicyholderException;
import lombok.extern.slf4j.Slf4j;
import utils.ServletUtil;
import utils.SessionUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Сервлет для аутентификации пользователя
 */
@Slf4j
@WebServlet(name = "auth", urlPatterns = "/auth")
public class AuthServlet extends HttpServlet {

    /**
     * Метод обработки POST-запроса
     * @param httpServletRequest запрос
     * @param httpServletResponse ответ
     * @throws IOException ошибка перенаправления на другую страницу
     */
    @Override
    protected void doPost (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        String policyholderLogin = httpServletRequest.getParameter(PolicyholderCredential.LOGIN.getPolicyholderCredential());
        String policyholderPsswd = httpServletRequest.getParameter(PolicyholderCredential.PSSWD.getPolicyholderCredential());
        PolicyholderDAO policyholderDAO = new PolicyholderDAO();
        Policyholder policyholder = null;
        if(isPolicyholderAttributeNull(policyholderLogin, policyholderPsswd)){
            ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.ERROR_EMPTY_AUTH.getPage());
        } else {
            if (isLoginPswdUsed(policyholderLogin, policyholderPsswd)){
                try {
                    policyholder = policyholderDAO.get(policyholderLogin, policyholderPsswd);
                }catch (UnregistredPolicyholderException | UnregistredAccountException e){
                    //TODO Вывести на GUI предупреждение с незарегистрирвоным клиентом
                    ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.ERROR_PAGE.getPage());
                    log.error(e.getMessage());
                }
                if(policyholder == null){
                    ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.ERROR_NULL_PAGE.getPage());
                } else {
                    HttpSession httpSession = httpServletRequest.getSession();
                    SessionUtil.fillSession(httpSession, policyholder);
                    ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.SUCCESS_AUTH_PAGE.getPage());
                }
            } else {
                log.error("Ошибка при попытке авторизоваться");
                ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.ERROR_AUTH_PAGE.getPage());
            }
            }
            }


    private boolean isPolicyholderAttributeNull (String login, String psswd){
        if(login.equals("")){
            return true;
        } else if(psswd.equals("")){
            return true;
        } else return false;
    }
    private boolean isLoginPswdUsed(String login, String psswd){
        PolicyholderDAO policyholderDAO = new PolicyholderDAO();
        List<Policyholder> allPolicyholder = policyholderDAO.getAll();
        Policyholder currentPolicyholder = null;
        if(allPolicyholder.stream().map(Policyholder::getLogin).anyMatch(x -> x.equalsIgnoreCase(login))){
            try {
               currentPolicyholder =  policyholderDAO.getByLogin(login);
            } catch (NullPointerException | UnregistredPolicyholderException e){
                log.error("Ошибка при определении соответствия логина паролю");
            }
            if (currentPolicyholder == null){
              return false;
            } else if((currentPolicyholder.getPsswd()).equals(psswd)){
                return true;
            } else return false;

        } return false;

    }

}
