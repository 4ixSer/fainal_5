package DAO;

import com.entity.Sauna;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by qny4i on 04.11.2016.
 */
public class SaunaService {

    public SaunaService() {

    }

//    public SaunaService(EntityManager em) {
//        this.em = em;
//    }

    public Sauna createSauna(Sauna newSauna) {
        EntityManager em = Persistence.createEntityManagerFactory("Jpa").createEntityManager();
        em.getTransaction().begin();
        Sauna sauna = newSauna;
        em.persist(sauna);
        em.getTransaction().commit();
        return sauna;
    }

    public void removeSauna(int id) {
        EntityManager em = Persistence.createEntityManagerFactory("Jpa").createEntityManager();
        em.getTransaction().begin();
        Sauna sauna = em.find(Sauna.class, id);

        if (sauna != null) {
            em.remove(sauna);
        }
        em.getTransaction().commit();
    }

    public Sauna findSauna(int id) {
        EntityManager em = Persistence.createEntityManagerFactory("Jpa").createEntityManager();
        em.getTransaction().begin();
        Sauna sauna = em.find(Sauna.class, id);
        em.getTransaction().commit();
        return sauna;
    }

    public List<Sauna> findAllSauna() {
        EntityManager em = Persistence.createEntityManagerFactory("Jpa").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Sauna> query = em.createQuery("SELECT a FROM Sauna a", Sauna.class);
        em.getTransaction().commit();
        return query.getResultList();
    }

    public Sauna changeSaunaName(int id, String newName) {
        EntityManager em = Persistence.createEntityManagerFactory("Jpa").createEntityManager();
        em.getTransaction().begin();
        Sauna sauna = em.find(Sauna.class, id);

        if (sauna != null) {
            sauna.setName(newName);
        }

        em.getTransaction().commit();
        return sauna;

    }

    public List<Sauna> findByName(String name) {
        EntityManager em = Persistence.createEntityManagerFactory("Jpa").createEntityManager();
        em.getTransaction().begin();
        String Query = "SELECt a from Sauna a  where nameSauna Like '%";
        Query=Query.concat(name);
        Query=Query.concat("%'");
        System.err.println();
        System.err.println(Query);
        System.err.println();
        TypedQuery<Sauna> query = em.createQuery(Query, Sauna.class);
        em.getTransaction().commit();
        return query.getResultList();
    }

    public List<Sauna> findByPrice(Integer minValue, Integer maxValue) {
        EntityManager em = Persistence.createEntityManagerFactory("Jpa").createEntityManager();
        em.getTransaction().begin();
        String Query = "SELECt a from Sauna a  where price >=" +minValue +" and price<=" +maxValue;
//        Query=Query.concat(toString(minValue));
//        Query=Query.concat("%'");
        System.err.println();
        System.err.println("SELECt a from Sauna a  where price >=" +minValue +" and price<=" +maxValue);
        System.err.println();
        TypedQuery<Sauna> query = em.createQuery(Query, Sauna.class);
        em.getTransaction().commit();
        return query.getResultList();
    }


    public List<Sauna> findByCapacity(Integer minValue, Integer maxValue) {
        EntityManager em = Persistence.createEntityManagerFactory("Jpa").createEntityManager();
        em.getTransaction().begin();
        String Query = "SELECt a from Sauna a  where capacity >=" +minValue +" and capacity<=" +maxValue;
//        Query=Query.concat(toString(minValue));
//        Query=Query.concat("%'");
        System.err.println();
        System.err.println("SELECt a from Sauna a  where capacity >=" +minValue +" and capacity<=" +maxValue);
        System.err.println();
        TypedQuery<Sauna> query = em.createQuery(Query, Sauna.class);
        em.getTransaction().commit();
        return query.getResultList();
    }


    public List<Sauna> findByAll(List<String> value) {
        EntityManager em = Persistence.createEntityManagerFactory("Jpa").createEntityManager();
        em.getTransaction().begin();
        String Query = "SELECt a from Sauna a  where price >=";

        for (int i = 0; i < value.size(); i++) {
            switch (i) {
                case 0:
                    Query = Query.concat(value.get(i)+" and price<="+value.get(i+1));
                    break;
                case 2:
                    Query = Query.concat(" and capacity>="+value.get(i)+" and capacity<="+value.get(i+1));
                    break;
                default:
                    break;

            }
        }

        System.err.println();
        System.err.println(Query);
        System.err.println();
        TypedQuery<Sauna> query = em.createQuery(Query, Sauna.class);
        em.getTransaction().commit();
        return query.getResultList();
    }


}