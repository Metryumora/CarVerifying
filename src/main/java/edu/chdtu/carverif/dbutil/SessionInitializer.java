package edu.chdtu.carverif.dbutil;

public class SessionInitializer implements Runnable {

    public void run() {
        HibernateUtil.getSession();
    }
}
