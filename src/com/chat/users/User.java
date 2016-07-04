package com.chat.users;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Created by shado on 7/4/2016.
 */
@ManagedBean(name = "Users")
@SessionScoped
public class User implements Serializable {
    private String username;

    public User (String username) {
        this.username = username;
    }

    public User () {
        this.username = "ANON";
    }

    public String getUsername() {
        return this.username;
    }
}
