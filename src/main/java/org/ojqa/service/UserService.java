package org.ojqa.service;

import org.ojqa.domain.pojo.User;

/**
 * @author ybak
 * 
 */
public interface UserService extends BaseService<User> {

    /** Get User by userName.
     * @param pName
     * @return User
     */
    User getByName(String pName);

}
