package dao;

public class ChekTaxQuerier {
/**
 * SQL-запрос для вставки в БД информации о расчете суммы страховых взносов
 */
    protected static final String INSERT_CHEKTAX_INFO = "INSERT INTO LKS.LKS.CHEKTAX (POLICYHOLDER_ID, POLICYHOLDER_NAME, POLICYHOLDER_INN, TOTAL_SALARY_MONTH, YEAR, MONTH, KOD_OKVED, RISK_CLASS, RATE, CONTRIBUTION) VALUES (?,?,?,?,?,?,?,?,?,?)";
}
