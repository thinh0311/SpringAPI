package com.example.reposity;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.example.entity.*;

@Repository
public interface NhanVienReposity extends JpaRepository<NhanVienEntity, Long> {
	@Query(value = "SELECT * FROM dbo.NhanVien WHERE MaTaiKhoan=?",
			nativeQuery = true)
	NhanVienEntity findByIdAcc(Long idAcc);
	
	@Query(value = "SELECT * FROM dbo.NhanVien as NV, dbo.TaiKhoan as TK "
						  + "WHERE NV.MaTaiKhoan=TK.MaTaiKhoan "
						  + "AND TK.Username=? and TK.Password=?",
			nativeQuery = true)
	NhanVienEntity findByLogin(String username, String password);
}