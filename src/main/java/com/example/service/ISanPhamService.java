package com.example.service;

import java.util.List;

import com.example.dto.SanPhamDTO;

public interface ISanPhamService {
	public SanPhamDTO save(SanPhamDTO dto);
	public String delete(Long id);
	public List<SanPhamDTO> getAll();
	public SanPhamDTO getOne(Long id);
	public List<SanPhamDTO> getByIdLoaiNuoc(Long idCategory);
	public List<SanPhamDTO> searchByNameOrDescribe(String text);
}
