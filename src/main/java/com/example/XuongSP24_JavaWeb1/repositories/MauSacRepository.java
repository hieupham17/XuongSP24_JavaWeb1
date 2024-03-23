package com.example.XuongSP24_JavaWeb1.repositories;

import com.example.XuongSP24_JavaWeb1.entities.MauSac;
import com.example.XuongSP24_JavaWeb1.utils.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
    @author: admin Date: 012/12/03/2024 Time: 13:08
*/
public class MauSacRepository {
    private List<MauSac> list;
    private Connection connection;

    //Hàm khởi tạo
    public MauSacRepository() {

        try {
            this.connection = DBConnect.getConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<MauSac> findAll() {
        String sql = "SELECT * FROM MauSac";
        ArrayList<MauSac> ds = new ArrayList<>();

        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            //MauSac mauSac = new MauSac();
            while (rs.next()) {
                int id = rs.getInt("Id");
                String ten = rs.getString("Ten");
                String ma = rs.getString("Ma");
                int trangThai = rs.getInt("TrangThai");
                MauSac ms = new MauSac(id, ma, ten, trangThai);
                ds.add(ms);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    //  add
    public void insert(MauSac mauSac) {
        //this.list.add(mauSac);
        String sql = "INSERT INTO MauSac(Ma, Ten, TrangThai) VALUES (?, ? ,?)";
        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, mauSac.getMa());
            ps.setString(2, mauSac.getTen());
            ps.setInt(3, mauSac.getTrangThai());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // update
//    public void update(MauSac mauSac) {
//        for (int i = 0; i < this.list.size(); i++) {
//            MauSac item = this.list.get(i);
//            if (item.getId() == mauSac.getId()) {
//                this.list.set(i, mauSac);
//                return;
//            }
//        }
//
//    }
    public void update(MauSac ms) {
        String sql = "UPDATE MauSac SET Ma = ?, Ten = ?, TrangThai = ? WHERE id = ?";
        try (Connection connection = DBConnect.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, ms.getMa());
            statement.setString(2, ms.getTen());
            statement.setInt(3, ms.getTrangThai());
            statement.setInt(4, ms.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //delete
    public void delete(MauSac ms) {
//        for (int i = 0; i < this.list.size(); i++) {
//            MauSac item = this.list.get(i);
//            if (item.getId() == mauSac.getId()) {
//                this.list.remove(i);
//                return;
//            }
//        }
        String sql = "DELETE FROM MauSac WHERE Id = ?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, ms.getId());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MauSac findById(int id) {
        String sql = "SELECT * FROM MauSac WHERE id = ?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) { // Kiểm tra xem có dữ liệu trong ResultSet hay không
                String ten = rs.getString("Ten");
                String ma = rs.getString("Ma");
                int trangThai = rs.getInt("TrangThai");
                return new MauSac(id, ma, ten, trangThai);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<MauSac> findAll(String ma, String ten, Integer trangThai)
    {
        ArrayList<MauSac> ds = new ArrayList<>();
        /*
         * 1. Nếu ko có tham số tìm kiếm -> SELECT * FROM MauSac
         * 2. Nếu có đủ 3 tham số tìm kiếm ->
         *      SELECT * FROM MauSac WHERE Ma LIKE %?% AND Ten LIKE %?% AND TrangThai = ?
         * 3. Nếu chỉ có Ma -> SELECT * FROM MauSac WHERE Ma LIKE '%?%'
         * 4. Nếu chỉ có Ten -> SELECT * FROM MauSac WHERE Ten LIKE '%?%'
         * 5. Nếu chỉ có TrangThai -> SELECT * FROM MauSac WHERE TrangThai = ?
         * 6. Nếu có Ma và TrangThai -> SELECT * FROM MauSac WHERE Ma LIKE '%?%' AND TrangThai = ?
         */
        // WHERE Ma LIKE %?% AND Ten LIKE %?% AND TrangThai = ?
        String sql = "SELECT * FROM MauSac";

        if (ma.length() != 0 || ten.length() != 0 || trangThai != null) {
            sql += " WHERE ";
        }

        if (ma.length() != 0) {
            sql += " Ma LIKE ? ";
        }

        if (ten.length() != 0) {
            sql += ma.length() != 0 ? " AND " : "";
            sql += " Ten LIKE ? ";
        }

        if (trangThai != null) {
            sql += (ma.length() != 0 || ten.length() != 0) ? " AND " : "";
            sql += " TrangThai = ? ";
        }

        System.out.println(sql);
        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            int i = 0;
            if (ma.length() != 0) {
                ps.setString(++i, "%" + ma + "%");
            }

            if (ten.length() != 0) {
                ps.setString(++i, "%" + ten + "%");
            }

            if (trangThai != null) {
                ps.setInt(++i, trangThai);
            }

            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("id");
                String ten1 = rs.getString("ten");
                String ma1 = rs.getString("ma");
                int trangThai1 = rs.getInt("trangThai");
                MauSac ms = new MauSac(id, ma1, ten1, trangThai1);
                ds.add(ms);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public List<MauSac> paging(Optional<Integer> optionalPage , Optional<Integer> optionalLimit) {
        int limit = optionalLimit.isPresent() ? optionalLimit.get() : 5 ;
        int page = optionalPage.isPresent() ? optionalPage.get() : 1 ;
        ArrayList<MauSac> ds = new ArrayList<>();
        String sql = "SELECT * FROM MauSac ORDER BY Id OFFSET ? ROWS FETCH  NEXT ? ROWS ONLY ";
        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            int offset  = (page -1) * limit;
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
                MauSac ms = new MauSac(id, ma, ten, trangThai);
                ds.add(ms);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }
    public int count()
    {
        String sql = "SELECT COUNT(ID) AS Total FROM MauSac";
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

        return -1;
    }
}
