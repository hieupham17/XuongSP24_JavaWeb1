package com.example.XuongSP24_JavaWeb1.repositories;

import com.example.XuongSP24_JavaWeb1.controllers.SanPhamServlet;
import com.example.XuongSP24_JavaWeb1.entities.KichThuoc;
import com.example.XuongSP24_JavaWeb1.entities.NhanVien;
import com.example.XuongSP24_JavaWeb1.entities.SanPham;
import com.example.XuongSP24_JavaWeb1.utils.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SanPhamRepository {
    private List<SanPham> list ;
    private Connection connection ;


    public SanPhamRepository(){
        try {
            this.connection = DBConnect.getConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // hàm findAll
    public  List<SanPham> findAll() {
        List<SanPham> list = new ArrayList<>();
        String sql = "SELECT * FROM SanPham";
        try {

            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("Id");
                String ten = rs.getString("Ten");
                String ma = rs.getString("Ma");
                int trangThai = rs.getInt("TrangThai");
                SanPham sp = new SanPham(id, ten, ma, trangThai);

                list.add(sp);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }
    public void insert (SanPham sp){
        //Câu truy vấn
        String sql = "INSERT INTO SanPham (Ma, Ten, TrangThai) VALUES (?, ? ,?)";
        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, sp.getMa());
            ps.setString(2, sp.getTen());
            ps.setInt(3, sp.getTrangThai());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void update(SanPham sp) {
        String sql = "UPDATE SanPham SET Ma = ?, Ten = ?, TrangThai = ? WHERE id = ?";
        try (Connection connection = DBConnect.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, sp.getMa());
            statement.setString(2, sp.getTen());
            statement.setInt(3, sp.getTrangThai());
            statement.setInt(4, sp.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void delete(SanPham sp) {
        String sql = "DELETE FROM SanPham WHERE Id = ?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, sp.getId());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public SanPham findById(int id) {
        String sql = "SELECT * FROM SanPham WHERE id = ?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) { // Kiểm tra xem có dữ liệu trong ResultSet hay không
                String ten = rs.getString("Ten");
                String ma = rs.getString("Ma");
                int trangThai = rs.getInt("TrangThai");
                return new SanPham(id, ma, ten, trangThai);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
