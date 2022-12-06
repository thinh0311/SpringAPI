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
import javax.persistence.Table;

import lombok.*;

@Entity
@Data
@Table(name = "PhieuNhap")
public class PhieuNhapEntity {
	@Id
	@Column(name ="MaPN")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maPN;

    @Column(name = "TrangThai", nullable = false)
    private int trangThai;
    
    @ManyToOne
	@JoinColumn(name ="MaNV",nullable = false, foreignKey = @ForeignKey(name="FK_PhieuNhap_NhanVien"))
	private NhanVienEntity nhanVienEntity;
    
    @OneToMany(mappedBy = "phieuNhapEntity")
    private List<CTPNEntity> ctpnEntities = new ArrayList<>();
}
