package com.example.reposity;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.example.entity.*;

@Repository
public interface DonDatHangReposity extends JpaRepository<DonDatHangEntity, Long> {
	@Query(value = "SELECT * FROM dbo.DonDatHang WHERE MaKH=?",
			nativeQuery = true)
	List<DonDatHangEntity> findByIdKhachHang(Long idKH);
	
	@Query(value = "SELECT * FROM dbo.DonDatHang WHERE TrangThai=?",
			nativeQuery = true)
	List<DonDatHangEntity> findByTrangThai(int status);
	
	@Query(value = "SELECT D.MaDonHang, D.DiaChi, D.MoTa, D.NguoiNhan, D.NgayLap, D.TrangThai, K.HoTen as KhachHang, N.HoTen as NhanVien S.HoTen as Shipper "
				 + "FROM dbo.DonDatHang as D, dbo.NhanVien as N, dbo.KhachHang as K, dbo.Shipper as S"
				 + "WHERE D.MaNV=N.MaNV AND D.MaKH=K.MaKH AND D.MaShipper=S.MaShipper",
			nativeQuery = true)
	List<DonDatHangEntity> getAllDonDatHang();
}