package DAO;

import com.entity.ServiceType;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by qny4i on 04.11.2016.
 */
public class TypeService {

    public EntityManager em = Persistence.createEntityManagerFactory("Jpa").createEntityManager();

    public TypeService() {

    }

    public TypeService(EntityManager em) {
        this.em = em;
    }

    public ServiceType createServiceType(ServiceType newServiceType) {
        em.getTransaction().begin();
        ServiceType type = newServiceType;
        em.persist(type);
        em.getTransaction().commit();
        return type;
    }

    public void removeServiceType(int id) {
        em.getTransaction().begin();
        ServiceType type = em.find(ServiceType.class, id);

        if (type != null) {
            em.remove(type);
        }
        em.getTransaction().commit();
    }

    public ServiceType findServiceType(int id) {
        em.getTransaction().begin();
        ServiceType type =em.find(ServiceType.class, id);
        em.getTransaction().commit();
        return type;
    }

    public List<ServiceType> findAllServiceType() {
        em.getTransaction().begin();
        TypedQuery<ServiceType> query = em.createQuery("SELECT a FROM ServiceType a", ServiceType.class);
        em.getTransaction().commit();
        return query.getResultList();
    }
}
