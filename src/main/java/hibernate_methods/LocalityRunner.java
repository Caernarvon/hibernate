package hibernate_methods;

import items.Locality;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class LocalityRunner {
    private static SessionFactory sessionFactory;

    public LocalityRunner(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addLocality(int id, String name, int populationAmount, String isCapital, String isRegionCentre,
                            int countryId, int localityTypeId, int emblemId, int regionId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Locality locality = new Locality(id, name, populationAmount, isCapital, isRegionCentre,
                countryId, localityTypeId, emblemId, regionId);
        session.save(locality);
        transaction.commit();
        session.close();
    }

    public void updateLocality(int id, String name, int populationAmount, String isCapital, String isRegionCentre,
                                   int countryId, int localityTypeId, int emblemId, int regionId) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Locality locality = (Locality) session.get(Locality.class, id);
        locality.setName(name);
        locality.setPopulationAmount(populationAmount);
        locality.setIsCapital(isCapital);
        locality.setIsRegionCentre(isRegionCentre);
        locality.setCountryId(countryId);
        locality.setLocalityTypeId(localityTypeId);
        locality.setEmblemId(emblemId);
        locality.setRegionId(regionId);
        session.save(locality);
        session.close();
    }

    public void removeLocality(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Locality locality = (Locality) session.get(Locality.class, id);
        session.delete(locality);
        transaction.commit();
        session.close();
    }

    public List listLocalities() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List localities = session.createQuery("FROM \"Locality\"").list();
        transaction.commit();
        session.close();
        return localities;
    }
}
