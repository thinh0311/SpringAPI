package com.example.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "NhanVien")
public class NhanVienEntity {
	@Id
	@Column(name ="MaNV")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maNV;

    @Column(name = "HoTen", nullable = false, length = 30)
    private String hoTen;
    
    @Column(name = "DiaChi", nullable = false)
    private String diaChi;
    
    @Column(name = "SDT", nullable = false, length = 15)
    private String sdt;
    
    //1-1
    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="MaTaiKhoan",nullable = false, foreignKey = @ForeignKey(name="FK_NhanVien_TaiKhoan"))
	private TaiKhoanEntity taiKhoanEntity;
    
    //1-N
    @OneToMany(mappedBy = "nhanVienEntity")
	private List<PhieuNhapEntity> phieuNhapEntities = new ArrayList<>();
    
    @OneToMany(mappedBy = "nhanVienEntity")
	private List<HoaDonEntity> hoaDonEntities = new ArrayList<>();
}
