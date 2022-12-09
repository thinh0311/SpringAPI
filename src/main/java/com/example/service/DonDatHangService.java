package com.example.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.convert.Convert;
import com.example.dto.*;
import com.example.entity.*;
import com.example.exception.DonHangResponse;
import com.example.reposity.*;

@Service
public class DonDatHangService implements IDonDatHangService {
	
	@Autowired
	private KhachHangReposity khachHangReposity;
	@Autowired
	private NhanVienReposity nhanVienReposity;
	@Autowired
	private ShipperReposity taiKhoanReposity;
	@Autowired
	private DonDatHangReposity donDatHangReposity;
	@Autowired
	private ShipperReposity shipperReposity;
	@Autowired
	private Convert convert;
	@Override
	public DonDatHangDTO save(DonDatHangDTO dto) {
		DonDatHangEntity entity = new DonDatHangEntity();
		entity = convert.toDonDatHangEntity(dto);
		KhachHangEntity khachHangEntity = khachHangReposity.findById(dto.getMaKH()).get();
		entity.setKhachHangEntity(khachHangEntity);
		donDatHangReposity.save(entity);
		return convert.toDonDatHangDTO(entity); 
	}
	@Override
	public List<DonHangResponse> getAll() {
		List<DonDatHangEntity> list = donDatHangReposity.findAll();
		List<DonHangResponse> list2 = new ArrayList<>();
		for (DonDatHangEntity entity : list) {
			DonHangResponse response = new DonHangResponse();
			response.setMaDonHang(entity.getMaDonHang());
			response.setDiaChi(entity.getDiaChi());
			response.setKhachHang(entity.getKhachHangEntity().getHoTen());
			response.setMoTa(entity.getMoTa());
			response.setNgayLap(entity.getNgayLap());
			response.setNguoiNhan(entity.getNguoiNhan());
			if(entity.getNhanVienEntity()!=null) {
				response.setNhanVien(entity.getNhanVienEntity().getHoTen());
			}
			if(entity.getShipperEntity()!=null) {
				response.setShipper(entity.getShipperEntity().getHoTen());
			}
			response.setTrangThai(entity.getTrangThai());
			list2.add(response);
		}
		return list2;
	}
	@Override
	public List<DonHangResponse> getByStatus(int status) {
		List<DonDatHangEntity> list = donDatHangReposity.findByTrangThai(status);
		List<DonHangResponse> list2 = new ArrayList<>();
		for (DonDatHangEntity entity : list) {
			DonHangResponse response = new DonHangResponse();
			response.setMaDonHang(entity.getMaDonHang());
			response.setDiaChi(entity.getDiaChi());
			response.setKhachHang(entity.getKhachHangEntity().getHoTen());
			response.setMoTa(entity.getMoTa());
			response.setNgayLap(entity.getNgayLap());
			response.setNguoiNhan(entity.getNguoiNhan());
			if(entity.getNhanVienEntity()!=null) {
				response.setNhanVien(entity.getNhanVienEntity().getHoTen());
			}
			if(entity.getShipperEntity()!=null) {
				response.setShipper(entity.getShipperEntity().getHoTen());
			}
			response.setTrangThai(entity.getTrangThai());
			list2.add(response);
		}
		return list2;
	}
	@Override
	public List<DonDatHangDTO> getByMaKH(Long idKH) {
		List<DonDatHangEntity> list = donDatHangReposity.findByIdKhachHang(idKH);
		List<DonDatHangDTO> list2 = new ArrayList<>();
		for (DonDatHangEntity entity : list) {
			DonDatHangDTO dto = convert.toDonDatHangDTO(entity);
			list2.add(dto);
		}
		return list2;
	}
	@Override
	public DonDatHangDTO duyet(Long idDDH,Long idNV) {
		DonDatHangEntity entity = donDatHangReposity.findById(idDDH).get();
		entity.setTrangThai(1);
		NhanVienEntity nVienEntity = nhanVienReposity.findById(idNV).get();
		entity.setNhanVienEntity(nVienEntity);
		entity = donDatHangReposity.save(entity);
		return convert.toDonDatHangDTO(entity);
	}
	@Override
	public DonDatHangDTO phancong(Long idDDH,Long idShipper) {
		DonDatHangEntity entity = donDatHangReposity.findById(idDDH).get();
		entity.setTrangThai(2);
		ShipperEntity shipperEntity = shipperReposity.findById(idShipper).get();
		entity.setShipperEntity(shipperEntity);
		entity = donDatHangReposity.save(entity);
		return convert.toDonDatHangDTO(entity);
	}
	@Override
	public DonDatHangDTO hoanthanh(Long idDDH) {
		DonDatHangEntity entity = donDatHangReposity.findById(idDDH).get();
		entity.setTrangThai(3);
		entity = donDatHangReposity.save(entity);
		return convert.toDonDatHangDTO(entity);
	}
	
}
