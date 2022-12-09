package com.example.service;

import java.util.List;

import com.example.dto.*;

public interface ICTDDHService {
	public CTDDHDTO save(CTDDHDTO dto);
	public List<CTDDHDTO> getByMaDonHang(Long idDH);
	public CTDDHDTO getByMaDonHangAndSanPham(Long idDH, Long idSP);
}
