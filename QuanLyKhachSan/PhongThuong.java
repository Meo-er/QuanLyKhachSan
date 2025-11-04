package QuanLyKhachSan;

import java.util.Scanner;

public class PhongThuong extends Phong {
    private double dichVuNT;
    private double phiDuaDon;

    public PhongThuong() {
    }

    public PhongThuong(String maPhong, float donGia, int soNguoi, int soGiuong, boolean tinhTrang, double dichVuNT,
            double phiDuaDon) {
        super(maPhong, donGia, soNguoi, soGiuong, tinhTrang);
        this.dichVuNT = dichVuNT;
        this.phiDuaDon = phiDuaDon;
    }

    public PhongThuong(PhongThuong pt) {
        super(pt.getMP(), pt.getDG(), pt.getSN(), pt.getSG(), pt.getTT());
        this.dichVuNT = pt.dichVuNT;
        this.phiDuaDon = pt.phiDuaDon;
    }

    public double getDVNT() {
        return dichVuNT;
    }

    public void setDVNT(double dichVuNT) {
        this.dichVuNT = dichVuNT;
    }

    public double getPhiDuaDon() {
        return phiDuaDon;
    }

    public void setPhiDuaDon(double phiDuaDon) {
        this.phiDuaDon = phiDuaDon;
    }

    public String getLoaiPhong() {
        return "Thuong";
    }

    public void nhap() {
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.println("=== NHAP THONG TIN PHONG THUONG ===");
        System.out.print("Nhap phi dua don: ");
        phiDuaDon = sc.nextDouble();
        System.out.print("Nhap phi dich vu ngoai troi: ");
        dichVuNT = sc.nextDouble();
        sc.nextLine();
    }

    public void xuat() {
        super.xuat();
        System.out.printf("%-15s %-25.0f %-15.0f\n",
                getLoaiPhong(), this.getPhiDuaDon(), this.getDVNT());
    }

    @Override
    public String toString() {
        String tinhTrangStr = getTT() ? "con" : "khong con";
        return getMP() + "," + getDG() + "," + getSN() + "," + getSG() + "," +
                tinhTrangStr + ",Thuong," + phiDuaDon + "," + dichVuNT;
    }
}
