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
    public EntityManager em = Persistence.createEntityManagerFactory("Jpa").createEntityManager();

    public BillService() {

    }

    public BillService(EntityManager em) {
        this.em = em;
    }

    public Bill createBill(Bill newBill) {
        em.getTransaction().begin();
        Bill bill = newBill;
        em.persist(bill);
        em.getTransaction().commit();
        return bill;
    }

    public void removeBill(int id) {
        em.getTransaction().begin();
        Bill bill = em.find(Bill.class, id);

        if (bill != null) {
            em.remove(bill);
        }
        em.getTransaction().commit();
    }

    public Bill findBill(int id) {
        em.getTransaction().begin();
        Bill bill =em.find(Bill.class, id);
        em.getTransaction().commit();
        return bill;
    }

    public List<Bill> findAllBill() {
        em.getTransaction().begin();
        TypedQuery<Bill> query = em.createQuery("SELECT a FROM Bill a", Bill.class);
        em.getTransaction().commit();
        return query.getResultList();
    }
}
