package com.example.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.convert.Convert;
import com.example.dto.*;
import com.example.entity.*;
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
}
