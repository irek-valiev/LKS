package dao;
import beans.Account;
import beans.Policyholder;
import enums.PolicyholderCredential;
import exceptions.DataSourceServiceException;
import exceptions.RegException;
import exceptions.UnregistredAccountException;
import exceptions.UnregistredPolicyholderException;
import lombok.extern.slf4j.Slf4j;
import service.DataSourceService;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


/**
 * Класс доступа к данным БД для страхователя
 */
@Slf4j
public class PolicyholderDAO implements DAO<Policyholder> {
    /**
     * Поле класса для работы с БД
     */
    private DataSourceService dataSourceService = new DataSourceService();

    /**
     * Метод для вставки в БД информации о клиенте
     * @param policyholder объект клиент
     */
    @Override
    public void insert (Policyholder policyholder) throws RegException {
        try(PreparedStatement preparedStatement = dataSourceService.getPreparedStatement(PolicyholderQuerier.INSERT_INTO_POLICYHOLDER_VALUES)) {
            preparedStatement.setString(1, policyholder.getLogin());
            preparedStatement.setString(2, policyholder.getPsswd());
            preparedStatement.setString(3, policyholder.getNameOfCompany());
            preparedStatement.setString(4, policyholder.getInn());
            preparedStatement.setString(5, policyholder.getDirector());
            preparedStatement.setInt(6, policyholder.getAccount().getId());
            preparedStatement.executeUpdate();
        } catch (DataSourceServiceException e){
            log.error("Ошибка подключения к БД при попытке вставки записи с данными страхователя", e);
            throw new RegException();
        }catch (SQLException e){
            log.error("Ошибка запроса при попытке вставки записи с данными страхователя " + PolicyholderQuerier.INSERT_INTO_POLICYHOLDER_VALUES, e);
            throw new RegException();
        } finally {
            dataSourceService.closeConnection();
        }
    }

    /**
     * Метод получения объекта страхователя из БД по логину и паролю
     * @param lgn логин
     * @param psswd пароль
     * @return объект клиента
     * @throws UnregistredPolicyholderException исключение "Незарегистрированный страхователь"
     */
    @Override
    public Policyholder get(String lgn, String psswd) throws UnregistredPolicyholderException, UnregistredAccountException {
        try (PreparedStatement preparedStatement = dataSourceService.getPreparedStatement(PolicyholderQuerier.SELECT_POLICYHOLDER_BY_LGN_PSSWD)) {
         preparedStatement.setString(1, lgn);
         preparedStatement.setString(2, psswd);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                int id = resultSet.getInt(PolicyholderCredential.ID.getPolicyholderCredential());
                String nameOfCompany = resultSet.getString(PolicyholderCredential.NAME_OF_COMPANY.getPolicyholderCredential());
                String inn = resultSet.getString(PolicyholderCredential.INN.getPolicyholderCredential());
                String director = resultSet.getString(PolicyholderCredential.DIRECTOR.getPolicyholderCredential());
                int accountId = resultSet.getInt(PolicyholderCredential.ACCOUNT_ID.getPolicyholderCredential());
                Account account = new AccountDAO().getById(accountId);
                return new Policyholder(id, lgn,psswd, nameOfCompany,inn, director, account);
            } else {
                throw new UnregistredPolicyholderException("Страхователь с логином " + lgn + " отсутствует");
            }
        }catch (DataSourceServiceException e){
            log.error("Ошибка при получении данных о страхователе с логином " + lgn, e);
            return null;
        } catch (SQLException e){
            log.error("Ошибка при выполнении запроса " + PolicyholderQuerier.SELECT_POLICYHOLDER_BY_LGN_PSSWD, e);
            return  null;
        }finally {
            dataSourceService.closeConnection();
        }
    }

    /**
     * Метод получения списка всех клиентов
     * @return список всех клиентов
     */
    @Override
    public List<Policyholder> getAll(){
        try(PreparedStatement preparedStatement = dataSourceService.getPreparedStatement(PolicyholderQuerier.SELECT_ALL_POLICYHOLDER)){
            List<Policyholder> allPolicyholders = new LinkedList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(PolicyholderCredential.ID.getPolicyholderCredential());
                String login = resultSet.getString(PolicyholderCredential.LOGIN.getPolicyholderCredential());
                String nameOfCompany = resultSet.getString(PolicyholderCredential.NAME_OF_COMPANY.getPolicyholderCredential());
                String inn = resultSet.getString(PolicyholderCredential.INN.getPolicyholderCredential());
                String director = resultSet.getString(PolicyholderCredential.DIRECTOR.getPolicyholderCredential());
                int accountId = resultSet.getInt(PolicyholderCredential.ACCOUNT_ID.getPolicyholderCredential());
                AccountDAO accountDAO = new AccountDAO();
                Account account = accountDAO.getById(accountId);
                allPolicyholders.add(new Policyholder(id, login, null, nameOfCompany, inn, director, account));
            }
            return allPolicyholders;
        }catch (DataSourceServiceException e){
            log.error("Ошибка при получении списка всех клиентов, e");
            return  null;
        }catch (SQLException | UnregistredAccountException e){
            log.error("Ошибка при выполнении запроса " + PolicyholderQuerier.SELECT_ALL_POLICYHOLDER, e);
            return null;
        }finally {
            dataSourceService.closeConnection();
        }
    }


    /**
     * Метод получения страхователя по ID
     * @return страхователь
     */
    @Override
    public Policyholder getById (int id) throws UnregistredPolicyholderException{
        try (PreparedStatement preparedStatement = dataSourceService.getPreparedStatement(PolicyholderQuerier.SELECT_POLICYHOLDER_BY_ID)) {
           preparedStatement.setInt(1, id);
           ResultSet resultSet = preparedStatement.executeQuery();
           if(resultSet.next()){
               String nameOfCompany = resultSet.getString(PolicyholderCredential.NAME_OF_COMPANY.getPolicyholderCredential());
               String inn = resultSet.getString(PolicyholderCredential.INN.getPolicyholderCredential());
               String director = resultSet.getString(PolicyholderCredential.DIRECTOR.getPolicyholderCredential());
               String lgn = resultSet.getString(PolicyholderCredential.LOGIN.getPolicyholderCredential());
               String psswd = resultSet.getString(PolicyholderCredential.PSSWD.getPolicyholderCredential());
               int accountId = resultSet.getInt(PolicyholderCredential.ACCOUNT_ID.getPolicyholderCredential());
               Account account = new AccountDAO().getById(accountId);
               return new Policyholder(id, lgn,psswd,nameOfCompany,inn,director,account);
           } else {
               throw new UnregistredPolicyholderException("Страхователь с идентификатором " + id + " отсутствует");
           }
        }catch (DataSourceServiceException e ){
            log.error("Ошибка при получении списка всех страхователей", e);
            return null;
        } catch (SQLException | UnregistredAccountException e){
            log.error("Ощибка выполнения запроса " +PolicyholderQuerier.SELECT_POLICYHOLDER_BY_ID, e);
            return null;
        }finally {
            dataSourceService.closeConnection();
        }
    }

    public Policyholder getByLogin (String login) throws UnregistredPolicyholderException{
        try (PreparedStatement preparedStatement = dataSourceService.getPreparedStatement(PolicyholderQuerier.SELECT_POLICYHOLDER_BY_LOGIN)) {
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                String nameOfCompany = resultSet.getString(PolicyholderCredential.NAME_OF_COMPANY.getPolicyholderCredential());
                String inn = resultSet.getString(PolicyholderCredential.INN.getPolicyholderCredential());
                String director = resultSet.getString(PolicyholderCredential.DIRECTOR.getPolicyholderCredential());
                String lgn = resultSet.getString(PolicyholderCredential.LOGIN.getPolicyholderCredential());
                String psswd = resultSet.getString(PolicyholderCredential.PSSWD.getPolicyholderCredential());
                int accountId = resultSet.getInt(PolicyholderCredential.ACCOUNT_ID.getPolicyholderCredential());
                Account account = new AccountDAO().getById(accountId);
                return new Policyholder(lgn,psswd,nameOfCompany,inn,director,account);
            } else {
                throw new UnregistredPolicyholderException("Страхователь с логином " + login + " отсутствует");
            }
        }catch (DataSourceServiceException e ){
            log.error("Ошибка при получении списка всех страхователей", e);
            return null;
        } catch (SQLException | UnregistredAccountException e){
            log.error("Ощибка выполнения запроса " +PolicyholderQuerier.SELECT_POLICYHOLDER_BY_LOGIN, e);
            return null;
        }finally {
            dataSourceService.closeConnection();
        }
    }

    /**
     * Метод получения страхователя по Accoint_ID
     * @return страхователь
     */

    public Policyholder getByAccountId (int Account_id) throws UnregistredPolicyholderException{
        try (PreparedStatement preparedStatement = dataSourceService.getPreparedStatement(PolicyholderQuerier.SELECT_POLICYHOLDER_BY_ACCOUNT_ID)) {
            preparedStatement.setInt(1, Account_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                int id = resultSet.getInt(PolicyholderCredential.ID.getPolicyholderCredential());
                String nameOfCompany = resultSet.getString(PolicyholderCredential.NAME_OF_COMPANY.getPolicyholderCredential());
                return new Policyholder(id, nameOfCompany);
            } else {
                throw new UnregistredPolicyholderException("Страхователь с идентификатором счета" + Account_id + " отсутствует");
            }
        }catch (DataSourceServiceException e ){
            log.error("Ошибка при получении списка всех страхователей", e);
            return null;
        } catch (SQLException  e){
            log.error("Ощибка выполнения запроса " + PolicyholderQuerier.SELECT_POLICYHOLDER_BY_ACCOUNT_ID, e);
            return null;
        }finally {
            dataSourceService.closeConnection();
        }
    }
}

