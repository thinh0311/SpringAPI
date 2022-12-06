package com.example.api;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.example.dto.*;
import com.example.service.*;

@RestController
@RequestMapping("/api/NhanVien")
public class NhanVienAPI {
	
	@Autowired
	private INhanVienService service;
	
	@PostMapping("")
	public NhanVienDTO add(@RequestBody NhanVienDTO dto) {
		return service.save(dto);
	}
	
	@GetMapping("")
	public List<NhanVienDTO> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/GetByMaTaiKhoan/{maTaiKhoan}")
	public NhanVienDTO getByIdCategory(@PathVariable("maTaiKhoan") Long id) {
		return service.getByIdAcc(id);
	}
	
	@GetMapping("/GetByLogin/{username}/{password}")
	public NhanVienDTO getByLogin(@PathVariable("username") String username, 
								   @PathVariable("password") String password) {
		return service.getByLogin(username, password);
	}
	
	@GetMapping("/{maNV}")
	public NhanVienDTO getOne(@PathVariable("maNV") Long id) {
		return service.getOne(id);
	}
	
	@PutMapping("/{maNV}")
	public NhanVienDTO edit(@RequestBody NhanVienDTO dto, @PathVariable("maNV") Long id) {
		dto.setMaNV(id);
		return service.save(dto);
	}
	
	@DeleteMapping("/{maNV}")
	public String delete( @PathVariable("maNV") Long id) {
		service.delete(id);
		return "Ok";
	}
}
