package com.example.XuongSP24_JavaWeb1.repositories.jpa;

import com.example.XuongSP24_JavaWeb1.entities.MauSac;
import com.example.XuongSP24_JavaWeb1.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class MauSacRepository {
    //Hiển thị toàn bộ thông tin ms
    public List<MauSac> getAll() {
        List<MauSac> list = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            list = session.createQuery("FROM MauSac", MauSac.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //Add
    public void addMauSac(MauSac ms) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.persist(ms);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Delete
    public void delete(MauSac mauSac) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.remove(mauSac);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //getOne: sử dụng khi lấy ra 1 đối tượng từ 1 id update/delete)
    public MauSac getOne(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            MauSac ms = session.find(MauSac.class, id);
            session.getTransaction().commit();
            return ms;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void update(MauSac mauSac){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.merge(mauSac);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
