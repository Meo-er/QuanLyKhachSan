package QuanLyKhachSan;

import java.util.Scanner;

abstract class Phong {
    private String maPhong;
    private float donGia;
    private int soNguoi;
    private int soGiuong;
    private boolean tinhTrang;

    public Phong() {
    }

    public Phong(String maPhong, float donGia, int soNguoi, int soGiuong, boolean tinhTrang) {
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

    public boolean getTT() {
        return tinhTrang;
    }

    public void setTT(boolean tinhTrang) {
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
        sc.nextLine();

        System.out.print("Nhap tinh trang(con/khong con): ");
        String tt = sc.nextLine().toLowerCase();

        if (tt.equals("con")) {
            tinhTrang = true;
        } else if (tt.equals("khong con")) {
            tinhTrang = false;
        } else {
            System.out.println("Tinh trang khong hop le! Mac dinh la con phong.");
            tinhTrang = true;
        }
    }

    public void xuat() {
        String tt;
        if (getTT()) {
            tt = "Trong";
        } else {
            tt = "Da dat";
        }

        System.out.printf("%-10s %-10.0f %-10d %-15d %-15s",
                this.getMP(), this.getDG(), this.getSN(), this.getSG(), tt);
    }

    public abstract String getLoaiPhong();

}