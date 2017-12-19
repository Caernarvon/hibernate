package hibernate_methods;

import items.Locality_type;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class Locality_typeRunner {
    private static SessionFactory sessionFactory;

    public Locality_typeRunner(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addLocalityType(int id, String type, String description) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Locality_type localityType = new Locality_type(id, type, description);
        session.save(localityType);
        transaction.commit();
        session.close();
    }

    public void updateLocalityType(int id, String type, String description) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Locality_type localityType = (Locality_type) session.get(Locality_type.class, id);
        localityType.setType(type);
        localityType.setDescription(description);
        session.save(localityType);
        session.close();
    }

    public void removeLocalityType(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Locality_type localityType = (Locality_type) session.get(Locality_type.class, id);
        session.delete(localityType);
        transaction.commit();
        session.close();
    }

    public List listLocalityTypes() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List localityTypes = session.createQuery("FROM \"Locality_type\"").list();
        transaction.commit();
        session.close();
        return localityTypes;
    }
}
