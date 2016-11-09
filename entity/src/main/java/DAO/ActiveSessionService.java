package DAO;

import com.entity.ActiveSession;
import com.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;


/**
 * Created by qny4i on 09.11.2016.
 */
public class ActiveSessionService {

    public ActiveSessionService() {

    }

//    public ActiveSessionService(EntityManager em) {
//        this.em = em;
//    }

    public ActiveSession createActiveSession(ActiveSession newActiveSession) {
        EntityManager em = Persistence.createEntityManagerFactory("Jpa").createEntityManager();
        em.getTransaction().begin();
        ActiveSession activeSession = newActiveSession;
        em.persist(activeSession);
        em.getTransaction().commit();
        return activeSession;
    }

    public void removeActiveSession(int id) {
        EntityManager em = Persistence.createEntityManagerFactory("Jpa").createEntityManager();
        em.getTransaction().begin();
        ActiveSession activeSession = em.find(ActiveSession.class, id);

        if (activeSession != null) {
            em.remove(activeSession);
        }
        em.getTransaction().commit();
    }

    public ActiveSession findActiveSession(int id) {
        EntityManager em = Persistence.createEntityManagerFactory("Jpa").createEntityManager();
        em.getTransaction().begin();
        ActiveSession activeSession = em.find(ActiveSession.class, id);
        em.getTransaction().commit();
        return activeSession;
    }

    public List<ActiveSession> findAllActiveSession() {
        EntityManager em = Persistence.createEntityManagerFactory("Jpa").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<ActiveSession> query = em.createQuery("SELECT a FROM ActiveSession a", ActiveSession.class);
        em.getTransaction().commit();
        return query.getResultList();
    }


    public ActiveSession findByToken(String token) {
        EntityManager em = Persistence.createEntityManagerFactory("Jpa").createEntityManager();
        ActiveSession u = null;
        em.getTransaction().begin();
        String Query = "SELECt a from ActiveSession a  where token ='" + token + "'";
        Query query = em.createQuery(Query, ActiveSession.class);
        if (query.getResultList().size() == 0)
            return null;
        u = (ActiveSession) query.getSingleResult();
        em.getTransaction().commit();
        return u;
    }

    public ActiveSession findByUser(User user) {
        EntityManager em = Persistence.createEntityManagerFactory("Jpa").createEntityManager();
        ActiveSession u = null;
        em.getTransaction().begin();
        String Query = "SELECt a from ActiveSession a  where user ='" + user.getId() + "'";
        Query query = em.createQuery(Query, ActiveSession.class);
        if (query.getResultList().size() == 0)
            return null;
        u = (ActiveSession) query.getSingleResult();
        em.getTransaction().commit();
        return u;
    }

    public ActiveSession updateActiveSession(ActiveSession newActiveSession) {
        EntityManager em = Persistence.createEntityManagerFactory("Jpa").createEntityManager();
        em.getTransaction().begin();
        ActiveSession activeSession = em.find(ActiveSession.class, newActiveSession.getSessionId());

        if (activeSession != null) {
            activeSession = newActiveSession;
        }

        em.getTransaction().commit();
        return activeSession;

    }

}
