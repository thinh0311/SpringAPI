package com.example.convert;

import org.springframework.stereotype.Component;

import com.example.dto.*;
import com.example.entity.*;

@Component
public class Convert {
	//tai khoan
	public TaiKhoanEntity toEntityTaiKhoan(TaiKhoanDTO dto) {
		TaiKhoanEntity entity = new TaiKhoanEntity();
		entity.setUsername(dto.getUsername());
		entity.setPassword(dto.getPassword());
		return entity;
	}
	
	public TaiKhoanDTO toDTOTaiKhoan(TaiKhoanEntity entity) {
		TaiKhoanDTO dto = new TaiKhoanDTO();
		dto.setMaTaiKhoan(entity.getMaTaiKhoan());
		dto.setUsername(entity.getUsername());
		dto.setPassword(entity.getPassword());
		dto.setMaQuyen(entity.getQuyenEntity().getMaQuyen());
		return dto;
	}
	
	public TaiKhoanEntity toEntityTaiKhoan(TaiKhoanDTO dto,TaiKhoanEntity entity) {
		entity.setUsername(dto.getUsername());
		entity.setPassword(dto.getPassword());
		return entity;
	}
	//san pham
	public SanPhamEntity toEntitySanPham(SanPhamDTO dto) {
		SanPhamEntity entity = new SanPhamEntity();
		entity.setDonGia(dto.getDonGia());
		entity.setHinhAnh(dto.getHinhAnh());
		entity.setMoTa(dto.getMoTa());
		entity.setTenSanPham(dto.getTenSanPham());
		return entity;
	}
	
	public SanPhamDTO toDTOSanPham(SanPhamEntity entity) {
		SanPhamDTO dto = new SanPhamDTO();
		dto.setMaSanPham(entity.getMaSanPham());
		dto.setDonGia(entity.getDonGia());
		dto.setHinhAnh(entity.getHinhAnh());
		dto.setMoTa(entity.getMoTa());
		dto.setTenSanPham(entity.getTenSanPham());
		dto.setMaLoaiNuoc(entity.getLoaiNuocEntity().getMaLoaiNuoc());
		return dto;
	}
	
	public SanPhamEntity toEntitySanPham(SanPhamDTO dto,SanPhamEntity entity) {
		entity.setDonGia(dto.getDonGia());
		entity.setHinhAnh(dto.getHinhAnh());
		entity.setMoTa(dto.getMoTa());
		entity.setTenSanPham(dto.getTenSanPham());
		return entity;
	}
	//khach hang
	public KhachHangEntity toEntityKhachHang(KhachHangDTO dto) {
		KhachHangEntity entity = new KhachHangEntity();
		entity.setHoTen(dto.getHoTen());
		entity.setDiaChi(dto.getDiaChi());
		entity.setSdt(dto.getSdt());
		entity.setEmail(dto.getEmail());
		entity.setAnhDaiDien(dto.getAnhDaiDien());
		return entity;
	}
	
	public KhachHangDTO toKhachHangDTO(KhachHangEntity entity) {
		KhachHangDTO dto = new KhachHangDTO();
		dto.setMaKH(entity.getMaKH());
		dto.setHoTen(entity.getHoTen());
		dto.setDiaChi(entity.getDiaChi());
		dto.setSdt(entity.getSdt());
		dto.setEmail(entity.getEmail());
		dto.setAnhDaiDien(entity.getAnhDaiDien());
		dto.setUsername(entity.getTaiKhoanEntity().getUsername());
		dto.setPassword(entity.getTaiKhoanEntity().getPassword());
		dto.setMaTaiKhoan(entity.getTaiKhoanEntity().getMaTaiKhoan());
		return dto;
	}
	
	public KhachHangEntity toKhachHangEntity(KhachHangDTO dto,KhachHangEntity entity) {
		entity.setHoTen(dto.getHoTen());
		entity.setDiaChi(dto.getDiaChi());
		entity.setSdt(dto.getSdt());
		entity.setEmail(dto.getEmail());
		entity.setAnhDaiDien(dto.getAnhDaiDien());
		return entity;
	}
	//nhan vien
	public NhanVienEntity toNhanVienEntity(NhanVienDTO dto) {
		NhanVienEntity entity = new NhanVienEntity();
		entity.setHoTen(dto.getHoTen());
		entity.setDiaChi(dto.getDiaChi());
		entity.setSdt(dto.getSdt());
		return entity;
	}
	
	public NhanVienDTO toNhanVienDTO(NhanVienEntity entity) {
		NhanVienDTO dto = new NhanVienDTO();
		dto.setMaNV(entity.getMaNV());
		dto.setHoTen(entity.getHoTen());
		dto.setDiaChi(entity.getDiaChi());
		dto.setSdt(entity.getSdt());
		dto.setUsername(entity.getTaiKhoanEntity().getUsername());
		dto.setPassword(entity.getTaiKhoanEntity().getPassword());
		dto.setMaTaiKhoan(entity.getTaiKhoanEntity().getMaTaiKhoan());
		return dto;
	}
	
	public NhanVienEntity toNhanVienEntity(NhanVienDTO dto,NhanVienEntity entity) {
		entity.setHoTen(dto.getHoTen());
		entity.setDiaChi(dto.getDiaChi());
		entity.setSdt(dto.getSdt());
		return entity;
	}
	//gio hang
	public GioHangDTO toGioHangDTO(GioHangEntity entity) {
		GioHangDTO dto = new GioHangDTO();
		dto.setId(entity.getId());
		dto.setMaKH(entity.getKhachHangEntity().getMaKH());
		dto.setMaSanPham(entity.getSanPhamEntity().getMaSanPham());
		dto.setSoLuong(entity.getSoLuong());
		return dto;
	}
	
	public GioHangEntity toGioHangEntity(GioHangDTO dto) {
		GioHangEntity entity = new GioHangEntity();
		entity.setSoLuong(dto.getSoLuong());
		return entity;
	}
	
	public GioHangEntity toGioHangEntity(GioHangDTO dto,GioHangEntity entity) {
		entity.setSoLuong(dto.getSoLuong());
		return entity;
	}
}
