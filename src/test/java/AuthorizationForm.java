import org.checkerframework.checker.units.qual.A;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class AuthorizationForm extends TestBase {

    @Test
    public void managerAuthTest() throws InterruptedException {
        managerAuth();
        Thread.sleep(1000);
        //searchText("All Projects");
        pageLogaut();
    }

    @Test
    public void clientAuthTest() throws InterruptedException {
        clientAuth();
        Thread.sleep(1000);
        //searchText("My Invoices");
        pageLogautClient();
    }


    @Test
    public void consultantAuthTest() throws InterruptedException {
        consultantAuth();
        Thread.sleep(1000);
        //searchText("My Projects");
        pageLogaut();
    }

}
