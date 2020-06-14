package dao;

public class OkvedQuerier {
    /**
     * SQL-запрос для получения из БД информации о тарифе по коду ОКВЭД
     */
    protected static final String SELECT_RATE_BY_OKVED = "SELECT * FROM LKS.LKS.OKVED WHERE KOD_OKVED = ?";
}
