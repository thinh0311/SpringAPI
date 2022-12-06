package com.example.api;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.example.dto.*;
import com.example.service.*;

@RestController
@RequestMapping("/api/KhachHang")
public class KhachHangAPI {
	
	@Autowired
	private IKhachHangService service;
	
	@PostMapping("")
	public KhachHangDTO add(@RequestBody KhachHangDTO dto) {
		return service.save(dto);
	}
	
	@GetMapping("")
	public List<KhachHangDTO> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/GetByMaTaiKhoan/{maTaiKhoan}")
	public KhachHangDTO getByIdCategory(@PathVariable("maTaiKhoan") Long id) {
		return service.getByIdAcc(id);
	}
	
	@GetMapping("/GetByLogin/{username}/{password}")
	public KhachHangDTO getByLogin(@PathVariable("username") String username, 
								   @PathVariable("password") String password) {
		return service.getByLogin(username, password);
	}
	
	@GetMapping("/GetIdByEmail/{email}")
	public Long getByEmaiDtol(@PathVariable("email") String email) {
		return service.getByEmail(email);
	}
	
	@GetMapping("/{maKH}")
	public KhachHangDTO getOne(@PathVariable("maKH") Long id) {
		return service.getOne(id);
	}
	
	@PutMapping("/{maKH}")
	public KhachHangDTO edit(@RequestBody KhachHangDTO dto, @PathVariable("maKH") Long id) {
		dto.setMaKH(id);
		return service.save(dto);
	}
	
	@DeleteMapping("/{maKH}")
	public String delete( @PathVariable("maKH") Long id) {
		service.delete(id);
		return "Ok";
	}
}
