package com.example.reposity;

import java.util.*;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.example.entity.*;
import com.example.exception.SanPhamRespon;

@Repository
public interface SanPhamReposity extends JpaRepository<SanPhamEntity, Long> {
	@Query(value = "select SanPham.MaSanPham, SanPham.DonGia, SanPham.HinhAnh, SanPham.MoTa, SanPham.TenSanPham , ISNULL(CTKM.PhanTramGiam,0) as GiamGia\r\n"
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
	
	@Query(value = "SELECT * FROM dbo.SanPham WHERE TenSanPham like %?1% OR MoTa like %?1%",
			nativeQuery = true)
	List<SanPhamEntity> search(String text);
	
	@Query(value = "select GioHang.SoLuong, GioHang.MaSanPham,SanPham.DonGia,SanPham.HinhAnh, SanPham.MoTa, SanPham.TenSanPham, ISNULL(CTKM.PhanTramGiam,0)  \r\n"
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
    
    
}