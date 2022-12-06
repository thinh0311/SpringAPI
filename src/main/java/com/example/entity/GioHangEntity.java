package com.example.entity;

import java.io.Serializable;
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
@Table(name = "GioHang")
public class GioHangEntity{
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    @Column(name = "SoLuong", nullable = false)
    private int soLuong;
    
    @ManyToOne
	@JoinColumn(name ="MaKH",nullable = false, foreignKey = @ForeignKey(name="FK_GioHang_KhachHang"))
	private KhachHangEntity khachHangEntity;
    
    @ManyToOne
    @JoinColumn(name ="MaSanPham",nullable = false, foreignKey = @ForeignKey(name="FK_GioHang_SanPham"))
    private SanPhamEntity sanPhamEntity;
}
