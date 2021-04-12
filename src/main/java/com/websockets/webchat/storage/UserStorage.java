package com.websockets.webchat.storage;

import java.util.Set;
import java.util.HashSet;
public class UserStorage {

    private static UserStorage instance;
    private Set<String> users;

    private UserStorage()
    {
        users = new HashSet<>();
    }

    public static synchronized UserStorage getInstance()
    {
        if (instance == null)
        {
            instance = new UserStorage();
        }
        return instance;
    }

    public Set<String> getUsers(){ return users; }

    public void setUser(String username) throws Exception {
        if(users.contains(username))
        {
             throw new Exception("User already exists" + username);
        }
        users.add(username);
    }
}
