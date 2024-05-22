package com.example.XuongSP24_JavaWeb1.repositories.jdbc;

import com.example.XuongSP24_JavaWeb1.entities.KichThuoc;
import com.example.XuongSP24_JavaWeb1.utils.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class KichThuocRepository {
    private List<KichThuoc> list;
    private Connection connection;

    //hàm khởi tạo
    public KichThuocRepository() {
        try {
            this.connection = DBConnect.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // hàm findAll
    public List<KichThuoc> findAll() {
        List<KichThuoc> list = new ArrayList<>();
        String sql = "SELECT * FROM KichThuoc";
        try {

            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("Id");
                String ten = rs.getString("Ten");
                String ma = rs.getString("Ma");
                int trangThai = rs.getInt("TrangThai");
                KichThuoc kt = new KichThuoc(id, ten, ma, trangThai);

                list.add(kt);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }

    public void insert(KichThuoc kt) {
        //Câu truy vấn
        String sql = "INSERT INTO KichThuoc (Ma, Ten, TrangThai) VALUES (?, ? ,?)";
        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, kt.getMa());
            ps.setString(2, kt.getTen());
            ps.setInt(3, kt.getTrangThai());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(KichThuoc kt) {
        String sql = "UPDATE KichThuoc SET Ma = ?, Ten = ?, TrangThai = ? WHERE id = ?";
        try (Connection connection = DBConnect.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, kt.getMa());
            statement.setString(2, kt.getTen());
            statement.setInt(3, kt.getTrangThai());
            statement.setInt(4, kt.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //delete
    public void delete(KichThuoc kt) {
        String sql = "DELETE FROM KichThuoc WHERE Id = ?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, kt.getId());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public KichThuoc findById(int id) {
        String sql = "SELECT * FROM KichThuoc WHERE id = ?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) { // Kiểm tra xem có dữ liệu trong ResultSet hay không
                String ten = rs.getString("Ten");
                String ma = rs.getString("Ma");
                int trangThai = rs.getInt("TrangThai");
                return new KichThuoc(id, ma, ten, trangThai);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        KichThuocRepository kichThuocRepository = new KichThuocRepository();
        List<KichThuoc> list = kichThuocRepository.findAll();
        for (KichThuoc kt : list) {
            System.out.println(kt.getId());
            System.out.println(kt.getTen());
            System.out.println(kt.getMa());
        }
    }

    public List<KichThuoc> paging(Optional<Integer> optionalPage, Optional<Integer> optionalLimit) {
        int limit = optionalLimit.isPresent() ? optionalLimit.get() : 5;
        int page = optionalPage.isPresent() ? optionalPage.get() : 1;
        ArrayList<KichThuoc> ds = new ArrayList<>();
        String sql = "SELECT * FROM KichThuoc ORDER BY Id OFFSET ? ROWS FETCH  NEXT ? ROWS ONLY ";
        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            int offset = (page - 1) * limit;
            ps.setInt(1, offset);
            ps.setInt(2, limit);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            //MauSac mauSac = new MauSac();
            while (rs.next()) {
                int id = rs.getInt("Id");
                String ten = rs.getString("Ten");
                String ma = rs.getString("Ma");
                int trangThai = rs.getInt("TrangThai");
                KichThuoc kt = new KichThuoc(id, ma, ten, trangThai);
                ds.add(kt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public int count() {
        String sql = "SELECT COUNT(ID) AS Total FROM KichThuoc";
        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            rs.next();
            int total = rs.getInt("Total");
            return total;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1 ;

    }
}
