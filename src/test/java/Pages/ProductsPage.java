package Pages;

import Tests.SeleniumTest;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.observer.entity.MediaEntity;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.IOException;

import static Tests.SeleniumTest.*;

public class ProductsPage {
    public static String formalShoesXpath = "/html/body/div[2]/center/h2";
    public static String sportsShoesXpath = "/html/body/div[3]/center/h2";
    public static String sneakersXpath = "/html/body/div[4]/center/h2";

    public static String formalShoesDropdownXpath = "/html/body/div[2]/center/div/i[1]";
    public static String sportsShoesDropdownXpath = "/html/body/div[3]/center/div/i[1]";

    public static String formalShoesFirstShowName = "/html/body/div[2]/table/tbody/tr[1]/td[1]";
    public static String sportsShoesFirstShowName = "/html/body/div[3]/table/tbody/tr[1]/td[1]";


    public static void formalShoesVerifyTitle() throws IOException {
        String expectedTitleFS = "Formal Shoes";

        String actualTitleFS = driver.findElement(By.xpath(formalShoesXpath)).getText().trim();
        Assert.assertEquals(expectedTitleFS, actualTitleFS);

        if (!expectedTitleFS.equals(actualTitleFS)) {
            // Capture screenshot before throwing the exception
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());

            // Throw the exception
            throw new AssertionError("Test failed for formal shoe name");
        } else {
            test.log(Status.PASS, "Test passed for formal shoe name");
            test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver)) + "Test Passed");
        }
    }



    public static void sportsShoesVerifyTitle() throws IOException {
        String expectedTitleSS = "Sports Shoes";

        String actualTitleSS = driver.findElement(By.xpath(sportsShoesXpath)).getText().trim();
        Assert.assertEquals(expectedTitleSS, actualTitleSS);

        if (!expectedTitleSS.equals(actualTitleSS)) {
            throw new AssertionError("Test failed for sport shoe name");

        } else {
            test.log(Status.PASS, "Test passed for sport shoe name");
            test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver))+ "Test Passed");
        }
    }


    public static void sneakersVerifyTitle(){
        String expectedTitleS = "Sneakers";

        String actualTitleS = driver.findElement(By.xpath(sneakersXpath)).getText().trim();
        Assert.assertEquals(expectedTitleS, actualTitleS);

        if (!expectedTitleS.equals(actualTitleS)) {
            throw new AssertionError("Test failed for Sneakers shoe name");
        } else {
            test.log(Status.PASS, "Test passed for Sneakers shoe name");
        }
    }


    public static void formalShoesFirstShoeVerify(){
        String expectedFirstFormalShoe = "Classic Cheltenham";
        driver.findElement(By.xpath(formalShoesDropdownXpath)).click();
        String actualFirstFormalShoe = driver.findElement(By.xpath(formalShoesFirstShowName)).getText().trim();
        Assert.assertEquals(expectedFirstFormalShoe, actualFirstFormalShoe);

        if (!expectedFirstFormalShoe.equals(actualFirstFormalShoe)) {
            throw new AssertionError("Test failed for first shoe name of Formal shoe i.e Classic Cheltenham");
        } else {
            test.log(Status.PASS, "Test passed for first shoe name of Formal shoe i.e Classic Cheltenham");
        }
    }

    public static void sportShoes_firstShoe_verify() {
        String expectedFirstSportsShoe = "Ultimate";
        driver.findElement(By.xpath(sportsShoesDropdownXpath)).click();
        String actualFirstSportsShoe = driver.findElement(By.xpath(sportsShoesFirstShowName)).getText().trim();
        Assert.assertEquals(expectedFirstSportsShoe, actualFirstSportsShoe);

        if (!expectedFirstSportsShoe.equals(actualFirstSportsShoe)) {
            throw new AssertionError("Test failed for first shoe name of sports shoe i.e Classic Ultimate");
        } else {
            test.log(Status.PASS, "Test passed for first shoe name of sports shoe i.e Classic Ultimate");
        }
    }
}