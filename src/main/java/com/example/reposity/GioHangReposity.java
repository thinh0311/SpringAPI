package com.example.reposity;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.example.entity.*;

@Repository
public interface GioHangReposity extends JpaRepository<GioHangEntity, Long> {
	@Query(value = "SELECT * FROM dbo.GioHang WHERE MaKH=?",
			nativeQuery = true)
	List<GioHangEntity> findByIdKhachHang(Long idKH);
	
	@Query(value = "SELECT * FROM dbo.GioHang WHERE MaKH=? AND MaSanPham=?",
			nativeQuery = true)
	GioHangEntity findByIdKhachHangAndSanPham(Long idKH,Long idSP);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM dbo.GioHang WHERE MaKH=?",
			nativeQuery = true)
	void deleteByIdKhachHang(Long idKH);
	
	@Modifying
	@Query(value = "UPDATE dbo.GioHang G SET G.SoLuong=? WHERE G.MaKH=? AND G.MaSanPham=?",
			nativeQuery = true)
	GioHangEntity updateQuantity(Long idKH, Long idSP, float quantity);
}