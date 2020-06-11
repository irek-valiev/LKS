package dao;

import beans.ReplenishData;
import exceptions.DataSourceServiceException;
import lombok.extern.slf4j.Slf4j;
import service.DataSourceService;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * Класс доступа к данным БД для пополнения
 */
@Slf4j
public class ReplenishDataDAO implements DAO<ReplenishData> {
    /**
     * Поле класса для работы с БД
     */
    private DataSourceService dataSourceService = new DataSourceService();
    /**
     * Метод для вставки в БД информации об оплате
     * @param replenishData
     */
    @Override
    public void insert (ReplenishData replenishData){
        try {
            PreparedStatement preparedStatement = dataSourceService.getPreparedStatement(ReplenishDataQuerier.INSERT_INTO_REPLENISH_DATA_VALUES);
            preparedStatement.setInt(1, replenishData.getPolicyholder().getId());
            preparedStatement.setString(2, replenishData.getPolicyholder().getNameOfCompany());
            preparedStatement.setInt(3, replenishData.getPolicyholder().getAccount().getId());
            preparedStatement.setInt(4, replenishData.getPolicyholder().getAccount().getAccountNumber());
            preparedStatement.setDouble(5, replenishData.getSum());
            preparedStatement.setTimestamp(6, new Timestamp(replenishData.getData().getTime()));
            preparedStatement.executeUpdate();
        }catch (DataSourceServiceException e){
            log.error("Ощибка подключения к БД при попытке вставки записи с данными пополнения", e);
        } catch (SQLException e){
            log.error("Ошибка запроса при попытке вставки записи с данными пополнения " + ReplenishDataQuerier.INSERT_INTO_REPLENISH_DATA_VALUES, e);
        } finally {
            dataSourceService.closeConnection();
        }
    }
    }