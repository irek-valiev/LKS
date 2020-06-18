package dao;

import beans.Okved;
import enums.OkvedInfo;
import exceptions.*;
import lombok.extern.slf4j.Slf4j;
import service.DataSourceService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

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
    public void insert(Okved okved) {}

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
    public Okved getOkved(String kod_okved) throws OkvedException {
        try (PreparedStatement preparedStatement = dataSourceService.getPreparedStatement(OkvedQuerier.SELECT_RATE_BY_OKVED)) {
            preparedStatement.setString(1, kod_okved);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int okved_id = resultSet.getInt(OkvedInfo.ID.getOkvedInfo());
                String nameVed = resultSet.getString(OkvedInfo.NAME_VED.getOkvedInfo());
                int riskClass = resultSet.getInt(OkvedInfo.RISK_CLASS.getOkvedInfo());
                double rate = resultSet.getDouble(OkvedInfo.RATE.getOkvedInfo());
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

    /**
     * Метод получения списка всех клиентов
     * @return список всех клиентов
     */
    @Override
    public List<Okved> getAll(){
        try(PreparedStatement preparedStatement = dataSourceService.getPreparedStatement(OkvedQuerier.SELECT_ALL_OKVED)){
            List<Okved> allOkved = new LinkedList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int okved_id = resultSet.getInt(OkvedInfo.ID.getOkvedInfo());
                String kod_okved = resultSet.getString(OkvedInfo.KOD_OKVED.getOkvedInfo());
                String name_ved = resultSet.getString(OkvedInfo.NAME_VED.getOkvedInfo());
                int risk_class= resultSet.getInt(OkvedInfo.RISK_CLASS.getOkvedInfo());
                double rate = resultSet.getDouble(OkvedInfo.RATE.getOkvedInfo());
                OkvedDAO okvedDAO = new OkvedDAO();
                allOkved.add(new Okved(okved_id, kod_okved, name_ved, risk_class, rate));
            }
            return allOkved;
        }catch (DataSourceServiceException e){
            log.error("Ошибка при получении списка всех ОКВЭДов, e");
            return  null;
        }catch (SQLException e){
            log.error("Ошибка при выполнении запроса " + OkvedQuerier.SELECT_ALL_OKVED, e);
            return null;
        }finally {
            dataSourceService.closeConnection();
        }
    }
}
