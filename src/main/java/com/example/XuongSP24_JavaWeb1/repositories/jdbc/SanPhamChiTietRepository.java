package com.example.XuongSP24_JavaWeb1.repositories.jdbc;

import com.example.XuongSP24_JavaWeb1.entities.SanPham;
import com.example.XuongSP24_JavaWeb1.entities.SanPhamChiTiet;
import com.example.XuongSP24_JavaWeb1.entities.custom_entity.SanPhamChiTietCustom;
import com.example.XuongSP24_JavaWeb1.utils.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SanPhamChiTietRepository {
    private List<SanPhamChiTiet> list;
    private Connection connection;


    public SanPhamChiTietRepository() {
        try {
            this.connection = DBConnect.getConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public List<SanPhamChiTiet> findAll() {
//        List<SanPhamChiTiet> list = new ArrayList<>();
//        String sql = "SELECT * FROM SanPhamChiTiet";
//        try {
//
//            PreparedStatement ps = this.connection.prepareStatement(sql);
//            ps.execute();
//            ResultSet rs = ps.getResultSet();
//            while (rs.next()) {
//                int id = rs.getInt("Id");
//                //int ten = rs.getInt("IdMauSac");
//                int idMS = rs.getInt("IdMauSac");
//                int idKT = rs.getInt("IdKichThuoc");
//                int IdSP = rs.getInt("IdSanPham");
//                String maSPCT = rs.getString("MaSPCT");
//                int soLuong = rs.getInt("SoLuong");
//                double donGia = rs.getDouble("DonGia");
//                int trangThai = rs.getInt("TrangThai");
//                SanPhamChiTiet spct = new SanPhamChiTiet(id, idMS, idKT, IdSP, maSPCT, soLuong, donGia, trangThai);
//                list.add(spct);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//
//    }
    public List<SanPhamChiTietCustom> findAllWithPopName(int spId) {
        List<SanPhamChiTietCustom> list = new ArrayList<>();
        String sql = "SELECT spct.ID, ms.Ten AS tenMauSac, kt.Ten AS tenKichThuoc, spct.MaSPCT, spct.SoLuong, spct.DonGia, spct.TrangThai \n" +
                "FROM SanPhamChiTiet spct \n" +
                "JOIN MauSac ms \n" +
                "ON spct.IdMauSac = ms.ID JOIN KichThuoc kt \n" +
                "ON spct.IdKichThuoc = kt.ID \n" +
                "WHERE spct.idSanPham = ?"
                ;
        try {

            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, spId);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String tenMauSac = rs.getString("tenMauSac");
                String tenKichThuoc = rs.getString("tenKichThuoc");
                String maSanPhamChiTiet = rs.getString("MaSPCT");
                int soLuong = rs.getInt("SoLuong");
                double donGia = rs.getDouble("DonGia");
                int trangThai = rs.getInt("TrangThai");
                SanPhamChiTietCustom obj = new SanPhamChiTietCustom(id, tenMauSac, tenKichThuoc, maSanPhamChiTiet, soLuong, donGia, trangThai);
                list.add(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }

    public List<SanPhamChiTiet> findByIdSPCT(Integer idSPCT) {
        List<SanPhamChiTiet> list = new ArrayList<>();
        String sql = "SELECT * FROM SanPhamChiTiet WHERE ID = ?";
        try {

            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, idSPCT);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("Id");
                int idMS = rs.getInt("IdMauSac");
                int idKT = rs.getInt("IdKichThuoc");
                int IdSP = rs.getInt("IdSanPham");
                String maSPCT = rs.getString("MaSPCT");
                int soLuong = rs.getInt("SoLuong");
                double donGia = rs.getDouble("DonGia");
                int trangThai = rs.getInt("TrangThai");
                SanPhamChiTiet spct = new SanPhamChiTiet(id, idMS, idKT, IdSP, maSPCT, soLuong, donGia, trangThai);
                list.add(spct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }
}
