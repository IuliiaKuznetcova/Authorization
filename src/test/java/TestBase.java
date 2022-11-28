import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

    WebDriver webdr;

    @BeforeTest
    public void prepare() throws InterruptedException {
        webdr = new ChromeDriver();
        pageLogin();
        webdr.manage().window().maximize();
        Thread.sleep(2000);
    }



    public void pageLogin () {
        webdr.get("https://derrick686.softr.app/login");
    }
    public void managerNegativPass() throws InterruptedException {
        WebElement emailNegTest = webdr.findElement(By.xpath("//*[@id=\"sw-form-capture-email-input\"]"));
        emailNegTest.click();
        emailNegTest.clear();
        emailNegTest.sendKeys("billye@example.com");
        Thread.sleep(1000);

        WebElement passNegTest = webdr.findElement(By.xpath("//*[@id=\"sw-form-password-input\"]"));
        passNegTest.click();
        passNegTest.clear();
        passNegTest.sendKeys("654321");
        Thread.sleep(1000);

        webdr.findElement(By.id("sw-sign-in-submit-btn")).click();
        Thread.sleep(1000);


    }

    public void managerAuth() throws InterruptedException {
        WebElement emailPositivTest = webdr.findElement(By.xpath("//*[@id=\"sw-form-capture-email-input\"]"));
        emailPositivTest.click();
        emailPositivTest.clear();
        emailPositivTest.sendKeys("billye@example.com");
        Thread.sleep(1000);

        WebElement passPositivTest = webdr.findElement(By.xpath("//*[@id=\"sw-form-password-input\"]"));
        passPositivTest.click();
        passPositivTest.clear();
        passPositivTest.sendKeys("123456");
        Thread.sleep(1000);

        webdr.findElement(By.id("sw-sign-in-submit-btn")).click();
        Thread.sleep(1000);
    }


    public void bagRepotInvalidTrue() throws InterruptedException {
        String source = webdr.getPageSource();
        String bugReport = "Invalid email or password";
        Boolean bugR = source.contains(bugReport);
        System.out.println(bugR);
        Assert.assertEquals(bugR, Boolean.TRUE);
        Thread.sleep(1000);

    }

    public void bagRepotInvalidFalshe() throws InterruptedException {
        String source = webdr.getPageSource();
        String bugReport = "Invalid email or password";
        Boolean bugR = source.contains(bugReport);
        System.out.println(bugR);
        Assert.assertEquals(bugR, Boolean.FALSE);
        Thread.sleep(1000);

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

}
