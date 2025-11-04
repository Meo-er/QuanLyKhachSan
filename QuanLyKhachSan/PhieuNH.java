package QuanLyKhachSan;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PhieuNH {
    private String manh;
    private String manv;
    private String mancc; // nhà cung cấp
    private LocalDate date;
    private float thanhtien = 0;

    private DanhSachChiTietPNH dsctpnh; // danh sách chi tiết phiếu nhập

    // ==== Constructor ====
    public PhieuNH() {
        dsctpnh = new DanhSachChiTietPNH();
    }

    public PhieuNH(String manh, String manv, String mancc, LocalDate date) {
        this.manh = manh;
        this.manv = manv;
        this.mancc = mancc;
        this.date = date;
        this.dsctpnh = new DanhSachChiTietPNH();
    }

    public PhieuNH(PhieuNH pnh) {
        this.manh = pnh.manh;
        this.mancc = pnh.mancc;
        this.manv = pnh.manv;
        this.date = pnh.date;
        this.thanhtien = pnh.thanhtien;
        this.dsctpnh = new DanhSachChiTietPNH(pnh.dsctpnh);
    }

    public void setDS(ChiTietPNH[] dsct) {
        this.dsctpnh.setDS(dsct); // gán danh sách chi tiết
        this.thanhtien = dsctpnh.tinhTongTien(); // tính lại tổng tiền
    }

    // ==== Getter & Setter ====
    public String getmanh() {
        return manh;
    }

    public void setmanh(String manh) {
        this.manh = manh;
    }

    public String getmanv() {
        return manv;
    }

    public void setmanv(String manv) {
        this.manv = manv;
    }

    public String getmancc() {
        return mancc;
    }

    public void setmancc(String mancc) {
        this.mancc = mancc;
    }

    public LocalDate getdate() {
        return date;
    }

    public void setdate(LocalDate date) {
        this.date = date;
    }

    public DanhSachChiTietPNH getDS() {
        return dsctpnh;
    }

    // ==== Tính tổng tiền ====
    public float getThanhTien() {
        this.thanhtien = dsctpnh.tinhTongTien();
        return thanhtien;
    }

    // ==== Nhập dữ liệu ====
    Scanner sc = new Scanner(System.in);

    public void nhap() {
        System.out.print("Nhap ma phieu nhap: ");
        manh = sc.nextLine();
        System.out.print("Nhap ma nhan vien lap phieu: ");
        manv = sc.nextLine();
        System.out.print("Nhap ma nha cung cap: ");
        mancc = sc.nextLine();
        System.out.print("Nhap ngay lap (yyyy-MM-dd): ");
        String ngay = sc.nextLine();
        date = LocalDate.parse(ngay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

    }

    // ==== Xuất dữ liệu ====
    public void xuat() {
        System.out.println("Ma phieu nhap hang: " + getmanh());
        System.out.println("Ma nhan vien lap phieu:" + getmanv());
        System.out.println("Ma nha cung cap: " + date);
    }

    public void xuatChiTiet() {
        System.out.println("Danh sach chi tiet phieu nhap:");
        dsctpnh.xuat();
        System.out.printf("=> Tong tien phieu: %.2f\n", getThanhTien());
    }

    // ==== Ghi chuỗi (ghi file / xuất log) ====
    @Override
    public String toString() {
        return manh + "," + manv + "," + mancc + "," + date;
    }
}