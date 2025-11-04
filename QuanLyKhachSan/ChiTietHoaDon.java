package QuanLyKhachSan;

import java.util.Scanner;;

public class ChiTietHoaDon {
    private String maHD;
    private String maChiTiet;
    private String loai; // "PHONG" hoặc "DICHVU"
    private double donGia;
    private int soLuong; // Số ngày nếu là PHONG, số lượng nếu là DICHVU
    private double thanhTien;

    public static ChiTietHoaDon taoChiTietPhong(String maHD, String maPhong,
            double donGiaNgay, int soNgay) {
        ChiTietHoaDon ct = new ChiTietHoaDon();
        ct.maHD = maHD;
        ct.loai = "PHONG";
        ct.maChiTiet = maPhong;
        ct.donGia = donGiaNgay;
        ct.soLuong = soNgay;
        ct.tinhThanhTien();
        return ct;
    }

    public static ChiTietHoaDon taoChiTietDichVu(String maHD, String maDV,
            double donGia, int soLuong) {
        ChiTietHoaDon ct = new ChiTietHoaDon();
        ct.maHD = maHD;
        ct.loai = "DICHVU";
        ct.maChiTiet = maDV;
        ct.donGia = donGia;
        ct.soLuong = soLuong;
        ct.tinhThanhTien();
        return ct;
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

    public double getThanhTien() {
        return thanhTien;
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

    public void tinhThanhTien() {
        if ("PHONG".equalsIgnoreCase(loai)) {
            this.thanhTien = donGia * soLuong;
        } else {
            this.thanhTien = donGia * soLuong;
        }
    }

    public void nhap(String maHD) {
        Scanner sc = new Scanner(System.in);
        this.maHD = maHD;

        System.out.print("Nhap loai (PHONG/DICHVU): ");
        this.loai = sc.nextLine().toUpperCase();
        System.out.print("Nhap ma phong/ dich vu: ");
        this.maChiTiet = sc.nextLine();
        System.out.print("Nhap don gia: ");
        this.donGia = sc.nextDouble();
        System.out.print("Nhap so luong: ");
        this.soLuong = sc.nextInt();
        sc.nextLine();

        tinhThanhTien();
    }

    public void xuat() {
        System.out.printf("%-12s %-12s %-12.2f %-12d %-12.2f\n",
                loai, maChiTiet, donGia, soLuong, thanhTien);
    }

    public String toString() {
        return maHD + "," + maChiTiet + "," + loai + "," + donGia + "," + soLuong + "," + thanhTien;
    }
}