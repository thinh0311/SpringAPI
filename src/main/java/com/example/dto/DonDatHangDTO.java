package com.example.dto;

import java.util.Date;

import lombok.Data;

@Data
public class DonDatHangDTO {
    private long maDonHang;
    private Date ngayLap;
    private String moTa;
    private String nguoiNhan;
    private String diaChi;
    private int trangThai;
    private Long maNV;
    private Long maKH;
    private Long maShipper;
}
