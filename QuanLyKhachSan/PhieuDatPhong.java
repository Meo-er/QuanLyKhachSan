package QuanLyKhachSan;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class PhieuDatPhong {
    private String maDatPhong;
    private LocalDate ngayDP;
    private LocalDate ngayTP;
    private KhachHang kh;

    private NhanVien nv;
    private int sl_Phong;
    private float tongTien;
    private String[] dsMaPhong;

    public PhieuDatPhong() {
        maDatPhong = "";
        ngayDP = null;
        ngayTP = null;
        kh = new KhachHang();
        nv = new NhanVien();
        sl_Phong = 0;
        tongTien = 0;
        dsMaPhong = new String[0];
    }

    public PhieuDatPhong(String maDP, LocalDate dateDP, LocalDate dateTP, KhachHang maKH, NhanVien maNV, int sl,
            float sum, String[] dsMaPhong) {
        this.maDatPhong = maDP;
        this.ngayDP = dateDP;
        this.ngayTP = dateTP;
        this.kh = maKH;
        this.nv = maNV;
        this.sl_Phong = sl;
        this.tongTien = sum;
        this.dsMaPhong = dsMaPhong;
    }

    public PhieuDatPhong(PhieuDatPhong d) {
        this.maDatPhong = d.maDatPhong;
        this.ngayDP = d.ngayDP;
        this.ngayTP = d.ngayTP;
        this.kh = new KhachHang(d.kh);
        this.nv = new NhanVien(d.nv);
        this.sl_Phong = d.sl_Phong;
        this.tongTien = d.tongTien;
    }

    public String getMaDP() {
        return maDatPhong;
    }

    public void setMaDP(String maDP) {
        this.maDatPhong = maDP;
    }

    public LocalDate getNgayDP() {
        return ngayDP;
    }

    public void setNgayDP(LocalDate dateDP) {
        this.ngayDP = dateDP;
    }

    public LocalDate getNgayTP() {
        return ngayTP;
    }

    public void setNgayTP(LocalDate dateTP) {
        this.ngayTP = dateTP;
    }

    public KhachHang getKhachHang() {
        return kh;
    }

    public void setKhachHang(KhachHang maKH) {
        this.kh = maKH;
    }

    public NhanVien getNV() {
        return nv;
    }

    public void setNV(NhanVien maNV) {
        this.nv = maNV;
    }

    public int getSl() {
        return sl_Phong;
    }

    public void setSl(int sl) {
        this.sl_Phong = sl;
    }

    public float getTong() {
        return tongTien;
    }

    public void setTong(float sum) {
        this.tongTien = sum;
    }

    public String[] getDsMaPhong() {
        return dsMaPhong;
    }

    public void setDsMaPhong(String[] ds) {
        this.dsMaPhong = ds;
    }

    public void nhap(DSP dsp) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("=== NHAP THONG TIN PHIEU DAT PHONG ===");
        System.out.print("Nhap ma phieu: ");
        maDatPhong = sc.nextLine();

        System.out.print("Nhap ma khach hang: ");
        String maKh = sc.nextLine();
        kh = new KhachHang();
        kh.setMaKH(maKh);

        System.out.print("Nhap ma nhan vien: ");
        String maNV = sc.nextLine();
        nv = new NhanVien();
        nv.setMaNV(maNV);

        while (true) {
            try {
                System.out.print("Nhap ngay dat phong (dd/MM/yyyy): ");
                String ngayDPStr = sc.nextLine().trim();
                ngayDP = LocalDate.parse(ngayDPStr, f);

                System.out.print("Nhap ngay tra phong (dd/MM/yyyy): ");
                String ngayTPStr = sc.nextLine().trim();
                ngayTP = LocalDate.parse(ngayTPStr, f);

                if (ngayTP.isBefore(ngayDP)) {
                    System.out.println("Ngay tra phong phai sau ngay dat phong! Nhap lai.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println(" Dinh dang ngay khong hop le! Vui long nhap lai theo dang dd/MM/yyyy.");
            }
        }

        System.out.print("Nhap so luong phong muon dat: ");
        sl_Phong = sc.nextInt();
        sc.nextLine();

        dsMaPhong = new String[sl_Phong];
        for (int i = 0; i < sl_Phong; i++) {
            System.out.print("Nhap ma phong thu " + (i + 1) + ": ");
            String maPhong = sc.nextLine();
            Phong p = dsp.timPhongTheoMa(maPhong);

            if (p == null) {
                System.out.println("Ma phong khong ton tai!");
                i--;
                continue;
            }

            boolean trung = false;
            for (int j = 0; j < i; j++) {
                if (dsMaPhong[j].equalsIgnoreCase(maPhong)) {
                    trung = true;
                    break;
                }
            }
            if (trung) {
                System.out.println("Phong nay da duoc chon trong phieu! Nhap phong khac.");
                i--;
                continue;
            }
        }

        tinhTongTien(dsp);
    }

    public void tinhTongTien(DSP dsp) {
        if (dsMaPhong == null || dsMaPhong.length == 0)
            return;

        long soNgayThue = ChronoUnit.DAYS.between(ngayDP, ngayTP);
        if (soNgayThue == 0)
            soNgayThue = 1;

        tongTien = 0;
        for (String maPhong : dsMaPhong) {
            Phong p = dsp.timPhongTheoMa(maPhong);
            if (p == null)
                continue;

            float giaPhong = p.getDG();
            if (p instanceof PhongThuong) {
                PhongThuong pt = (PhongThuong) p;
                giaPhong += pt.getDVNT() + pt.getPhiDuaDon();
            }
            tongTien += giaPhong * soNgayThue;
        }
    }

    public void xuat() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-10s\n", "Ma dat phong", "Ngay dat", "Ngay tra",
                "Ma KH", "Ma NV", "So phong", "Tong tien");
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15d %-10.0f\n", getMaDP(), getNgayDP().format(formatter),
                getNgayTP().format(formatter), getKhachHang().getMaKH(), getNV().getMaNV(), getSl(), getTong());
        System.out.print("Danh sach ma phong: ");
        for (String ma : dsMaPhong)
            System.out.print(ma + " ");
        System.out.println();
    }

}