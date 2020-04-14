/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repo;

import entity.Album;
import entity.Artist;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import util.PersistenceUtil;

public class AlbumRepository {

    public static void create(Album album) {
        EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction et = null;

        try {
            et = em.getTransaction();
            et.begin();
            em.persist(album);
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

    public static Album findByID(int id) {
        EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();
        String query = "SELECT a FROM Album a WHERE a.id = :albumId";

        TypedQuery<Album> tq = em.createQuery(query, Album.class);
        tq.setParameter("albumId", new BigDecimal(id));
        Album album = null;
        try {
            album = tq.getSingleResult();
        } catch (NoResultException ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }

        return album;
    }

    public static List<Album> findByName(String nume) {
        EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();

        Query query = em.createNamedQuery("Album.findByName");
        query.setParameter("name", nume);
        List<Album> albums = null;
        try {
            albums = query.getResultList();
        } catch (NoResultException ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }

        return albums;
    }

    public static List<Album> findByArtist(Artist artist) {
        EntityManager em = PersistenceUtil.getEntityManagerFactory().createEntityManager();

        Query query = em.createNamedQuery("Album.findByArtist");
        query.setParameter("artistId", artist);
        List<Album> albums = null;
        try {
            albums = query.getResultList();
        } catch (NoResultException ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }

        return albums;
    }
}
