package com.example.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.*;

@Entity
@Data
@Table(name = "PhaChe")
public class PhaCheEntity implements Serializable{
    
    @Column(name = "KhoiLuong", nullable = false)
    private float khoiLuong;
    
    @Id
    @ManyToOne
	@JoinColumn(name ="MaSanPham",nullable = false, foreignKey = @ForeignKey(name="FK_PhaChe_SanPham"))
	private SanPhamEntity sanPhamEntity;
    
    @ManyToOne
    @JoinColumn(name ="MaNguyenLieu",nullable = false,unique = true, foreignKey = @ForeignKey(name="FK_PhaChe_NguyenLieu"))
    private NguyenLieuEntity nguyenLieuEntity;
}
