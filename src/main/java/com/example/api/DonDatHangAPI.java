package com.example.api;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.example.convert.Convert;
import com.example.dto.*;
import com.example.entity.DonDatHangEntity;
import com.example.exception.DonHangResponse;
import com.example.reposity.DonDatHangReposity;
import com.example.service.*;

@RestController
@RequestMapping("/api/DonDatHang")
public class DonDatHangAPI {
	
	@Autowired
	private IDonDatHangService service;
	@Autowired
	private DonDatHangReposity reposity;
	@Autowired
	private Convert convert;
	
	@PostMapping("")
	public DonDatHangDTO add(@RequestBody DonDatHangDTO dto) {
		return service.save(dto);
	}
	
	@GetMapping("")
	public List<DonDatHangEntity> getAll() {
		return reposity.findAll();
	}
	
	@GetMapping("/GetDonHangByKhachHang/{maKH}")
	public List<DonDatHangDTO> getByIdCategory(@PathVariable("maKH") Long id) {
		return service.getByMaKH(id);
	}
	
	@GetMapping("/GetDonHangByTrangThai/{status}")
	public List<DonHangResponse> getByLogin(@PathVariable("status") int status) {
		return service.getByStatus(status);
	}
	
	@GetMapping("/GetAllDonHang")
	public List<DonHangResponse> getByEmaiDtol() {
		return service.getAll();
	}
	
	@GetMapping("/{maDonHang}")
	public DonDatHangDTO getOne(@PathVariable("maDonHang") Long id) {
		return convert.toDonDatHangDTO(reposity.findById(id).get());
	}
	
	@PutMapping("/DuyetDonHang/{MaDonHang}/{MaNV}")
	public DonDatHangDTO edit( @PathVariable("MaDonHang") Long id, @PathVariable("MaNV") Long idNV) {
		return service.duyet(id, idNV);
	}
	
	@PutMapping("/PhanCong/{MaDonHang}/{MaShipper}")
	public DonDatHangDTO edit2( @PathVariable("MaDonHang") Long id, @PathVariable("MaShipper") Long idShipper) {
		return service.phancong(id, idShipper);
	}
	
	@PutMapping("/HoanThanh/{MaDonHang}")
	public DonDatHangDTO edit3( @PathVariable("MaDonHang") Long id) {
		return service.hoanthanh(id);
	}
}
