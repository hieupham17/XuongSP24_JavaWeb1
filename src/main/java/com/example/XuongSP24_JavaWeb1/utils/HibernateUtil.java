package com.example.XuongSP24_JavaWeb1.utils;

import com.example.XuongSP24_JavaWeb1.entities.KichThuoc;
import com.example.XuongSP24_JavaWeb1.entities.MauSac;
import com.example.XuongSP24_JavaWeb1.entities.SanPham;
import com.example.XuongSP24_JavaWeb1.entities.SanPhamChiTiet;
import com.example.XuongSP24_JavaWeb1.entities.custom_entity.SanPhamChiTietCustom;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
                settings.put(Environment.URL, "jdbc:sqlserver://localhost;database=XuongSP24_JavaWeb1;encrypt=true;trustServerCertificate=true;");
                settings.put(Environment.USER, "sa");
                settings.put(Environment.PASS, "123");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.FORMAT_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                //settings.put(Environment.HBM2DDL_AUTO, "create-drop");

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(MauSac.class);
                configuration.addAnnotatedClass(KichThuoc.class);
                configuration.addAnnotatedClass(SanPham.class);
                configuration.addAnnotatedClass(SanPhamChiTiet.class);
                configuration.addAnnotatedClass(SanPhamChiTietCustom.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    public static void main(String[] args) {
        System.out.println(getSessionFactory());
    }
}
