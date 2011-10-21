/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import exceptions.PreexistingEntityException;
import entities.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author guilherme
 */
public class UserDAOJpa {

    EntityManager em;

    public UserDAOJpa(EntityManager em) {
        this.em=em;
    }
    
    
    public void create(User user) throws PreexistingEntityException,Exception{
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (getUserbyId(user.getUsername()) != null) {
                throw new PreexistingEntityException("User " + user + " already exists.");
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
            //em.close();
      
        }
    }

    public void update(User user){
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
        //em.close();
    }

    public void delete(String id){
        em.getTransaction().begin();
        em.remove(this.getUserbyId(id));
        em.getTransaction().commit();
        //em.close();
    }

    public List<User> findUsers() {
        Query q = em.createQuery("select u from User");
        return q.getResultList();
    }

    public User getUserbyId(String id) {
        Query q = em.createQuery("select u from User u where u.username = :id");
        q.setParameter("id", id);
        return (User) q.getResultList().get(0);
    }

    
    
}
