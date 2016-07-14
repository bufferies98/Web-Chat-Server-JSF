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
public class ChatMessages implements Serializable {
    private List<String> messages = new ArrayList<String>();

    public List<String> getMessages() {
        return this.messages;
    }

    public void add(String user, String msg) {
        String message = "[" + user + "]: " + msg;
        this.messages.add(message);
    }
}
