package com.example.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.*;

@Entity
@Data
@Table(name = "DonDatHang")
public class DonDatHangEntity {
	@Id
	@Column(name ="MaDonHang")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maDonHang;

    @Column(name = "NgayLap", nullable = false)
    private Date ngayLap;
    
    @Column(name = "MoTa", nullable = true)
    private String moTa;
    
    @Column(name = "NguoiNhan", nullable = false, length = 50)
    private String nguoiNhan;
    
    @Column(name = "DiaChi", nullable = false)
    private String diaChi;
    
    @Column(name = "TrangThai", nullable = false)
    private int trangThai;
    
    @ManyToOne
	@JoinColumn(name ="MaNV",nullable = true, foreignKey = @ForeignKey(name="FK_DonDatHang_NhanVien"))
	private NhanVienEntity nhanVienEntity;
    
    @ManyToOne
    @JoinColumn(name ="MaKH",nullable = true, foreignKey = @ForeignKey(name="FK_DonDatHang_KhachHang"))
    private KhachHangEntity khachHangEntity;
    
    @ManyToOne
    @JoinColumn(name ="MaShipper",nullable = true, foreignKey = @ForeignKey(name="FK_DonDatHang_Shipper"))
    private ShipperEntity shipperEntity;
    
	@OneToMany(mappedBy = "donDatHangEntity") 
	private List<CTDDHEntity> ctddhEntities = new ArrayList<>();
	
	@OneToOne(mappedBy = "donDatHangEntity")
	private HoaDonEntity hoaDonEntity;
	 
}
