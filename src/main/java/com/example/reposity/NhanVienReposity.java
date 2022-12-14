package com.example.reposity;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.example.entity.*;

@Repository
public interface NhanVienReposity extends JpaRepository<NhanVienEntity, Long> {
	@Query(value = "SELECT * FROM dbo.NhanVien WHERE MaTaiKhoan=?", nativeQuery = true)
	NhanVienEntity findByIdAcc(Long idAcc);

	@Query(value = "SELECT * FROM dbo.NhanVien as NV, dbo.TaiKhoan as TK " + "WHERE NV.MaTaiKhoan=TK.MaTaiKhoan "
			+ "AND TK.Username=? and TK.Password=?", nativeQuery = true)
	NhanVienEntity findByLogin(String username, String password);

	@Query(value = "select FORMAT(D.NgayLap,'yyyy') as NAM, SUM(C.DonGia*C.SoLuong) as TONGTIEN\r\n"
			+ "from DonDatHang as D, CTDDH as C\r\n"
			+ "where D.MaDonHang=C.MaDonHang and D.NgayLap between ? and ?\r\n"
			+ "group by FORMAT(D.NgayLap,'yyyy')", nativeQuery = true)
	List<Object[]> thongKeTheoNam(String start, String end);
	
	@Query(value = "select FORMAT(D.NgayLap,'MM/yyyy') as NAM, SUM(C.DonGia*C.SoLuong) as TONGTIEN\r\n"
			+ "from DonDatHang as D, CTDDH as C\r\n"
			+ "where D.MaDonHang=C.MaDonHang and D.NgayLap between ? and ?\r\n"
			+ "group by FORMAT(D.NgayLap,'MM/yyyy')", nativeQuery = true)
	List<Object[]> thongKeTheoThang(String start, String end);
	
	@Query(value = "select FORMAT(D.NgayLap,'dd/MM/yyyy') as NAM, SUM(C.DonGia*C.SoLuong) as TONGTIEN\r\n"
			+ "from DonDatHang as D, CTDDH as C\r\n"
			+ "where D.MaDonHang=C.MaDonHang and D.NgayLap between ? and ?\r\n"
			+ "group by FORMAT(D.NgayLap,'dd/MM/yyyy')", nativeQuery = true)
	List<Object[]> thongKeTheoNgay(String start, String end);
}