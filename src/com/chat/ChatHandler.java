package com.chat;

import org.primefaces.context.RequestContext;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

/**
 * Created by shado on 7/14/2016.
 */
@ManagedBean
@ViewScoped
public class ChatHandler implements Serializable {

    @ManagedProperty("#{chatUsers}")
    private ChatUsers users;

    @ManagedProperty("#{chatMessages}")
    private ChatMessages messages;

    private String message;

    private String username;

    private boolean loggedIn;

    public ChatUsers getUsers() {
            return users;
    }

    public void setUsers(ChatUsers users) {
        this.users = users;
    }

    public ChatMessages getMessages() { return messages; }

    public void setMessages (ChatMessages messages) { this.messages = messages; }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isLoggedIn() {
        return this.loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public void sendMessage() {
        messages.add(getUsername(), message);
        message = null;
    }

    public void login() {
        if (users.contains(username)) {
            loggedIn = false;
        } else {
            users.add(username);
            loggedIn = true;
        }
    }

    public void disconnect() {
        users.remove(username);
        loggedIn = false;
        username = null;
    }
}
