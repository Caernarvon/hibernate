package hibernate_methods;

import items.Nationality;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class NationalityRunner {
    private static SessionFactory sessionFactory;

    public NationalityRunner(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addNationality(int id, String name, String skinColor) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Nationality nationality = new Nationality(id, name, skinColor);
        session.save(nationality);
        transaction.commit();
        session.close();
    }

    public void updateNationality(int id, String name, String skinColor) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Nationality nationality = (Nationality) session.get(Nationality.class, id);
        nationality.setName(name);
        nationality.setSkinColor(skinColor);
        session.save(nationality);
        session.close();
    }

    public void removeNationality(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Nationality nationality = (Nationality) session.get(Nationality.class, id);
        session.delete(nationality);
        transaction.commit();
        session.close();
    }

    public List listNationalities() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List nationalities = session.createQuery("FROM \"Nationality\"").list();
        transaction.commit();
        session.close();
        return nationalities;
    }
}
