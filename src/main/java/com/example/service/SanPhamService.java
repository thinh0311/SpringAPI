package com.example.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.convert.Convert;
import com.example.dto.*;
import com.example.entity.*;
import com.example.exception.SanPhamRespon;
import com.example.reposity.*;

@Service
public class SanPhamService implements ISanPhamService {
	
	@Autowired
	private SanPhamReposity sanPhamReposity;
	@Autowired
	private LoaiNuocReposity loaiNuocReposity;
	@Autowired
	private Convert convert;
	@Override
	public SanPhamDTO save(SanPhamDTO dto) {
		SanPhamEntity entity = new SanPhamEntity();
		if(dto.getMaSanPham() != 0L) {
			SanPhamEntity oldEntity = sanPhamReposity.findById(dto.getMaSanPham()).get();
			entity = convert.toEntitySanPham(dto, oldEntity);
			
		}
		else {
			entity = convert.toEntitySanPham(dto);
		}
		LoaiNuocEntity category = loaiNuocReposity.findById(dto.getMaLoaiNuoc()).get();
		entity.setLoaiNuocEntity(category);
		entity = sanPhamReposity.save(entity);
		
		return convert.toDTOSanPham(entity);
	}
	@Override
	public String delete(Long id) {
		SanPhamEntity entity = sanPhamReposity.findById(id).get();
		sanPhamReposity.delete(entity);
		return "Ok";
	}
	@Override
	public List<SanPhamDTO> getAll() {
		List<SanPhamEntity> list = sanPhamReposity.findAll();
		List<SanPhamDTO> list2 = new ArrayList<>();
		for (SanPhamEntity entity : list) {
			SanPhamDTO dto = convert.toDTOSanPham(entity);
			list2.add(dto);
		}
		return list2;
	}
	@Override
	public SanPhamDTO getOne(Long id) {
		SanPhamEntity entity = sanPhamReposity.findById(id).get();
		return convert.toDTOSanPham(entity);
	}
	@Override
	public List<SanPhamDTO> getByIdLoaiNuoc(Long idCategory) {
		List<SanPhamEntity> list = sanPhamReposity.findByIdLoaiNuoc(idCategory);
		List<SanPhamDTO> list2 = new ArrayList<>();
		for (SanPhamEntity entity : list) {
			SanPhamDTO dto = convert.toDTOSanPham(entity);
			list2.add(dto);
		}
		return list2;
	}
	@Override
	public List<SanPhamDTO> searchByNameOrDescribe(String text) {
		List<SanPhamEntity> list = sanPhamReposity.search(text);
		List<SanPhamDTO> list2 = new ArrayList<>();
		for (SanPhamEntity entity : list) {
			SanPhamDTO dto = convert.toDTOSanPham(entity);
			list2.add(dto);
		}
		return list2;
	}
	@Override
	public List<SanPhamEntity> getSanPhamTrongGioHang(Long idKH) {
		List<SanPhamEntity> list = sanPhamReposity.getSanPhamTrongGioHang(idKH);
		return list;
	}

	
}
