package hibernate_methods;

import items.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class CountryRunner {

    private static SessionFactory sessionFactory;

    public CountryRunner(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addCountry(int id, String shortName, String fullName, int emblemId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Country country = new Country(id, shortName, fullName, emblemId);
        session.save(country);
        transaction.commit();
        session.close();
    }

    public void updateCountry(int id, String shortName, String fullName, int emblemId) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Country country = (Country) session.get(Country.class, id);
        country.setShortName(shortName);
        country.setFullName(fullName);
        country.setEmblemId(emblemId);
        session.update(country);
        transaction.commit();
        session.close();
    }

    public void removeCountry(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Country country = (Country) session.get(Country.class, id);
        session.delete(country);
        transaction.commit();
        session.close();
    }

    public List listCountries() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List countries = session.createQuery("FROM \"Country\"").list();

        transaction.commit();
        session.close();
        return countries;
    }
}
