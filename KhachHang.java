package Do_an_OOP;

import java.util.Scanner;

public class KhachHang {
    private String maKH, ho, ten, sdt, email;

    public KhachHang() {
    };

    public KhachHang(String maKH, String ho, String ten, String sdt, String email) {
        this.maKH = maKH;
        this.ho = ho;
        this.ten = ten;
        this.sdt = sdt;
        this.email = email;
    }

    public KhachHang(KhachHang kh) {
        maKH = kh.maKH;
        ho = kh.ho;
        ten = kh.ten;
        sdt = kh.sdt;
        email = kh.email;
    }

    public String getMaKH() {
        return maKH;
    }

    public String getHo() {
        return ho;
    }

    public String getTen() {
        return ten;
    }

    public String getSdt() {
        return sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void nhapKH() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma KH: ");
        maKH = sc.nextLine();
        System.out.print("Nhap ho: ");
        ho = sc.nextLine();
        System.out.print("Nhap ten: ");
        ten = sc.nextLine();
        System.out.print("Nhap SDT: ");
        sdt = sc.nextLine();
        System.out.print("Nhap email: ");
        email = sc.nextLine();
    }

    public void xuatKH() {
        System.out.print("Ma KH: " + maKH + "\tHo: " + ho + "\tTen:" + ten + "\tSDT:" + sdt + "\tEmail: " + email);
    }
}
