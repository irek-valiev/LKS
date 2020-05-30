package dao;

/**
 * Класс, содержащий запросы к таблице pay_data
 */
public class PayDataQuerier {
    /**
     * SQL-запрос для вставки в БД информации о платеже
     */
    protected static final String INSERT_INTO_PAY_DATA_VALUES = "INSERT INTO LKS.LKS.PAY_DATA (POLICYHOLDER_ID, TARGET_ACCOUNT, SUN, DATE) VALUES (?,?,?,?)";
}
