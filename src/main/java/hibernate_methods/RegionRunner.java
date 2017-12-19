package hibernate_methods;

import items.Region;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class RegionRunner {
    private static SessionFactory sessionFactory;

    public RegionRunner(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addRegion(int id, String name, int code, int populationAmount, String geoData, int emblemId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Region region = new Region(id, name, code, populationAmount, geoData, emblemId);
        session.save(region);
        transaction.commit();
        session.close();
    }

    public void updateRegion(int id, String name, int code, int populationAmount, String geoData, int emblemId) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Region region = (Region) session.get(Region.class, id);
        region.setName(name);
        region.setCode(code);
        region.setPopulationAmount(populationAmount);
        region.setGeoData(geoData);
        region.setEmblemId(emblemId);
        session.update(region);
        transaction.commit();
        session.close();
    }

    public void removeRegion(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Region region = (Region) session.get(Region.class, id);
        session.delete(region);
        transaction.commit();
        session.close();
    }

    public List listRegions() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List regions = session.createQuery("FROM \"Region\"").list();

        transaction.commit();
        session.close();
        return regions;
    }
}
