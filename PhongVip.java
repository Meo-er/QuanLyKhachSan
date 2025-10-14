package QuanLyKhachSan;

import java.util.Scanner;

public class PhongVip extends Phong {
    private String quaChaoMung;
    private String Jacuzzi;

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

    public String getLoaiPhong() {
        return "Vip";
    }

    public void nhap() {
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.println("=== NHAP THONG TIN PHONG VIP ===");
        System.out.print("Nhap qua chao mung: ");
        quaChaoMung = sc.nextLine();
        System.out.print("Nhap loai Jacuzzi: ");
        sc.nextLine();
    }

    public void xuat() {
        super.xuat();
        System.out.println(
                "Loai phong: " + getLoaiPhong() + "\tQua chao mung: " + quaChaoMung + "\tLoai Jacuzzi: " + Jacuzzi);
    }

}
