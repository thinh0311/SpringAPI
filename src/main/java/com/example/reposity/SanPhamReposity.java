package com.example.reposity;

import java.util.*;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.example.entity.*;
import com.example.exception.SanPhamRespon;

@Repository
public interface SanPhamReposity extends JpaRepository<SanPhamEntity, Long> {
	@Query(value = "select SanPham.MaSanPham, SanPham.DonGia, SanPham.HinhAnh, SanPham.MoTa, SanPham.TenSanPham , ISNULL(CTKM.PhanTramGiam,0) as GiamGia, SanPham.MaLoaiNuoc\r\n"
			+ "from SanPham\r\n"
			+ "LEFT JOIN CTKM ON CTKM.MaSanPham = SanPham.MaSanPham\r\n"
			+ "LEFT JOIN KhuyenMai ON KhuyenMai.MaKM=CTKM.MaKM and KhuyenMai.NgayBatDau <= GETDATE() and KhuyenMai.NgayKetThuc >= GETDATE() \r\n"
			+ "WHERE SanPham.MaSanPham=?",
			nativeQuery = true)
	List<Object[]> findByIdProduct(Long id);
	
	@Query(value = "select SanPham.MaSanPham, SanPham.DonGia, SanPham.HinhAnh, SanPham.MoTa, SanPham.TenSanPham , ISNULL(CTKM.PhanTramGiam,0) as GiamGia\r\n"
			+ "from SanPham\r\n"
			+ "JOIN LoaiNuoc on LoaiNuoc.MaLoaiNuoc=SanPham.MaLoaiNuoc\r\n"
			+ "LEFT JOIN CTKM ON CTKM.MaSanPham = SanPham.MaSanPham\r\n"
			+ "LEFT JOIN KhuyenMai ON KhuyenMai.MaKM=CTKM.MaKM and KhuyenMai.NgayBatDau <= GETDATE() and KhuyenMai.NgayKetThuc >= GETDATE() \r\n"
			+ "WHERE LoaiNuoc.MaLoaiNuoc=?",
			nativeQuery = true)
	List<Object[]> findByIdLoaiNuoc(Long idCategory);
	
	@Query(value = "select SanPham.MaSanPham, SanPham.DonGia, SanPham.HinhAnh, SanPham.MoTa, SanPham.TenSanPham , ISNULL(CTKM.PhanTramGiam,0) as GiamGia "
				+ "from SanPham "
				+ "LEFT JOIN CTKM ON CTKM.MaSanPham = SanPham.MaSanPham "
				+ "LEFT JOIN KhuyenMai ON KhuyenMai.MaKM=CTKM.MaKM and KhuyenMai.NgayBatDau <= GETDATE() and KhuyenMai.NgayKetThuc >= GETDATE() "
				+ "WHERE SanPham.TenSanPham like %?1% OR SanPham.MoTa like %?1%",
			nativeQuery = true)
	List<Object[]> search(String text);
	
	@Query(value = "select GioHang.SoLuong, GioHang.MaSanPham,SanPham.DonGia,SanPham.HinhAnh, SanPham.MoTa, SanPham.TenSanPham, ISNULL(CTKM.PhanTramGiam,0), GioHang.ID  \r\n"
			+ "from GioHang \r\n"
			+ "JOIN SanPham ON GioHang.MaSanPham = SanPham.MaSanPham\r\n"
			+ "LEFT JOIN CTKM ON CTKM.MaSanPham = GioHang.MaSanPham \r\n"
			+ "LEFT JOIN KhuyenMai ON KhuyenMai.MaKM=CTKM.MaKM and KhuyenMai.NgayBatDau <= GETDATE() and KhuyenMai.NgayKetThuc >= GETDATE()\r\n"
			+ "WHERE GioHang.MaKH=?", nativeQuery = true)
    List<Object[]> getSanPhamTrongGioHang(Long idKH);
    
    @Query(value = "select TOP(6) SanPham.MaSanPham, SanPham.DonGia, SanPham.HinhAnh, SanPham.MoTa, SanPham.TenSanPham , CTKM.PhanTramGiam\r\n"
    		+ "from SanPham\r\n"
    		+ "JOIN CTKM ON CTKM.MaSanPham = SanPham.MaSanPham and CTKM.PhanTramGiam >=30\r\n"
    		+ "JOIN KhuyenMai ON KhuyenMai.MaKM=CTKM.MaKM and KhuyenMai.NgayBatDau <= GETDATE() and KhuyenMai.NgayKetThuc >= GETDATE()"
    		+ "order by ctkm.PhanTramGiam DESC", nativeQuery = true)
    List<Object[]> getSanPhamKhuyenMai();
    
    
    @Query(value = "select TOP(6) SanPham.MaSanPham, SanPham.DonGia, SanPham.HinhAnh, SanPham.MoTa, SanPham.TenSanPham , ISNULL(CTKM.PhanTramGiam,0),SUM(Ctddh.SoLuong) as TongSoLuong\r\n"
    		+ "from SanPham\r\n"
    		+ "JOIN ctddh on SanPham.MaSanPham=Ctddh.MaSanPham\r\n"
    		+ "LEFT JOIN CTKM ON CTKM.MaSanPham = SanPham.MaSanPham\r\n"
    		+ "LEFT JOIN KhuyenMai ON KhuyenMai.MaKM=CTKM.MaKM and KhuyenMai.NgayBatDau <= GETDATE() and KhuyenMai.NgayKetThuc >= GETDATE() \r\n"
    		+ "group by ctddh.soLuong,SanPham.MaSanPham, SanPham.DonGia, SanPham.HinhAnh, SanPham.MoTa, SanPham.TenSanPham , CTKM.PhanTramGiam\r\n"
    		+ "order by SUM(ctddh.SoLuong) DESC ", nativeQuery = true)
    List<Object[]> getSanPhamBanChay();
    
//    @Query(value = "DELCLARE @tempdate DATE"
//    			 + "DECLARE @start = ? DATE"
//    			 + "DECLARE @end = ? DATE "
//    			 + "SET @tempdate = DATEADD(month,-1,@start) "
//    			 + "CREATE TABLE #TEMP ( ThangNam DATE) "
//    			 + "WHILE @tempdate <= @end "
//    			 + "BEGIN "
//    			 	+ "INSERT #TEMP(ThangNam) VALUES(DATEADD(month,1,@tempdate)) "
//    			 	+ "SET @tempdate = DATEADD(month,1,@tempdate) "
//    			 	+ "IF(MONTH(@tempdate) = MONTH(@end)) " 
//    			 		+"BEGIN "
//    			 			+"SET @tempdate = DATEADD(month,1,@tempdate) "
//    			 		+ "END "
//    			 + "END "
//    			 + "SELECT CONCAT(M.THANG,'-',M.NAM) as THANGNAM, ISNULL(DH.DonGia*DH.SoLuong, 0) as TONGTIEN "
//    			 + "FROM (SELECT FORMAT(THANGNAM,'yyyy') as NAM, FORMAT(THANGNAM, 'MM') as THANG from #TEMP) as M "
//    			 	+ "LEFT JOIN "
//    			 	+ "(SELECT FORMAT(DDH.NgayLap,'yyyy') as NAM, FORMAT(DDH.NgayLap,'MM) as THANG, CTDDH.SoLuong as SoLuong, CTDDH.DonGia as Don Gia "
//    			 	+ "FROM (SELECT MaDonHang, NgayLap FROM DonDatHang as DDH WHERE NgayLap BETWEEN @start and AND @end) DDH, CTDDH "
//    			 	+ "WHERE DDH.MaDonHang = CTDDH.MaDonHang) DH"
//    			 	+ "ON M.THANG =  DH.THANG and M.NAM=DH.NAM"
//    			 	+ "GROUP BY M.THANG, M.NAM"
//    			 	+ "ORDER BY M.NAM ASC, M.THANG ASC", nativeQuery = true)
//    List<Object[]> thongKeTheoThang();
    
    
    
    
}