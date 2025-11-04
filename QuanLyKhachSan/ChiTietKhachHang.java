package QuanLyKhachSan;

import java.util.Scanner;

public class ChiTietKhachHang {
    private PhieuDatPhong pdp;
    private ChiTietPhieuDatPhong ct;
    private KhachHang[][] ds_maKhachHang;

    public ChiTietKhachHang() {
        pdp = null;
        ct = null;
        ds_maKhachHang = new KhachHang[0][0];

    }

    public ChiTietKhachHang(PhieuDatPhong maDP, ChiTietPhieuDatPhong maP) {
        this.pdp = maDP;
        this.ct = maP;
        DanhSach[] dsPhong = ct.getDanhSach();
        ds_maKhachHang = new KhachHang[dsPhong.length][];
        for (int i = 0; i < dsPhong.length; i++) {
            ds_maKhachHang[i] = new KhachHang[dsPhong[i].getSl_nguoi()];
        }
    }

    public ChiTietKhachHang(ChiTietKhachHang d) {
        this.pdp = d.pdp;
        this.ct = d.ct;
        this.ds_maKhachHang = new KhachHang[d.ds_maKhachHang.length][];
        for (int i = 0; i < d.ds_maKhachHang.length; i++) {
            this.ds_maKhachHang[i] = new KhachHang[d.ds_maKhachHang[i].length];
            for (int j = 0; j < d.ds_maKhachHang[i].length; j++) {
                this.ds_maKhachHang[i][j] = d.ds_maKhachHang[i][j];
            }

        }

    }

    public KhachHang[][] getDs_KH() {
        return ds_maKhachHang;
    }

    public void setDs_KH(KhachHang[][] ds) {
        this.ds_maKhachHang = ds;
    }

    public PhieuDatPhong getPdp() {
        return pdp;
    }

    public void setPdp(PhieuDatPhong p) {
        this.pdp = p;
    }

    public ChiTietPhieuDatPhong getCt() {
        return ct;
    }

    public void setCt(ChiTietPhieuDatPhong c) {
        this.ct = c;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        DanhSach[] danhSachPhong = ct.getDanhSach();

        if (ds_maKhachHang == null || ds_maKhachHang.length != danhSachPhong.length) {
            ds_maKhachHang = new KhachHang[danhSachPhong.length][];
            for (int i = 0; i < danhSachPhong.length; i++) {
                ds_maKhachHang[i] = new KhachHang[danhSachPhong[i].getSl_nguoi()];
            }
        }

        for (int i = 0; i < danhSachPhong.length; i++) {
            System.out.println("Nhập mã khách hàng cho phòng " + danhSachPhong[i].getP().getMP());
            for (int j = 0; j < danhSachPhong[i].getSl_nguoi(); j++) {
                System.out.print("Khách " + (j + 1) + ": ");
                ds_maKhachHang[i][j] = new KhachHang();
                ds_maKhachHang[i][j].nhap();
            }
        }
    }

    public void xuat() {
        if (pdp == null || ct == null || ds_maKhachHang == null) {
            System.out.println("Thong tin chua day du");
            return;
        }
        DanhSach[] danhSachPhong = ct.getDanhSach();
        if (ds_maKhachHang.length != danhSachPhong.length) {
            System.out.println("Du lieu khong khop voi so phong!");
            return;
        }
        System.out.println("Ma dat phong: " + pdp.getMaDP());
        for (int i = 0; i < danhSachPhong.length; i++) {
            System.out.println("Phong: " + danhSachPhong[i].getP().getMP());
            System.out.println("  Danh sach ma khach hang:");
            for (int j = 0; j < ds_maKhachHang[i].length; j++) {
                System.out.println("Khach " + (j + 1) + ": ");
                ds_maKhachHang[i][j].xuat();
            }
        }
        System.out.println("---//---//---");
    }

}
