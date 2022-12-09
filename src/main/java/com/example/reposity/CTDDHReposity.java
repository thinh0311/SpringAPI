package com.example.reposity;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.example.entity.*;

@Repository
public interface CTDDHReposity extends JpaRepository<CTDDHEntity, Long> {
	@Query(value = "SELECT * FROM dbo.CTDDH WHERE MaDonHang=?",
			nativeQuery = true)
	List<CTDDHEntity> findByIdDonDatHang(Long idDH);
	
	@Query(value = "SELECT * FROM dbo.CTDDH WHERE MaDonHang=? AND MaSanPham=?",
			nativeQuery = true)
	CTDDHEntity findByIdDonDatHangAndSanPham(Long idDH,Long idSP);
	
}