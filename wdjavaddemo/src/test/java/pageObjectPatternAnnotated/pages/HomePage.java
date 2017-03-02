package pageObjectPatternAnnotated.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
public class HomePage extends PageObject {

    private final String URL = "https://www.swisscom.ch/en/residential.html";

    @FindBy(css = ".scsh-sitesearch-open-button")
    private WebElement searchButtonSelector;

    @FindBy(id = "scs-sitesearch-search-field-2050931542")
    private WebElement searchFieldSelector;

    @FindBy(id = "scsh-sitesearch-button-2050931542")
    private WebElement searchFieldButtonSelector;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public HomePage open(){
        this.driver.get(URL);
        return this;
    }

    public SearchResultPage doSearch(String searchString){
        searchButtonSelector.click();
        searchFieldSelector.clear();
        searchFieldSelector.sendKeys(searchString);
        searchFieldButtonSelector.submit();
        return new SearchResultPage(driver);
    }

    public HomePage close(){
        this.driver.quit();
        return this;
    }
}
