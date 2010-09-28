package org.ojqa.util;

import java.text.SimpleDateFormat;

import org.ojqa.domain.pojo.User;

/**
 * @author ybak
 * 
 */
public final class PojoInstanceFactory {

    private PojoInstanceFactory() {
    }

    public static final long USER_ID = 123L;

    public static User createPersistentUser() {
        User user = new User();
        user.setId(USER_ID);
        user.setName("ybak");
        user.setPassword("520811");
        user.setConfirmPassword("520811");
        return user;
    }

    public static User createTransientUser() {
        User user = new User();
        user.setName("ybak");
        user.setPassword("520811");
        user.setConfirmPassword("520811");
        return user;
    }

    public static void main(String[] args) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        String dateString = "2010-05-23T19:15:49+08:00";
        int i = dateString.lastIndexOf(':');
        String newDateString = dateString.substring(0, i) + dateString.substring(i + 1);
        System.out.println(dateFormat.parse(newDateString));
    }
}
