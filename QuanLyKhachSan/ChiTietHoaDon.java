package Doan;

import java.util.Scanner;

public class ChiTietHoaDon {
    private String maHD; // Mã hóa đơn
    private String loai; // "PHONG" hoặc "DICHVU"
    private String maChiTiet; // Mã phòng hoặc mã dịch vụ
    private double donGia;
    private int soLuong;
    private double thanhTien;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(String maHD, String loai, String maChiTiet, double donGia, int soLuong, double thanhtien) {
        this.maHD = maHD;
        this.loai = loai;
        this.maChiTiet = maChiTiet;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.thanhTien = donGia * soLuong;
    }

    public void nhap(String maHD) {
        Scanner sc = new Scanner(System.in);
        this.maHD = maHD;
        System.out.print("Loai (PHONG/DICHVU): ");
        this.loai = sc.nextLine().trim().toUpperCase();
        System.out.print("Ma: ");
        this.maChiTiet = sc.nextLine();
        System.out.print("Don gia: ");
        this.donGia = sc.nextDouble();
        System.out.print("So luong: ");
        this.soLuong = sc.nextInt();
        sc.nextLine();
        this.thanhTien = donGia * soLuong;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma HD: ");
        this.maHD = sc.nextLine();
        nhap(maHD);
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public String getLoai() {
        return loai;
    }

    public double getDonGia() {
        return donGia;
    }

    public String getMaChiTiet() {
        return maChiTiet;
    }

    public String getMaHD() {
        return maHD;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public void setMaChiTiet(String maChiTiet) {
        this.maChiTiet = maChiTiet;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public void xuat() {
        System.out.printf("%-12s %-12s %-12.2f %-12d %-12.2f%n",
                loai, maChiTiet, donGia, soLuong, thanhTien);
    }

    @Override
    public String toString() {
        return maHD + "," + loai + "," + maChiTiet + "," + donGia + "," + soLuong + "," + thanhTien;
    }
}
