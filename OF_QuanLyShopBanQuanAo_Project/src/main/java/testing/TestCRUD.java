package testing;

import entity.KhachHang;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import net.datafaker.Faker;

public class TestCRUD {
    public static void main(String[] args) {
        System.out.println("Hello World");

        EntityManager em = Persistence.createEntityManagerFactory("default")
                .createEntityManager();

        EntityTransaction tr = em.getTransaction();
        Faker faker = new Faker();
        tr.begin();

        for (int i = 0; i < 5; i++) {
            String maKH = faker.number().digits(5);
            String tenKH = faker.educator().campus();
            String diaChi = faker.address().city();
            String sdt = faker.phoneNumber().cellPhone();
            boolean gioiTinh = faker.bool().bool();

            KhachHang kh = new KhachHang(maKH, tenKH, diaChi, sdt, gioiTinh);
            em.persist(kh);
        }

        tr.commit();

    }
}
