package com.example.XuongSP24_JavaWeb1.repositories.jpa;

import com.example.XuongSP24_JavaWeb1.entities.KichThuoc;
import com.example.XuongSP24_JavaWeb1.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class KichThuocRepository {
    //Hiển thị toàn bộ thông tin ms
    public List<KichThuoc> getAll() {
        List<KichThuoc> list = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            list = session.createQuery("FROM KichThuoc", KichThuoc.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //Add
    public void addKichThuoc(KichThuoc kt) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.persist(kt);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Delete
    public void delete(KichThuoc kt) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.remove(kt);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //getOne: sử dụng khi lấy ra 1 đối tượng từ 1 id update/delete)
    public KichThuoc getOne(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            KichThuoc kt = session.find(KichThuoc.class, id);
            session.getTransaction().commit();
            return kt;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void update(KichThuoc kt){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.merge(kt);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
