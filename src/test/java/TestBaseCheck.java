import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


// CheckSearchGrowLab отрабатывает все 3 теста


public class TestBaseCheck {


    WebDriver webdr;

    @BeforeTest
    public void prepare() throws InterruptedException {
        webdr = new ChromeDriver();
        webdr.get("https://derrick686.softr.app/login");
        webdr.manage().window().maximize();
        Thread.sleep(2000);
    }



    public void pageLogin () throws InterruptedException {
        webdr.findElement(By.xpath("//*[@id=\"navbarDropdown\"]")).click();
        Thread.sleep(1000);
        webdr.findElement(By.xpath("//*[@id=\"home-header1\"]/div/div[1]/ul/li[5]/div/a/span/span")).click();
        Thread.sleep(1000);
        webdr.get("https://derrick686.softr.app/login");
        Thread.sleep(1000);
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

    public void clientAuth() throws InterruptedException {
        WebElement emailPositivTest = webdr.findElement(By.xpath("//*[@id=\"sw-form-capture-email-input\"]"));
        emailPositivTest.click();
        emailPositivTest.clear();
        emailPositivTest.sendKeys("lucie@example.com");
        Thread.sleep(1000);

        WebElement passPositivTest = webdr.findElement(By.xpath("//*[@id=\"sw-form-password-input\"]"));
        passPositivTest.click();
        passPositivTest.clear();
        passPositivTest.sendKeys("123456");
        Thread.sleep(1000);

        webdr.findElement(By.id("sw-sign-in-submit-btn")).click();
        Thread.sleep(1000);
    }

    public void consultantAuth() throws InterruptedException {
        WebElement emailPositivTest = webdr.findElement(By.xpath("//*[@id=\"sw-form-capture-email-input\"]"));
        emailPositivTest.click();
        emailPositivTest.clear();
        emailPositivTest.sendKeys("edra@example.com");
        Thread.sleep(1000);

        WebElement passPositivTest = webdr.findElement(By.xpath("//*[@id=\"sw-form-password-input\"]"));
        passPositivTest.click();
        passPositivTest.clear();
        passPositivTest.sendKeys("123456");
        Thread.sleep(1000);

        webdr.findElement(By.id("sw-sign-in-submit-btn")).click();
        Thread.sleep(1000);
    }


    public void bagRepotManagerTrue() throws InterruptedException {
        String source = webdr.getPageSource();
        String bugReport = "All Projects";
        Boolean bugR = source.contains(bugReport);
        System.out.println(bugR);
        Assert.assertEquals(bugR, Boolean.TRUE);
        Thread.sleep(1000);
    }

    public void bagRepotConsultantTrue() throws InterruptedException {
        String source = webdr.getPageSource();
        String bugReport = "My Projects";
        Boolean bugR = source.contains(bugReport);
        System.out.println(bugR);
        Assert.assertEquals(bugR, Boolean.TRUE);
        Thread.sleep(1000);
    }

    public void bagRepotClientTrue() throws InterruptedException {
        String source = webdr.getPageSource();
        String bugReport = "Invalid email or password";
        Boolean bugR = source.contains(bugReport);
        System.out.println(bugR);
        Assert.assertEquals(bugR, Boolean.TRUE);
        Thread.sleep(1000);

    }

    public void bagRepotClientFalshe() throws InterruptedException {
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
