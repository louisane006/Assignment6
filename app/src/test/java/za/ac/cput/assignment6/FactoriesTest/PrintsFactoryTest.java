package za.ac.cput.assignment6.FactoriesTest;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import za.ac.cput.assignment6.Domain.Customer;
import za.ac.cput.assignment6.Domain.Printer;
import za.ac.cput.assignment6.Domain.Prints;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class PrintsFactoryTest {
    Prints print;
    Prints newPrint;
    Printer printer;
    Customer customer;

    public PrintsFactoryTest() {
    }
    @Test
    public void createTest(){
        print = new Prints.Builder().identification((long) 45454545).desc("Wedding Cards").taskNum("101").price(100.00).build();
        Assert.assertEquals(print.getDesc() , "Wedding Cards");
    }
    @Test
    public void updateTest() {
        newPrint = new Prints.Builder().desc("Gift Cards").build();
        Assert.assertEquals(newPrint.getDesc(), "Gift Cards");
    }
    @BeforeClass
    public static void setUpClass() throws Exception {
    }
    @AfterClass
    public static void tearDownClass() throws Exception {
    }
}
