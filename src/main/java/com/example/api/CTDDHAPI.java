package com.example.api;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.example.dto.*;
import com.example.service.*;

@RestController
@RequestMapping("/api/CTDDH")
public class CTDDHAPI {
	
	@Autowired
	private ICTDDHService service;
	
	@PostMapping("")
	public CTDDHDTO add(@RequestBody CTDDHDTO dto) {
		return service.save(dto);
	}
	
	@GetMapping("/{maDonHang}")
	public List<CTDDHDTO> getByIdCategory(@PathVariable("maDonHang") Long id) {
		return service.getByMaDonHang(id);
	}
	
	@GetMapping("/{maDonHang}/{maSanPham}")
	public CTDDHDTO getByIdCategory2(@PathVariable("maDonHang") Long idDH,
										   @PathVariable("maSanPham") Long idSP) {
		return service.getByMaDonHangAndSanPham(idDH,idSP);
	}
}
