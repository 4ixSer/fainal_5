package DAO;

import com.entity.Phone;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by qny4i on 04.11.2016.
 */
public class PhoneService {
    public EntityManager em = Persistence.createEntityManagerFactory("Jpa").createEntityManager();

    public PhoneService() {

    }

    public PhoneService(EntityManager em) {
        this.em = em;
    }

    public Phone createPhone(Phone newPhone) {
        em.getTransaction().begin();
        Phone phone = newPhone;
        em.persist(phone);
        em.getTransaction().commit();
        return phone;
    }

    public void removePhone(int id) {
        em.getTransaction().begin();
        Phone phone = em.find(Phone.class, id);

        if (phone != null) {
            em.remove(phone);
        }
        em.getTransaction().commit();
    }

    public Phone findPhone(int id) {
        em.getTransaction().begin();
        Phone phone =em.find(Phone.class, id);
        em.getTransaction().commit();
        return phone;
    }

    public List<Phone> findAllPhone() {
        em.getTransaction().begin();
        TypedQuery<Phone> query = em.createQuery("SELECT a FROM Phone a", Phone.class);
        em.getTransaction().commit();
        return query.getResultList();
    }

}
