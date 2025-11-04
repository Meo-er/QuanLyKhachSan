package QuanLyKhachSan;

import java.util.Scanner;

public class PhieuSuDungDV {
    private String masddv;
    private String madp;
    private String makh;
    private double thanhtien;

    public PhieuSuDungDV() {
        masddv = "";
        madp = "";
        makh = "";
        thanhtien = 0;
    }

    public PhieuSuDungDV(String masddv, String madp, String makh, double thanhtien) {
        this.masddv = masddv;
        this.madp = madp;
        this.makh = makh;
        this.thanhtien = thanhtien;
    }

    public PhieuSuDungDV(PhieuSuDungDV p) {
        this.masddv = p.masddv;
        this.madp = p.madp;
        this.makh = p.makh;
        this.thanhtien = p.thanhtien;
    }

    public String getMasddv() {
        return masddv;
    }

    public void setMasddv(String masddv) {
        this.masddv = masddv;
    }

    public String getMadp() {
        return madp;
    }

    public void setMadp(String madp) {
        this.madp = madp;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public double getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(double thanhtien) {
        this.thanhtien = thanhtien;
    }

    public void nhap(DSDV dsDV) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== NHAP THONG TIN PHIEU SU DUNG DICH VU ===");

        System.out.print("Nhap ma phieu su dung dich vu: ");
        masddv = sc.nextLine();

        System.out.print("Nhap ma dat phong: ");
        madp = sc.nextLine();

        System.out.print("Nhap ma khach hang: ");
        makh = sc.nextLine();

        thanhtien = 0;

        // Tìm dịch vụ
        DichVu dv = null;
        while (true) {
            System.out.print("Nhap ma dich vu: ");
            String maDV = sc.nextLine();

            dv = dsDV.timtheomadv(maDV);
            if (dv != null) {
                break; // Thoát khi tìm thấy dịch vụ
            }
            System.out.println("Khong tim thay dich vu co ma: " + maDV + ". Vui long nhap lai!");
        }

        System.out.print("Nhap so luong: ");
        int soLuong = sc.nextInt();
        sc.nextLine();

        thanhtien = dv.getdongia() * soLuong;
        System.out.println("Da them dich vu: " + dv.gettendv());
        System.out.println("Thanh tien: " + thanhtien);
    }

    public double tinhTongTien(DichVu dv, int soLuong) {
        return dv.getdongia() * soLuong;
    }

    @Override
    public String toString() {
        return masddv + "," + madp + "," + makh + "," + thanhtien;
    }

    public void xuat() {
        System.out.printf("%-15s %-15s %-15s %-15s\n",
                "Ma SDDV", "Ma Dat Phong", "Ma KH", "Thanh Tien");
        System.out.printf("%-15s %-15s %-15s %-15.2f\n",
                masddv, madp, makh, thanhtien);
    }
}