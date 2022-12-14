package com.example.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.convert.Convert;
import com.example.dto.*;
import com.example.entity.*;
import com.example.reposity.*;

@Service
public class CTDDHService implements ICTDDHService {
	
	@Autowired
	private DonDatHangReposity donDatHangReposity;
	@Autowired
	private SanPhamReposity sanPhamReposity;
	@Autowired
	private CTDDHReposity ctddhReposity;
	@Autowired
	private Convert convert;
	@Override
	public CTDDHDTO save(CTDDHDTO dto) {
		CTDDHEntity entity = new CTDDHEntity();
		entity = convert.toCtddhEntity(dto);
		DonDatHangEntity donHang = donDatHangReposity.findById(dto.getMaDonHang()).get();
		entity.setDonDatHangEntity(donHang);
		SanPhamEntity sanPham = sanPhamReposity.findById(dto.getMaSanPham()).get();
		entity.setSanPhamEntity(sanPham);
		entity = ctddhReposity.save(entity);
		return convert.toCtddhdto(entity);
	}
	@Override
	public List<CTDDHDTO> getByMaDonHang(Long idDH) {
		List<CTDDHEntity> list = ctddhReposity.findByIdDonDatHang(idDH);
		List<CTDDHDTO> list2 = new ArrayList<>();
		for (CTDDHEntity entity : list) {
			CTDDHDTO dto = convert.toCtddhdto(entity);
			dto.setMaDonHang(entity.getDonDatHangEntity().getMaDonHang());
			dto.setMaSanPham(entity.getSanPhamEntity().getMaSanPham());
			dto.setTenSanPham(entity.getSanPhamEntity().getTenSanPham());
			dto.setHinhAnh(entity.getSanPhamEntity().getHinhAnh());
			list2.add(dto);
		}
		return list2;
	}
	@Override
	public CTDDHDTO getByMaDonHangAndSanPham(Long idDH,Long idSP) {
		CTDDHEntity entity = ctddhReposity.findByIdDonDatHangAndSanPham(idDH, idSP);
		CTDDHDTO dto = convert.toCtddhdto(entity);
		dto.setMaDonHang(entity.getDonDatHangEntity().getMaDonHang());
		dto.setMaSanPham(entity.getSanPhamEntity().getMaSanPham());
		dto.setTenSanPham(entity.getSanPhamEntity().getTenSanPham());
		dto.setHinhAnh(entity.getSanPhamEntity().getHinhAnh());
		return dto;
	}
	
}
