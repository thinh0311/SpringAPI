package com.example.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.*;

@Entity
@Data
@Table(name = "NguyenLieu")
public class NguyenLieuEntity {
	@Id
	@Column(name ="MaNguyenLieu")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maNguyenLieu;

    @Column(name = "TenNguyenLieu", nullable = false, length = 50)
    private String tenQuyen;
    
    @OneToMany(mappedBy = "nguyenLieuEntity")
	private List<PhaCheEntity> phaCheEntities = new ArrayList<>();
    
    @OneToMany(mappedBy = "nguyenLieuEntity")
    private List<CTPNEntity> ctpnEntities = new ArrayList<>();
}
