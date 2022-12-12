/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dataaccess.ItemDB;
import dataaccess.UserDB;
import java.util.List;
import models.Item;
import models.User;

/**
 *
 * @author Timle
 */
public class ItemService {
    
    /**
     * 
     * @param reqId
     * @return
     * @throws Exception 
     */
    public Item get(int reqId) throws Exception {
        ItemDB itemDB = new ItemDB();
        Item item = itemDB.get(reqId);
        
        return item;
        
        
    }
    
    /**
     * 
     * @param email
     * @return
     * @throws Exception 
     */
    public List<Item> getAll(String email) throws Exception {
        ItemDB itemDB = new ItemDB();
        List<Item> items = itemDB.getAll(email);
        return items;
    }
    
    
    /**
     * 
     * @param reqId
     * @param reqCat
     * @param itemName
     * @param owner
     * @throws Exception 
     */
    public void insert(int reqId, int reqCat, String itemName, String owner) throws Exception {
        UserDB userDB = new UserDB();
        
        User user = userDB.get(owner);
        
        Item item = new Item(reqId, reqCat, itemName, user);
       
        ItemDB itemDB = new ItemDB();
        itemDB.insert(item);
        
    }
    
    /**
     * 
     * @param reqId
     * @param itemName
     * @param price
     * @throws Exception 
     */
    public void update(int reqId, String itemName, float price) throws Exception {
        ItemDB itemDB = new ItemDB();
        Item item = itemDB.get(reqId);
        item.setName(itemName);
        item.setPrice(price);
        
        itemDB.update(item);
    }
    
    /**
     * 
     * @param noteId
     * @throws Exception 
     */
    public void delete(int reqId) throws Exception {
        ItemDB itemDB = new ItemDB();
        Item item = itemDB.get(reqId);
        itemDB.delete(item);
    }
    
}
