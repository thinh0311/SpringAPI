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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.*;

@Entity
@Data
@Table(name = "LoaiNuoc")
public class LoaiNuocEntity {
	@Id
	@Column(name ="MaLoaiNuoc")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maLoaiNuoc;

    @Column(name = "TenLoaiNuoc", nullable = false, length = 50)
    private String tenLoaiNuoc;
    
    @Column(name = "MoTa", nullable = true)
    private String moTa;
    
    @Column(name = "HinhAnh", nullable = false)
    private String hinhAnh;
 
    @JsonIgnore
	@OneToMany(mappedBy = "loaiNuocEntity") private List<SanPhamEntity> sanPhamEntities = new ArrayList<>();
	 
}
