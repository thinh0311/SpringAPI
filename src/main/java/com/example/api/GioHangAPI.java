package com.example.api;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.example.dto.*;
import com.example.service.*;

@RestController
@RequestMapping("/api/GioHang")
public class GioHangAPI {
	
	@Autowired
	private IGioHangService service;
	
	@PostMapping("")
	public GioHangDTO add(@RequestBody GioHangDTO dto) {
		return service.save(dto);
	}
	
	@GetMapping("")
	public List<GioHangDTO> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/{maKH}")
	public List<GioHangDTO> getByIdKH(@PathVariable("maKH") Long id) {
		return service.getByIdKhachHang(id);
	}
	
	@GetMapping("/{maKH}/{maSP}")
	public GioHangDTO getByIdKHAndSP(@PathVariable("maKH") Long idKH,@PathVariable("maSP") Long idSP) {
		return service.getOne(idKH,idSP);
	}
	
	@PutMapping("/{idGH}")
	public GioHangDTO edit(@RequestBody GioHangDTO dto, @PathVariable("idGH") Long id) {
		dto.setId(id);
		return service.save(dto);
	}
	
	@DeleteMapping("/{maKH}")
	public String delete( @PathVariable("maKH") Long id) {
		String response = service.deleteByIdKhachHang(id);
		if (response=="Ok") {
			return "Ok";
		}
		return "Failure";
	}
	
	@DeleteMapping("/{maKH}/{maSP}")
	public String delete2( @PathVariable("maKH") Long idKH,@PathVariable("maSP") Long idSP) {
		String response = service.deleteSanPham(idKH, idSP);
		if (response=="Ok") {
			return "Ok";
		}
		return "Failure";
	}
}
