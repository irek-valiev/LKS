package dao;

import beans.Okved;
import beans.TransferData;
import exceptions.DataSourceServiceException;
import exceptions.OkvedException;
import lombok.extern.slf4j.Slf4j;
import service.DataSourceService;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * Класс доступа к данным БД для переводов
 */
@Slf4j
public class TransferDataDAO implements DAO<TransferData> {
    /**
     * Поле класса для работы с БД
     */
    private DataSourceService dataSourceService = new DataSourceService();
    /**
     * Метод для вставки в БД информации об оплате
     * @param transferData
     */
    @Override
    public void insert (TransferData transferData){
        try{
            PreparedStatement preparedStatement = dataSourceService.getPreparedStatement(TransferDataQuerier.INSERT_INTO_TRANSFER_DATA_VALUES);
            preparedStatement.setInt(1, transferData.getFromPolicyholder().getId());
            preparedStatement.setString(2, transferData.getFromPolicyholder().getNameOfCompany());
            preparedStatement.setInt(3, transferData.getFromPolicyholder().getAccount().getId());
            preparedStatement.setInt(4, transferData.getFromPolicyholder().getAccount().getAccountNumber());
            preparedStatement.setInt(5, transferData.getToPolicyholder().getId());
            preparedStatement.setString(6, transferData.getToPolicyholder().getNameOfCompany());
            preparedStatement.setInt(7, transferData.getToPolicyholder().getAccount().getId());
            preparedStatement.setInt(8, transferData.getToPolicyholder().getAccount().getAccountNumber());
            preparedStatement.setDouble(9, transferData.getTransferSum());
            preparedStatement.setTimestamp(10, new Timestamp(transferData.getData().getTime()));
            preparedStatement.executeUpdate();
        }catch (DataSourceServiceException e){
            log.error("Ощибка подключения к БД при попытке вставки записи с данными перевода", e);
        } catch (SQLException e){
            log.error("Ошибка запроса при попытке вставки записи с данными перевода " + TransferDataQuerier.INSERT_INTO_TRANSFER_DATA_VALUES, e);
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
