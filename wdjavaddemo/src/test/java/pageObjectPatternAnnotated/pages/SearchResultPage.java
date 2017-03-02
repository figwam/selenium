package pageObjectPatternAnnotated.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

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
public class SearchResultPage extends PageObject {

    private WebDriverWait wait;

    @FindBy(css = ".scs-sitesearch-product-teaser-title")
    private WebElement productTitleSelector;

    @FindBy(css = ".scs-sitesearch-product-teaser-intro")
    private WebElement productTeaserSelector;

    public SearchResultPage(WebDriver driver){
        super(driver);
    }

    public String getProductTitle(){
        return productTitleSelector.getText();
    }

    public String getProductTeaser(){
        return productTeaserSelector.getText();
    }
}
