package com.taxiandroid.ru.lvexample3;

import java.util.ArrayList;

/**
 * Created by saperov on 16.10.15.
 */
public class User {
    public String name;
    public String hometown;
    static ArrayList<User> users;

    public User(String name, String hometown) {
        this.name = name;
        this.hometown = hometown;
    }
    public static ArrayList<User> getUsers() {
       // ArrayList<User> users = new ArrayList<User>();
        users = new ArrayList<User>();
        users.add(new User("Harry", "San Diego"));
        users.add(new User("Marla", "San Francisco"));
        users.add(new User("Sarah", "San Marco"));
        return users;
    }
    public static ArrayList<User> delUsers() {
        users= new ArrayList<User>();
        users.clear();
        return users;
    }
    public static ArrayList<User> insUsers(String name, String hometown) {
        users = new ArrayList<User>();
        users.add(new User(name, hometown));

        return users;
    }

}
