package QuanLyKhachSan;

import java.util.Scanner;

public class PhongVip extends Phong {
    private String quaChaoMung;
    private String Jacuzzi;

    public PhongVip() {
    }

    public PhongVip(String maPhong, float donGia, int soNguoi, int soGiuong, Boolean tinhTrang, String quaChaoMung,
            String Jacuzzi) {
        super(maPhong, donGia, soNguoi, soGiuong, tinhTrang);
        this.quaChaoMung = quaChaoMung;
        this.Jacuzzi = Jacuzzi;
    }

    public String getQCM() {
        return quaChaoMung;
    }

    public void setQCM(String quaChaoMung) {
        this.quaChaoMung = quaChaoMung;
    }

    public String getJacuzzi() {
        return Jacuzzi;
    }

    public void setJacuzzi(String Jacuzzi) {
        this.Jacuzzi = Jacuzzi;
    }

    @Override
    public String getLoaiPhong() {
        return "Vip";
    }

    @Override
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== NHẬP THÔNG TIN PHÒNG THƯỜNG ===");
        System.out.print("Nhập mã phòng: ");
        this.maPhong = sc.nextLine();
        System.out.print("Nhập đơn giá: ");
        this.donGia = sc.nextFloat();
        System.out.print("Nhập số người: ");
        this.soNguoi = sc.nextInt();
        System.out.print("Nhập số giường: ");
        this.soGiuong = sc.nextInt();
        System.out.print("Nhập tình trạng: ");
        this.tinhTrang = sc.nextBoolean();
        sc.nextLine();
    }

    @Override
    public void xuat() {
        System.out.println("Mã phòng: " + maPhong);
        System.out.println("Đơn giá: " + donGia + " VND/Ngày");
        System.out.println("Loại phòng: " + getLoaiPhong());
        System.out.println("Số người: " + soNguoi);
        System.out.println("Số giường: " + soGiuong);
        System.out.println("Tình trạng: " + kiemTraTinhTrang());
    }

    public void chonLoaiJacuzzi() {
        Scanner sc = new Scanner(System.in);

    }
}
