package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
public class LoaiKhuyenMai implements Serializable{
    private String maLoaiKMai;
    @Column(columnDefinition = "nvarchar(45)")
    private String tenLoaiKM;

    public LoaiKhuyenMai(String maLoaiKMai, String tenLoaiKM) {
        this.maLoaiKMai = maLoaiKMai;
        this.tenLoaiKM = tenLoaiKM;
    }

    @Override
    public String toString() {
        return "loaiKhuyenMai{" + "maLoaiKMai=" + maLoaiKMai + ", tenLoaiKM=" + tenLoaiKM + '}';
    }

}

