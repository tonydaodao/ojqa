package org.ojqa.integration.selenium;

import java.util.UUID;

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

    public void testIntegration() throws Exception {
        String username = UUID.randomUUID().toString();
        String password = "password";

        this.selenium.windowMaximize();
        this.selenium.setSpeed("1000");
        this.selenium.open("/ojqa/spring_security_login");
        this.selenium.click("link=Users");
        this.selenium.click("//div[@id='main']/a/span");
        this.selenium.type("name", username);
        this.selenium.type("password", password);
        this.selenium.type("confirmPassword", password);
        this.selenium.click("//input[@value='Submit']");
        this.selenium.click("link=Comments");
        this.selenium.type("j_username", username);
        this.selenium.type("j_password", password);
        this.selenium.click("submit");
        this.selenium.click("//div[@id='main']/a/span");
        this.selenium.type("//input[@name='content']", "god like you");
        this.selenium.click("//input[@value='Submit']");
        this.selenium.click("link=ask a question");
        this.selenium.type("title", "a dumb question");
        this.selenium.type("myTextarea", "no question is dumb.");
        this.selenium.type("tagNames", "question");
        this.selenium.click("//input[@value='Ask Your Question']");
    }
}
