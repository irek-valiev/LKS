package dao;

public class PolicyholderQuerier {
    /**
     * SQL-запрос для вставки в БД информации о страхователе
     */
    protected static final String INSERT_INTO_POLICYHOLDER_VALUES = "INSERT INTO LKS.LKS.POLICYHOLDER (LOGIN, PSWD, NAMEOFCOMPANY, INN, DIRECTOR, ACCOUNT_ID) VALUES (?,?,?,?,?,?)";
    /**
     * SQL-запрос для получения из БД информации о страхователе по логину и паролю
     */
    protected static final String SELECT_POLICYHOLDER_BY_LGN_PSSWD = "SELECT * FROM LKS.LKS.POLICYHOLDER WHERE LOGIN = ? AND PSWD = ?";
    /**
     * SQL-запрос для получения из БД информацию со списком всех страхователей
     */
    protected static final String SELECT_ALL_POLICYHOLDER = "SELECT * FROM LKS.LKS.POLICYHOLDER";
    /**
     * SQL-запрос для получения из БД информации о страхователе по ID
     */

    protected static final String SELECT_POLICYHOLDER_BY_ID = "SELECT * FROM LKS.LKS.POLICYHOLDER WHERE ID = ?";
    /**
     * SQL-запрос для получения из БД информации о страхователе по логину
     */
    protected static final String SELECT_POLICYHOLDER_BY_LOGIN = "SELECT * FROM LKS.LKS.POLICYHOLDER WHERE LOGIN = ?";
    /**
     * SQL-запрос для получения из БД информации о страхователе по Account_ID
     */
    protected static final String SELECT_POLICYHOLDER_BY_ACCOUNT_ID = "SELECT * FROM LKS.LKS.POLICYHOLDER WHERE ACCOUNT_ID = ?";
}
