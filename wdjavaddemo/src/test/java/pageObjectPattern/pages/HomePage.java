package pageObjectPattern.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Utils;

import java.util.concurrent.TimeUnit;

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
public class HomePage {

    private WebDriver driver;
    private final String URL = "https://www.swisscom.ch/en/residential.html";

    private By searchButtonSelector;
    private By searchFieldSelector;
    private By searchFieldButtonSelector;

    public HomePage(){
        this.driver = Utils.DEFAULT_DRIVER;
        this.driver.manage().timeouts().implicitlyWait(Utils.DEFAULT_WAIT_TIME_OUT_IN_SECONDS, TimeUnit.SECONDS);
        /* HTML Elements */
        this.searchButtonSelector = By.cssSelector(".scsh-sitesearch-open-button");
        this.searchFieldSelector = By.id("scs-sitesearch-search-field-2050931542");
        this.searchFieldButtonSelector = By.id("scsh-sitesearch-button-2050931542");
    }

    public HomePage(WebDriver driver){
        this();
        this.driver = driver;
    }

    public HomePage open(){
        this.driver.get(URL);
        return this;
    }

    public SearchResultPage doSearch(String searchString){
        this.driver.findElement(searchButtonSelector).click();
        driver.findElement(searchFieldSelector).clear();
        driver.findElement(searchFieldSelector).sendKeys(searchString);
        driver.findElement(searchFieldButtonSelector).submit();
        return new SearchResultPage(driver);
    }

    public HomePage close(){
        this.driver.quit();
        return this;
    }
}
