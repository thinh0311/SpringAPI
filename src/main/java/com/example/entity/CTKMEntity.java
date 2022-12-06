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
@Table(name = "CTKM")
public class CTKMEntity{
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    @Column(name = "PhanTramGiam", nullable = false)
    private float khoiLuong;
    
    @ManyToOne
	@JoinColumn(name ="MaKM",nullable = false, foreignKey = @ForeignKey(name="FK_CTKM_KhuyenMai"))
	private KhuyenMaiEntity khuyenMaiEntity;
    
    @ManyToOne
    @JoinColumn(name ="MaSanPham",nullable = false, foreignKey = @ForeignKey(name="FK_CTKM_SanPham"))
    private SanPhamEntity sanPhamEntity;
}
