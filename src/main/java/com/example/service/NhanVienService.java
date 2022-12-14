package com.example.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.convert.Convert;
import com.example.dto.*;
import com.example.entity.*;
import com.example.exception.KhachHangResponse;
import com.example.exception.SanPhamRespon;
import com.example.reposity.*;

@Service
public class NhanVienService implements INhanVienService {
	
	@Autowired
	private QuyenReposity quyenReposity;
	@Autowired
	private NhanVienReposity nhanVienReposity;
	@Autowired
	private TaiKhoanReposity taiKhoanReposity;
	@Autowired
	private Convert convert;
	@Override
	public NhanVienDTO save(NhanVienDTO dto) {
		NhanVienEntity entity = new NhanVienEntity();
		if(dto.getMaNV() != 0L) {
			NhanVienEntity oldEntity = nhanVienReposity.findById(dto.getMaNV()).get();
			entity = nhanVienReposity.save(convert.toNhanVienEntity(dto, oldEntity));
			return convert.toNhanVienDTO(entity);
			
		}
		else {
			entity = convert.toNhanVienEntity(dto);
		}
		QuyenEntity role = quyenReposity.findById((long) 2).get();//Ma quyen 2 la nhan vien
		TaiKhoanEntity account = new TaiKhoanEntity();
		account.setUsername(dto.getUsername());
		account.setPassword(dto.getPassword());
		account.setQuyenEntity(role);
		TaiKhoanEntity accountE = taiKhoanReposity.save(account);
		entity.setTaiKhoanEntity(accountE);
		entity = nhanVienReposity.save(entity);
		return convert.toNhanVienDTO(entity);
	}
	@Override
	public String delete(Long id) {
		NhanVienEntity entity = nhanVienReposity.findById(id).get();
		nhanVienReposity.delete(entity);
		return "Ok";
	}
	@Override
	public List<NhanVienDTO> getAll() {
		List<NhanVienEntity> list = nhanVienReposity.findAll();
		List<NhanVienDTO> list2 = new ArrayList<>();
		for (NhanVienEntity entity : list) {
			NhanVienDTO dto = convert.toNhanVienDTO(entity);
			list2.add(dto);
		}
		return list2;
	}
	@Override
	public NhanVienDTO getOne(Long id) {
		NhanVienEntity entity = nhanVienReposity.findById(id).get();
		return convert.toNhanVienDTO(entity);
	}
	
	@Override
	public NhanVienDTO getByIdAcc(Long idAcc) {
		NhanVienEntity entity = nhanVienReposity.findByIdAcc(idAcc);
		return convert.toNhanVienDTO(entity);
	}
	@Override
	public NhanVienDTO getByLogin(String username, String password) {
		NhanVienEntity entity = nhanVienReposity.findByLogin(username, password);
		return convert.toNhanVienDTO(entity);
	}
	@Override
	public List<StatisticDTO> statiticByYear(String start, String end) {
		List<Object[]> list =  nhanVienReposity.thongKeTheoNam(start,end);
		List<StatisticDTO> list2 = new ArrayList<>();
		for (Object[] object1 : list) {
			for (int i = 0; i<object1.length;i++) {
				StatisticDTO respon = new StatisticDTO();
				respon.setTime(object1[0]);
				respon.setMoney(object1[1]);
				
				int check=0;
				for (StatisticDTO sanPhamRespon : list2) {
					if(respon.getTime()==sanPhamRespon.getTime()) {
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
	public List<StatisticDTO> statiticByMonth(String start, String end) {
		List<Object[]> list =  nhanVienReposity.thongKeTheoThang(start,end);
		List<StatisticDTO> list2 = new ArrayList<>();
		for (Object[] object1 : list) {
			for (int i = 0; i<object1.length;i++) {
				StatisticDTO respon = new StatisticDTO();
				respon.setTime(object1[0]);
				respon.setMoney(object1[1]);
				
				int check=0;
				for (StatisticDTO sanPhamRespon : list2) {
					if(respon.getTime()==sanPhamRespon.getTime()) {
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
	public List<StatisticDTO> statiticByDay(String start, String end) {
		List<Object[]> list =  nhanVienReposity.thongKeTheoNgay(start,end);
		List<StatisticDTO> list2 = new ArrayList<>();
		for (Object[] object1 : list) {
			for (int i = 0; i<object1.length;i++) {
				StatisticDTO respon = new StatisticDTO();
				respon.setTime(object1[0]);
				respon.setMoney(object1[1]);
				
				int check=0;
				for (StatisticDTO sanPhamRespon : list2) {
					if(respon.getTime()==sanPhamRespon.getTime()) {
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
	public int statiticProduct() {
		int dem=0;
		List<Object[]> list =  nhanVienReposity.thongKeSanPham();
		List<StatisticDTO> list2 = new ArrayList<>();
		for (Object[] object1 : list) {
			for (int i = 0; i<object1.length;i++) {
				StatisticDTO respon = new StatisticDTO();
				respon.setTime(object1[0]);
				
				
				int check=0;
				for (StatisticDTO sanPhamRespon : list2) {
					if(respon.getTime()==sanPhamRespon.getTime()) {
						check=1;
					}
				}
				if(check !=1) {
					list2.add(respon);
					dem++;
				}
				
			}
		}
		return dem;
	}
	
	@Override
	public List<Object[]> statiticImcome() {
		
		List<Object[]> list =  nhanVienReposity.thongKeThuNhap();
		List<StatisticDTO> list2 = new ArrayList<>();
		for (Object[] object1 : list) {
			for (int i = 0; i<object1.length;i++) {
				StatisticDTO respon = new StatisticDTO();
				respon.setTime(object1[0]);
				
				
				int check=0;
				for (StatisticDTO sanPhamRespon : list2) {
					if(respon.getTime()==sanPhamRespon.getTime()) {
						check=1;
					}
				}
				if(check !=1) {
					list2.add(respon);
				}
				
			}
		}
		return list;
	}
	
	@Override
	public List<KhachHangResponse> statiticTopUser() {
		
		List<Object[]> list =  nhanVienReposity.thongKetopkhachhang();
		List<KhachHangResponse> list2 = new ArrayList<>();
		for (Object[] object1 : list) {
			for (int i = 0; i<object1.length;i++) {
				KhachHangResponse respon = new KhachHangResponse();
				respon.setHoTen(object1[0]);
				respon.setEmail(object1[2]);
				respon.setDiaChi(object1[1]);
				respon.setSoTien(object1[2]);
				
				
				int check=0;
				for (KhachHangResponse sanPhamRespon : list2) {
					if(respon.getEmail()==sanPhamRespon.getEmail()) {
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
	public List<KhachHangResponse> statiticTopOrder() {
		
		List<Object[]> list =  nhanVienReposity.thongKetopdonHang();
		List<KhachHangResponse> list2 = new ArrayList<>();
		for (Object[] object1 : list) {
			for (int i = 0; i<object1.length;i++) {
				KhachHangResponse respon = new KhachHangResponse();
				respon.setMaDonHang(object1[0]);
				respon.setHoTen(object1[1]);
				respon.setNgayLap(object1[2]);
				respon.setTrangThai(object1[3]);
				respon.setSoTien(object1[4]);
				
				
				int check=0;
				for (KhachHangResponse sanPhamRespon : list2) {
					if(respon.getMaDonHang()==sanPhamRespon.getMaDonHang()) {
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
