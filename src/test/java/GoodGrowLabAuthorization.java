import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class GoodGrowLabAuthorization {
    WebDriver webdr;

    @BeforeTest
    public void prepare() throws InterruptedException {
        webdr = new ChromeDriver();
        webdr.get("https://derrick686.softr.app/login");
        webdr.manage().window().maximize();
        Thread.sleep(2000);
    }

/*//test negativ email billyeexample.com
  @Test
  public void ourTestNegativEmail () throws InterruptedException {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    WebElement emailNegTest = webdr.findElement(By.xpath("//*[@id=\"sw-form-capture-email-input\"]"));
    emailNegTest.click();
    emailNegTest.clear();
    emailNegTest.sendKeys("billyeexample.com");
    Thread.sleep(1000);

    WebElement passNegTest = webdr.findElement(By.xpath("//*[@id=\"sw-form-password-input\"]"));
    passNegTest.click();
    passNegTest.clear();
    passNegTest.sendKeys("123456");
    Thread.sleep(1000);

    webdr.findElement(By.id("sw-sign-in-submit-btn")).click();
    Thread.sleep(2000);
  }*/


    //test negativ pass 123656
    @Test
    public void ourTestNegativpass() throws InterruptedException {
        managerNegativPass();
        Thread.sleep(1000);

        /*String text = "Invalid email or password";
        Assert.assertEquals(webdr.getPageSource().contains(text),Boolean.TRUE);*/

        String source = webdr.getPageSource();
        String bugReport = "Invalid email or password";
        Boolean bugR = source.contains(bugReport);
        System.out.println(bugR);
        Assert.assertEquals(bugR, Boolean.TRUE);
    }

    //test positiv billye@example.com  123456
    @Test
    public void  managerAuthTest() throws InterruptedException {
        managerAuth();
        Thread.sleep(1000);

        String source = webdr.getPageSource();
        String bugReport = "Invalid email or password";
        Boolean bugR = source.contains(bugReport);
        System.out.println(bugR);
        Assert.assertEquals(bugR, Boolean.FALSE);

        /*String text = "Invalid email or password";
        Assert.assertEquals(webdr.getPageSource().contains(text),Boolean.FALSE);*/
    }


    @AfterTest
    public void after() {
        webdr.close();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        webdr.quit();
    }

public void click(By locator) {
        webdr.findElement(locator).click();
}
    public void managerNegativPass() throws InterruptedException {
        WebElement emailNegTest = webdr.findElement(By.id("sw-form-capture-email-input"));
        emailNegTest.click();
        emailNegTest.clear();
        emailNegTest.sendKeys("billyeexample.com");
        Thread.sleep(1000);

        WebElement passNegTest = webdr.findElement(By.id("sw-form-password-input"));
        passNegTest.click();
        passNegTest.clear();
        passNegTest.sendKeys("123986");
        Thread.sleep(1000);

        webdr.findElement(By.id("sw-sign-in-submit-btn")).click();
        Thread.sleep(1000);


    }

    public void  managerAuth() throws InterruptedException {
        WebElement emailPositivTest = webdr.findElement(By.id("sw-form-capture-email-input"));
        emailPositivTest.click();
        emailPositivTest.clear();
        emailPositivTest.sendKeys("billye@example.com");
        Thread.sleep(1000);

        WebElement passPositivTest = webdr.findElement(By.id("sw-form-password-input"));
        passPositivTest.click();
        passPositivTest.clear();
        passPositivTest.sendKeys("123456");
        Thread.sleep(1000);

        webdr.findElement(By.id("sw-sign-in-submit-btn")).click();
        Thread.sleep(5000);
    }

}
