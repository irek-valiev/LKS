package dao;

import beans.Okved;
import beans.PayData;
import exceptions.DataSourceServiceException;
import exceptions.OkvedException;
import lombok.extern.slf4j.Slf4j;
import service.DataSourceService;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * Класс доступа к данным БД для оплат
 */
@Slf4j
public class PayDataDAO implements DAO<PayData> {
    /**
     * Поле класса для работы с БД
     */
    private DataSourceService dataSourceService = new DataSourceService();
    /**
     * Метод для вставки в БД информации об оплате
     * @param payData
     */
    @Override
    public void insert (PayData payData){
        try (PreparedStatement preparedStatement = dataSourceService.getPreparedStatement(PayDataQuerier.INSERT_INTO_PAY_DATA_VALUES)){
            preparedStatement.setInt(1, payData.getPolicyholder().getId());
            preparedStatement.setString(2, payData.getTargetAccount());
            preparedStatement.setString(3, payData.getPolicyholder().getNameOfCompany());
            preparedStatement.setInt(4, payData.getPolicyholder().getAccount().getId());
            preparedStatement.setInt(5, payData.getPolicyholder().getAccount().getAccountNumber());
            preparedStatement.setDouble(6, payData.getSum());
            preparedStatement.setTimestamp(7, new Timestamp(payData.getData().getTime()));
            preparedStatement.executeUpdate();
        }catch (DataSourceServiceException e){
            log.error("Ощибка подключения к БД при попытке вставки записи с данными оплаты", e);
        } catch (SQLException e){
            log.error("Ошибка запроса при попытке вставки записи с данными оплаты " + PayDataQuerier.INSERT_INTO_PAY_DATA_VALUES, e);
        } finally {
            dataSourceService.closeConnection();
        }
    }

    @Override
    public void insert() {

    }

    @Override
    public Okved getOkved(String kod_okved) throws OkvedException {
        return null;
    }
}
