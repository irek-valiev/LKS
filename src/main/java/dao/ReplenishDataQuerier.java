package dao;

/**
 * Класс, содержащий запросы к таблице replenish_data
 */
public class ReplenishDataQuerier {
    /**
     * SQL-запрос для вставки в БД информации о пополнении
     */
    protected static final String INSERT_INTO_REPLENISH_DATA_VALUES = "INSERT INTO LKS.LKS.REPLENISH_DATA (POLICYHOLDER_ID, POLICYHOLDER_NAME,     protected static final String INSERT_INTO_REPLENISH_DATA_VALUES = \"INSERT INTO LKS.LKS.REPLENISH_DATA (POLICYHOLDER_ID, POLICYHOLDER_NAME, POLICYHOLDER_ACCOUNT_ID, POLICYHOLDER_ACCOUNT_NUMBER, REPLENISH_SUM, REPLENISH_DATE) VALUES (?,?,?,?,?,?)";
}
