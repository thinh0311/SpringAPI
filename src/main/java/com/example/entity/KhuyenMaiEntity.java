package com.example.entity;

import java.util.ArrayList;
import java.util.Date;
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
@Table(name = "KhuyenMai")
public class KhuyenMaiEntity {
	@Id
	@Column(name ="MaKM")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maKM;

    @Column(name = "TenKM", nullable = false, length = 50)
    private String tenKM;
    
    @Column(name = "MoTa", nullable = true)
    private String moTa;
    
    @Column(name = "NgayBatDau", nullable = false)
    private Date ngayBatDau;
 
    @Column(name = "NgayKetThuc", nullable = false)
    private Date ngayKetThuc;
    
	@OneToMany(mappedBy = "khuyenMaiEntity") 
	private List<CTKMEntity> ctkmEntities = new ArrayList<>();
	 
}
