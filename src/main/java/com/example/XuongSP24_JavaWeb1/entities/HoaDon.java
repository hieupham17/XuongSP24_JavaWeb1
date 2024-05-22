package com.example.XuongSP24_JavaWeb1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "HoaDon")
public class HoaDon {

    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "IdKH")
    private Integer idKH;
    @Column(name = "IdNV")
    private Integer idNV;
    @Column(name = "NgayMuaHang")
    private Date ngayMuaHang;
    @Column(name = "TrangThai")
    private int trangThai;


}
