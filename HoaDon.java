package Do_an_OOP;

import java.util.Date;
import java.util.Scanner;

public class HoaDon {
    private String maHD;
    private Date ngayDatPhong, ngayTraPhong, thoiGianTaoHD;
    private double tongCong;
    private NhanVien nhanVien;
    private PhieuDP phieuDP;
    private PhieuSuDungDV phieuSuDungDV;

    public HoaDon() {
        this.thoiGianTaoHD = new Date();
    };

    public HoaDon(String maHD, PhieuDP phieuDP, Date ngayDatPhong, Date ngayTraPhong, Date thoiGianTaoHD,
            NhanVien nhanVien, double tongCong, PhieuSuDungDV phieuSuDungDV) {
        this.maHD = maHD;
        this.phieuDP = phieuDP;
        this.nhanVien = nhanVien;
        this.phieuSuDungDV = phieuSuDungDV;
        this.ngayDatPhong = phieuDP.getNgayDatPhong();
        this.ngayTraPhong = phieuDP.getNgayTraPhong();
        this.thoiGianTaoHD = new Date();
        this.tongTienDP = phieuDP.tongTienDP();
        this.tongTienDV = phieuSuDungDV.getTongTienDV();
        this.tongCong = tongTienDP + tongTienDV;
    }

    public HoaDon(HoaDon hd) {
        maHD = hd.maHD;
        phieuDP = hd.phieuDP;
        nhanVien = hd.nhanVien;
        phieuSuDungDV = hd.phieuSuDungDV;
        ngayDatPhong = hd.ngayDatPhong;
        ngayTraPhong = hd.ngayTraPhong;
        thoiGianTaoHD = hd.thoiGianTaoHD;
        tongTienDP = hd.tongTienDP;
        tongTienDV = hd.tongTienDV;
        tongCong = hd.tongCong;
    }

    public String getMAHD() {
        return maHD;
    }

    public String getMADP() {
        return phieuDP.getMaDP();
    }

    public String getMANV() {
        return nhanVien.getMaNV();
    }

    public Date getNGAYDATPHONG() {
        return ngayDatPhong;
    }

    public Date getNGAYTRAPHONG() {
        return ngayTraPhong;
    }

    public Date getTHOIGIANTAOHD() {
        return thoiGianTaoHD;
    }

    public double getTTDP() {
        return phieuDP.getTongTienDP();
    }

    public double getTTDV() {
        return phieuSuDungDV.tongTienDV();
    }

    public double getTONGCONG() {
        return tongCong;
    }

    public void setMAHD(String maHD) {
        this.maHD = maHD;
    }

    public void setTHOIGIANTAOHD(Date thoiGianTaoHD) {
        this.thoiGianTaoHD = thoiGianTaoHD;
    }

    public void nhapHD() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma HD: ");
        maHD = sc.nextLine();
        System.out.print("Nhap ma nhan vien: ");
        maNV = sc.nextLine();
        System.out.print("Nhap ma phieu đat phong: ");
        maDP = sc.nextLine();
        System.out.print("Nhap ma phieu su dung dich vu: ");
        maDV = sc.nextLine();

    }

    public void xuatKH() {
    }
}
