package com.github.debbysa;

import com.github.debbysa.models.User;

public class Session {
    private Settings settings;
    private String user;

    public Session(Settings settings) {
        this.settings = settings;
        user = settings.getUser();
    }

    public User doLogin(String username, String password){
        User fondUser = null;
        for (User user : Data.getUsers()){
            if (username.equals(user.getUsername())
                && password.equals(user.getPassword())) {
                fondUser = user;
                break;
            }
        }
        return fondUser;
    }

    public void doLogout(){
        settings.removeUser();
        this.user = null;
    }

    public boolean isLogin(){

        return user != null;
    }

    public String getUser(){

        return user;
    }

    public void setUser(String user){
        settings.setUser(user);
        this.user = user;
    }
}
