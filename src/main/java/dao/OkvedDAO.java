package dao;

import beans.Okved;
import enums.ChekTaxCredential;
import exceptions.*;
import lombok.extern.slf4j.Slf4j;
import service.DataSourceService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Класс доступа к данынм БД для страхователя
 */
@Slf4j
public class OkvedDAO implements DAO<Okved> {
    /**
     * Поле класса для работы с БД
     */
    private DataSourceService dataSourceService = new DataSourceService();

    @Override
    public void insert(Okved okved) throws UnregistredPolicyholderException, RegException, ChekTaxException {

    }

    @Override
    public void insert(){}

    /**
     * Метод получения данных о тарифе из БД по коду вида экономической деятельности
     *
     * @param kod_okved код вида экономической дейтельности
     * @return расшифровку ВЭД, класс риска и тариф
     * @throws OkvedException
     */
    @Override
    public Okved get(String kod_okved) throws OkvedException {
        try (PreparedStatement preparedStatement = dataSourceService.getPreparedStatement(OkvedQuerier.SELECT_RATE_BY_OKVED)) {
            preparedStatement.setString(1, kod_okved);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int okved_id = resultSet.getInt(ChekTaxCredential.ID.getChekTaxCredential());
                String nameVed = resultSet.getString(ChekTaxCredential.NAME_VED.getChekTaxCredential());
                int riskClass = resultSet.getInt(ChekTaxCredential.RISK_CLASS.getChekTaxCredential());
                int rate = resultSet.getInt(ChekTaxCredential.RATE.getChekTaxCredential());
                return new Okved(okved_id, kod_okved, nameVed, riskClass, rate);
            } else {
                throw new OkvedException("Счет с идентификатором " + kod_okved + " отсутствует");
            }
        } catch (DataSourceServiceException e) {
            log.error("Ошибка при получении данных о тарифе с кодом ОКВЭД" + kod_okved, e);
            return null;
        } catch (SQLException e) {
            log.error("Ошибка при выполнении запроса" + OkvedQuerier.SELECT_RATE_BY_OKVED);
            return null;
        } finally {
            dataSourceService.closeConnection();
        }
    }
}
