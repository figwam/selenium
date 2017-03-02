package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

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
public class Utils {

    static {
        System.setProperty("webdriver.gecko.driver",
                "/Users/alex/workspace/leantrace/swisscom/selenium-workshop/driver/geckodriver");
        System.setProperty("webdriver.chrome.driver",
                "/Users/alex/workspace/leantrace/swisscom/selenium-workshop/driver/chromedriver");
        System.setProperty("webdriver.safari.driver",
                "/usr/bin/safaridriver");
    }

    public final static long DEFAULT_WAIT_TIME_OUT_IN_SECONDS = 5;
    public final static WebDriver DEFAULT_DRIVER = new ChromeDriver(); //new ChromeDriver(); //FirefoxDriver();
}
