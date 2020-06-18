package servlets;

import beans.ChekTax;
import beans.Okved;
import beans.Policyholder;
import dao.ChekTaxDAO;
import dao.OkvedDAO;
import dao.PolicyholderDAO;
import enums.Page;
import exceptions.ChekTaxException;
import exceptions.OkvedException;
import exceptions.UnregistredAccountException;
import lombok.extern.slf4j.Slf4j;
import processors.TaxProcessor;
import utils.ServletUtil;
import utils.SessionUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Сервлет для обработки расчета суммы страховых взносов
 */
@Slf4j
@WebServlet(name = "chekTax", urlPatterns = "/chekTax")
public class ChekTaxServlet extends HttpServlet {
    /**
     * Метод обработки POST-запроса
     * @param httpServletRequest запрос
     * @param httpServletResponse ответ
     */
    @Override
    public void doPost (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        String year = httpServletRequest.getParameter("year");
        String month = httpServletRequest.getParameter("month");
        String kodOkved = httpServletRequest.getParameter("kodOkved");
        String totalSalaryMonth = httpServletRequest.getParameter("totalSalaryMonth");
        String delimeter = ",";
        String[] subStr = totalSalaryMonth.split(delimeter);
        if(subStr.length == 2 ){
            totalSalaryMonth = String.join(".", subStr[0], subStr[1]);
        }
        ChekTaxDAO chekTaxDAO = new ChekTaxDAO();
        OkvedDAO okvedDAO = new OkvedDAO();
        Okved okved;
        ChekTax chekTax;
        PolicyholderDAO policyholderDAO = new PolicyholderDAO();
        try {
            Policyholder chekTaxPolicyholder = SessionUtil.getPolicyholderFromSession(httpServletRequest.getSession());
            okved = okvedDAO.getOkved(kodOkved);
            double tax =  TaxProcessor.tax(okved, Double.parseDouble(totalSalaryMonth));
            chekTax = new ChekTax(chekTaxPolicyholder, Double.parseDouble(totalSalaryMonth), year, month, okved,  tax);
            chekTaxDAO.insert(chekTax);
            Policyholder policyholder = policyholderDAO.getById(chekTaxPolicyholder.getId());
            SessionUtil.fillCTSession(httpServletRequest.getSession(), chekTax);
            RequestDispatcher dispatcher = httpServletRequest.getRequestDispatcher("views/core/chektaxResult.jsp");
            try {
                dispatcher.forward(httpServletRequest, httpServletResponse);
            } catch (ServletException | IOException e){
                ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.ERROR_PAGE.getPage());
            }
            //ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.CHEKTAX_RESULT_PAGE.getPage());

        } catch (ChekTaxException e) {
            e.printStackTrace();
        } catch (OkvedException e) {
            e.printStackTrace();
        } catch (UnregistredAccountException e) {
            e.printStackTrace();
        }catch (Exception e){
            ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.ERROR_PAGE.getPage());
        }

    }
}
