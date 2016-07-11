package com.chat;

import org.primefaces.context.RequestContext;
import org.primefaces.push.EventBus;
import org.primefaces.push.EventBusFactory;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

/**
 * Created by shado on 7/11/2016.
 */
@ManagedBean
@ViewScoped
public class ViewHandler implements Serializable {
    private final EventBus eventBus = EventBusFactory.getDefault().eventBus();
    //private final static String CHANNEL = "/{room}/";

    @ManagedProperty("#{users}")
    private Users users;

    private String username;

    private boolean loggedIn;

    private String message;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn() {
        this.loggedIn = loggedIn;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void sendMessage() {
        eventBus.publish(username + ": " + message);
        message = null;
    }

    public void login() {
        RequestContext requestContext = RequestContext.getCurrentInstance();

        if (users.contains(username)) {
            loggedIn = false;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Username is already in use", "Try again!"));
            requestContext.update("growl");
        } else {
            users.add(username);
            requestContext.execute("PF('subscriber').connect('/" + username + "')");
            loggedIn = true;
        }
    }

    public void disconnect() {
        users.remove(username);
        RequestContext.getCurrentInstance().update("form:users");

        eventBus.publish(username + " left the channel.");

        loggedIn = false;
        username = null;
    }
}
