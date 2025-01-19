
package entity;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/*
@author: Lê Huy Hùng
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "HoaDon")
public class HoaDon implements Serializable{

	@Id
	@Column(name = "maHoaDon")
	private String maHD;

	@Column(name = "ngayTao")
	private LocalDate ngayTao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maKH")
	private KhachHang maKh;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maNhanVien")
	private NhanVien maNV;

//    @OneToMany(mappedBy = "maHD", cascade = CascadeType.REMOVE)
	@OneToMany(mappedBy = "maHD", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ChiTietHoaDon> setChiTietHoaDon;

	public HoaDon(String maHD, LocalDate ngayTao, KhachHang maKh, NhanVien maNV) {
		this.maHD = maHD;
		this.ngayTao = ngayTao;
		this.maKh = maKh;
		this.maNV = maNV;
	}

	public HoaDon(LocalDate ngayTao, KhachHang maKh, NhanVien maNV) {
		super();
		this.ngayTao = ngayTao;
		this.maKh = maKh;
		this.maNV = maNV;
	}

	public HoaDon(String maHD) {
		this.maHD = maHD;
	}

	public HoaDon(String maHD, LocalDate ngayTao) {
		this.maHD = maHD;
		this.ngayTao = ngayTao;
	}

	public HoaDon(LocalDate ngayTao, KhachHang maKh) {
		this.maKh = maKh;
		this.ngayTao = ngayTao;
	}

	public HoaDon(NhanVien maNV) {
		this.maNV = maNV;
	}

	public HoaDon(LocalDate ngayTao, NhanVien maNV) {
		this.ngayTao = ngayTao;
		this.maNV = maNV;
	}

	public HoaDon(LocalDate ngayTao) {

		this.ngayTao = ngayTao;
	}

	@Override
	public String toString() {
		return "HoaDon{" + "maHD=" + maHD + ", ngayTao=" + ngayTao + ", maKh=" + maKh + ", maNV=" + maNV + '}';
	}

}
