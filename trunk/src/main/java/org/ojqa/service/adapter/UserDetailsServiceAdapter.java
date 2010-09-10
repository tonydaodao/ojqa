package org.ojqa.service.adapter;

import java.util.Arrays;
import java.util.Collection;

import org.ojqa.domain.pojo.User;
import org.ojqa.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Adapter to get User info for spring security authorization.
 * 
 * @author ybak
 * 
 */
public class UserDetailsServiceAdapter implements UserDetailsService {

    private UserService userService;

    // TODO unimplemented
    public UserDetails loadUserByUsername(String username) {
        User user = userService.getByName(username);
        Collection<GrantedAuthority> authorities = Arrays.asList();
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), true, true,
                true, true, authorities);
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService pUserService) {
        this.userService = pUserService;
    }

}
