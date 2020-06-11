package dao;

/**
 * Класс, содержащий запросы к таблице transfer_data
 */
public class TransferDataQuerier {
    /**
     * SQL-запрос для вставки в БД информации о переводе
     */
    protected static final String INSERT_INTO_TRANSFER_DATA_VALUES = "INSERT INTO LKS.LKS.TRANSFER_DATA (FROMPOLICYHOLDER_ID, FROMPOLICYHOLDER_NAME, FROMPOLICYHOLDER_ACCOUNT_ID, FROMPOLICYHOLDER_ACCOUNT, TOPOLICYHOLDER_ID, TOPOLICYHOLDER_NAME, TOPOLICYHOLDER_ACCOUNT_ID, TOPOLICYHOLDER_ACCOUNT, TRANSFERSUM, DATE) VALUES (?,?,?,?,?,?,?,?,?,?)";
}
