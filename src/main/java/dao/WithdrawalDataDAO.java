package dao;

import beans.ReplenishData;
import beans.WithdrawalData;
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
public class WithdrawalDataDAO {
    /**
     * Поле класса для работы с БД
     */
    private DataSourceService dataSourceService = new DataSourceService();

    /**
     * Метод для вставки в БД информации об оплате
     *
     * @param withdrawalData
     */

    public void insert(WithdrawalData withdrawalData) {
        try {
            PreparedStatement preparedStatement = dataSourceService.getPreparedStatement(WithdrawalDataQuerier.INSERT_INTO_WITHDRAWAL_DATA_VALUES);
            preparedStatement.setInt(1, withdrawalData.getPolicyholder().getId());
            preparedStatement.setString(2, withdrawalData.getPolicyholder().getNameOfCompany());
            preparedStatement.setInt(3, withdrawalData.getPolicyholder().getAccount().getId());
            preparedStatement.setInt(4, withdrawalData.getPolicyholder().getAccount().getAccountNumber());
            preparedStatement.setDouble(5, withdrawalData.getSum());
            preparedStatement.setTimestamp(6, new Timestamp(withdrawalData.getData().getTime()));
            preparedStatement.executeUpdate();
        } catch (DataSourceServiceException e) {
            log.error("Ощибка подключения к БД при попытке вставки записи с данными снятия", e);
        } catch (SQLException e) {
            log.error("Ошибка запроса при попытке вставки записи с данными снятия " + WithdrawalDataQuerier.INSERT_INTO_WITHDRAWAL_DATA_VALUES, e);
        } finally {
            dataSourceService.closeConnection();

        }
    }
}
