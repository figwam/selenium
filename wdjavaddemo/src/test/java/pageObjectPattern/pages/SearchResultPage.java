package pageObjectPattern.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
public class SearchResultPage {

    private WebDriver driver;

    private By productTitleSelector;
    private By productTeaserSelector;

    public SearchResultPage(WebDriver driver){
        this.driver = driver;
        /* HTML Elements */
        productTitleSelector = By.cssSelector(".scs-sitesearch-product-teaser-title");
        productTeaserSelector = By.cssSelector(".scs-sitesearch-product-teaser-intro");
    }

    public String getProductTitle(){
        return driver.findElement(productTitleSelector).getText();
    }

    public String getProductTeaser(){
        return driver.findElement(productTeaserSelector).getText();
    }
}
