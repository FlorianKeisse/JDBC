package data;

import model.Country;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

public class CountryDAO {

    private EntityManagerFactory emf;

    public CountryDAO() throws SQLException {
        emf = EMFactory.getEMF();
    }


    public Country getCountryById(int id) throws SQLException {
        EntityManager em = emf.createEntityManager();
        return em.find(Country.class, id);
    }

    public List<Country> getAllCountries() throws SQLException {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT a FROM Country a");
        List<Country> countries = query.getResultList();
        return countries;
    }


    public void addCountry(Country country) throws SQLException {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(country);
        em.getTransaction().commit();
    }

    public void updateCountry(Country country, int id) throws SQLException {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(country);
        em.getTransaction().commit();
    }

    public void deleteCountry(Country country) throws SQLException {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Country.class,country.getId()));
        em.getTransaction().commit();

//        EntityManager em = emf.createEntityManager();
//        country = em.find(Country.class, country);
//        em.remove(country);
    }
}
