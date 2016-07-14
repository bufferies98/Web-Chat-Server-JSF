package com.chat;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shado on 7/14/2016.
 */
@ManagedBean
@ApplicationScoped
public class ChatUsers implements Serializable {
    private List<String> users = new ArrayList<String>();

    public List<String> getUsers() {
        return this.users;
    }

    public void remove(String user) {
        this.users.remove(user);
    }

    public void add(String user) {
        this.users.add(user);
    }

    public boolean contains(String user) {
        return this.users.contains(user);
    }
}
