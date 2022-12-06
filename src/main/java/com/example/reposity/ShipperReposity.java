package com.example.reposity;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.example.entity.*;

@Repository
public interface ShipperReposity extends JpaRepository<ShipperEntity, Long> {
	@Query(value = "SELECT MaShipper, DiaChi, Email, HoTen, SDT, MaCongTy, MaTaiKhoan"
				 + " FROM dbo.Shipper",
			nativeQuery = true)
	List<ShipperEntity> findAllShipper();
}