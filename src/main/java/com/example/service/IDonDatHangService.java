package com.example.service;

import java.util.List;

import com.example.dto.*;
import com.example.exception.DonHangResponse;

public interface IDonDatHangService {
	public DonDatHangDTO save(DonDatHangDTO dto);
	//public String delete(Long id);
	public List<DonDatHangDTO> getByMaKH(Long idKH);
	public List<DonHangResponse> getByStatus(int status);
	public List<DonHangResponse> getAll();
	public DonDatHangDTO duyet(Long idDDH,Long idNV);
	public DonDatHangDTO phancong(Long idDDH,Long idShipper);
	public DonDatHangDTO hoanthanh(Long idDDH);
}