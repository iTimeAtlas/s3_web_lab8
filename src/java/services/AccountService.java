package services;

import dataaccess.UserDB;
import models.Role;
import models.User;

public class AccountService {
    
    public User login(String email, String password) {
        UserDB userDB = new UserDB();
        
        try {
            User user = userDB.get(email);
            if (password.equals(user.getPassword())) {
                return user;
            }
        } catch (Exception e) {
        }
        
        return null;
    }
    
    public void signUp(String email, String fName, String lName, String password) throws Exception {
        UserDB userDB = new UserDB();
        
        Role role = new Role(2);
        
        User newUser = new User(email, true, fName, lName, password, role);
        
        userDB.insert(newUser);
       
    }
    
    
    
    
}
