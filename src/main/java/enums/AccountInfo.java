package enums;

/**
 * Перечисление, содержащее данные для счета
 */
public enum AccountInfo {
    /**
     * Идентификатор
     */
    ID("id"),
    /**
     * Номер счета
     */
    ACCOUNT_NUMBER("account_number"),
    /**
     * Сумма
     */
    SUM("sum"),
    /**
     * Сумма пополнения
     */
    REPLENISH_SUM("replenish_sum"),
    /**
     * Сумма снятия
     */
    WITHDRAWAL_SUM("withdrawal_sum");

    /**
     * Данные для счета
     */
    private String accountInfo;

    /**
     * Конструктор с полем аутентификационных данных
     * @param accountInfo аутентификационные данные
     */
    AccountInfo(String accountInfo){
        this.accountInfo = accountInfo;
    }

    /**
     * Геттер аутентификационных данных
     * @return аутентификационные данные
     */
    public String getAccountInfo(){
        return accountInfo;
    }
}
