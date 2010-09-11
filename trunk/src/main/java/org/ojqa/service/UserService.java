package org.ojqa.service;

import org.ojqa.domain.pojo.User;

/**
 * @author ybak
 * 
 */
public interface UserService extends BaseService<User> {

    /**
     * @param pName
     *            the name of the User
     * @return a user instance
     */
    User getByName(String pName);

}
