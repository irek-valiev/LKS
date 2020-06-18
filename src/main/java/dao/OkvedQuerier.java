package dao;

public class OkvedQuerier {
    /**
     * SQL-запрос для получения из БД информации о тарифе по коду ОКВЭД
     */
    protected static final String SELECT_RATE_BY_OKVED = "SELECT * FROM LKS.LKS.OKVED WHERE KOD_OKVED = ?";
    /**
     * SQL-запрос для получения из БД информацию со списком всех видов деятельности
     */
    protected static final String SELECT_ALL_OKVED = "SELECT * FROM LKS.LKS.OKVED";
}
