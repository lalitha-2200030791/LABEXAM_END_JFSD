package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientDemo {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Device device = new Device();
        device.setBrand("Earphones");
        device.setModel("Sony");
        device.setPrice(5000.0);
        session.save(device);

        Smartphone smartphone = new Smartphone();
        smartphone.setBrand("Apple");
        smartphone.setModel("iPhone 14");
        smartphone.setPrice(120000.0);
        smartphone.setOperatingSystem("iOS");
        smartphone.setCameraResolution("12 MP");
        session.save(smartphone);

        Tablet tablet = new Tablet();
        tablet.setBrand("Samsung");
        tablet.setModel("Galaxy Tab S7");
        tablet.setPrice(65000.0);
        tablet.setScreenSize("11 inches");
        tablet.setBatteryLife("14 hours");
        session.save(tablet);

        transaction.commit();
        session.close();
        sessionFactory.close();

        System.out.println("inserted successfully.");
    }
}
