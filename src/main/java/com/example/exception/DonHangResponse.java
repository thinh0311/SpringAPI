package com.example.exception;

import java.util.Date;

import lombok.Data;

@Data
public class DonHangResponse {
	private Long MaDonHang;
	private String DiaChi;
	private String MoTa;
	private Date NgayLap;
	private String NguoiNhan;
	private int TrangThai;
	private String KhachHang;
	private String NhanVien;
	private String Shipper;
}
