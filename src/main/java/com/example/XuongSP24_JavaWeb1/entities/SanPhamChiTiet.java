package com.example.XuongSP24_JavaWeb1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SanPhamChiTiet")
public class SanPhamChiTiet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "IdMauSac")
    private Integer idMauSac;

    @Column(name = "IdKichThuoc")
    private Integer idKichThuoc;

    @Column(name = "IdSanPham")
    private Integer idSanPham;

    @Column(name = "MaSPCT")
    private String maSanPhamChiTiet;

    @Column(name = "SoLuong")
    private int soLuong;

    @Column(name = "DonGia")
    private Double donGia;

    @Column(name = "TrangThai")
    private int trangThai;
}
