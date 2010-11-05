package org.ojqa.integration.selenium;

import com.thoughtworks.selenium.SeleneseTestCase;

/**
 * @author ybak
 * 
 */
public class SimpleIntegrationTest extends SeleneseTestCase {
    @Override
    public void setUp() throws Exception {
        setUp("http://localhost:9090/ojqa/spring_security_login", "*chrome");
    }

    public void testUntitled() throws Exception {
        this.selenium.windowMaximize();
        this.selenium.setSpeed("1000");
        this.selenium.open("/ojqa/spring_security_login");
        this.selenium.click("link=Users");
        this.selenium.click("//div[@id='main']/a/span");
        this.selenium.type("name", "ybak");
        this.selenium.type("password", "520811");
        this.selenium.type("confirmPassword", "520811");
        this.selenium.click("//input[@value='Submit']");
        this.selenium.click("link=Comments");
        this.selenium.type("j_username", "ybak");
        this.selenium.type("j_password", "520811");
        this.selenium.click("submit");
        this.selenium.click("//div[@id='main']/a/span");
        this.selenium.type("//input[@name='content']", "god like you");
        // this.selenium.waitForPageToLoad("2000");
        this.selenium.click("//input[@value='Submit']");
        this.selenium.click("link=ask a question");
        this.selenium.type("title", "a dumb question");
        this.selenium.type("myTextarea", "no question is dumb.");
        this.selenium.type("tagNames", "question");
        this.selenium.click("//input[@value='Ask Your Question']");
    }
}
