package org.ojqa.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Description;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.api.Action;
import org.jmock.api.Invocation;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ojqa.domain.pojo.User;
import org.ojqa.domain.repository.UserRepository;
import org.ojqa.util.PojoInstanceFactory;

/**
 * @author ybak
 * 
 */
@RunWith(JMock.class)
public class UserServiceImplTest {
    private Mockery context = new JUnit4Mockery();
    private UserServiceImpl service = new UserServiceImpl();
    private final UserRepository repository = context.mock(UserRepository.class);

    private void checkingRepositoryFindAllUsers() {
        context.checking(new Expectations() {
            {
                oneOf(repository).findAll();
                List<User> result = new ArrayList<User>();
                will(returnValue(result));
            }
        });
        service.setRepository(repository);
    }

    private void checkingRepositorySaveUser() {
        final User transientUser = PojoInstanceFactory.createTransientUser();
        context.checking(new Expectations() {
            {
                oneOf(repository).save(transientUser);
                will(new SaveUserAction());
            }
        });
        service.setRepository(repository);
    }

    @Test
    public void testSaveUser() {
        checkingRepositorySaveUser();
        User user = PojoInstanceFactory.createTransientUser();
        assertNull(user.getId());
        service.save(user);
        assertNotNull(user.getId());
    }

    @Test
    public void testFindAllUser() {
        checkingRepositoryFindAllUsers();
        List<User> users = service.getAll();
        assertNotNull(users);
    }

    /**
     * Mock saving user function.
     *
     */
    class SaveUserAction implements Action {
        public Object invoke(Invocation invocation) throws Throwable {
            ((User) invocation.getParameter(0)).setId(PojoInstanceFactory.USER_ID);
            return null;
        }
        
        public void describeTo(Description arg0) {
        }
        
    }
}
