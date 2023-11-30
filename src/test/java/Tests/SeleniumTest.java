package Tests;

import Pages.HomePage;
import Pages.ProductsPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.browsingcontext.BrowsingContext;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static Pages.ProductsPage.formalShoes_verifyTitle;
import static Pages.ProductsPage.sneakers_verifyTitle;

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



    @Test(groups = "validateTitles_onlineProducts", alwaysRun = true)
    public void validateTitles_onlineProducts() throws InterruptedException {
        test = extent.createTest("Validate Shoe Titles on Product Page", "This test validates that the different shoe types are correct on Online Products Page");

        try {
            ProductsPage.formalShoes_verifyTitle();
            test.log(Status.PASS, "Title verification passed for Formal Shoes");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Title verification failed for Formal Shoes");
        }

        try {
            ProductsPage.sportsShoes_verifyTitle();
            test.log(Status.PASS, "Title verification passed for Sports Shoes");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Title verification failed for Sports Shoes");
        }

        try {
            ProductsPage.sneakers_verifyTitle();
            test.log(Status.PASS, "Title verification passed for Sneakers");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Title verification failed for Sneakers");
        }

        extent.flush();
    }



    @Test(groups = "validateTitles_onlineProducts")
    public void validateFirstFormalShoes() {
        test = extent.createTest("Validate First Formal Shoe", "This test validates First Formal Shoe on Online Products Page");
        try {
            ProductsPage.formalShoes_firstShoe_verify();
            test.pass("Validation passed for the first formal shoe.");
        } catch (AssertionError e) {
            test.fail("Validation failed for the first formal shoe.");
            throw e; // This line ensures that the main test function fails if the validation fails
        }
    }

    @Test(groups = "validateTitles_onlineProducts")
    public void validateFirstSportsShoes() {
        test = extent.createTest("Validate First Sports Shoe", "This test validates First Sports Shoe on Online Products Page");
        try {
            ProductsPage.sportShoes_firstShoe_verify();
            test.pass("Validation passed for the first sports shoe.");
        } catch (AssertionError e) {
            test.fail("Validation failed for the first sports shoe.");
            throw e; // This line ensures that the main test function fails if the validation fails
        }
    }

    @AfterSuite
    public void cleanup() {
        extent.flush();
        driver.quit();
    }

}