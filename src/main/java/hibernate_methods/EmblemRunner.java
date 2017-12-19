package hibernate_methods;

import items.Emblem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class EmblemRunner {
    private static SessionFactory sessionFactory;

    public EmblemRunner(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addEmblem(int id, String name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Emblem emblem = new Emblem(id, name);
        session.save(emblem);
        transaction.commit();
        session.close();
    }

    public void updateEmblem(int id, String name) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Emblem emblem = (Emblem) session.get(Emblem.class, id);
        emblem.setName(name);
        session.save(emblem);
        session.close();
    }

    public void removeEmblem(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Emblem emblem = (Emblem) session.get(Emblem.class, id);
        session.delete(emblem);
        transaction.commit();
        session.close();
    }

    public List listEmblems() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List emblems = session.createQuery("FROM \"Emblem\"").list();
        transaction.commit();
        session.close();
        return emblems;
    }
}
