package com.walidatorkh.linkto;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by jbt on 25/06/2017.
 */

public class User {
    private int id;
    private String name;
    private String username;
    private String email;

    public User(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        setId(jsonObject.getInt("id"));
        setName(jsonObject.getString("name"));
        setUsername(jsonObject.getString("username"));
        setEmail(jsonObject.getString("email"));
    }

    public String toString(){
        return "ID:" + id + "\nName: " + name + "\nUser Name: " + username + "\nEmail: " + email;
    }

    public User(int id, String name, String username, String email) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
