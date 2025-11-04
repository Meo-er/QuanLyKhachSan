package QuanLyKhachSan;

import java.util.Scanner;

public class ChiTietPNH {
    private String mapnh; // mã phiếu nhập hàng (thêm vào để giống chức năng của mã phiếu mượn)
    private String masp;
    private String tensp;
    private int soluong;
    private float dongia;

    public ChiTietPNH() {
    }

    public ChiTietPNH(String mapnh, String masp, String tensp, int soluong, float dongia) {
        this.mapnh = mapnh;
        this.masp = masp;
        this.tensp = tensp;
        this.soluong = soluong;
        this.dongia = dongia;
    }

    public ChiTietPNH(ChiTietPNH other) {
        this.mapnh = other.mapnh;
        this.masp = other.masp;
        this.tensp = other.tensp;
        this.soluong = other.soluong;
        this.dongia = other.dongia;
    }

    // ===== Getter & Setter =====
    public String getMapnh() {
        return mapnh;
    }

    public void setMapnh(String mapnh) {
        this.mapnh = mapnh;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public float getDongia() {
        return dongia;
    }

    public void setDongia(float dongia) {
        this.dongia = dongia;
    }

    public float getThanhTien() {
        return soluong * dongia;
    }

    // ===== Nhap xuat =====
    Scanner sc = new Scanner(System.in);

    public void nhap(String ma) {
        mapnh = ma;
        System.out.print("Nhap ma san pham: ");
        masp = sc.nextLine();
        System.out.print("Nhap ten san pham: ");
        tensp = sc.nextLine();
        System.out.print("Nhap so luong: ");
        soluong = sc.nextInt();
        System.out.print("Nhap don gia: ");
        dongia = sc.nextFloat();
        sc.nextLine(); // bo dong thua
    }

    public void xuat() {
        System.out.printf("%-8s %-8s %-20s %-9d %-10.2f %-12.2f\n",
                mapnh, masp, tensp, soluong, dongia, getThanhTien());
    }

    @Override
    public String toString() {
        return mapnh + "," + masp + "," + tensp + "," + soluong + "," + dongia;
    }
}