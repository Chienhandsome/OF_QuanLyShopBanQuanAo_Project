package entity;

import java.util.Date;
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
@Table(name = "KhuyenMai")
@NamedQueries({
	@NamedQuery(name = "KhuyenMai.docTuBang", query = "SELECT km FROM KhuyenMai km"),
})
public class KhuyenMai implements Serializable{
	@Id
	private String maKhuyenMai;
	@Column(columnDefinition = "nvarchar(45)")
	private String tenKhuyenMai;
	@Column(columnDefinition = "nvarchar(45)")
	private String moTa;
	@Temporal(TemporalType.DATE)
	private Date ngayBatDau;
	@Temporal(TemporalType.DATE)
	private Date ngayKetThuc;
	@Column(columnDefinition = "nvarchar(45)")
	private String trangThai;

	@OneToMany(mappedBy = "khuyenMai", cascade = CascadeType.REMOVE)
	private Set<ChiTietKhuyenMai> setChiTietKhuyenMai;

	public KhuyenMai(String maKhuyenMai, String tenKhuyenMai, String moTa, Date ngayBatDau, Date ngayKetThuc,
			String trangThai) {
		this.maKhuyenMai = maKhuyenMai;
		this.tenKhuyenMai = tenKhuyenMai;
		this.moTa = moTa;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.trangThai = trangThai;
	}

	public KhuyenMai(String maKhuyenMai) {
		this.maKhuyenMai = maKhuyenMai;
	}

	@Override
	public String toString() {
		return "KhuyenMai{" + "maKhuyenMai=" + maKhuyenMai + ", tenKhuyenMai=" + tenKhuyenMai + ", moTa=" + moTa
				+ ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc=" + ngayKetThuc + ", trangThai=" + trangThai + '}';
	}

}
