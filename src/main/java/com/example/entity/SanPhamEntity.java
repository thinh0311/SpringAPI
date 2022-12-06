package com.example.entity;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.*;

@Entity
@Data
@Table(name = "SanPham")
public class SanPhamEntity {
	@Id
	@Column(name ="MaSanPham")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maSanPham;

    @Column(name = "TenSanPham", nullable = false, length = 50)
    private String tenSanPham;
    
    @Column(name = "MoTa", nullable = true)
    private String moTa;
    
    @Column(name = "DonGia", nullable = false)
    private float donGia;
    
    @Column(name = "HinhAnh", nullable = false)
    private String hinhAnh;
    
    //N-1
    @ManyToOne
	@JoinColumn(name ="MaLoaiNuoc",nullable = false, foreignKey = @ForeignKey(name="FK_SanPham_LoaiNuoc"))
	private LoaiNuocEntity loaiNuocEntity;
    
    //1-N
    @OneToMany(mappedBy = "sanPhamEntity")
	private List<PhaCheEntity> phaCheEntities = new ArrayList<>();
    
    @OneToMany(mappedBy = "sanPhamEntity") 
	private List<CTDDHEntity> ctddhEntities = new ArrayList<>();
    
    @OneToMany(mappedBy = "sanPhamEntity") 
	private List<CTKMEntity> ctkmEntities = new ArrayList<>();
    
    @OneToMany(mappedBy = "sanPhamEntity") 
	private List<GioHangEntity> gioHangEntities = new ArrayList<>();

}
