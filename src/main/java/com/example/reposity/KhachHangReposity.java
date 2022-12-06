package com.example.reposity;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.example.entity.*;

@Repository
public interface KhachHangReposity extends JpaRepository<KhachHangEntity, Long> {
	@Query(value = "SELECT * FROM dbo.KhachHang WHERE MaTaiKhoan=?",
			nativeQuery = true)
	KhachHangEntity findByIdAcc(Long idAcc);
	
	@Query(value = "SELECT * FROM dbo.KhachHang as KH, dbo.TaiKhoan as TK "
						  + "WHERE KH.MaTaiKhoan=TK.MaTaiKhoan "
						  + "AND TK.Username=? and Password=?",
			nativeQuery = true)
	KhachHangEntity findByLogin(String username, String password);
	
	@Query(value = "SELECT * FROM dbo.KhachHang WHERE Email=?",
			nativeQuery = true)
	KhachHangEntity findByEmail(String email);
}