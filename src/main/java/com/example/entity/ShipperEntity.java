package com.example.entity;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name = "Shipper")
public class ShipperEntity {
	@Id
	@Column(name ="MaShipper")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maShipper;

    @Column(name = "HoTen", nullable = false, length = 50)
    private String hoTen;
    
    @Column(name = "DiaChi", nullable = false)
    private String diaChi;
    
    @Column(name = "SDT", nullable = false, length = 15)
    private String sdt;
    
    @Column(name = "Email", nullable = false, length = 50)
    private String email;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
	@JoinColumn(name ="MaTaiKhoan",nullable = false, foreignKey = @ForeignKey(name="FK_Shipper_TaiKhoan"))
	private TaiKhoanEntity taiKhoanEntity;
    
    @ManyToOne
    @JsonIgnore
	@JoinColumn(name ="MaCongTy",nullable = true, foreignKey = @ForeignKey(name="FK_Shipper_CongTyShip"))
	private CongTyShipEntity congTyShipEntity;
}
