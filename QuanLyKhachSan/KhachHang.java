package QuanLyKhachSan;

import java.util.Scanner;

public class KhachHang {
    private String makh, ho, ten, email;
    private long sdt;

    public KhachHang() {
    };

    public KhachHang(String makh, String ho, String ten, long sdt, String email) {
        this.makh = makh;
        this.ho = ho;
        this.ten = ten;
        this.sdt = sdt;
        this.email = email;
    }

    public KhachHang(KhachHang kh) {
        makh = kh.makh;
        ho = kh.ho;
        ten = kh.ten;
        sdt = kh.sdt;
        email = kh.email;
    }

    public String getMaKH() {
        return makh;
    }

    public String getHo() {
        return ho;
    }

    public String getTen() {
        return ten;
    }

    public long getSdt() {
        return sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setMaKH(String makh) {
        this.makh = makh;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setSdt(long sdt) {
        this.sdt = sdt;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma KH: ");
        this.setMaKH(sc.nextLine());
        System.out.print("Nhap ho: ");
        this.setHo(sc.nextLine());
        System.out.print("Nhap ten: ");
        this.setTen(sc.nextLine());
        System.out.print("Nhap SDT: ");
        this.setSdt(sc.nextLong());
        sc.nextLine();
        System.out.print("Nhap email: ");
        this.setEmail(sc.nextLine());

    }

    public void xuat() {
        System.out.printf("%-15s %-10s %-10s %-15s %-15s\n", this.getMaKH(), this.getHo(), this.getTen(),
                this.getSdt(), this.getEmail());
    }

    public static void main(String[] args) {
        KhachHang kh = new KhachHang();
        kh.nhap();
        kh.xuat();
    }
}
