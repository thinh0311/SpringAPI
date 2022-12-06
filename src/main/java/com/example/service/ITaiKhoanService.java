package com.example.service;

import java.util.List;

import com.example.dto.TaiKhoanDTO;

public interface ITaiKhoanService {
	public TaiKhoanDTO save(TaiKhoanDTO dto);
	public void delete(Long maTaiKhoan);
	public List<TaiKhoanDTO> getAll();
	public TaiKhoanDTO getOne(Long maTaiKhoan);
}
