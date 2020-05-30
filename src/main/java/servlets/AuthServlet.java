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
        try {
            policyholder = policyholderDAO.get(policyholderLogin, policyholderPsswd);
            if(policyholder != null){
                //TODO Вывести на GUI предупреждение "Проблемы с БД, обратись к админу"
            }
        }catch (UnregistredPolicyholderException | UnregistredAccountException e){
            //TODO Вывести на GUI предупреждение с незарегистрирвоным клиентом
            log.error(e.getMessage());
        }
        HttpSession httpSession = httpServletRequest.getSession();
        SessionUtil.fillSession(httpSession, policyholder);
        ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.SUCCESS_AUTH_PAGE.getPage());
    }
}
