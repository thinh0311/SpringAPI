package com.example.service;

import java.util.List;

import com.example.dto.*;

public interface IKhachHangService {
	public KhachHangDTO save(KhachHangDTO dto);
	public String delete(Long id);
	public List<KhachHangDTO> getAll();
	public KhachHangDTO getOne(Long id);
	public KhachHangDTO getByIdAcc(Long idAcc);
	public KhachHangDTO getByLogin(String username, String password);
	public Long getByEmail(String email);
}
