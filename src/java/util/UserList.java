/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entities.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guilherme
 */
public class UserList {
    
    private static UserList _instance = null;
    private List<User> usersLogged = null;
    private UserList() {
        usersLogged = new ArrayList<User>();
    }
    
    public static UserList getInstance() {
        if(UserList._instance==null)
            UserList._instance=new UserList();
        return UserList._instance;
    }
    public void addUser(User u){
        if(this.usersLogged.contains(u)){
        }
        else this.usersLogged.add(u);
    }
    public List<User> getList(){
        return this.usersLogged;
    }
}
