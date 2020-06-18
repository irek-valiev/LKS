package dao;

import beans.ChekTax;
import beans.Okved;
import exceptions.ChekTaxException;
import exceptions.DataSourceServiceException;
import exceptions.OkvedException;
import lombok.extern.slf4j.Slf4j;
import service.DataSourceService;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Класс доступа к данным БД для расчета суммы страховых взносов
 */
@Slf4j
public class ChekTaxDAO implements DAO<ChekTax> {
    /**
     * Поле класса для работы с БД
     */
    private DataSourceService dataSourceService = new DataSourceService();
    /**
     * Метод для вставки в БД расчету суммы страховых взносов
     * @param chekTax
     */
    @Override
    public void insert (ChekTax chekTax) throws ChekTaxException {
        try (PreparedStatement preparedStatement = dataSourceService.getPreparedStatement(ChekTaxQuerier.INSERT_CHEKTAX_INFO)){
            preparedStatement.setInt(1, chekTax.getPolicyholder().getId());
            preparedStatement.setString(2, chekTax.getPolicyholder().getNameOfCompany());
            preparedStatement.setString(3, chekTax.getPolicyholder().getInn());
            preparedStatement.setDouble(4, chekTax.getTotalSalaryForMonth());
            preparedStatement.setString(5, chekTax.getYear());
            preparedStatement.setString(6, chekTax.getMonth());
            preparedStatement.setString(7, chekTax.getOkved().getKod_okved());
            preparedStatement.setString(8, chekTax.getOkved().getNameVed());
            preparedStatement.setInt(9, chekTax.getOkved().getRiskClass());
            preparedStatement.setDouble(10, chekTax.getOkved().getRate());
            preparedStatement.setDouble(11, chekTax.getContribution());
            preparedStatement.executeUpdate();
        }catch (DataSourceServiceException e){
            log.error("Ошибка подключения к БД при попытке вставки записи с данными расчета суммы страховых взносов", e);
            throw new ChekTaxException();
        }catch (SQLException e){
            log.error("Ошибка запроса при попытке вставки записи с данными расчета суммы страховых взносов " + ChekTaxQuerier.INSERT_CHEKTAX_INFO, e);
            throw new ChekTaxException();
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
