package org.ojqa.domain.repository.jpa;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.ojqa.domain.pojo.User;
import org.ojqa.domain.repository.UserRepository;
import org.ojqa.domain.util.PagedQueryResult;
import org.ojqa.util.PojoInstanceFactory;
import org.springframework.context.ApplicationContext;

/**
 * I use AbstractTransactionalJUnit4SpringContextTests in version 46 , but it is really slow, so I roll back this test
 * to version 34.
 * 
 * @author iyu
 * 
 */
@SuppressWarnings("deprecation")
public class JPAUserRepositoryImplTest extends BaseJPATest {
    private static final int USER_SIZE_PER_PAGE = 5;
    private static final int USER_SIZE_IN_DB = 7;
    private UserRepository repository;

    public JPAUserRepositoryImplTest() {
        super();
        ApplicationContext ctx = super.getApplicationContext();
        repository = (UserRepository) ctx.getBean("userRepository");
        assertNotNull(repository);
    }

    @Test
    public void testFindUser() {
        User user = repository.find(1);
        assertEquals("name1", user.getName());
    }

    @Test
    public void testSaveUser() {
        User user = PojoInstanceFactory.createTransientUser();
        repository.save(user);
        Assert.assertNotNull(user.getId());
        Assert.assertNotNull(user.getCreateTime());

        String updatedName = "updatedName";
        user.setName(updatedName);
        repository.save(user);
        User updatedUser = repository.find(user.getId());
        assertEquals(updatedName, updatedUser.getName());
    }

    @Test
    public void testFindAllUsers() {
        List<User> allUsers = repository.findAll();
        assertEquals(USER_SIZE_IN_DB, allUsers.size());
        assertTrue(allUsers.get(0) instanceof User);

        jdbcTemplate.execute("delete from user");
        allUsers = repository.findAll();
        assertEquals(0, allUsers.size());
    }

    @Test
    public void testDeleteUser() {
        int count1 = jdbcTemplate.queryForInt("select count(*) from user");
        User user = PojoInstanceFactory.createTransientUser();
        repository.save(user);
        int count2 = jdbcTemplate.queryForInt("select count(*) from user");
        assertEquals(count1 + 1, count2);
        repository.delete(user);
        int count3 = jdbcTemplate.queryForInt("select count(*) from user");
        assertEquals(count1, count3);

    }

    @Test
    public void testFindUsers() {
        PagedQueryResult<User> users = repository.findAndPaging(0, USER_SIZE_PER_PAGE);
        assertEquals(true, users.isMore());
        assertEquals(USER_SIZE_PER_PAGE, users.getResults().size());
        assertTrue(users.getResults().get(0) instanceof User);

        users = repository.findAndPaging(USER_SIZE_PER_PAGE, USER_SIZE_PER_PAGE);
        assertEquals(false, users.isMore());
        assertEquals(2, users.getResults().size());

        jdbcTemplate.execute("delete from user");
        users = repository.findAndPaging(0, USER_SIZE_PER_PAGE);
        assertEquals(false, users.isMore());
        assertEquals(0, users.getResults().size());
    }

    public void testFindAndPagingWithExample() {
        User user = new User();
        user.setPassword("password");
        PagedQueryResult<User> users = repository.findAndPaging(0, USER_SIZE_PER_PAGE, user);
        assertEquals(2, users.getResults().size());
    }

    public void testFindByName() {
        User user = repository.getByName("name1");
        assertNotNull(user);
        assertEquals("name1", user.getName());
        assertEquals("password", user.getPassword());
    }

}
