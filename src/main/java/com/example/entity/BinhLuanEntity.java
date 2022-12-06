package com.example.entity;

import java.util.Date;
import java.util.ArrayList;
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
import javax.persistence.Table;

import lombok.*;

@Entity
@Data
@Table(name = "BinhLuan")
public class BinhLuanEntity {
	@Id
	@Column(name ="MaBinhLuan")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maBinhLuan;

    @Column(name = "NgayBinhLuan", nullable = false)
    private Date ngayBinhLuan;
    
    @Column(name = "NoiDung", nullable = false)
    private Date noiDung;
    
    @ManyToOne
	@JoinColumn(name ="MaSanPham",nullable = false, foreignKey = @ForeignKey(name="FK_BinhLuan_SanPham"))
	private SanPhamEntity sanPhamEntity;
    
    @ManyToOne
    @JoinColumn(name ="MaKH",nullable = false, foreignKey = @ForeignKey(name="FK_BinhLuan_KhachHang"))
    private KhachHangEntity khachHangEntity;
}
