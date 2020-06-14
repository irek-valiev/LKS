package enums;

/**
 * Перечисление, содержащее данные для страхового тарифа
 */
public enum ChekTaxCredential {
    /**
     * Идентификатор (фактически список)
     */
    ID("okved_id"),
    /**
     * Код вида экономической деятельности
     */
    KOD_OKVED("kod_okved"),
    /**
     * Расшифровка вида экономической деятельности
     */
    NAME_VED("name_ved"),
    /**
     * Класс профессионального риска
     */
    RISK_CLASS("risk_class"),
    /**
     * Страховой тариф
     */
    RATE("rate");

    /**
     * Данные для страхового тарифа
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
