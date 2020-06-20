package servlets;

import beans.Account;
import beans.Policyholder;
import dao.AccountDAO;
import dao.PolicyholderDAO;
import enums.Page;
import enums.PolicyholderCredential;
import exceptions.RegException;
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
import java.util.concurrent.ThreadLocalRandom;

/**
 * Сервлет для страницы регистрации
 */
@Slf4j
@WebServlet(name = "regPolicyholder", urlPatterns = "/regPolicyholder")
public class RegPolicyholderServlet extends HttpServlet {

    /**
     * Метод обработки POST-запроса
     * @param httpServletRequest запрос
     * @param httpServletResponse ответ
     * @throws IOException
     */
    @Override
    protected void doPost (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        Map<String, String> policyholderCridentials = SessionUtil.readPolicyholderCredentials(httpServletRequest);
        if (isPolicyholderAttributeNull((policyholderCridentials.get(PolicyholderCredential.LOGIN.getPolicyholderCredential())),
                (policyholderCridentials.get(PolicyholderCredential.PSSWD.getPolicyholderCredential())),
                (policyholderCridentials.get(PolicyholderCredential.NAME_OF_COMPANY.getPolicyholderCredential())),
                (policyholderCridentials.get(PolicyholderCredential.INN.getPolicyholderCredential())),
                (policyholderCridentials.get(PolicyholderCredential.DIRECTOR.getPolicyholderCredential())))){
            ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.ERROR_EMPTY_REG.getPage());
        } else {
            if(isLoginAlreadyExist(policyholderCridentials.get(PolicyholderCredential.LOGIN.getPolicyholderCredential()))){
                ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.ERROR_REG_PAGE.getPage());
            }else {
                AccountDAO accountDAO = new AccountDAO();
                List<Account> allAccountsNumbers = accountDAO.getAll();
                int accountNumber;
                Account currentAccount;
                do{
                    accountNumber = ThreadLocalRandom.current().nextInt(10000, 99999);
                    currentAccount = new Account(accountNumber);
                } while (allAccountsNumbers.contains(currentAccount));
                accountDAO.insert(currentAccount);
                try {
                    currentAccount = accountDAO.get(String.valueOf(accountNumber));
                } catch (Exception e) {
                    log.error("Ошибка при попытке получить объект счета по номеру " + accountNumber);
                }
                Policyholder policyholder = null;
                try {
                    policyholder = new Policyholder(
                            policyholderCridentials.get(PolicyholderCredential.LOGIN.getPolicyholderCredential()),
                            policyholderCridentials.get(PolicyholderCredential.PSSWD.getPolicyholderCredential()),
                            policyholderCridentials.get(PolicyholderCredential.NAME_OF_COMPANY.getPolicyholderCredential()),
                            policyholderCridentials.get(PolicyholderCredential.INN.getPolicyholderCredential()),
                            policyholderCridentials.get(PolicyholderCredential.DIRECTOR.getPolicyholderCredential()),
                            currentAccount);
                    PolicyholderDAO policyholderDAO = new PolicyholderDAO();
                    policyholderDAO.insert(policyholder);
                } catch (RegException e){
                    ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.ERROR_PAGE.getPage());
                }
                HttpSession httpSession = httpServletRequest.getSession();
                SessionUtil.fillSession(httpSession, policyholder);
                ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.SUCCESS_REG_PAGE.getPage());
            }
        }
    }

    private boolean isPolicyholderAttributeNull (@org.jetbrains.annotations.NotNull String login, String psswd, String nameOfCompany, String inn, String director){
        if(login.equals("")){
            return true;
        } else if(psswd.equals("")){
            return true;
        } else if(nameOfCompany.equals("")){
            return true;
        } else if(inn.equals("")){
            return true;
        } else if (director.equals("")){
            return true;
        } else return false;
    }



    private boolean isLoginAlreadyExist(String login){
        PolicyholderDAO policyholderDAO = new PolicyholderDAO();
        List<Policyholder> allPolicyholder = policyholderDAO.getAll();
       return allPolicyholder.stream().map(Policyholder::getLogin).anyMatch(x -> x.equalsIgnoreCase(login));
    }
}
