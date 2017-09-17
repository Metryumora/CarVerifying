package edu.chdtu.carverif.dbutil;


import edu.chdtu.carverif.entity.Client;
import edu.chdtu.carverif.entity.User;
import edu.chdtu.carverif.entity.Vehicle;
import edu.chdtu.carverif.entity.Verification;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * Created by Metr_yumora on 28.04.2017.
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private static Session session;

    private static User activeUser;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null)
            try {
                Configuration configuration = new Configuration().addResource("hibernate.cfg.xml");
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Client.class);
                configuration.addAnnotatedClass(Vehicle.class);
                configuration.addAnnotatedClass(Verification.class);
                configuration.configure();
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                        configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Throwable ex) {
                throw new ExceptionInInitializerError(ex);
            }
        return sessionFactory;
    }


    public static Session getSession() {
        if (session == null)
            session = getSessionFactory().openSession();
        return session;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }

    public static User getUserByLogin(String login) {
        try {
            return getSession().createQuery("from User u where u.login='" + login + "'", User.class).getSingleResult();
        } catch (NoResultException e) {
            System.out.println("No results!");
            return null;
        }
    }

    public static User getActiveUser() {
        return activeUser;
    }

    public static void setActiveUser(User activeUser) {
        HibernateUtil.activeUser = activeUser;
    }

    public static boolean authUser(String login, String password) {
        User checkedUser = getUserByLogin(login);
        if (checkedUser != null && checkedUser.verifyPassword(password)) {
            setActiveUser(checkedUser);
            return true;
        } else
            return false;
    }

    public static void logOut() {
        activeUser = null;
    }


    public static List<Client> getAllClients() {
        return getSession().createQuery("FROM Client ", Client.class).list();
    }

    public static List<Client> getAllClientsByName(String anyMatch) {
        return getSession().createQuery("FROM Client c where c.name like '%" + anyMatch + "%'", Client.class).list();
    }

    public static Client getClientByPassport(String passport) {
        return getSession().createQuery("FROM Client c where c.passport = '" + passport + "'", Client.class).getSingleResult();
    }

    public static List<Vehicle> getAllVehicles() {
        return getSession().createQuery("FROM Vehicle ", Vehicle.class).list();
    }

    public static List<Vehicle> getAllVehiclesByOwner(String anyMatch) {
        return getSession().createQuery("FROM Vehicle v where v.owner.name like '%" + anyMatch + "%'", Vehicle.class).list();
    }

    public static List<Verification> getVerificationHistory() {
        return getSession().createQuery("FROM Verification ", Verification.class).list();
    }

    public static List<Verification> getVerificationHistoryByCarNumberOrInspector(String anyMatch) {
        return getSession().createQuery("FROM Verification v where v.user.name like '%" + anyMatch + "%' or v.vehicle.registrationNumber like " +
                "'%" + anyMatch + "%'", Verification.class).list();
    }

}
