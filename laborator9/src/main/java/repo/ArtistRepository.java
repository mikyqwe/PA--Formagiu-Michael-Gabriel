package repo;

import entity.Artist;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import util.PersistenceUtil;

public class ArtistRepository {

    public static void create(Artist artist) {
        EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction et = null;

        try {
            et = em.getTransaction();
            et.begin();
            em.persist(artist);
            et.commit();
        } catch (Exception ex) {
            if (et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        } finally {
            em.close();
        }

    }

    public static Artist findByID(int id) {
        EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
        String query = "SELECT a FROM Artist a WHERE a.id = :artistId";

        TypedQuery<Artist> tq = em.createQuery(query, Artist.class);
        tq.setParameter("artistId", new BigDecimal(id));
        Artist artist = null;
        try {
            artist = tq.getSingleResult();
        } catch (NoResultException ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }

        return artist;
    }

    public static List<Artist> findByName(String nume) // intoarce artistii cu numele nume
    {
        EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();

        Query query = em.createNamedQuery("Artist.findByName");
        query.setParameter("name", nume);
        List<Artist> artists = null;
        try {
            artists = query.getResultList();
        } catch (NoResultException ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }

        return artists;
    }
}
