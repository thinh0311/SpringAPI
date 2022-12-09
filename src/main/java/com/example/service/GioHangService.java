package com.example.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.convert.Convert;
import com.example.dto.*;
import com.example.entity.*;
import com.example.reposity.*;

@Service
public class GioHangService implements IGioHangService {
	
	@Autowired
	private SanPhamReposity sanPhamReposity;
	@Autowired
	private KhachHangReposity khachHangReposity;
	@Autowired
	private GioHangReposity gioHangReposity;
	@Autowired
	private Convert convert;
	@Override
	public GioHangDTO save(GioHangDTO dto) {
		GioHangEntity entity = new GioHangEntity();
		if(dto.getId()!=null) {
			GioHangEntity oldEntity = gioHangReposity.findByIdKhachHangAndSanPham(dto.getMaKH(),dto.getMaSanPham());
			entity = gioHangReposity.save(convert.toGioHangEntity(dto, oldEntity));
			return convert.toGioHangDTO(entity);
			
		}
		else {
			entity = convert.toGioHangEntity(dto);
		}
		KhachHangEntity khachHangEntity = khachHangReposity.findById(dto.getMaKH()).get();
		entity.setKhachHangEntity(khachHangEntity);
		SanPhamEntity sanPhamEntity = sanPhamReposity.findById(dto.getMaSanPham()).get();
		entity.setSanPhamEntity(sanPhamEntity);
		entity = gioHangReposity.save(entity);
		return convert.toGioHangDTO(entity);
	}
	@Override
	public String deleteByIdKhachHang(Long id) {
		List<GioHangDTO> list = getByIdKhachHang(id);
		if(list.isEmpty()) {
			return "Failure";
		}
		gioHangReposity.deleteByIdKhachHang(id);
		return "Ok";
	}
	@Override
	public List<GioHangDTO> getAll() {
		List<GioHangEntity> list = gioHangReposity.findAll();
		List<GioHangDTO> list2 = new ArrayList<>();
		for (GioHangEntity entity : list) {
			GioHangDTO dto = convert.toGioHangDTO(entity);
			list2.add(dto);
		}
		return list2;
	}
	@Override
	public List<GioHangDTO> getByIdKhachHang(Long idKH) {
		List<GioHangEntity> list = gioHangReposity.findByIdKhachHang(idKH);
		List<GioHangDTO> list2 = new ArrayList<>();
		for (GioHangEntity entity : list) {
			GioHangDTO dto = convert.toGioHangDTO(entity);
			list2.add(dto);
		}
		return list2;
	}
	@Override
	public GioHangDTO getOne(Long idKH, Long idSP) {
		GioHangEntity entity = gioHangReposity.findByIdKhachHangAndSanPham(idKH, idSP);
		return convert.toGioHangDTO(entity);
	}
	@Override
	public String deleteSanPham(Long idKH, Long idSP) {
		GioHangDTO sanPham = getOne(idKH,idSP);
		if(sanPham.getMaSanPham()!=null) {
			gioHangReposity.deleteSanPham(idKH, idSP);
			return "Ok";
		}
		return "Failure";
		
	}
	
}
