package dao;

import beans.PayData;
import beans.Policyholder;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;
@Ignore
public class PayDataDAOTest {
    private static final Policyholder policyholder = new Policyholder("test", "test", "test", "test","test");
    private static final String targetAccountTest = "1608";
    private static final int sumTest = 100;
    private static final Date dateTest = new Date();


    private PayDataDAO payDataDAO;
    private PayData payData;

    @Before
    public void prepareDoInsertTest(){
        payDataDAO = new PayDataDAO();
        payData = new PayData(policyholder, targetAccountTest, sumTest, dateTest);

    }


    @Test
    public void doInsertTest() {
        payDataDAO.insert(payData);
    }
}