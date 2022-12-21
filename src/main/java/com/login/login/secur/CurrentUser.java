package com.login.login.secur;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class CurrentUser extends User {
   private final com.login.login.model.User user;

    public CurrentUser(com.login.login.model.User user1) {
        super(user1.getEmail(), user1.getPassword(), AuthorityUtils.createAuthorityList(user1.getUserType().name()));
        this.user = user1;
    }
    public com.login.login.model.User getUser() {
        return this.user;
    }
}
