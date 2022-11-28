import org.testng.annotations.Test;


public class CheckSearchGrowLab extends TestBase{


    //test negativ pass 123656
    @Test
    public void ourTestNegativpass() throws InterruptedException {
        managerNegativPass();
        Thread.sleep(1000);
        bagRepotInvalidTrue();
        pageLogin();
    }

    //test positiv billye@example.com  123456
    @Test
    public void managerAuthTest() throws InterruptedException {
        managerAuth();
        Thread.sleep(1000);
        bagRepotInvalidFalshe();
        pageLogin();
    }

    @Test
    public void GoodAuthafterBadAuth() throws InterruptedException {
        //try bad auth
        managerNegativPass();
        bagRepotInvalidTrue();
        //try manager auth
        managerAuth();
        bagRepotInvalidFalshe();//checkClientsLink();
        pageLogin();
    }

}

