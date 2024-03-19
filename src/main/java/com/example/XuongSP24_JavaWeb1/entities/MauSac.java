package com.example.XuongSP24_JavaWeb1.entities;

/*
    @author: admin Date: 012/12/03/2024 Time: 13:04
*/
public class MauSac {
    private int id;
    private String ma;
    private String ten;
    private int trangThai;

    public MauSac() {
    }

    public MauSac(int id, String ma, String ten, int trangThai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.trangThai = trangThai;
    }

    public MauSac(String ma, String ten, int trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
}
