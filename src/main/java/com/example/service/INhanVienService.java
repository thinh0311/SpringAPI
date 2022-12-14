package com.example.service;

import java.util.Date;
import java.util.List;

import com.example.dto.*;

public interface INhanVienService {
	public NhanVienDTO save(NhanVienDTO dto);
	public String delete(Long id);
	public List<NhanVienDTO> getAll();
	public NhanVienDTO getOne(Long id);
	public NhanVienDTO getByIdAcc(Long idAcc);
	public NhanVienDTO getByLogin(String username, String password);
	public List<StatisticDTO> statiticByYear(String start, String end);
	public List<StatisticDTO> statiticByMonth(String start, String end);
	public List<StatisticDTO> statiticByDay(String start, String end);
}
