package com.example.reposity;

import java.util.*;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.example.entity.*;

@Repository
public interface SanPhamReposity extends JpaRepository<SanPhamEntity, Long> {
	@Query(value = "SELECT * FROM dbo.SanPham WHERE MaLoaiNuoc=?",
			nativeQuery = true)
	List<SanPhamEntity> findByIdLoaiNuoc(Long idCategory);
	
	@Query(value = "SELECT * FROM dbo.SanPham WHERE TenSanPham like %?1% OR MoTa like %?1%",
			nativeQuery = true)
	List<SanPhamEntity> search(String text);
}