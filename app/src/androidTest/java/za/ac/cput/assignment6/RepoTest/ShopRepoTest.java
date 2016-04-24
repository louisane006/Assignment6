package za.ac.cput.assignment6.RepoTest;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import za.ac.cput.assignment6.Repos.ShopRepo;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class ShopRepoTest extends AndroidTestCase {
    private static final String TAG="SETTINGS TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        ShopRepo repo = new SmartScreenRepoImpl(this.getContext());
        // CREATE
        SmartScreen createEntity = new SmartScreen.Builder()
                .id((long) 5800)
                .name("Samsung")
                .code("BKT500")
                .costPrice(5000)
                .build();
        SmartScreen insertedEntity = repo.save(createEntity);
        id=insertedEntity.getIdentification();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<SmartScreen> screen = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",screen.size()>0);

        //READ ENTITY
        SmartScreen entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);

        //UPDATE ENTITY
        SmartScreen updateEntity = new SmartScreen.Builder()
                .name("Apple")
                .build();
        repo.update(updateEntity);
        SmartScreen newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","TEST47",newEntity.getName());

        // DELETE ENTITY
        repo.delete(updateEntity);
        SmartScreen deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }




}














{
    Shop shop;
    Shop newShop;
    Laptop laptop;
    List<VideoCamera> camera;
    Prints print;

    public ShopTest() {
    }
    @Test
    public void createTest(){
        shop = new Shop.Builder().identification((long) 55).size(500.22).address("406, Protea Place, Plumstead").build();
        Assert.assertEquals(shop.getSize() , 500.22);
    }
    @Test
    public void updateTest() {
        newShop = new Shop.Builder().size(800.20).build();
        Assert.assertEquals(newShop.getSize(), 800.20);
    }
    @BeforeClass
    public static void setUpClass() throws Exception {
    }
    @AfterClass
    public static void tearDownClass() throws Exception {
    }
}
