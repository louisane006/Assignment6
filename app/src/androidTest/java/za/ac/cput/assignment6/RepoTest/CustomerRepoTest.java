package za.ac.cput.assignment6.RepoTest;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import za.ac.cput.assignment6.Domain.Customer;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class CustomerRepoTest {

    Customer customer;
    Customer newCustomer;
    public CustomerRepoTest() {
    }
    @Test
    public void createTest(){
        customer = new Customer.Builder().identification((long) 1020300).name("Sarah").surname("Smith").build();
        Assert.assertEquals(customer.getName(), "Sarah");
    }
    @Test
    public void updateTest() {
        newCustomer = new Customer.Builder().name("Ritah").build();
        Assert.assertEquals(newCustomer.getName(), "Ritah");
    }
    @BeforeClass
    public static void setUpClass() throws Exception {
    }
    @AfterClass
    public static void tearDownClass() throws Exception {
    }
}
