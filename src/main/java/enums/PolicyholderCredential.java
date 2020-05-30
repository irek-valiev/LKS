package enums;

/**
 * Перечисление, содержащее аутентификационные данные для страхователя
 */
public enum PolicyholderCredential {
    /**
     * Идентификатор (регистрационный номер)
     */
    ID("id"),
    /**
     * Наименование организации
     */
    NAME_OF_COMPANY("nameOfConpany"),
    /**
     * ИНН организации
     */
    INN("inn"),
    /**
     * Имя руководителя
     */
    DIRECTOR("director"),
    /**
     * Логин
     */
    LOGIN("login"),
    /**
     * Пароль
     */
    PSSWD("pswd"),
    /**
     * Идентификатор счета
     */
    ACCOUNT_ID("account_id");

    /**
     * Аутентификационные данные
     */
    private String policyholderCredential;

    /**
     * Конструктор с полем аутентификационных данных
     * @param policyholderCredential аутентификационные данные
     */
    PolicyholderCredential (String policyholderCredential){
        this.policyholderCredential = policyholderCredential;
    }

    /**
     * Геттер аутентификационных данных
     * @return аутентификационные данные
     */
    public String getPolicyholderCredential (){
        return policyholderCredential;
    }
}

