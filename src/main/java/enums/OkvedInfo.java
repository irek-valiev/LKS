package enums;
/**
 * Перечисление, содержащее данные для ОКВЭДа
 */
public enum OkvedInfo {
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
     * Данные для ОКВЭДа
     */
    private String okvedInfo;
    /**
     * Конструктор
     */
    OkvedInfo(String okvedInfo){
        this.okvedInfo = okvedInfo;
    }
    /**
     * Геттер
     */
    public String getOkvedInfo(){
        return okvedInfo;
    }
}
