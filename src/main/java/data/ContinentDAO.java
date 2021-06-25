package data;

import model.Continent;
import model.Country;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

public class ContinentDAO {

    private CountryDAO countryDAO;
    private ContinentDAO continentDAO;
    private Continent continent;

    private EntityManagerFactory emf;

    public ContinentDAO() throws SQLException {
        emf = EMFactory.getEMF();
    }

    //TODO: create update, delete and Insert methods

    public Continent getContinentById(int id) throws SQLException {
        EntityManager em = emf.createEntityManager();
        return em.find(Continent.class, id);
    }


    public List<Continent> getAllContinents() throws SQLException {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT c FROM City c");
        List<Continent> continentList = query.getResultList();
        return continentList;
    }

    public Continent getContinentByCountry(Country country) throws SQLException {
        EntityManager em = emf.createEntityManager();
        return em.find(Continent.class, country);
    }

    public void addContinent(Continent continent) throws SQLException {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(continent);
        em.getTransaction().commit();
    }

    public void updateContinent(Continent continent) throws SQLException {
        // No id needed, zoek merge() eens op
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(continent);
        em.getTransaction().commit();
    }

    public void deleteContinent(Continent continent) throws SQLException {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(continent);
        em.getTransaction().commit();
    }

}
