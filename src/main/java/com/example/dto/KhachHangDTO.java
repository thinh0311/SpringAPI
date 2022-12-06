package com.example.dto;

import lombok.Data;

@Data
public class KhachHangDTO {
	
    private long maKH;
    private String hoTen;
    private String diaChi;
    private String sdt;
    private String email;
    private String anhDaiDien;
	private Long maTaiKhoan;
	private String username;
	private String password;
}

