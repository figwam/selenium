package plain;

/**
 * leantrace GmbH
 * http://www.leantrace.ch/
 * <p>
 * (c) Copyright leantrace GmbH. All rights reserved.
 * <p>
 * This product is the proprietary and sole property of leantrace GmbH.
 * Use, duplication or dissemination is subject to prior written consent of
 * leantrace GmbH.
 * <p>
 * Created on 31.01.17
 *
 * @author: Alexander Schamne <alexander.schamne@leantrace.ch>
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BuilderExportTest {
    FirefoxDriver wd;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver",
                "/Users/alex/workspace/leantrace/swisscom/selenium-workshop/webdriverio/geckodriver");
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Test
    public void BuilderExportTest() {
        wd.get("https://www.swisscom.ch/en/residential.html");
        wd.findElement(By.cssSelector(".scsh-sitesearch-open-button")).click();
        wd.findElement(By.id("scs-sitesearch-search-field-2050931542")).click();
        wd.findElement(By.id("scs-sitesearch-search-field-2050931542")).clear();
        wd.findElement(By.id("scs-sitesearch-search-field-2050931542")).sendKeys("iphone 7");
        wd.findElement(By.id("scsh-sitesearch-button-2050931542")).click();
        wd.findElement(By.cssSelector("div.scs-sitesearch-product-teaser")).click();
        wd.findElement(By.cssSelector("div.scs-sitesearch-product-teaser-intro")).click();
    }

    @After
    public void tearDown() {
        wd.quit();
    }

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
