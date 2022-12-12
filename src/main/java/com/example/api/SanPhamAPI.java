package com.example.api;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.example.dto.*;
import com.example.entity.SanPhamEntity;
import com.example.exception.SanPhamRespon;
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
	public List<SanPhamRespon> getByIdCategory(@PathVariable("maLoaiNuoc") Long id) {
		return service.getByIdLoaiNuoc(id);
	}
	
	@GetMapping("/GetSanPhamTrongGioHang/{maKH}")
	public List<SanPhamRespon> getByIdCategory1(@PathVariable("maKH") Long id) {
		List<SanPhamRespon> list = service.getSanPhamTrongGioHang(id);
		return list;
	}
	
	@GetMapping("/GetSanPhamSaleKhung")
	public List<SanPhamRespon> getByIdCategory2() {
		List<SanPhamRespon> list = service.getSanPhamKhuyenMai();
		return list;
	}
	
	@GetMapping("/GetSanPhamBanChay")
	public List<SanPhamRespon> getByIdCategory23() {
		List<SanPhamRespon> list = service.getSanPhamBanChay();
		return list;
	}
	
	@GetMapping("/GetByNameOrDescribe/{text}")
	public List<SanPhamRespon> getByNameOrDescribe(@PathVariable("text") String text) {
		return service.searchByNameOrDescribe(text);
	}
	
	@GetMapping("/{maSanPham}")
	public List<SanPhamRespon> getOne(@PathVariable("maSanPham") Long id) {
		return service.getByIdProduct(id);
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
