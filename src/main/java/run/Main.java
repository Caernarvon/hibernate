package run;

import hibernate_methods.*;
import items.Emblem;
import items.Locality_type;
import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.FileSystemResourceAccessor;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.sql.SQLException;

public class Main {
    public static SessionFactory sessionFactory;

    public static void main(String[] args) throws ClassNotFoundException, SQLException, LiquibaseException {
        Connect.connect();
        sessionFactory = new Configuration().configure().buildSessionFactory();
        createTables(sessionFactory);
    }

    public static void createTables(SessionFactory sessionFactory) throws ClassNotFoundException, SQLException, LiquibaseException {
        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(Connect.connection));
        File changeCreateTables = new File(ClassLoader.getSystemResource("liquibase/1.0-create-tables.xml").getFile());
        Liquibase createTables = new liquibase.Liquibase(changeCreateTables.toString(), new FileSystemResourceAccessor(), database);
        createTables.update(new Contexts(), new LabelExpression());

        File change_fill_tables = new File(ClassLoader.getSystemResource("liquibase/4.0-fill-tables.xml").getFile());
        Liquibase fill_tables = new liquibase.Liquibase(change_fill_tables.toString(), new FileSystemResourceAccessor(), database);
        fill_tables.update(new Contexts(), new LabelExpression());

        Country_nationalitiesRunner countryNationalitiesRunner = new Country_nationalitiesRunner(sessionFactory);
        CountryRunner countryRunner = new CountryRunner(sessionFactory);
        EmblemRunner emblemRunner = new EmblemRunner(sessionFactory);
        Locality_typeRunner localityTypeRunner = new Locality_typeRunner(sessionFactory);
        LocalityRunner localityRunner = new LocalityRunner(sessionFactory);
        NationalityRunner nationalityRunner = new NationalityRunner(sessionFactory);
        RegionRunner regionRunner = new RegionRunner(sessionFactory);



    }
}
