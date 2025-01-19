
package entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ChiTietHoaDon")
@NamedQueries({ @NamedQuery(name = "ChiTietHoaDon.docTuBang", query = "select cthd from ChiTietHoaDon cthd"),

		@NamedQuery(name = "ChiTietHoaDon.selectChung1", query = "SELECT NEW entity.ChiTietHoaDon("
				+ "NEW entity.HoaDon(hd.maHD, hd.ngayTao, NEW entity.KhachHang(kh.maKH, kh.tenKH), NEW entity.NhanVien(nv.maNhanVien, nv.tenNhanVien, nv.gioiTinh)) "
				+ ", CAST(COUNT(hd.maHD) AS INTEGER), SUM(cthd.soLuong * cthd.donGia)) " + "FROM HoaDon hd "
				+ "JOIN hd.maNV nv " + "JOIN hd.maKh kh " + "JOIN hd.setChiTietHoaDon cthd "
				+ "GROUP BY hd.maHD, hd.ngayTao, nv.maNhanVien, kh.maKH, nv.tenNhanVien, nv.gioiTinh, kh.tenKH"),

		@NamedQuery(name = "ChiTietHoaDon.selectChungLocDate", query = "SELECT NEW entity.ChiTietHoaDon("
				+ "NEW entity.HoaDon(hd.maHD, hd.ngayTao, NEW entity.KhachHang(kh.maKH, kh.tenKH, kh.gioiTinh), NEW entity.NhanVien(nv.maNhanVien, nv.tenNhanVien, nv.gioiTinh)) "
				+ ", CAST(COUNT(hd.maHD) AS INTEGER), SUM(cthd.soLuong * cthd.donGia)) " + "FROM HoaDon hd "
				+ "JOIN hd.maNV nv " + "JOIN hd.maKh kh " + "JOIN hd.setChiTietHoaDon cthd "
				+ "WHERE hd.ngayTao BETWEEN :fromDate AND :toDate "
				+ "GROUP BY hd.maHD, nv.maNhanVien, kh.maKH, hd.ngayTao, nv.tenNhanVien, kh.tenKH, kh.gioiTinh, nv.gioiTinh"),

		@NamedQuery(name = "ChiTietHoaDon.selectChung2", query = "SELECT NEW entity.ChiTietHoaDon("
				+ "NEW entity.HoaDon(hd.ngayTao , " + "NEW entity.KhachHang(kh.maKH, kh.tenKH, kh.gioiTinh), "
				+ "NEW entity.NhanVien(nv.maNhanVien, nv.tenNhanVien, nv.gioiTinh)), "
				+ "CAST(COUNT(DISTINCT hd.maHD) AS integer), SUM(cthd.soLuong * cthd.donGia)) " + "FROM HoaDon hd "
				+ "JOIN hd.maKh kh " + "JOIN hd.maNV nv " + "JOIN hd.setChiTietHoaDon cthd "
				+ "GROUP BY hd.ngayTao, kh.maKH, kh.tenKH, kh.gioiTinh, nv.maNhanVien, nv.tenNhanVien, nv.gioiTinh"),

		@NamedQuery(name = "ChiTietHoaDon.selectLocDate2", query = "SELECT NEW entity.ChiTietHoaDon("
				+ "NEW entity.HoaDon(hd.ngayTao , " + "NEW entity.KhachHang(kh.maKH, kh.tenKH, kh.gioiTinh), "
				+ "NEW entity.NhanVien(nv.maNhanVien, nv.tenNhanVien, nv.gioiTinh)), "
				+ "CAST(COUNT(DISTINCT hd.maHD) AS integer), SUM(cthd.soLuong * cthd.donGia)) " + "FROM HoaDon hd "
				+ "JOIN hd.maKh kh " + "JOIN hd.maNV nv " + "JOIN hd.setChiTietHoaDon cthd "
				+ "WHERE hd.ngayTao BETWEEN :fromDate AND :toDate "
				+ "GROUP BY hd.ngayTao, kh.maKH, kh.tenKH, kh.gioiTinh, nv.maNhanVien, nv.tenNhanVien, nv.gioiTinh"),

})
//
//@NamedQuery(name = "ChiTietHoaDon.selectChung", query = "SELECT cthd FROM ChiTietHoaDon cthd JOIN FETCH cthd.maHD hd JOIN FETCH hd.maNV nv JOIN FETCH hd.maKh kh"),
public class ChiTietHoaDon implements Serializable{

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maHoaDon")
	private HoaDon maHD;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maSP")
	private SanPham maSP;

	@Column(name = "soLuong", nullable = false)
	private int soLuong;

	@Column(name = "donGiaBan", nullable = false)
	private Double donGia;

	public ChiTietHoaDon(HoaDon maHD, SanPham maSP, int soLuong, Double donGia) {
		this.maHD = maHD;
		this.maSP = maSP;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}

	public ChiTietHoaDon(HoaDon maHD) {
		this.maHD = maHD;
	}

	public ChiTietHoaDon(HoaDon maHD, int soLuong, Double donGia) {
		this.maHD = maHD;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}


	@Override
	public String toString() {
		return "ChiTietHoaDon{" + "maHD=" + maHD + ", maSP=" + maSP + ", soLuong=" + soLuong + ", donGia=" + donGia
				+ '}';
	}
}
