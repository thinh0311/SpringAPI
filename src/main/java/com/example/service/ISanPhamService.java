package com.example.service;

import java.util.List;

import com.example.dto.SanPhamDTO;
import com.example.entity.SanPhamEntity;
import com.example.exception.SanPhamRespon;

public interface ISanPhamService {
	public SanPhamDTO save(SanPhamDTO dto);
	public String delete(Long id);
	public List<SanPhamDTO> getAll();
	public SanPhamDTO getOne(Long id);
	public List<SanPhamRespon> getByIdLoaiNuoc(Long idCategory);
	List<SanPhamRespon> getByIdProduct(Long id);
	public List<SanPhamRespon> searchByNameOrDescribe(String text);
	public List<SanPhamRespon> getSanPhamTrongGioHang(Long idKH);
	List<SanPhamRespon> getSanPhamKhuyenMai();
	List<SanPhamRespon> getSanPhamBanChay();
}
