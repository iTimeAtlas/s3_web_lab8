/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dataaccess.UserDB;
import models.User;

/**
 *
 * @author Timle
 */
public class UserServices {
    
    
    public void update(String email, String fName, String lName, String password) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        user.setFirstName(fName);
        user.setLastName(lName);
        user.setPassword(password);
        
        userDB.update(user);
    }
}
