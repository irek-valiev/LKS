package enums;

/**
 * Перечисление, содержащее данные для расчета суммы страховых взносов
 */
public enum ChekTaxCredential {
    /**
     * Идентификатор
     */
    CHEKTAX_ID("chektax_id"),
    /**
     * Идентификатор страхователя
     */
    POLICYHOLDER_ID("policyholder_id"),
    /**
     * Наименование организации
     */
    POLICYHOLDER_NAME("policyholder_name"),
    /**
     * ИНН организации
     */
    POLICYHOLDER_INN("policyholder_inn"),
    /**
     * Фонд оплаты труда
     */
    TOTAL_SALARY_MONTH("total_salary_month"),
    /**
     * Год
     */
    YEAR("year"),
    /**
     * Месяц
     */
    MONTH("month"),
    /**
     * Код ВЭД
     */
    KOD_OKVED("kod_okved"),
    /**
     * Нименование ВЭД
     */
    NAME_VED("name_ved"),
    /**
     * Класс профессионального риска
     */
    RISK_CLASS("risk_class"),
    /**
     * Страховой тариф
     */
    RATE("rate"),
    /**
     * Сумма страхового взноса
     */
    CONTRIBUTION("contribution");


    /**
     * Данные для расчета суммы страховых взносов
     */
    private String chekTaxCredential;

    /**
     * Конструктор
     */
    ChekTaxCredential (String chekTaxCredential){
        this.chekTaxCredential = chekTaxCredential;
    }

    /**
     * Геттер
     */
    public String getChekTaxCredential(){
        return chekTaxCredential;
    }

}
