package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.convert.Convert;
import com.example.dto.TaiKhoanDTO;
import com.example.entity.QuyenEntity;
import com.example.entity.TaiKhoanEntity;
import com.example.reposity.QuyenReposity;
import com.example.reposity.TaiKhoanReposity;

@Service
public class TaiKhoanService implements ITaiKhoanService {
	
	@Autowired
	private TaiKhoanReposity taiKhoanReposity;
	@Autowired
	private QuyenReposity quyenReposity;
	@Autowired
	private Convert convert;

	@Override
	public TaiKhoanDTO save(TaiKhoanDTO dto) {
		TaiKhoanEntity account = new TaiKhoanEntity();
		if(dto.getMaTaiKhoan() != null) {
			TaiKhoanEntity oldEntity = taiKhoanReposity.findById(dto.getMaTaiKhoan()).get();
			account = convert.toEntityTaiKhoan(dto,oldEntity);
		}
		else account=convert.toEntityTaiKhoan(dto);
		QuyenEntity quyenEntity = quyenReposity.findById(dto.getMaQuyen()).get();
		account.setQuyenEntity(quyenEntity);
		taiKhoanReposity.save(account);
		return convert.toDTOTaiKhoan(account);
	}

	@Override
	public void delete(Long maTaiKhoan) {
		TaiKhoanEntity entity = taiKhoanReposity.findById(maTaiKhoan).get();
		taiKhoanReposity.delete(entity);
	}

	@Override
	public List<TaiKhoanDTO> getAll() {
		List<TaiKhoanEntity> list = taiKhoanReposity.findAll();
		List<TaiKhoanDTO> listUser = new ArrayList<>();
		for (TaiKhoanEntity entity : list) {
			TaiKhoanDTO dto = convert.toDTOTaiKhoan(entity);
			listUser.add(dto);
		}
		return listUser;
	}

	@Override
	public TaiKhoanDTO getOne(Long maTaiKhoan) {
		TaiKhoanEntity entity = taiKhoanReposity.findById(maTaiKhoan).get();
		return convert.toDTOTaiKhoan(entity);
	}
}
