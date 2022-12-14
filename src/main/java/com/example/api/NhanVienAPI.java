package com.example.api;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.example.dto.*;
import com.example.reposity.NhanVienReposity;
import com.example.service.*;

@RestController
@RequestMapping("/api/NhanVien")
public class NhanVienAPI {
	
	@Autowired
	private INhanVienService service;
	@Autowired
	private IKhachHangService khService;
	
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
	
	@GetMapping("/ThongKeTheoNam/{start}/{end}")
	public List<StatisticDTO> getOne1(@PathVariable("start") String start,@PathVariable("end") String end) {
		return service.statiticByYear(start,end);
	}
	
	@GetMapping("/ThongKeTheoThang/{start}/{end}")
	public List<StatisticDTO> getOne12(@PathVariable("start") String start,@PathVariable("end") String end) {
		return service.statiticByMonth(start,end);
	}
	
	@GetMapping("/ThongKeTheoNgay/{start}/{end}")
	public List<StatisticDTO> getOne11(@PathVariable("start") String start,@PathVariable("end") String end) {
		return service.statiticByDay(start,end);
	}
	
	@GetMapping("/ThongKeKhachhang")
	public int statistic1() {
		List<KhachHangDTO> list = khService.getAll();
		int dem = 0;
		for (KhachHangDTO khachHangDTO : list) {
			dem++;
		}
		return dem;
	}
}
