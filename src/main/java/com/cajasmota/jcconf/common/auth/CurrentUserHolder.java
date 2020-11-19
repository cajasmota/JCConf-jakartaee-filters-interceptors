package com.cajasmota.jcconf.common.auth;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class CurrentUserHolder {

    private CurrentUser currentUser;

    public void set(Long id, String name, String email){
        this.currentUser = new CurrentUser(id, name, email);
    }

    public CurrentUser get(){
        return this.currentUser;
    }
}
