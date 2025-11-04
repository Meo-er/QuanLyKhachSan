package QuanLyKhachSan;

import java.util.Scanner;

public class NhanVien {
    private String manv, ho, ten, chucvu;
    double luong;

    public NhanVien() {
    };

    public NhanVien(String manv, String ho, String ten, String chucvu, double luong) {
        this.manv = manv;
        this.ho = ho;
        this.ten = ten;
        this.chucvu = chucvu;
        this.luong = luong;
    }

    public NhanVien(NhanVien nv) {
        manv = nv.manv;
        ho = nv.ho;
        ten = nv.ten;
        chucvu = nv.chucvu;
        luong = nv.luong;
    }

    public String getMaNV() {
        return manv;
    }

    public String getHo() {
        return ho;
    }

    public String getTen() {
        return ten;
    }

    public String getchucvu() {
        return chucvu;
    }

    public double getLuong() {
        return luong;
    }

    public void setMaNV(String manv) {
        this.manv = manv;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setchucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma NV: ");
        this.setMaNV(sc.nextLine());
        System.out.print("Nhap ho: ");
        this.setHo(sc.nextLine());
        System.out.print("Nhap ten: ");
        this.setTen(sc.nextLine());
        System.out.print("Nhap chuc vu: ");
        this.setchucvu(sc.nextLine());
        System.out.print("Nhap luong: ");
        this.setLuong(sc.nextDouble());
        System.out.println("-----");
    }

    public void xuat() {
        System.out.printf("%-10s %-15s %-10s %-15s %-10.2f\n",
                this.getMaNV(), this.getHo(), this.getTen(), this.getchucvu(), this.getLuong());

    }

    @Override
    public String toString() {
        return manv + "," + ho + "," + ten + "," + chucvu + "," + luong;
    }

}
