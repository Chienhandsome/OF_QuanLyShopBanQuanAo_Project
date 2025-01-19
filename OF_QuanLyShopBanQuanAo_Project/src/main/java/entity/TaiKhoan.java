package entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TaiKhoan")
@NamedNativeQueries({
    @NamedNativeQuery(
            name = "TaiKhoan.docTuBang",
            query = "SELECT * FROM [dbo].[TaiKhoan]",
            resultClass = TaiKhoan.class
    ),
    @NamedNativeQuery(name = "TaiKhoan.getTaiKhoanTheoTK",
            query = "SELECT * FROM [dbo].[TaiKhoan] WHERE tenTaiKhoan = ?",
            resultClass = TaiKhoan.class)
})
public class TaiKhoan implements Serializable {

    @Id
    private String tenTaiKhoan;
    private String matKhau;
    @Column(columnDefinition = "nvarchar(255)", nullable = false)
    private String quyenTruyCap;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "maNhanVien")
    private NhanVien maNhanVien;
//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "maNhanVien")
//    private NhanVien maNhanVien;

//  public TaiKhoan(String maNhanVien){
//       this.maNhanVien=maNhanVien;
//  }
    public TaiKhoan(NhanVien maNhanVien, String tenTaiKhoan, String matKhau, String quyenTruyCap) {
        super();
        this.maNhanVien = maNhanVien;
        this.tenTaiKhoan = tenTaiKhoan;
        this.matKhau = matKhau;
        this.quyenTruyCap = quyenTruyCap;

    }

    @Override
    public String toString() {
        return "TaiKhoan [tenTaiKhoan=" + tenTaiKhoan + ", matKhau=" + matKhau + ", quyenTruyCap=" + quyenTruyCap
                + ", maNhanVien=" + maNhanVien + "]";
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final TaiKhoan other = (TaiKhoan) obj;
        if (!Objects.equals(this.tenTaiKhoan, other.tenTaiKhoan)) {
            return false;
        }
        if (!Objects.equals(this.matKhau, other.matKhau)) {
            return false;
        }
        if (!Objects.equals(this.quyenTruyCap, other.quyenTruyCap)) {
            return false;
        }
        return Objects.equals(this.maNhanVien, other.maNhanVien);
    }
}
