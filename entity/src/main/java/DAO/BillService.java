package DAO;

import com.entity.Bill;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by qny4i on 03.11.2016.
 */
public class BillService {

    public BillService() {

    }



    public Bill createBill(Bill newBill) {
        EntityManager em = Persistence.createEntityManagerFactory("Jpa").createEntityManager();

        em.getTransaction().begin();
        Bill bill = newBill;
        em.persist(bill);
        em.getTransaction().commit();
        return bill;
    }

    public void removeBill(int id) {
        EntityManager em = Persistence.createEntityManagerFactory("Jpa").createEntityManager();

        em.getTransaction().begin();
        Bill bill = em.find(Bill.class, id);

        if (bill != null) {
            em.remove(bill);
        }
        em.getTransaction().commit();
    }

    public Bill findBill(int id) {
        EntityManager em = Persistence.createEntityManagerFactory("Jpa").createEntityManager();

        em.getTransaction().begin();
        Bill bill =em.find(Bill.class, id);
        em.getTransaction().commit();
        return bill;
    }

    public List<Bill> findAllBill() {
        EntityManager em = Persistence.createEntityManagerFactory("Jpa").createEntityManager();

        em.getTransaction().begin();
        TypedQuery<Bill> query = em.createQuery("SELECT a FROM Bill a", Bill.class);
        em.getTransaction().commit();
        return query.getResultList();
    }
}
