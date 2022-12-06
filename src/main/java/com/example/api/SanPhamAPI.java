package com.example.api;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.example.dto.*;
import com.example.service.ISanPhamService;

@RestController
@RequestMapping("/api/SanPham")
public class SanPhamAPI {
	
	@Autowired
	private ISanPhamService service;
	
	@PostMapping("")
	public SanPhamDTO addUser(@RequestBody SanPhamDTO dto) {
		return service.save(dto);
	}
	
	@GetMapping("")
	public List<SanPhamDTO> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/GetByMaLoaiNuoc/{maLoaiNuoc}")
	public List<SanPhamDTO> getByIdCategory(@PathVariable("maLoaiNuoc") Long id) {
		return service.getByIdLoaiNuoc(id);
	}
	
	@GetMapping("/GetByNameOrDescribe/{text}")
	public List<SanPhamDTO> getByNameOrDescribe(@PathVariable("text") String text) {
		return service.searchByNameOrDescribe(text);
	}
	
	@GetMapping("/{maSanPham}")
	public SanPhamDTO getOne(@PathVariable("maSanPham") Long id) {
		return service.getOne(id);
	}
	
	@PutMapping("/{maSanPham}")
	public SanPhamDTO edit(@RequestBody SanPhamDTO dto, @PathVariable("maSanPham") Long id) {
		dto.setMaSanPham(id);
		return service.save(dto);
	}
	
	@DeleteMapping("/{maSanPham}")
	public String delete( @PathVariable("maSanPham") Long id) {
		service.delete(id);
		return "Ok";
	}
}
