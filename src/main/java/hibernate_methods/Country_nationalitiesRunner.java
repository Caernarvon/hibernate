package hibernate_methods;

import items.Country_nationalities;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class Country_nationalitiesRunner {
    private static SessionFactory sessionFactory;

    public Country_nationalitiesRunner(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addCountryNationality(int countryId, int nationId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Country_nationalities countryNationalities = new Country_nationalities(countryId, nationId);
        session.save(countryNationalities);
        transaction.commit();
        session.close();
    }

    public void updateCountryNationality(int countryId, int nationId) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Country_nationalities countryNationalities = new Country_nationalities(countryId, nationId);
        if(session.contains(countryNationalities)) {
            countryNationalities.setNationId(nationId);
            session.update(countryNationalities);
            transaction.commit();
        }
        session.close();
    }

    public void removeCountryNationalities(int countryId, int nationId) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;


        //создавать новый объект по класс.ид и там уже пытаться с ним что-то делать
        transaction = session.beginTransaction();
        Country_nationalities countryNationalities = new Country_nationalities(countryId, nationId);
        if(session.contains(countryNationalities)) {
            session.delete(countryNationalities);
            transaction.commit();
        }
        session.close();
    }

    public List listCountries() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List countryNationalities = session.createQuery("FROM \"Country_nationalities\"").list();

        transaction.commit();
        session.close();
        return countryNationalities;
    }
}
