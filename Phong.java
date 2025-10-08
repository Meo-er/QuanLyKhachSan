package QuanLyKhachSan;

import java.util.Scanner;

public abstract class Phong {
    private String maPhong;
    private float donGia;
    private int soNguoi;
    private int soGiuong;
    private Boolean tinhTrang;

    public Phong() {
    }

    public Phong(String maPhong, float donGia, int soNguoi, int soGiuong, Boolean tinhTrang) {
        this.maPhong = maPhong;
        this.donGia = donGia;
        this.soNguoi = soNguoi;
        this.soGiuong = soGiuong;
        this.tinhTrang = tinhTrang;
    }

    public String getMP() {
        return maPhong;
    }

    public void setMP(String maPhong) {
        this.maPhong = maPhong;
    }

    public float getDG() {
        return donGia;
    }

    public void setDG(float donGia) {
        this.donGia = donGia;
    }

    public int getSN() {
        return soNguoi;
    }

    public void setSN(int soNguoi) {
        this.soNguoi = soNguoi;
    }

    public int getSG() {
        return soGiuong;
    }

    public void setSG(int soGiuong) {
        this.soGiuong = soGiuong;
    }

    public Boolean getTT() {
        return tinhTrang;
    }

    public void setTT(Boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    // public void nhap() {
    // Scanner sc = new Scanner(System.in);
    // System.out.print("Nhập mã phòng: ");
    // maPhong = sc.nextLine();
    // System.out.print("Nhập đơn giá: ");
    // donGia = sc.nextFloat();
    // System.out.print("Nhập số người: ");
    // soNguoi = sc.nextInt();
    // System.out.print("Nhập số giường: ");
    // soGiuong = sc.nextInt();
    // System.out.print("Nhập tình trạng: ");
    // tinhTrang = sc.nextBoolean();
    // }

    // public void xuat() {
    // System.out.println("Mã phòng: " + maPhong);
    // System.out.println("Đơn giá: " + donGia + " VND/Ngày");
    // System.out.println("Số người: " + soNguoi);
    // System.out.println("Số giường: " + soGiuong);
    // System.out.println("Tình trạng: " + tinhTrang);
    // }

    public String kiemTraTinhTrang() {
        if (tinhTrang == true) {
            return "Còn phòng";
        } else {
            return "Hết phòng";
        }
    }

    public Boolean datPhong() {
        if (tinhTrang) {
            tinhTrang = false;
            return true;
        }
        return false;
    }

    public void traPhong() {
        tinhTrang = true;
    }

    public static int chonLoaiPhong() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n=== CHỌN LOẠI PHÒNG ===");
        System.out.println("1. Phòng Thường");
        System.out.println("2. Phòng VIP");
        System.out.print("Chọn loại phòng: ");

        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }

    public abstract void nhap();

    public abstract void xuat();

    public abstract String getLoaiPhong();

    public abstract double tinhGiamGia(int soNgay);

}