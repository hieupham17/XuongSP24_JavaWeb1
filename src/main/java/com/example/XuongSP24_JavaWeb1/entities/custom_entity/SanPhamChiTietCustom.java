package com.example.XuongSP24_JavaWeb1.entities.custom_entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SanPhamChiTietCustom {
    @Id
    private Integer id;
    private String tenMauSac;
    private String tenKichThuoc;
    private String maSanPhamChiTiet;
    private int soLuong;
    private Double donGia;
    private int trangThai;
}
