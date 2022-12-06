package com.example.dto;

import lombok.*;

@Data
public class SanPhamDTO {
    private long maSanPham;
    private String tenSanPham;
    private String moTa;
    private float donGia;
    private String hinhAnh;
    private Long maLoaiNuoc;
}
