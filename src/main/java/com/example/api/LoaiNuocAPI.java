package com.example.api;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.LoaiNuocEntity;
import com.example.reposity.LoaiNuocReposity;

@RestController
@RequestMapping("/api/LoaiNuoc")
public class LoaiNuocAPI {
	
	@Autowired
	private LoaiNuocReposity reposity;
	
	@GetMapping("")
	public List<LoaiNuocEntity> getAll(){
		return reposity.findAll();
	}
	
	@GetMapping("/{maLoaiNuoc}")
	  public LoaiNuocEntity getOne(@PathVariable(value = "maLoaiNuoc") Long maLoaiNuoc)
	       {
	  LoaiNuocEntity entity = reposity.findById(maLoaiNuoc).get();
	    return entity;
	  }
	
	@PostMapping("")
	  public LoaiNuocEntity createQ(@RequestBody LoaiNuocEntity entity) {
	    return reposity.save(entity);
	  }
	
	@PutMapping("/{maLoaiNuoc}")
	public String edit(@PathVariable(value = "maLoaiNuoc") Long maLoaiNuoc,@RequestBody LoaiNuocEntity newEntity) {
		LoaiNuocEntity entity = reposity.findById(maLoaiNuoc).get();
		if(!Objects.isNull(entity.getMaLoaiNuoc())) {
			entity.setTenLoaiNuoc(newEntity.getTenLoaiNuoc());
			entity.setMoTa(newEntity.getMoTa());
			entity.setHinhAnh(newEntity.getHinhAnh());
			reposity.save(entity);
			return "Ok";
		}
		return "Not found";
	}
	
	@DeleteMapping("/{maLoaiNuoc}")
	public String delete(@PathVariable(value = "maLoaiNuoc") Long maLoaiNuoc) {
		LoaiNuocEntity entity = reposity.findById(maLoaiNuoc).get();
		if(!Objects.isNull(entity.getMaLoaiNuoc())) {
			reposity.delete(entity);
			return "Ok";
		}
		return "Not found";
	}
}
