package com.example.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.dto.TaiKhoanDTO;
import com.example.entity.QuyenEntity;
import com.example.entity.TaiKhoanEntity;
import com.example.exception.NotFound;
import com.example.reposity.QuyenReposity;
import com.example.reposity.TaiKhoanReposity;
import com.example.service.ITaiKhoanService;

@RestController
@RequestMapping("/api/User")
public class TaiKhoanAPI {
		
		@Autowired
		private ITaiKhoanService service;
		
		@PostMapping("")
		public TaiKhoanDTO addUser(@RequestBody TaiKhoanDTO dto) {
			return service.save(dto);
		}
		
		@GetMapping("")
		public List<TaiKhoanDTO> getAll() {
			return service.getAll();
		}
		
		@GetMapping("/{maTaiKhoan}")
		public TaiKhoanDTO getOne(@PathVariable("maTaiKhoan") Long id) {
			return service.getOne(id);
		}
		
		@PutMapping("/{maTaiKhoan}")
		public TaiKhoanDTO edit(@RequestBody TaiKhoanDTO dto, @PathVariable("maTaiKhoan") Long id) {
			dto.setMaTaiKhoan(id);
			return service.save(dto);
		}
		
		@DeleteMapping("/{maTaiKhoan}")
		public void delete( @PathVariable("maTaiKhoan") Long id) {
			service.delete(id);
		}
}
