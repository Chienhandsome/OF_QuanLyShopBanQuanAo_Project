package entity;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "SanPham")
@NamedQueries({
	@NamedQuery(name = "SanPham.docTuBang", query = "select sp from SanPham sp"),
})

public class SanPham implements Serializable{
	@Id
	private String maSP;
	@Column(name = "tenSP", nullable = false, columnDefinition = "nvarchar(45)")
	private String tenSP;
	private String hinhAnh;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "maloaiSP")
	private LoaiSanPham loaiSP;

	@Column(nullable = false)
	private double giaNhap;
	@Column(nullable = false)
	private double giaBan;

	@Column(name = "soLuong", nullable = false)
	private int soLuong;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maNhaCungCap")
	private NhaCungCap nhaCungCap;

	@OneToMany(mappedBy = "maSP", cascade = CascadeType.REMOVE)
	private Set<ChiTietHoaDon> setChiTietHoaDon;

	@OneToMany(mappedBy = "maSP", cascade = CascadeType.REMOVE)
	private Set<ChiTietDonDatHang> setChiTietDonDatHang;

	@OneToMany(mappedBy = "sanPham", cascade = CascadeType.REMOVE)
	private Set<ChiTietKhuyenMai> setChiTietKhuyenMai;

	public SanPham(String maSP, String hinhAnh) {
		this.maSP = maSP;
		this.hinhAnh = hinhAnh;
	}

	public SanPham(LoaiSanPham loaiSP) {
		this.loaiSP = loaiSP;
	}

	public SanPham(String maSP, String tenSP, LoaiSanPham loaiSP, double giaNhap, double giaBan, int soLuong,
			NhaCungCap nhaCungCap, String hinhAnh) {
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.loaiSP = loaiSP;
		this.giaNhap = giaNhap;
		this.giaBan = giaBan;
		this.soLuong = soLuong;
		this.nhaCungCap = nhaCungCap;
		this.hinhAnh = hinhAnh;
	}

	public SanPham(String maSP, String tenSP, LoaiSanPham loaiSP, double giaBan, int soLuong) {
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.loaiSP = loaiSP;
		this.giaBan = giaBan;
		this.soLuong = soLuong;

	}

	public SanPham(String maSP, String tenSP, LoaiSanPham loaiSP) {
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.loaiSP = loaiSP;
	}

	public SanPham(String maSP) {
		this.maSP = maSP;
	}

	public SanPham(String maSP, String tenSP, double giaBan) {
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.giaBan = giaBan;
	}

	public SanPham(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 53 * hash + Objects.hashCode(this.maSP);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final SanPham other = (SanPham) obj;
		return Objects.equals(this.maSP, other.maSP);
	}

	@Override
	public String toString() {
		return "SanPham{" + "maSP=" + maSP + ", tenSP=" + tenSP + ", hinhAnh=" + hinhAnh + ", loaiSP=" + loaiSP
				+ ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + ", soLuong=" + soLuong + ", nhaCungCap=" + nhaCungCap
				+ '}';
	}

}
