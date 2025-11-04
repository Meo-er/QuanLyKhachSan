package QuanLyKhachSan;

import java.util.Scanner;

public class DichVu {
    private String madv;
    private String tendv;
    private float dongia;
    private String mota;
    private int soluong;

    public DichVu() {
    }

    public DichVu(String madv, String tendv, float dongia, int soluong, String mota) {
        this.madv = madv;
        this.tendv = tendv;
        this.dongia = dongia;
        this.soluong = soluong;
        this.mota = mota;
    }

    public DichVu(DichVu other) {
        madv = other.madv;
        tendv = other.tendv;
        dongia = other.dongia;
        mota = other.mota;
        soluong = other.soluong;
    }

    // getter setter
    public String getmadv() {
        return madv;
    }

    public void setmadv(String madv) {
        this.madv = madv;
    }

    public String gettendv() {
        return tendv;
    }

    public void settendv(String tendv) {
        this.tendv = tendv;
    }

    public float getdongia() {
        return dongia;
    }

    public void setdongia(float dongia) {
        if (dongia < 0)
            this.dongia = 0;
        else
            this.dongia = dongia;
    }

    public String getmota() {
        return mota;
    }

    public void setmota(String mota) {
        this.mota = mota;
    }

    public int getsoluong() {
        return soluong;
    }

    public void setsoluong(int soluong) {
        if (soluong < 0)
            this.soluong = 0;
        else
            this.soluong = soluong;
    }

    // ===== Nhap xuat =====
    Scanner sc = new Scanner(System.in);

    public void nhap() {
        System.out.print("Nhap ma dich vu: ");
        setmadv(sc.nextLine());
        System.out.print("Nhap ten dich vu: ");
        settendv(sc.nextLine());
        System.out.print("Nhap don gia: ");
        setdongia(sc.nextFloat());
        System.out.print("Nhap so luong: ");
        setsoluong(sc.nextInt());
        sc.nextLine();
        System.out.print("Nhap mo ta: ");
        setmota(sc.nextLine());
    }

    public void xuat() {
        System.out.printf("%-9s %-15s %-15.2f %-15d %-15s\n", getmadv(), gettendv(), getdongia(), getsoluong(),
                getmota());
    }

    @Override
    public String toString() {
        return madv + "," + tendv + "," + dongia + "," + soluong + "," + mota;
    }
}
