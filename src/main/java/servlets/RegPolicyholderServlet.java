package servlets;

import beans.Account;
import beans.Policyholder;
import dao.AccountDAO;
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
import java.net.URLEncoder;
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
        //TODO доработать проброс на страницу ошибок
        Map<String, String> policyholderCridentials = SessionUtil.readPolicyholderCredentials(httpServletRequest);
        if(isLoginAlreadyExist(policyholderCridentials.get(PolicyholderCredential.LOGIN.getPolicyholderCredential()))){
            //TODO Добавить проброс на инфо-страницу о том, что логин уже есть и кнопкой на страницу регистрации
            try {
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() +
                        Page.REG_PAGE.getPage() + "?message=" + URLEncoder.encode("Пользователь с таким именем уже есть", "UTF-8"));
            }catch (IOException e){
                log.error("Ошибка при попытке регистрации страхователя с повторяющимся наименованием");
            }
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
            Policyholder policyholder = new Policyholder(
                    policyholderCridentials.get(PolicyholderCredential.LOGIN.getPolicyholderCredential()),
                    policyholderCridentials.get(PolicyholderCredential.PSSWD.getPolicyholderCredential()),
                    policyholderCridentials.get(PolicyholderCredential.NAME_OF_COMPANY.getPolicyholderCredential()),
                    policyholderCridentials.get(PolicyholderCredential.INN.getPolicyholderCredential()),
                    policyholderCridentials.get(PolicyholderCredential.DIRECTOR.getPolicyholderCredential()),
                    currentAccount);
            PolicyholderDAO policyholderDAO = new PolicyholderDAO();
            policyholderDAO.insert(policyholder);
            HttpSession httpSession = httpServletRequest.getSession();
            try {
                policyholder = policyholderDAO.get(policyholderCridentials.get(PolicyholderCredential.LOGIN.getPolicyholderCredential()),
                        policyholderCridentials.get(PolicyholderCredential.PSSWD.getPolicyholderCredential()));
            }catch (UnregistredPolicyholderException | UnregistredAccountException e){
                log.error("Ошибка при регистрации нового страхователя");
            }
            SessionUtil.fillSession(httpSession, policyholder);
            ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.SUCCESS_REG_PAGE.getPage());
        }

    }

    private boolean isLoginAlreadyExist(String login){
        PolicyholderDAO policyholderDAO = new PolicyholderDAO();
        List<Policyholder> allPolicyholder = policyholderDAO.getAll();
       return allPolicyholder.stream().map(Policyholder::getLogin).anyMatch(x -> x.equalsIgnoreCase(login));
    }
}
