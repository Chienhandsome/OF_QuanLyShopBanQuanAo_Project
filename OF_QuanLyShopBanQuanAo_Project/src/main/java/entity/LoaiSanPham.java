package entity;

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
@Table(name = "LoaiSanPham")
public class LoaiSanPham implements Serializable{
	@Id
	private String maLoai;
	@Column(columnDefinition = "nvarchar(45)", nullable = false)
	private String tenLoai;

	@OneToMany(mappedBy = "loaiSP", cascade = CascadeType.REMOVE)
	private Set<SanPham> setSanPham;

	public LoaiSanPham(String maLoai, String tenLoai) {
		this.maLoai = maLoai;
		this.tenLoai = tenLoai;
	}


	public LoaiSanPham(String maLoai) {
		this.maLoai = maLoai;
	}

	@Override
	public String toString() {
		return "LoaiSanPham{" + "maLoai=" + maLoai + ", tenLoai=" + tenLoai + '}';
	}

}
