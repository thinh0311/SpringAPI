package com.example.entity;

import java.util.List;

import javax.persistence.CascadeType;
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

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.*;

@Entity
@Data
@Table(name = "TaiKhoan")
public class TaiKhoanEntity {
	@Id
	@Column(name ="MaTaiKhoan")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maTaiKhoan;

    @Column(name = "Username", nullable = false, length = 30)
    private String username;
    
    @Column(name = "Password", nullable = false, length = 30)
    private String password;
    
    @ManyToOne
	@JoinColumn(name ="MaQuyen",nullable = false, foreignKey = @ForeignKey(name="FK_TaiKhoan_Quyen"))
	private QuyenEntity quyenEntity;
    
    @OneToOne(mappedBy = "taiKhoanEntity",cascade = CascadeType.ALL)
	private KhachHangEntity khachHangEntity;
    
    @OneToOne(mappedBy = "taiKhoanEntity",cascade = CascadeType.ALL)
	private NhanVienEntity nhanVienEntity;
    
    @OneToOne(mappedBy = "taiKhoanEntity",cascade = CascadeType.ALL)
	private ShipperEntity shipperEntity;
}
