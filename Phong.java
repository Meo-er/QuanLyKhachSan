package QuanLyKhachSan;

import java.util.Scanner;

public abstract class Phong {
    private String maPhong;
    private float donGia;
    private int soNguoi;
    private int soGiuong;
    private Boolean tinhTrang;

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

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma phong: ");
        maPhong = sc.nextLine();
        System.out.print("Nhap don gia: ");
        donGia = sc.nextFloat();
        System.out.print("Nhap so nguoi: ");
        soNguoi = sc.nextInt();
        System.out.print("Nhap so giuong: ");
        soGiuong = sc.nextInt();
        System.out.print("Nhap tinh trang: ");
        tinhTrang = sc.nextBoolean();
    }

    public void xuat() {
        System.out.println("Ma phong: " + maPhong + "\tDon gia: " + donGia + "\tSo nguoi: " + soNguoi + "\tSo giuong: "
                + soGiuong + "\tTinh trang: " + tinhTrang);
    }

    public abstract String getLoaiPhong();

}
