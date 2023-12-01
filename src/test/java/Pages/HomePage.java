package Pages;

import org.openqa.selenium.By;

import static Tests.SeleniumTest.driver;

public class HomePage {
    public static String hamburger_menu_xpath = "//*[@id=\"menuToggle\"]/input";
    public static String onlineProduct_link_xpath = "//*[@id=\"menu\"]/a[3]/li";

    public static void click_hamburger_menu(){
        driver.findElement(By.xpath(hamburger_menu_xpath)).click();
    }

    public static void click_onlineProduct_link() throws InterruptedException {
        Thread.sleep(1800);
        driver.findElement(By.xpath(onlineProduct_link_xpath)).click();
    }
}
