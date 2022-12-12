/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Timle
 */
@Entity
@Table(name = "item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i")
    , @NamedQuery(name = "Item.findByItemId", query = "SELECT i FROM Item i WHERE i.item_id = :itemId")
    , @NamedQuery(name = "Item.findByCategory", query = "SELECT i FROM Item i WHERE i.category = :category")
    , @NamedQuery(name = "User.findByItemName", query = "SELECT i FROM Item i WHERE i.item_name= :itemName")
    , @NamedQuery(name = "User.findByPrice", query = "SELECT i FROM Item i WHERE i.price = :price")
    , @NamedQuery(name = "User.findByOwner", query = "SELECT i FROM Item i WHERE i.owner = :owner")})
public class Item {
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "item_Id")
    private Integer itemId;
    @Basic(optional = false)
    @Column(name = "category")
    private Integer category;
    @Basic(optional = false)
    @Column(name = "item_name")
    private String itemName;
    @Basic(optional = false)
    @Column(name = "price")
    private Float price;
    @Basic(optional = false)
    @Column(name = "owner")
    private User owner;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "email", fetch = FetchType.EAGER)
    private List<User> userList;
    
    public Item(){}
    
    public Item(int reqId, int reqCat, String reqName, User reqOwner) {
        itemId = reqId;
        category = reqCat;
        itemName = reqName;
        owner = reqOwner;
    }
    
    public Item(int reqId, int reqCat, String reqName, float reqPrice, User reqOwner) {
    
        itemId = reqId;
        category = reqCat;
        itemName = reqName;
        price = reqPrice;
        owner = reqOwner;
        
    }
    
    // setters and getters
    
    // ID
    
    public int getId() {
        return itemId; 
    }
    
    public void setId(int reqId) {
        itemId = reqId;
    }
    
    
    //Cat
    
    public int getCat(){
     return category;
    }
    
    public void setCat(int reqCat) {
        category = reqCat;
    }
    
    
    // item Name
    
    public String getName() {
        return itemName;
    }

    public void setName(String reqName) {
        itemName = reqName;
    }
    
    // price
    
    public float getPrice() {
        return price;
    }
    
    public void setPrice(float reqPrice) {
        price = reqPrice;
    }
    
    
    // Owner
    
    public User getOwner() {
        return owner;
    }
    
    
    public void setOwner(User reqEmail) {
        owner = reqEmail;
    }
    
    
    // Users
    
    public List<User> getUsers() {
        return userList;
    }
    
    public void setUsers(List<User> reqUsers) {
        userList = reqUsers;
    }
    
    @Override
    public String toString() {
        return "models.Item[ item.itemId=" + itemId + "  item.itemName=" + itemName + "]";
    }
    
}
