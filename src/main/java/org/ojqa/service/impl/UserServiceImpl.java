package org.ojqa.service.impl;

import org.ojqa.domain.pojo.User;
import org.ojqa.domain.repository.UserRepository;
import org.ojqa.service.UserService;

/**
 * @author ybak
 * 
 */
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {


    public User getByName(String pName) {
        return ((UserRepository) getRepository()).getByName(pName);
    }

}
