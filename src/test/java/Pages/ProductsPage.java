package Pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;

import static Tests.SeleniumTest.driver;
import static Tests.SeleniumTest.test;

public class ProductsPage {
    public static String formalShoes_xpath = "/html/body/div[2]/center/h2";
    public static String sportsShoes_xpath = "/html/body/div[3]/center/h2";
    public static String sneakers_xpath = "/html/body/div[4]/center/h2";

    public static String formalShoesDropdown_xpath = "/html/body/div[2]/center/div/i[1]";
    public static String sportsShoesDropdown_xpath = "/html/body/div[3]/center/div/i[1]";
    public static String sneakersDropdown_xpath = "/html/body/div[4]/center/div/i[1]";

    public static String formalShoes_firstShoeName = "/html/body/div[2]/table/tbody/tr[1]/td[1]";
    public static String sportsShoes_firstShoeName = "/html/body/div[3]/table/tbody/tr[1]/td[1]";

    public static void formalShoes_verifyTitle() {
        String expectedTitleFs = "Formal Shoes";
        String actualTitleFs = driver.findElement(By.xpath(formalShoes_xpath)).getText().trim();
        Assert.assertEquals(actualTitleFs, expectedTitleFs, "Title verification of formal shoes failed");
        logStatus(Status.PASS, Status.FAIL, "Title verification of formal shoes", expectedTitleFs, actualTitleFs);
    }

    public static void sportsShoes_verifyTitle() {
        String expectedTitleSs = "Sports Shoes";
        String actualTitleSs = driver.findElement(By.xpath(sportsShoes_xpath)).getText().trim();
        Assert.assertEquals(actualTitleSs, expectedTitleSs, "Title verification of sports shoes failed");
        logStatus(Status.PASS, Status.FAIL, "Title verification of sports shoes", expectedTitleSs, actualTitleSs);
    }

    public static void sneakers_verifyTitle() {
        String expectedTitleSn = "Sneakers";
        String actualTitleSn = driver.findElement(By.xpath(sneakers_xpath)).getText().trim();
        Assert.assertEquals(actualTitleSn, expectedTitleSn, "Title verification of sneakers failed");
        logStatus(Status.PASS, Status.FAIL, "Title verification of sneakers", expectedTitleSn, actualTitleSn);
    }

    public static boolean formalShoes_firstShoe_verify() {
        driver.findElement(By.xpath(formalShoesDropdown_xpath)).click();
        return verifyFirstShoeName(formalShoes_firstShoeName, "Classic Cheltenham");
    }

    public static boolean sportsShoes_firstShoe_verify() {
        driver.findElement(By.xpath(sportsShoesDropdown_xpath)).click();
        return verifyFirstShoeName(sportsShoes_firstShoeName, "Ultimate");
    }

    private static boolean verifyFirstShoeName(String xpath, String expectedShoeName) {
        String actualFirstShoeName = driver.findElement(By.xpath(xpath)).getText().trim();
        Assert.assertEquals(actualFirstShoeName, expectedShoeName, "First shoe name verification failed");
        logStatus(Status.PASS, Status.FAIL, "First shoe name verification", expectedShoeName, actualFirstShoeName);
        return expectedShoeName.equals(actualFirstShoeName);
    }

    private static void logStatus(Status passStatus, Status failStatus, String verification, String expected, String actual) {
        if (passStatus == Status.PASS) {
            test.log(passStatus, verification + " passed: " + expected);
        } else {
            test.log(failStatus, verification + " failed: Expected '" + expected + "', Actual '" + actual + "'");
        }
    }
}
