package com.example.XuongSP24_JavaWeb1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "HoaDonChiTiet")
public class HoaDonChiTiet {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "IdHoaDon")
    private Integer idHoaDon ;

    @Column(name = "IdSPCT")
    private Integer idSPCT ;

    @Column(name = "SoLuong")
    private int soLuong;

    @Column(name = "DonGia")
    private float donGia ;

    @Column(name = "ThoiGian")
    private Date thoiGian ;

    @Column(name = "TrangThai")
    private int trangThai ;

}
