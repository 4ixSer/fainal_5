package DAO;

import com.entity.District;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by qny4i on 04.11.2016.
 */
public class DistrictService {



    public DistrictService() {

    }

//    public DistrictService(EntityManager em) {
//        this.em = em;
//    }

    public District createDistrict(District newDistrict) {
        EntityManager em = Persistence.createEntityManagerFactory("Jpa").createEntityManager();
        em.getTransaction().begin();
        District district = newDistrict;
        em.persist(district);
        em.getTransaction().commit();
        return district;
    }

    public void removeDistrict(int id) {
        EntityManager em = Persistence.createEntityManagerFactory("Jpa").createEntityManager();
        em.getTransaction().begin();
        District district = em.find(District.class, id);

        if (district != null) {
            em.remove(district);
        }
        em.getTransaction().commit();
    }

    public District findDistrict(int id) {
        EntityManager em = Persistence.createEntityManagerFactory("Jpa").createEntityManager();
        em.getTransaction().begin();
        District district =em.find(District.class, id);
        em.getTransaction().commit();
        return district;
    }

    public List<District> findAllDistrict() {
        EntityManager em = Persistence.createEntityManagerFactory("Jpa").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<District> query = em.createQuery("SELECT a FROM District a", District.class);
        em.getTransaction().commit();
        return query.getResultList();
    }
}
