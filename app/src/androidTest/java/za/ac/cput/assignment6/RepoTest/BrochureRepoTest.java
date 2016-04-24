package za.ac.cput.assignment6.RepoTest;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import za.ac.cput.assignment6.Domain.Brochure;
import za.ac.cput.assignment6.Domain.Customer;
import za.ac.cput.assignment6.Domain.Designer;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class BrochureRepoTest {
   Brochure brochure;
    Brochure newBrochure;
    Designer designer;
    Customer customer;
    public BrochureRepoTest() {
    }
    @Test
    public void createTest(){
        brochure = new Brochure.Builder().desc("TM100").designer(designer).customer(customer).taskID((long) 10000).build();
        Assert.assertEquals(brochure.getDesigner() , designer);
    }
    @Test
    public void updateTest() {
        newBrochure = new Brochure.Builder().designer(designer).build();
        Assert.assertEquals(newBrochure.getDesigner(), designer);
    }
    @BeforeClass
    public static void setUpClass() throws Exception {
    }
    @AfterClass
    public static void tearDownClass() throws Exception {
    }
}
