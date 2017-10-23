/*
 *Author: Yosra Harbaoui
 *Date: October 2017
 *Description: Class modeling a User
*/

package ch.heigvd.amt.yosra.model;

public class User {
    private int id;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}