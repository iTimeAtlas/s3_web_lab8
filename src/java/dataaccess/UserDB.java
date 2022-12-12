package dataaccess;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import static javafx.scene.input.KeyCode.T;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;
import javax.persistence.Query;
import models.User;
import static models.User_.email;


public class UserDB {
    /**
     * 
     * @param email
     * @return 
     */
    public User get(String email) throws Exception{
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            User user = em.find(User.class, email);
            return user;
        } finally {
            em.close();
        }
    }
    
    /**
     * 
     * @return
     * @throws Exception 
     */
    public ArrayList<User> getAll() throws Exception{
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        ArrayList<User> users = new ArrayList<User>();
        
        ResultSet pInt = (ResultSet) em.createNamedQuery("SELECT COUNT(*) AS total FROM user");
        
        int listSize = pInt.getInt("total");
        
        if (listSize == 0) {
            throw new Exception();
        }
        
        for (int loop1 = 0; loop1 <  listSize; loop1++) {
            ResultSet curRow = (ResultSet) em.createNamedQuery("SELECT email AS theEmail FROM user WHERE ROWNUM() = " + loop1);
            String holderStr = curRow.getString("theEmail");
            User user = em.find(User.class, holderStr);
            users.add(user);
        }
        
        em.close();
        return users;
    }
    
    
    /**
     * 
     * @param note
     * @throws Exception 
     */
    public void insert(User user) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            
            trans.begin();
            em.persist(user);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
    /**
     * 
     * @param user
     * @throws Exception 
     */
    public void update(User user) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.merge(user);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
    /**
     * 
     * @param note
     * @throws Exception 
     */
    public void delete(User user) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
  
        try {
            trans.begin();
            em.remove(em.merge(user));
            em.merge(user);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }       
        
    }
    
    
}
