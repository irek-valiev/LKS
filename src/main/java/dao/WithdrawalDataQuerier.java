package dao;

/**
 * Класс, содержащий запросы к таблице withdrawal_data
 */
public class WithdrawalDataQuerier {
    /**
     * SQL-запрос для вставки в БД информации о пополнении
     */
    protected static final String INSERT_INTO_WITHDRAWAL_DATA_VALUES = "INSERT INTO LKS.LKS.WITHDRAWAL_DATA (POLICYHOLDER_ID, POLICYHOLDER_NAME, POLICYHOLDER_ACCOUNT_ID, POLICYHOLDER_ACCOUNT_NUMBER, WITHDRAWAL_SUM, WITHDRAWAL_DATE) VALUES (?,?,?,?,?,?)";
}
