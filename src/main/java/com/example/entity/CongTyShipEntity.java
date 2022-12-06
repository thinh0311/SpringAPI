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
@Table(name = "CongTyShip")
public class CongTyShipEntity {
	@Id
	@Column(name ="MaCongTy")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maCongTy;

    @Column(name = "TenCongTy", nullable = false, length = 50)
    private String tenCongTy;
    
    @Column(name = "DiaChi", nullable = false, length = 255)
    private String diaChi;
    
    @Column(name = "SDT", nullable = false, length = 15)
    private String sdt;
    
    @Column(name = "MoTa", nullable = true)
    private String moTa;
    
    @OneToMany(mappedBy = "congTyShipEntity")
    private List<ShipperEntity> shipperEntities = new ArrayList<>();
}
