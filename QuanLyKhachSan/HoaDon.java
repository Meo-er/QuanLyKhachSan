package QuanLyKhachSan;

import java.util.Arrays;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class HoaDon {
    private String maHD, maDP, maNV;
    private LocalDateTime thoiGianTaoHD;
    private LocalDate ngayDP, ngayTP;
    private double tongtienDP, tongtienDV;
    private double tongcong;
    private ChiTietHoaDon[] dsct = new ChiTietHoaDon[0];

    public HoaDon() {
        this.thoiGianTaoHD = LocalDateTime.now();
    };

    public HoaDon(String maHD, String maDP, String maNV, LocalDate ngayDP, LocalDate ngayTP, double tongtienDP,
            double tongtienDV) {
        this.maHD = maHD;
        this.maDP = maDP;
        this.maNV = maNV;
        this.ngayDP = ngayDP;
        this.ngayTP = ngayTP;
        this.tongtienDP = tongtienDP;
        this.tongtienDV = tongtienDV;
        this.tongcong = tongtienDP + tongtienDV;
        this.thoiGianTaoHD = LocalDateTime.now();
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

    public void setTongCong(double tongcong) {
        this.tongcong = tongcong;
    }

    public long tinhSoNgay() {
        return java.time.temporal.ChronoUnit.DAYS.between(ngayDP, ngayTP);
    }

    public void tinhTongCong() {
        {
            tongtienDP = 0;
            tongtienDV = 0;
            for (ChiTietHoaDon ct : dsct) {
                if ("PHONG".equalsIgnoreCase(ct.getLoai()))
                    tongtienDP += ct.getThanhTien();
                else
                    tongtienDV += ct.getThanhTien();

            }
            this.tongcong = tongtienDP + tongtienDV;
        }
    }

    public void themChiTiet(ChiTietHoaDon ct) {
        dsct = Arrays.copyOf(dsct, dsct.length + 1);
        dsct[dsct.length - 1] = ct;
        tinhTongCong();
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.print("Nhap ma hoa don: ");
        maHD = sc.nextLine();
        System.out.print("Nhap ma phieu dat phong: ");
        maDP = sc.nextLine();
        System.out.print("Nhap ma nhan vien lap hoa don: ");
        maNV = sc.nextLine();
        System.out.print("Nhap ngay dat phong (dd/MM/yyyy): ");
        ngayDP = LocalDate.parse(sc.nextLine(), formatter);
        System.out.print("Nhap ngay tra phong (dd/MM/yyyy): ");
        ngayTP = LocalDate.parse(sc.nextLine(), formatter);
        System.out.print("Nhap so luong chi tiet hoa don: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Chi tiet thu " + (i + 1) + " ---");
            ChiTietHoaDon ct = new ChiTietHoaDon();
            ct.nhap(maHD);
            themChiTiet(ct);
        }
        thoiGianTaoHD = LocalDateTime.now();
    }

    public void xuat() {
        DateTimeFormatter tg = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println("\n\t\t\t\t\t==========HOA DON==========");
        System.out.println("Ngay lap hoa don: "
                + this.getThoiGianTaoHD().format(tg) + "\nMa HD: " + this.getMaHD() + "\t Ma DP: " + this.getMaDP()
                + "\t Ma NV: " + this.getMaNV()
                + "\t Ngay DP: " + this.getNgayDP() + "\t Ngay TP: " + this.getNgayTP() + "\t Tien DP: "
                + this.getTTDP() + "\t Tien DV: " + this.getTTDV() + "\tTong cong: " + this.getTongCong());
        System.out.println("\t\t\t\t\t==========CHI TIET HOA DON==========");
        System.out.printf("%-12s %-12s %-12s %-12s %-12s\n",
                "Loai", "Ma", "Don gia", "SL", "Thanh tien");
        for (ChiTietHoaDon ct : dsct) {
            ct.xuat();
        }
    }

    @Override
    public String toString() {
        return maHD + "," + maDP + "," + maNV + "," + ngayDP + "," + ngayTP + "," + tongtienDP + "," + tongtienDV;
    }

    public static void main(String[] args) {
        HoaDon hd = new HoaDon();
        hd.nhap();
        hd.xuat();
    }
}
