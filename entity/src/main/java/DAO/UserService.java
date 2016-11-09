package DAO;

import com.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by qny4i on 03.11.2016.
 */
public class UserService {


    public UserService() {

    }

//    public UserService(EntityManager em) {
//
//        this.em = em;
//    }

    public User createUser(User newUser) {
        EntityManager em = Persistence.createEntityManagerFactory("Jpa").createEntityManager();
        em.getTransaction().begin();
        User user = newUser;
        em.persist(user);
        em.getTransaction().commit();
        return user;
    }

    public void removeUser(int id) {
        EntityManager em = Persistence.createEntityManagerFactory("Jpa").createEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class, id);

        if (user != null) {
            em.remove(user);
        }
        em.getTransaction().commit();
    }

    public User findUser(int id) {
        EntityManager em = Persistence.createEntityManagerFactory("Jpa").createEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class, id);
        em.getTransaction().commit();
        return user;
    }

    public List<User> findAllUser() {
        EntityManager em = Persistence.createEntityManagerFactory("Jpa").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<User> query = em.createQuery("SELECT a FROM User a", User.class);
        em.getTransaction().commit();
        return query.getResultList();
    }


    public User findByLogin(String name) {
        EntityManager em = Persistence.createEntityManagerFactory("Jpa").createEntityManager();
        User u = null;
        em.getTransaction().begin();
        String Query = "SELECt a from User a  where userLogin_mail ='" + name + "'";
        Query query = em.createQuery(Query, User.class);
        if (query.getResultList().size() == 0)
            return null;
        u = (User) query.getSingleResult();
        em.getTransaction().commit();
        return u;
    }


}
