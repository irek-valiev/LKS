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

    public Policyholder getPolicyholder(){return this.policyholder = policyholder;}
    public double getTotalSalaryForMonth (){return this.totalSalaryForMonth = totalSalaryForMonth;}
    public  String getYear(){return this.year = year;}
    public String getMonth(){return this.month = month;}
    public Okved getOkved(){return this.okved = okved;}



}
