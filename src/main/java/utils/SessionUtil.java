package utils;

import beans.Account;
import beans.Policyholder;
import dao.AccountDAO;
import enums.AccountInfo;
import enums.Page;
import enums.PolicyholderCredential;
import exceptions.UnregistredAccountException;
import exceptions.UnregistredPolicyholderException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Утилитный класс для работы с сессией
 */
public class SessionUtil {

    /**
     * Метод для считывания аутентификационных данных
     * @param httpServletRequest запрос
     * @return мапа с аутентификационными данными
     */
    public static Map<String, String> readPolicyholderCredentials (HttpServletRequest httpServletRequest){
        Map <String, String> result = new HashMap<>();
        String policyholderNameOfCompany = httpServletRequest.getParameter(PolicyholderCredential.NAME_OF_COMPANY.getPolicyholderCredential());
        String policyholderInn = httpServletRequest.getParameter(PolicyholderCredential.INN.getPolicyholderCredential());
        String policyholderDirector = httpServletRequest.getParameter(PolicyholderCredential.DIRECTOR.getPolicyholderCredential());
        String policyholderLogin = httpServletRequest.getParameter(PolicyholderCredential.LOGIN.getPolicyholderCredential());
        String policyholderPsswd = httpServletRequest.getParameter(PolicyholderCredential.PSSWD.getPolicyholderCredential());
        result.put(PolicyholderCredential.NAME_OF_COMPANY.getPolicyholderCredential(), policyholderNameOfCompany);
        result.put(PolicyholderCredential.INN.getPolicyholderCredential(), policyholderInn);
        result.put(PolicyholderCredential.DIRECTOR.getPolicyholderCredential(), policyholderDirector);
        result.put(PolicyholderCredential.LOGIN.getPolicyholderCredential(), policyholderLogin);
        result.put(PolicyholderCredential.PSSWD.getPolicyholderCredential(), policyholderPsswd);
        return result;
        }

    /**
     * Метод заполнения сессии данными
     * @param httpSession сессия
     * @param policyholder клиент
     */
    public static void fillSession(HttpSession httpSession, Policyholder policyholder){
            httpSession.setAttribute(PolicyholderCredential.ID.getPolicyholderCredential(), policyholder.getId());
            httpSession.setAttribute(PolicyholderCredential.NAME_OF_COMPANY.getPolicyholderCredential(), policyholder.getNameOfCompany());
            httpSession.setAttribute(PolicyholderCredential.INN.getPolicyholderCredential(), policyholder.getInn());
            httpSession.setAttribute(PolicyholderCredential.DIRECTOR.getPolicyholderCredential(), policyholder.getDirector());
            httpSession.setAttribute(PolicyholderCredential.LOGIN.getPolicyholderCredential(), policyholder.getLogin());
            httpSession.setAttribute(PolicyholderCredential.PSSWD.getPolicyholderCredential(), policyholder.getPsswd());
            httpSession.setAttribute(PolicyholderCredential.ACCOUNT_ID.getPolicyholderCredential(), policyholder.getAccount().getId());
            httpSession.setAttribute(AccountInfo.ACCOUNT_NUMBER.getAccountInfo(), policyholder.getAccount().getAccountNumber());
            httpSession.setAttribute(AccountInfo.SUM.getAccountInfo(), policyholder.getAccount().getSum());
            httpSession.setMaxInactiveInterval(300);
    }

    /**
     * Метод получения страхователя из сессии
     */
    public static Policyholder getPolicyholderFromSession(HttpSession httpSession) throws UnregistredAccountException {
        AccountDAO accountDAO = new AccountDAO();
        Account account = accountDAO.getById((int) httpSession.getAttribute(PolicyholderCredential.ACCOUNT_ID.getPolicyholderCredential()));
        return new Policyholder((int) httpSession.getAttribute(PolicyholderCredential.ID.getPolicyholderCredential()),
                (String) httpSession.getAttribute(PolicyholderCredential.NAME_OF_COMPANY.getPolicyholderCredential()),
                (String) httpSession.getAttribute(PolicyholderCredential.INN.getPolicyholderCredential()),
                (String) httpSession.getAttribute(PolicyholderCredential.DIRECTOR.getPolicyholderCredential()),
                account);
    }
}
