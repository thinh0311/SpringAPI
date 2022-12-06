package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.*;

@Entity
@Data
@Table(name = "CTDDH")
public class CTDDHEntity{
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    @Column(name = "SoLuong", nullable = false)
    private int soLuong;
    
    @Column(name = "DonGia", nullable = false)
    private float donGia;
    
    @ManyToOne
	@JoinColumn(name ="MaDonHang",nullable = false, foreignKey = @ForeignKey(name="FK_CTDDH_DonDatHang"))
	private DonDatHangEntity donDatHangEntity;
    
    @ManyToOne
    @JoinColumn(name ="MaSanPham",nullable = false, foreignKey = @ForeignKey(name="FK_CTDDH_SanPham"))
    private SanPhamEntity sanPhamEntity;
}
