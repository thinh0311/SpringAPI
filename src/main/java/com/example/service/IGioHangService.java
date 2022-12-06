package com.example.service;

import java.util.List;

import com.example.dto.*;

public interface IGioHangService {
	public GioHangDTO save(GioHangDTO dto);
	public String deleteByIdKhachHang(Long id);
	public List<GioHangDTO> getAll();
	public GioHangDTO getOne(Long idKH, Long idSP);
	public List<GioHangDTO> getByIdKhachHang(Long id);
}
