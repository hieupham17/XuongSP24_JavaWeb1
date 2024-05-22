package com.example.XuongSP24_JavaWeb1.repositories.jdbc;

import com.example.XuongSP24_JavaWeb1.controllers.KhachHangServlet;
import com.example.XuongSP24_JavaWeb1.entities.KhachHang;
import com.example.XuongSP24_JavaWeb1.entities.NhanVien;
import com.example.XuongSP24_JavaWeb1.utils.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class KhachHangRepository {
    private List<KhachHang> list;
    private  Connection connection;
    //hàm khởi tạo
    public KhachHangRepository()  {
        try {
            this.connection = DBConnect.getConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<KhachHang> findAdd(){
        ArrayList<KhachHang> list = new ArrayList<>();
        String sql = "SELECT * FROM KhachHang";
        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                int id = rs.getInt("Id");
                String ma= rs.getString("Ma");
                String ten = rs.getString("Ten");
                String sdt = rs.getString("SDT");
                int trangThai = rs.getInt("TrangThai");
                KhachHang kh = new KhachHang(id, ten, ma, sdt, trangThai);
                list.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public void insert(KhachHang kh){
        String sql = "INSERT INTO [dbo].[KhachHang]([ID],[Ma],[Ten],[SDT],[TrangThai]) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, kh.getId());
            ps.setString(2, kh.getMa());
            ps.setString(3, kh.getTen());
            ps.setString(4, kh.getSdt());
            ps.setInt(5, kh.getTrangThai());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void update(KhachHang kh){
        String sql = "UPDATE [dbo].[KhachHang] SET Ma = ?, Ten = ?,SDT = ?,TrangThai = ? WHERE Id = ?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, kh.getMa());
            ps.setString(2, kh.getTen());
            ps.setString(3, kh.getSdt());
            ps.setInt(4, kh.getTrangThai());
            ps.setInt(5, kh.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void delete(KhachHang kh){
        String sql = "DELETE FROM KhachHang WHERE Id = ?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, kh.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public KhachHang findById(int id){
        String sql = "SELECT * FROM KhachHang WHERE Id = ?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                String ma= rs.getString("Ma");
                String ten = rs.getString("Ten");
                String sdt = rs.getString("SDT");
                int trangThai = rs.getInt("TrangThai");
                return new KhachHang(id, ten, ma, sdt, trangThai);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
