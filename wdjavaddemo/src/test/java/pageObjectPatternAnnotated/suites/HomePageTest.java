package pageObjectPatternAnnotated.suites;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObjectPatternAnnotated.pages.HomePage;
import pageObjectPatternAnnotated.pages.SearchResultPage;
import utils.Utils;

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
 */
public class HomePageTest {

    private HomePage homePage = new HomePage(Utils.DEFAULT_DRIVER);

    @Before
    public void setUp() throws Exception {
        homePage.open();
    }

    @Test
    public void testSimpleSwisscom() throws Exception {
        SearchResultPage result = homePage.doSearch("iphone 7");
        assertEquals("Apple", result.getProductTitle());
        assertEquals("iPhone 7", result.getProductTeaser());
        Utils.takeScreenShot("testSimpleSwisscom.png",homePage.getDriver());
    }

    @After
    public void tearDown() throws Exception {
        homePage.close();
    }
}
