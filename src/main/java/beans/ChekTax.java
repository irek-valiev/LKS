package beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;




/**
 * Класс для описаня расчета суммы страховых взносов
 */
@Builder
@AllArgsConstructor
public class ChekTax {
    /**
     * Идентификатор
     */
    private int chekTax_id;
    /**
     * Страхователь
     */
    private Policyholder policyholder;
    /**
     * Фонд оплаты труда за конкретный месяц
     */
    private double totalSalaryForMonth;
    /**
     * Указатель года, за который идет расчет страховых взносов
     */
    private String year;
    /**
     * Указатель месяца, за который идет расчет страховых взносов
     */
    private String month;
    /**
     *Основной вид экономической деятельности страхователя в предыдущем финнансовом году
     */
    private Okved okved;

    /**
     *Сумма страховых взносов, причитающихся к уплате
     */
    private double contribution;

    /**
     * Конструктор
     */
    public ChekTax(Policyholder policyholder, double totalSalaryForMonth, String year, String month, Okved okved, double contribution){
        this.policyholder = policyholder;
        this.totalSalaryForMonth = totalSalaryForMonth;
        this.year = year;
        this.month = month;
        this.okved = okved;
        this.contribution= contribution;
    }


    public int getChekTax_id(){return this.chekTax_id = chekTax_id;}
    public Policyholder getPolicyholder(){return this.policyholder = policyholder;}
    public double getTotalSalaryForMonth (){return this.totalSalaryForMonth = totalSalaryForMonth;}
    public  String getYear(){return this.year = year;}
    public String getMonth(){return this.month = month;}
    public Okved getOkved(){return this.okved = okved;}
    public double getContribution(){return this.contribution = contribution;}
    public void setChekTax_id(int chekTax_id){this.chekTax_id=chekTax_id;}
    public void setTotalSalaryForMonth (double totalSalaryForMonth){this.totalSalaryForMonth=totalSalaryForMonth;}
    public void setYear(String year){this.year=year;}
    public void setMonth(String month){this.month = month;}
    public void setContribution(double contribution){this.contribution = contribution;}



}
