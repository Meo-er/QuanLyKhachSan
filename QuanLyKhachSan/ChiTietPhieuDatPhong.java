package QuanLyKhachSan;

import java.util.Scanner;

class DanhSach {
    private Phong p;
    private int Sl_nguoi;

    public DanhSach() {
        Sl_nguoi = 0;
        p = null;
    }

    public DanhSach(Phong maP, int sl) {
        this.p = maP;
        this.Sl_nguoi = sl;
    }

    public DanhSach(DanhSach d) {
        if (d.p instanceof PhongThuong)
            this.p = new PhongThuong((PhongThuong) d.p);
        else if (d.p instanceof PhongVip)
            this.p = new PhongVip((PhongVip) d.p);
        this.Sl_nguoi = d.Sl_nguoi;
    }

    public Phong getP() {
        return p;
    }

    public void setP(Phong maP) {
        this.p = maP;
    }

    public int getSl_nguoi() {
        return Sl_nguoi;
    }

    public void setSl_N(int sl) {
        this.Sl_nguoi = sl;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Chọn loại phòng:");
        System.out.println("1. Phòng Thường");
        System.out.println("2. Phòng VIP");
        System.out.print("Lựa chọn: ");
        int loai = Integer.parseInt(sc.nextLine());

        if (loai == 1)
            p = new PhongThuong();
        else if (loai == 2)
            p = new PhongVip();
        else {
            System.out.println("Lựa chọn không hợp lệ. Mặc định: Phòng Thường");
            p = new PhongThuong();
        }
        p.nhap();
        System.out.print("So luong nguoi:");
        Sl_nguoi = Integer.parseInt(sc.nextLine());

    }

    public void xuat() {
        System.out.printf("%-15s %-15d\n", getP().getMP(), getSl_nguoi());
    }
}

public class ChiTietPhieuDatPhong {
    private DanhSach[] ds;
    private PhieuDatPhong pdp;
    int n;

    public ChiTietPhieuDatPhong() {
        ds = new DanhSach[0];
        pdp = new PhieuDatPhong();
    }

    public ChiTietPhieuDatPhong(PhieuDatPhong b) {

        this.pdp = b;
    }

    public ChiTietPhieuDatPhong(DanhSach[] ds) {
        this.ds = ds;
        this.n = ds.length;
        this.pdp = new PhieuDatPhong();
    }

    public ChiTietPhieuDatPhong(ChiTietPhieuDatPhong e) {
        this.n = e.n;
        this.ds = new DanhSach[n];
        for (int i = 0; i < n; i++) {
            this.ds[i] = new DanhSach(e.ds[i]);
        }
        this.pdp = new PhieuDatPhong(e.pdp);

    }

    public PhieuDatPhong getPdp() {
        return pdp;
    }

    public void setPdp(PhieuDatPhong ma) {
        this.pdp = ma;
    }

    public DanhSach[] getDanhSach() {
        return ds;
    }

    public void setDanhSach(DanhSach[] dsach) {
        this.ds = dsach;
    }

    public void nhap_ThongTin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma dat phong:");
        String maDP = sc.nextLine();
        pdp.setMaDP(maDP);
        System.out.print("Nhap so luong trong danh sach:");
        n = sc.nextInt();
        sc.nextLine();
        ds = new DanhSach[n];
        for (int i = 0; i < n; i++) {
            boolean trungMa;
            do {
                trungMa = false;
                ds[i] = new DanhSach();
                ds[i].nhap();
                for (int j = 0; j < i; j++) {
                    if (ds[i].getP().getMP().equalsIgnoreCase(ds[j].getP().getMP())) {
                        System.out.println("Ma phong da ton tai. Vui long nhap lai!!!");
                        trungMa = true;
                        break;
                    }
                }
            } while (trungMa);
        }
        int tongNguoi = 0;
        for (int i = 0; i < n; i++) {
            tongNguoi += ds[i].getSl_nguoi();
        }
        System.out.println("Tong so nguoi:" + tongNguoi);

    }

    public void xuat_ThongTin() {
        System.out.printf("\n%-15s %-15s %-15s\n", "Ma dat phong", "Ma phong", "So luong nguoi");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-15s %-15s %-15d\n", pdp.getMaDP(), ds[i].getP().getMP(), ds[i].getSl_nguoi());
        }
    }

}
