package org.ojqa.integration.selenium;

import com.thoughtworks.selenium.SeleneseTestCase;

/**
 * @author ybak
 *
 */
public class SimpleIntegrationTest extends SeleneseTestCase {
    public void setUp() throws Exception {
        setUp("http://localhost:8080/", "*chrome");
    }

    public void testUntitled() throws Exception {
        selenium.windowMaximize();
        selenium.setSpeed("2000");
        selenium.open("/actm/spring_security_login");
        selenium.type("j_username", "rod");
        selenium.type("j_password", "koala");
        selenium.click("submit");
        selenium.waitForPageToLoad("30000");
        selenium.click("//div[@id='main']/a/span");
        selenium.waitForPageToLoad("30000");
        selenium.type("name", "newUser");
        selenium.type("password", "password");
        selenium.type("confirmPassword", "Password");
        selenium.click("//input[@value='Submit']");
        selenium.waitForPageToLoad("30000");
        selenium.click("//div[@id='main']/table/tbody/tr");
        selenium.waitForPageToLoad("30000");
        selenium.click("//div[@id='main']/form/ul/li[3]/a");
        selenium.waitForPageToLoad("30000");
        selenium.click("link=Logout");
        selenium.waitForPageToLoad("30000");
    }
}
