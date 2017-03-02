package plain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

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
 *
 *
 * driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
 * OR
 * wait = new WebDriverWait(driver, 5);
 * wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".scsh-sitesearch-open-button")));
 * OR
 * wait.until(ExpectedConditions.visibilityOf(searchFieldSelector));
 */
public class SimpleSwisscomTest {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver",
                "/Users/alex/workspace/leantrace/swisscom/selenium-workshop/driver/geckodriver");
        driver = new FirefoxDriver();
        baseUrl = "https://www.swisscom.ch/";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testSimpleSwisscom() throws Exception {
        driver.get(baseUrl + "en/residential.html");
        driver.findElement(By.cssSelector(".scsh-sitesearch-open-button")).click();
        driver.findElement(By.id("scs-sitesearch-search-field-2050931542")).clear();
        driver.findElement(By.id("scs-sitesearch-search-field-2050931542")).sendKeys("iphone 7");
        driver.findElement(By.id("scsh-sitesearch-button-2050931542")).submit();
        assertEquals("Apple", driver.findElement(By.cssSelector(".scs-sitesearch-product-teaser-title"))
                .getText());
        assertEquals("iPhone 7", driver.findElement(By.cssSelector(".scs-sitesearch-product-teaser-intro"))
                .getText());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
