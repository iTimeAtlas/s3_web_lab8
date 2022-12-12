/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.User;
import models.Item;

/**
 *
 * @author Timle
 */
public class ItemDB {
    
    public List<Item> getAll(String owner) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
        
            User user = em.find(User.class, owner);
            return user.getItemList();
            
        } finally {
            em.close();
        }
        
    }
    
    /**
     *
     * @param reqId
     * @return
     */
    public Item get(int reqId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            
            Item item = em.find(Item.class, reqId);
            return item;
        
        } finally {
            em.close();
        }
    
    }
    
    /**
     * 
     * @param reqItem
     * @throws Exception 
     */
    public void insert(Item reqItem) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            User user = reqItem.getOwner();
            user.getItemList().add(reqItem);
            trans.begin();
            em.persist(reqItem);
            em.merge(user);
            trans.commit();
            
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
        
        
    // END OF METHOD    
    }
    
    /**
     * 
     * @param reqItem
     * @throws Exception 
     */
    public void update(Item reqItem)throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.merge(reqItem);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
    
    }
    
    public void delete(Item reqItem) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            User user = reqItem.getOwner();
            user.getNoteList().remove(reqItem);
            trans.begin();
            em.remove(em.merge(reqItem));
            em.merge(user);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
}
