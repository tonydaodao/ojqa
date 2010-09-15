package org.ojqa.integration.selenium;

import com.thoughtworks.selenium.SeleneseTestCase;

/**
 * @author ybak
 * 
 */
public class SimpleIntegrationTest extends SeleneseTestCase {
    @Override
    public void setUp() throws Exception {
        setUp("http://localhost:9090/", "*chrome");
    }

    public void testUntitled() throws Exception {
        this.selenium.windowMaximize();
        this.selenium.setSpeed("2000");
        this.selenium.open("/actm/spring_security_login");
        this.selenium.type("j_username", "rod");
        this.selenium.type("j_password", "koala");
        this.selenium.click("submit");
        this.selenium.waitForPageToLoad("30000");
        this.selenium.click("//div[@id='main']/a/span");
        this.selenium.waitForPageToLoad("30000");
        this.selenium.type("name", "newUser");
        this.selenium.type("password", "password");
        this.selenium.type("confirmPassword", "Password");
        this.selenium.click("//input[@value='Submit']");
        this.selenium.waitForPageToLoad("30000");
        this.selenium.click("//div[@id='main']/table/tbody/tr");
        this.selenium.waitForPageToLoad("30000");
        this.selenium.click("//div[@id='main']/form/ul/li[3]/a");
        this.selenium.waitForPageToLoad("30000");
        this.selenium.click("link=Logout");
        this.selenium.waitForPageToLoad("30000");
    }
}
