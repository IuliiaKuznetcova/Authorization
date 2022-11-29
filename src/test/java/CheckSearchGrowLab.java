import org.testng.annotations.Test;

// отрабатывают все три теста
public class CheckSearchGrowLab extends TestBaseCheck {


    //test negativ pass 123656
    @Test
    public void ourTestNegativpass() throws InterruptedException {
        managerNegativPass();
        Thread.sleep(1000);
        bagRepotClientTrue();

    }

    //test positiv billye@example.com  123456
    @Test
    public void managerAuthTest() throws InterruptedException {
        managerAuth();
        Thread.sleep(1000);
        bagRepotClientFalshe();
        pageLogin();
    }

    @Test
    public void GoodAuthafterBadAuth() throws InterruptedException {
        //try bad auth
        managerNegativPass();
        bagRepotClientTrue();
        //try manager auth
        managerAuth();
        bagRepotClientFalshe();//checkClientsLink();
        pageLogin();
    }

}

