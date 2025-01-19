
package entity;

/*
@author: Lê Huy Hùng
 */
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
@Table(name = "ChiTietKhuyenMai")
@NamedQueries({
//    @NamedQuery(name = "KhuyenMai.docTuBang", query = "SELECT DISTINCT km FROM KhuyenMai km WHERE EXISTS (SELECT 1 FROM ChiTietKhuyenMai ctkm WHERE ctkm.khuyenMai = km)")
    @NamedQuery(name = "ChiTietKhuyenMai.docTuBang", query = "SELECT DISTINCT ctkm FROM ChiTietKhuyenMai ctkm JOIN ctkm.khuyenMai km JOIN ctkm.sanPham sp JOIN sp.loaiSP lsp")
})
public class ChiTietKhuyenMai implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "maKhuyenMai")
    private KhuyenMai khuyenMai;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "maSP")
    private SanPham sanPham;
    @Column(nullable = false)
    private double giaGiam;

    public ChiTietKhuyenMai(KhuyenMai khuyenMai, SanPham sanPham, double giaGiam) {
        this.khuyenMai = khuyenMai;
        this.sanPham = sanPham;
        this.giaGiam = giaGiam;
    }

    public ChiTietKhuyenMai(KhuyenMai khuyenMai, double giaGiam) {
        this.khuyenMai = khuyenMai;
        this.giaGiam = giaGiam;
    }

    @Override
    public String toString() {
        return "ChiTietKhuyenMai{" + "khuyenMai=" + khuyenMai + ", sanPham=" + sanPham + ", giaGiam=" + giaGiam + '}';
    }

}
