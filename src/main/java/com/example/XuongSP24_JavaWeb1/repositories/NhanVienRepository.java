package com.example.XuongSP24_JavaWeb1.repositories;

import com.example.XuongSP24_JavaWeb1.entities.NhanVien;
import com.example.XuongSP24_JavaWeb1.utils.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NhanVienRepository {

    private List<NhanVien> list ;
    private Connection connection ;

    public NhanVienRepository(){
        try {
            this.connection = DBConnect.getConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<NhanVien> findAdd(){
        ArrayList<NhanVien> list = new ArrayList<>();
        String sql = "SELECT * FROM NhanVien";

        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                int id = rs.getInt("Id");
                String ten = rs.getString("Ten");
                String ma= rs.getString("Ma");
                String tenDangNhap = rs.getString("TenDangNhap");
                String matKhau = rs.getString("MatKhau");
                int trangThai = rs.getInt("TrangThai");
                NhanVien nv = new NhanVien(id, ten, ma, tenDangNhap, matKhau, trangThai);
                list.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insert(NhanVien nv){
        String sql = "INSERT INTO NhanVien(ID, Ten, Ma, TenDangNhap, MatKhau, TrangThai) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
                ps.setInt(1, nv.getId());
                ps.setString(2, nv.getTen());
                ps.setString(3, nv.getMa());
                ps.setString(4, nv.getTenDangNhap());
                ps.setString(5, nv.getMatkhau());
                ps.setInt(6, nv.getTrangThai());
                ps.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    public void update(NhanVien nv){
        String sql = "UPDATE NhanVien SET Ten = ?, Ma = ?, TenDangNhap = ?, MatKhau = ?, TrangThai = ? WHERE Id = ?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, nv.getTen());
            ps.setString(2, nv.getMa());
            ps.setString(3, nv.getTenDangNhap());
            ps.setString(4, nv.getMatkhau());
            ps.setInt(5, nv.getTrangThai());
            ps.setInt(6, nv.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void delete(NhanVien nv){
        String sql = "DELETE FROM NhanVien WHERE Id = ?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, nv.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public NhanVien findById(int id){
        String sql = "SELECT * FROM NhanVien WHERE Id = ?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                String ten = rs.getString("Ten");
                String ma= rs.getString("Ma");
                String tenDangNhap = rs.getString("TenDangNhap");
                String matKhau = rs.getString("MatKhau");
                int trangThai = rs.getInt("TrangThai");
                return new NhanVien(id, ten, ma, tenDangNhap, matKhau, trangThai);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
