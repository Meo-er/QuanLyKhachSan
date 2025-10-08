package QuanLyKhachSan;

import java.util.Scanner;

public class PhongThuong extends Phong {
    private double dichVuNT;
    private double PhiDuaDon;

    public PhongThuong() {
    }

    public PhongThuong(String maPhong, float donGia, int soNguoi, int soGiuong, Boolean tinhTrang, double dichVuNT,
            double PhiDuaDon) {
        super(maPhong, donGia, soNguoi, soGiuong, tinhTrang);
        this.dichVuNT = dichVuNT;
        this.PhiDuaDon = PhiDuaDon;
    }

    public double getDVNT() {
        return dichVuNT;
    }

    public void setDVNT(double dichVuNT) {
        this.dichVuNT = dichVuNT;
    }

    public double getPhiDuaDon() {
        return PhiDuaDon;
    }

    public void setPhiDuaDon(double PhiDuaDon) {
        this.PhiDuaDon = PhiDuaDon;
    }

    @Override
    public String getLoaiPhong() {
        return "Thường";
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
        System.out.print("Nhập phí đưa đón: ");
        this.PhiDuaDon = sc.nextDouble();
        System.out.print("Nhập phí dịch vụ ngoài trời: ");
        this.dichVuNT = sc.nextDouble();
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
        System.out.println("Phí đưa đón: " + PhiDuaDon);
        System.out.println("Phí dịch vụ ngoài trời: " + dichVuNT);
    }

    public double tinhGiamGia(int soNgay) {
        if (soNgay >= 7) {
            return donGia * soNgay * 0.1;
        }
        return 0;
    }

}
