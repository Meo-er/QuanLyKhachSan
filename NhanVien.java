package Do_an_OOP;

import java.util.Scanner;

public class NhanVien {
    private String maNV, ho, ten, chucVu;
    double luong;

    public NhanVien() {
    };

    public NhanVien(String maNV, String ho, String ten, String chucVu, double luong) {
        this.maNV = maNV;
        this.ho = ho;
        this.ten = ten;
        this.chucVu = chucVu;
        this.luong = luong;
    }

    public NhanVien(NhanVien nv) {
        maNV = nv.maNV;
        ho = nv.ho;
        ten = nv.ten;
        chucVu = nv.chucVu;
        luong = nv.luong;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getHo() {
        return ho;
    }

    public String getTen() {
        return ten;
    }

    public String getChucVu() {
        return chucVu;
    }

    public double getLuong() {
        return luong;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public void nhapNV() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma NV: ");
        maNV = sc.nextLine();
        System.out.print("Nhap ho: ");
        ho = sc.nextLine();
        System.out.print("Nhap ten: ");
        ten = sc.nextLine();
        System.out.print("Nhap chuc vu: ");
        chucVu = sc.nextLine();
        System.out.print("Nhap luong: ");
        luong = sc.nextDouble();
    }

    public void xuatNV() {
        System.out.print(
                "Ma NV: " + maNV + "\tHo: " + ho + "\tTen: " + ten + "\tChuc vu: " + chucVu + "\tLuong: " + luong);

    }
}
