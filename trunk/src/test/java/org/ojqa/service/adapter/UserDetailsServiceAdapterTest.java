package org.ojqa.service.adapter;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ojqa.domain.pojo.User;
import org.ojqa.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Test class of UserDetailsServiceAdapter.
 * 
 * @author Isaac.Yu
 * 
 */
@RunWith(JMock.class)
public class UserDetailsServiceAdapterTest {
    private static final String PASSWORD = "password";
    private static final String USER_NAME = "name1";
    private Mockery context = new JUnit4Mockery();
    private UserDetailsServiceAdapter adapter = new UserDetailsServiceAdapter();
    private final UserService userService = context.mock(UserService.class);

    private void checkinServiceGetUserByName() {
        context.checking(new Expectations() {
            {
                allowing(userService).getByName(USER_NAME);
                User userResult = new User();
                userResult.setName(USER_NAME);
                userResult.setPassword(PASSWORD);
                will(returnValue(userResult));
            }
        });
        adapter.setUserService(userService);
    }

    @Test
    public void testLoadUserByUsername() {
        checkinServiceGetUserByName();
        UserDetails userDetails = adapter.loadUserByUsername(USER_NAME);
        Assert.assertNotNull(userDetails);
        Assert.assertEquals(USER_NAME, userDetails.getUsername());
        Assert.assertEquals(PASSWORD, userDetails.getPassword());
    }

}
