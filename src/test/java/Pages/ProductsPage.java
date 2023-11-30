package Pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static Tests.SeleniumTest.driver;
import static Tests.SeleniumTest.*;

public class ProductsPage {
    public static String formalShoes_xpath = "/html/body/div[2]/center/h2";
    public static String sportsShoes_xpath = "/html/body/div[3]/center/h2";
    public static String sneakers_xpath = "/html/body/div[4]/center/h2";


    public static String formalShoesDropdown_xpath = "/html/body/div[2]/center/div/i[1]";

    public static String sportsShoesDropdown_xpath = "/html/body/div[3]/center/div/i[1]";

    public static String sneakersDropdown_xpath = "/html/body/div[4]/center/div/i[1]";

    public static String formalShoes_firstShoeName = "/html/body/div[2]/table/tbody/tr[1]/td[1]";

    public static String sportsShoes_firstShoeName = "/html/body/div[3]/table/tbody/tr[1]/td[1]";




    public static String formalShoes_verifyTitle() {
        String expectedTitleFs = "Formal Shoes";
        String actualTitleFs = null;

        try {
            actualTitleFs = driver.findElement(By.xpath(formalShoes_xpath)).getText();
            Assert.assertEquals(expectedTitleFs, actualTitleFs);
            test.log(Status.PASS, "Test passed for title verification of formal shoes");
        } catch (NoSuchElementException e) {
            test.log(Status.FAIL, "Element not found for Formal Shoes title verification");
            logErrorDetails("Formal Shoes", "Element not found");
            throw new AssertionError("Test failed for title verification of Formal Shoes", e);
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Test failed for title verification of formal shoes");

            logErrorDetails("Formal Shoes", "Expected Title: " + expectedTitleFs + "\nActual Title: " + actualTitleFs);
            throw new AssertionError("Test failed for title verification of Formal Shoes", e);
        }
        return expectedTitleFs;
    }



    public static String sportsShoes_verifyTitle() {
        String expectedTitleSs = "Sports Shoes";
        String actualTitleSs = null;

        try {
            actualTitleSs = driver.findElement(By.xpath(sportsShoes_xpath)).getText();
            Assert.assertEquals(expectedTitleSs.toLowerCase(), actualTitleSs.toLowerCase());
            test.log(Status.PASS, "Test passed for title verification of sports shoes");
        } catch (NoSuchElementException e) {
            test.log(Status.FAIL, "Element not found for Sports Shoes title verification");
            logErrorDetails("Sports Shoes", "Element not found");
            throw new AssertionError("Test failed for title verification of Sports Shoes", e);
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Test failed for title verification of sports shoes");

            logErrorDetails("Sports Shoes", "Expected Title: " + expectedTitleSs + "\nActual Title: " + actualTitleSs);
            throw new AssertionError("Test failed for title verification of Sports Shoes", e);
        }
        return expectedTitleSs;
    }


    public static String sneakers_verifyTitle() {
        String expectedTitleSn = "Sneakers";

        String actualTitleSn = null;
        try {
            WebElement sneakersElement = driver.findElement(By.xpath(sneakers_xpath));
            actualTitleSn = sneakersElement.getText();
            Assert.assertEquals(expectedTitleSn, actualTitleSn);
            test.log(Status.PASS, "Test passed for title verification of Sneakers");
        } catch (NoSuchElementException e) {
            test.log(Status.FAIL, "Element not found for Sneakers title verification");
            logErrorDetails("Sneakers", "Element not found");
            throw new AssertionError("Test failed for title verification of Sneakers", e);
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Test failed for title verification of Sneakers");
            logErrorDetails("Sneakers", "Expected Title: " + expectedTitleSn + "\nActual Title: " + actualTitleSn);
            throw new AssertionError("Test failed for title verification of Sneakers", e);
        }
        return expectedTitleSn;
    }


    private static void logErrorDetails(String shoeType, String errorDetails) {
        test.log(Status.FAIL, "Details for " + shoeType + ":\n" + errorDetails);
    }



    public static void formalShoes_firstShoe_verify() {
        String expectedFirstFormalShoe = "Classic Cheltenham";
        driver.findElement(By.xpath(formalShoesDropdown_xpath)).click();
        String actualFirstFormalShoe = driver.findElement(By.xpath(formalShoes_firstShoeName)).getText().trim();
        Assert.assertEquals(expectedFirstFormalShoe, actualFirstFormalShoe);

        if (!expectedFirstFormalShoe.equals(actualFirstFormalShoe)) {
            throw new AssertionError("Test failed for first shoe name of formal shoe i.e Classic Cheltanham");
        } else {
            test.log(Status.PASS, "Test passed for first shoe name of formal shoe i.e Classic Cheltanham");
        }
    }

    public static void sportShoes_firstShoe_verify() {
        String expectedFirstSportsShoe = "Ultimate";
        driver.findElement(By.xpath(sportsShoesDropdown_xpath)).click();
        String actualFirstSportsShoe = driver.findElement(By.xpath(sportsShoes_firstShoeName)).getText().trim();
        Assert.assertEquals(expectedFirstSportsShoe, actualFirstSportsShoe);

        if (!expectedFirstSportsShoe.equals(actualFirstSportsShoe)) {
            throw new AssertionError("Test failed for first shoe name of sports shoe i.e Classic Ultimate");
        } else {
            test.log(Status.PASS, "Test passed for first shoe name of sports shoe i.e Classic Ultimate");
        }
    }



}
