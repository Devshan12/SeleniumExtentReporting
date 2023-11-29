package Tests;

import Pages.HomePage;
import Pages.ProductsPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SeleniumTest {
    public static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeSuite
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");
        driver.manage().window().maximize();

        ExtentSparkReporter spark = new ExtentSparkReporter("target/spark.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);

        // Navigation to Online Products Page
        HomePage.click_hamburger_menu();
        HomePage.click_onlineProduct_link();
    }

    @Test
    public void validateTitles_onlineProducts() throws InterruptedException {
        test = extent.createTest("Validate Shoe Titles on Product Page", "This test validates that the different shoe types are correct on Online Products Page");
        ProductsPage.formalShoes_verifyTitle();
        ProductsPage.sportsShoes_verifyTitle();
        ProductsPage.sneakers_verifyTitle();
        extent.flush();
    }

    @Test(dependsOnMethods = "validateTitles_onlineProducts")
    public void validateFirstFormalShoes() throws InterruptedException {
        test = extent.createTest("Validate First Formal Shoe", "This test validates First Formal Shoe on Online Products Page");
        boolean isFormalShoeValid = ProductsPage.formalShoes_firstShoe_verify();
        if (!isFormalShoeValid) {
            test.fail("Validation failed for the first formal shoe.");
        }
    }

    @Test(dependsOnMethods = "validateTitles_onlineProducts")
    public void validateFirstSportsShoes() {
        test = extent.createTest("Validate First Sports Shoe", "This test validates First Sports Shoe on Online Products Page");
        boolean isSportsShoeValid = ProductsPage.sportsShoes_firstShoe_verify();
        if (!isSportsShoeValid) {
            test.fail("Validation failed for the first sports shoe.");
        }
    }

    @AfterSuite
    public void cleanup() {
        extent.flush();
        driver.quit();
    }
}
