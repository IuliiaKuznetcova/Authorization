// CheckSearchGrowLab отрабатывает все 3 теста

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
        webdr.get("https://derrick686.softr.app/login");
        webdr.manage().window().maximize();
        Thread.sleep(2000);
    }

//logaut manager and Consultant
    public void pageLogaut() throws InterruptedException {
        webdr.findElement(By.xpath("//*[@id=\"navbarDropdown\"]")).click();
        Thread.sleep(1000);
        webdr.findElement(By.xpath("//*[@id=\"home-header1\"]/div/div[1]/ul/li[5]/div/a/span/span")).click();
        Thread.sleep(1000);
        webdr.get("https://derrick686.softr.app/login");
        Thread.sleep(1000);
    }

    ////logaut client
    public void pageLogautClient() throws InterruptedException {
        webdr.findElement(By.xpath("//*[@id=\"navbarDropdown\"]")).click();
        Thread.sleep(1000);
        webdr.findElement(By.xpath("//*[@id=\"home-header3\"]/div/div[1]/ul/li[3]/div/a/span/span")).click();
        Thread.sleep(1000);
        webdr.get("https://derrick686.softr.app/login");
        Thread.sleep(1000);
    }

    //authorization for all
    public void authorization(String username, String password) throws InterruptedException {
        //Enter email in registration form
        WebElement emailNegTest = webdr.findElement(By.xpath("//*[@id=\"sw-form-capture-email-input\"]"));
        emailNegTest.click();
        emailNegTest.clear();
        emailNegTest.sendKeys(username);
        Thread.sleep(1000);

        //Enter password in registration form
        WebElement passNegTest = webdr.findElement(By.xpath("//*[@id=\"sw-form-password-input\"]"));
        passNegTest.click();
        passNegTest.clear();
        passNegTest.sendKeys(password);
        Thread.sleep(1000);

        //Sign in
        webdr.findElement(By.id("sw-sign-in-submit-btn")).click();
        Thread.sleep(1000);

    }

    //manager's authorization
    public void managerAuth() throws InterruptedException {
        authorization("billye@example.com", "123456");
    }

    //client's authorization
    public void clientAuth() throws InterruptedException {
        authorization("lucie@example.com", "123456");
    }
    //consultant's authorization
    public void consultantAuth() throws InterruptedException {
        authorization("edra@example.com", "123456");
    }


    public void searchText(String textOnThePage) throws InterruptedException {
        webdr.getPageSource();
        webdr.findElement(By.partialLinkText(textOnThePage));
    }


    @AfterTest
    public void after() {
        webdr.close();
        webdr.quit();
    }

}
