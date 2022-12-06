package com.example.entity;

import java.util.ArrayList;
import java.util.Date;
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

import lombok.*;

@Entity
@Data
@Table(name = "HoaDon")
public class HoaDonEntity {
	@Id
	@Column(name ="MaHoaDon", length = 50)
    private String maHoaDon;

    @Column(name = "NgayLap", nullable = false)
    private Date ngayLap;
    
    @ManyToOne
	@JoinColumn(name ="MaNV",nullable = true, foreignKey = @ForeignKey(name="FK_HoaDon_NhanVien"))
	private NhanVienEntity nhanVienEntity;
    
    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="MaDonHang",nullable = false, foreignKey = @ForeignKey(name="FK_HoaDon_DonDatHang"))
	private DonDatHangEntity donDatHangEntity;
}
