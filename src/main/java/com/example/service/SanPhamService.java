package com.example.service;

import java.util.*;

import org.hibernate.annotations.Check;
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
	public List<SanPhamRespon> getByIdProduct(Long id) {
		List<Object[]> list =  sanPhamReposity.findByIdProduct(id);
		List<SanPhamRespon> list2 = new ArrayList<>();
		for (Object[] object1 : list) {
			for (int i = 0; i<object1.length;i++) {
				SanPhamRespon respon = new SanPhamRespon();
				respon.setMaSanPham(object1[0]);
				respon.setDonGia(object1[1]);
				respon.setHinhAnh(object1[2]);
				respon.setMoTa(object1[3]);
				respon.setTenSanPham(object1[4]);
				respon.setGiamGia(object1[5]);
				int check=0;
				for (SanPhamRespon sanPhamRespon : list2) {
					if(respon.getMaSanPham()==sanPhamRespon.getMaSanPham()) {
						check=1;
					}
				}
				if(check !=1) {
					list2.add(respon);
				}
				
			}
		}
		return list2;
	}
	@Override
	public List<SanPhamRespon> getByIdLoaiNuoc(Long idCategory) {
		List<Object[]> list =  sanPhamReposity.findByIdLoaiNuoc(idCategory);
		List<SanPhamRespon> list2 = new ArrayList<>();
		for (Object[] object1 : list) {
			for (int i = 0; i<object1.length;i++) {
				SanPhamRespon respon = new SanPhamRespon();
				respon.setMaSanPham(object1[0]);
				respon.setDonGia(object1[1]);
				respon.setHinhAnh(object1[2]);
				respon.setMoTa(object1[3]);
				respon.setTenSanPham(object1[4]);
				respon.setGiamGia(object1[5]);
				respon.setMaLoaiNuoc(object1[6]);
				int check=0;
				for (SanPhamRespon sanPhamRespon : list2) {
					if(respon.getMaSanPham()==sanPhamRespon.getMaSanPham()) {
						check=1;
					}
				}
				if(check !=1) {
					list2.add(respon);
				}
				
			}
		}
		return list2;
	}
	@Override
	public List<SanPhamRespon> searchByNameOrDescribe(String text) {
		List<Object[]> list =  sanPhamReposity.search(text);
		List<SanPhamRespon> list2 = new ArrayList<>();
		for (Object[] object1 : list) {
			for (int i = 0; i<object1.length;i++) {
				SanPhamRespon respon = new SanPhamRespon();
				respon.setMaSanPham(object1[0]);
				respon.setDonGia(object1[1]);
				respon.setHinhAnh(object1[2]);
				respon.setMoTa(object1[3]);
				respon.setTenSanPham(object1[4]);
				respon.setGiamGia(object1[5]);
				int check=0;
				for (SanPhamRespon sanPhamRespon : list2) {
					if(respon.getMaSanPham()==sanPhamRespon.getMaSanPham()) {
						check=1;
					}
				}
				if(check !=1) {
					list2.add(respon);
				}
				
			}
		}
		return list2;
	}
	@Override
	public List<SanPhamRespon> getSanPhamTrongGioHang(Long idKH) {
		List<Object[]> list =  sanPhamReposity.getSanPhamTrongGioHang(idKH);
		List<SanPhamRespon> list2 = new ArrayList<>();
		for (Object[] object1 : list) {
			for (int i = 0; i<object1.length;i++) {
				SanPhamRespon respon = new SanPhamRespon();
				respon.setSoLuong(object1[0]);
				respon.setMaSanPham(object1[1]);
				respon.setDonGia(object1[2]);
				respon.setHinhAnh(object1[3]);
				respon.setMoTa(object1[4]);
				respon.setTenSanPham(object1[5]);
				respon.setGiamGia(object1[6]);
				respon.setId(object1[7]);
				int check=0;
				for (SanPhamRespon sanPhamRespon : list2) {
					if(respon.getMaSanPham()==sanPhamRespon.getMaSanPham()) {
						check=1;
					}
				}
				if(check !=1) {
					list2.add(respon);
				}
				
			}
		}
		return list2;
	}
	@Override
	public List<SanPhamRespon> getSanPhamKhuyenMai() {
		List<Object[]> list =  sanPhamReposity.getSanPhamKhuyenMai();
		List<SanPhamRespon> list2 = new ArrayList<>();
		for (Object[] object1 : list) {
			for (int i = 0; i<object1.length;i++) {
				SanPhamRespon respon = new SanPhamRespon();
				respon.setMaSanPham(object1[0]);
				respon.setDonGia(object1[1]);
				respon.setHinhAnh(object1[2]);
				respon.setMoTa(object1[3]);
				respon.setTenSanPham(object1[4]);
				respon.setGiamGia(object1[5]);
				int check=0;
				for (SanPhamRespon sanPhamRespon : list2) {
					if(respon.getMaSanPham()==sanPhamRespon.getMaSanPham()) {
						check=1;
					}
				}
				if(check !=1) {
					list2.add(respon);
				}
				
			}
		}
		return list2;
	}
	@Override
	public List<SanPhamRespon> getSanPhamBanChay() {
		List<Object[]> list =  sanPhamReposity.getSanPhamBanChay();
		List<SanPhamRespon> list2 = new ArrayList<>();
		for (Object[] object1 : list) {
			for (int i = 0; i<object1.length;i++) {
				SanPhamRespon respon = new SanPhamRespon();
				respon.setMaSanPham(object1[0]);
				respon.setDonGia(object1[1]);
				respon.setHinhAnh(object1[2]);
				respon.setMoTa(object1[3]);
				respon.setTenSanPham(object1[4]);
				respon.setGiamGia(object1[5]);
				respon.setSoLuong(object1[6]);
				int check=0;
				for (SanPhamRespon sanPhamRespon : list2) {
					if(respon.getMaSanPham()==sanPhamRespon.getMaSanPham()) {
						check=1;
					}
				}
				if(check !=1) {
					list2.add(respon);
				}
				
			}
		}
		return list2;
	}

	
}
