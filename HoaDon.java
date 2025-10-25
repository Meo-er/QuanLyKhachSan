package Doan;

import java.util.Date;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class HoaDon {
    private String maHD, maDP, maNV;
    private LocalDateTime thoiGianTaoHD;
    private LocalDate ngayDP, ngayTP;
    private double tongcong;
    private double tongtienDP, tongtienDV;

    private PhieuDatPhong phieuDP;
    private PhieuSuDungDV phieuSDDV;

    public HoaDon() {

        this.thoiGianTaoHD = LocalDateTime.now();
    };

    public HoaDon(String maHD, String maDP, String maNV) {
        this.maHD = maHD;
        this.maDP = maDP;
        this.maNV = maNV;

        this.ngayDP = LocalDate.now(); // tạm thời gán ngày hiện tại
        this.ngayTP = LocalDate.now().plusDays(1); // tạm thời ngày trả sau 1 ngày
        this.tongtienDP = 0; // test

        this.thoiGianTaoHD = LocalDateTime.now();
        this.tongtienDV = 3; // test
        this.tongcong = tongtienDP + tongtienDV;
    }

    public HoaDon(HoaDon hd) {
        maHD = hd.maHD;
        maDP = hd.maDP;
        maNV = hd.maNV;
        ngayDP = hd.ngayDP;
        ngayTP = hd.ngayTP;
        thoiGianTaoHD = hd.thoiGianTaoHD;
        tongtienDP = hd.tongtienDP;
        tongtienDV = hd.tongtienDV;
        tongcong = hd.tongcong;
    }

    public String getMaHD() {
        return maHD;
    }

    public String getMaDP() {
        return maDP;
    }

    public String getMaNV() {
        return maNV;
    }

    public LocalDate getNgayDP() {
        return ngayDP;
    }

    public LocalDate getNgayTP() {
        return ngayTP;
    }

    public LocalDateTime getThoiGianTaoHD() {
        return thoiGianTaoHD;
    }

    public double getTTDP() {
        return tongtienDP;
    }

    public double getTTDV() {
        return tongtienDV;
    }

    public double getTongCong() {
        return tongcong;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public void setMaDP(String maDP) {
        this.maDP = maDP;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setThoiGianTaoHD(LocalDateTime thoiGianTaoHD) {
        this.thoiGianTaoHD = thoiGianTaoHD;
    }

    public void setNgayDP(LocalDate ngayDP) {
        this.ngayDP = ngayDP;
    }

    public void setNgayTP(LocalDate ngayTP) {
        this.ngayTP = ngayTP;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma HD: ");
        maHD = sc.nextLine();
        System.out.print("Nhap ma DP: ");
        maDP = sc.nextLine();
        System.out.print("Nhap ma NV: ");
        maNV = sc.nextLine();
        // PhieuDatPhong p = dspdp.timTheoMa(maDP);
        // if (p != null) {
        // this.ngayDP = p.getNgayDP();
        // this.ngayTP = p.getNgayTP();
        // this.tongtienDP = p.getTong();
        // } else
        // System.out.println("Khong tim thay phong " + maDP);

        // PhieuSuDungDV pdv = dspssdv.timTheoMa(maDP);
        // if (pdv != null) {
        // this.tongtienDV = pdv.Tinhthanhtien();
        // } else
        // System.out.println("Khong tim thay phieu su dung dung vu cua phong " + maDP);
        this.tongcong = this.tongtienDP + this.tongtienDV;
    }

    public void xuat() {
        System.out.printf("%-10s %-10s %-10s %-15s %-15s %-15s %-15s %-15s %-25.22s\n", this.getMaHD(),
                this.getMaDP(),
                this.getMaNV(), this.getNgayDP(), this.getNgayTP(), this.getTTDP(), this.getTTDV(), this.getTongCong(),
                this.getThoiGianTaoHD());
    }

    public static void main(String[] args) {
        HoaDon hd1 = new HoaDon("01", "01", "01");
        hd1.xuat();
    }
}
