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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "KhachHang")
public class KhachHangEntity {
	@Id
	@Column(name ="MaKH")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maKH;

    @Column(name = "HoTen", nullable = false, length = 30)
    private String hoTen;
    
    @Column(name = "DiaChi", nullable = false)
    private String diaChi;
    
    @Column(name = "SDT", nullable = false, length = 15)
    private String sdt;
    
    @Column(name = "Email", nullable = false, length = 50)
    private String email;
    
    @Column(name = "AnhDaiDien", nullable = true)
    private String anhDaiDien;
    
    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="MaTaiKhoan",nullable = false, foreignKey = @ForeignKey(name="FK_KhachHang_TaiKhoan"))
	private TaiKhoanEntity taiKhoanEntity;
    
    @OneToMany(mappedBy = "khachHangEntity") 
	private List<GioHangEntity> gioHangEntities = new ArrayList<>();
}
