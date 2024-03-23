package com.example.XuongSP24_JavaWeb1.entities;

public class NhanVien {
    private int id;
    private String ten;
    private String ma;
    private String tenDangNhap;
    private String matkhau;
    private int trangThai;

    public NhanVien() {
    }

    public NhanVien(int id, String ten, String ma, String tenDangNhap, String matkhau, int trangThai) {
        this.id = id;
        this.ten = ten;
        this.ma = ma;
        this.tenDangNhap = tenDangNhap;
        this.matkhau = matkhau;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
}
