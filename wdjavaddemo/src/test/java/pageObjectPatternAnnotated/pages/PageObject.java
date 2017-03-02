package pageObjectPatternAnnotated.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
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
public class PageObject {
    protected WebDriver driver;
    public PageObject(WebDriver driver){
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(Utils.DEFAULT_WAIT_TIME_OUT_IN_SECONDS, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }
}
