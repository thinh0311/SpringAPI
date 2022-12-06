package com.example.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.convert.Convert;
import com.example.dto.*;
import com.example.entity.*;
import com.example.reposity.*;

@Service
public class KhachHangService implements IKhachHangService {
	
	@Autowired
	private QuyenReposity quyenReposity;
	@Autowired
	private KhachHangReposity khachHangReposity;
	@Autowired
	private TaiKhoanReposity taiKhoanReposity;
	@Autowired
	private Convert convert;
	@Override
	public KhachHangDTO save(KhachHangDTO dto) {
		KhachHangEntity entity = new KhachHangEntity();
		if(dto.getMaKH() != 0L) {
			KhachHangEntity oldEntity = khachHangReposity.findById(dto.getMaKH()).get();
			entity = khachHangReposity.save(convert.toKhachHangEntity(dto, oldEntity));
			return convert.toKhachHangDTO(entity);
			
		}
		else {
			entity = convert.toEntityKhachHang(dto);
		}
		QuyenEntity role = quyenReposity.findById((long) 1).get();//Ma quyen 1 la Khach hang
		TaiKhoanEntity account = new TaiKhoanEntity();
		account.setUsername(dto.getUsername());
		account.setPassword(dto.getPassword());
		account.setQuyenEntity(role);
		TaiKhoanEntity accountE = taiKhoanReposity.save(account);
		entity.setTaiKhoanEntity(accountE);
		entity = khachHangReposity.save(entity);
		return convert.toKhachHangDTO(entity);
	}
	@Override
	public String delete(Long id) {
		KhachHangEntity entity = khachHangReposity.findById(id).get();
		khachHangReposity.delete(entity);
		return "Ok";
	}
	@Override
	public List<KhachHangDTO> getAll() {
		List<KhachHangEntity> list = khachHangReposity.findAll();
		List<KhachHangDTO> list2 = new ArrayList<>();
		for (KhachHangEntity entity : list) {
			KhachHangDTO dto = convert.toKhachHangDTO(entity);
			list2.add(dto);
		}
		return list2;
	}
	@Override
	public KhachHangDTO getOne(Long id) {
		KhachHangEntity entity = khachHangReposity.findById(id).get();
		return convert.toKhachHangDTO(entity);
	}
	
	@Override
	public KhachHangDTO getByIdAcc(Long idAcc) {
		KhachHangEntity entity = khachHangReposity.findByIdAcc(idAcc);
		return convert.toKhachHangDTO(entity);
	}
	@Override
	public KhachHangDTO getByLogin(String username, String password) {
		KhachHangEntity entity = khachHangReposity.findByLogin(username, password);
		return convert.toKhachHangDTO(entity);
	}
	@Override
	public Long getByEmail(String email) {
		KhachHangEntity entity = khachHangReposity.findByEmail(email);
		return convert.toKhachHangDTO(entity).getMaKH();
	}
	
}
