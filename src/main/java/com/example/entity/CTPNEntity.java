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
@Table(name = "CTPN")
public class CTPNEntity{
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    @Column(name = "KhoiLuong", nullable = false)
    private float khoiLuong;
    
    @Column(name = "Gia", nullable = false)
    private float gia;
    
    @ManyToOne
	@JoinColumn(name ="MaPN",nullable = false, foreignKey = @ForeignKey(name="FK_CTPN_PhieuNhap"))
	private PhieuNhapEntity phieuNhapEntity;
    
    @ManyToOne
    @JoinColumn(name ="MaNguyenLieu",nullable = false, foreignKey = @ForeignKey(name="FK_CTPN_NguyenLieu"))
    private NguyenLieuEntity nguyenLieuEntity;
}
