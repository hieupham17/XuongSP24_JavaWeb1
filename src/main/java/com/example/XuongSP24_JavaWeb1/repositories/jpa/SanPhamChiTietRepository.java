package com.example.XuongSP24_JavaWeb1.repositories.jpa;

import com.example.XuongSP24_JavaWeb1.entities.SanPhamChiTiet;
import com.example.XuongSP24_JavaWeb1.entities.custom_entity.SanPhamChiTietCustom;
import com.example.XuongSP24_JavaWeb1.request.spct.IndexRequest;
import com.example.XuongSP24_JavaWeb1.utils.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SanPhamChiTietRepository {
    private Session session;

    public SanPhamChiTietRepository() {
        this.session = HibernateUtil.getSessionFactory().openSession();

    }

    public List<SanPhamChiTietCustom> findAllWithPopName(int spId) {
        List<SanPhamChiTietCustom> list = new ArrayList<>();
        String sql = "SELECT new SanPhamChiTietCustom(spct.id, ms.ten, kt.ten, spct.maSanPhamChiTiet, spct.soLuong, spct.donGia, spct.trangThai) " +
                "FROM SanPhamChiTiet spct " +
                "LEFT JOIN MauSac ms ON spct.idMauSac = ms.id " +
                "LEFT JOIN KichThuoc kt ON spct.idKichThuoc = kt.id " +
                "WHERE spct.idSanPham = ?1";

        Query query = this.session.createQuery(sql, SanPhamChiTiet.class);
        query.setParameter(1, spId);
        return query.getResultList();

    }

    public List<SanPhamChiTietCustom> findAllWithPropName(IndexRequest params) {
        ArrayList<SanPhamChiTietCustom> ds = new ArrayList<>();
        String jpql = "SELECT new SanPhamChiTietCustom( " +
                "spct.id, ms.ten, kt.ten, spct.maSanPhamChiTiet, " +
                "spct.soLuong, spct.donGia, spct.trangThai) " +
                "FROM SanPhamChiTiet spct " +
                "LEFT OUTER JOIN MauSac ms ON spct.idMauSac = ms.id " +
                "LEFT OUTER JOIN KichThuoc kt ON spct.idKichThuoc = kt.id " +
                "WHERE spct.idSanPham = :idSanPham ";

        if (params.getKeyword() != null) {
            jpql += " AND (spct.maSanPhamChiTiet LIKE :keyword OR ms.ten LIKE :keyword OR kt.ten LIKE :keyword) ";
        }

        if (params.getTrangThai() != null) {
            jpql += " AND spct.trangThai = :trangThai ";
        }

        System.out.println(jpql);
        Query q = this.session.createQuery(jpql, SanPhamChiTiet.class);
        q.setParameter("idSanPham", params.getIdSanPham());

        if (params.getKeyword() != null) {
            q.setParameter("keyword", "%" + params.getKeyword() + "%");
        }

        if (params.getTrangThai() != null) {
            q.setParameter("trangThai", params.getTrangThai());
        }

        int start =  (params.getPage()) * params.getLimit() + 1;
        q.setFirstResult(start);
        q.setMaxResults(params.getLimit());

        return q.getResultList();
    }

}
