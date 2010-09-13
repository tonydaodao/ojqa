package org.ojqa.service.impl;

import java.util.Arrays;
import java.util.List;

import org.ojqa.domain.pojo.User;
import org.ojqa.domain.repository.UserRepository;
import org.ojqa.service.UserService;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author ybak
 */
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService, UserDetailsService {

    public User getByName(final String pName) {
        return ((UserRepository) this.getRepository()).getByName(pName);
    }

    public UserDetails loadUserByUsername(final String username) {
        User user = this.getByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not exsit.");
        }
        List authorities = Arrays.asList();
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), true, true,
                true, true, authorities);
    }
}
