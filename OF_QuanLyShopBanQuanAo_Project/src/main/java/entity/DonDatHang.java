
package entity;

import java.time.LocalDate;
import java.util.Objects;
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
@Table(name = "DonDatHang")
public class DonDatHang implements Serializable{
	@Id
	@Column(name = "maDonDatHang")
	private String maDDH;
	
	private LocalDate ngayTao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maKH")
	private KhachHang maKh;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maNhanVien")
	private NhanVien maNV;
	@Column(name = "tinhTrang", columnDefinition = "nvarchar(255)", nullable = false)
	private String tinhTrang;

	@OneToMany(mappedBy = "maDDH", cascade = CascadeType.REMOVE)
	private Set<ChiTietDonDatHang> dsChiTietDonDatHang;
	public DonDatHang(String maDDH, LocalDate ngayTao, KhachHang maKh, NhanVien maNV, String tinhTrang) {
		this.maDDH = maDDH;
		this.ngayTao = ngayTao;
		this.maKh = maKh;
		this.maNV = maNV;
		this.tinhTrang = tinhTrang;
	}

	@Override
	public String toString() {
		return "DonDatHang{" + "maDDH=" + maDDH + ", ngayTao=" + ngayTao + ", maKh=" + maKh + ", maNV=" + maNV + '}';
	}

	@Override
	public int hashCode() {
		int hash = 7;
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
		final DonDatHang other = (DonDatHang) obj;
		if (!Objects.equals(this.maDDH, other.maDDH)) {
			return false;
		}
		if (!Objects.equals(this.maKh, other.maKh)) {
			return false;
		}
		return Objects.equals(this.maNV, other.maNV);
	}
}
