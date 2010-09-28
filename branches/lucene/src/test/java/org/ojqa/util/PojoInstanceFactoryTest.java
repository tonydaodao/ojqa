package org.ojqa.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.ojqa.domain.pojo.User;


/**
 * @author ybak
 *
 */
public class PojoInstanceFactoryTest {
    
    @Test
    public void testCreateTransientUser() {
        User transientUser1 = PojoInstanceFactory.createTransientUser();
        User transientUser2 = PojoInstanceFactory.createTransientUser();
        assertTrue(transientUser1.equals(transientUser2));
        testCreatePersistentUser();
    }

    @Test
    public void testCreatePersistentUser() {
        User persistentUser1 = PojoInstanceFactory.createPersistentUser();
        User persistentUser2 = PojoInstanceFactory.createPersistentUser();
        assertTrue(persistentUser1.equals(persistentUser2));
    }
}
