package QuanLyKhachSan;

import java.util.Scanner;
import java.time.LocalDate;
import java.util.Arrays;
import java.time.format.DateTimeFormatter;

public class DSPhieuDatPhong {
    private PhieuDatPhong[] ds = new PhieuDatPhong[0];
    int soLuong = 0;
    private DSP dsp;

    public DSPhieuDatPhong() {
        ds = new PhieuDatPhong[0];
        soLuong = 0;
    }

    public DSPhieuDatPhong(DSP dsp) {
        this.dsp = dsp;
    }

    public DSPhieuDatPhong(PhieuDatPhong[] dsPDP, int sl) {
        this.ds = dsPDP;
        soLuong = sl;
    }

    public DSPhieuDatPhong(DSPhieuDatPhong d) {
        this.ds = d.ds;
        this.soLuong = d.soLuong;
    }

    public boolean maTonTai(String maDaCo) {
        for (int i = 0; i < soLuong; i++) {
            if (ds[i].getMaDP().equals(maDaCo)) {
                return true;
            }
        }
        return false;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);

        int soLuong = 0;
        while (true) {
            System.out.print("Nhap so luong phieu dat phong:");
            try {
                soLuong = sc.nextInt();
                sc.nextLine();
                if (soLuong <= 0) {
                    System.out.println("So luong khong hop le. Vui long nhap lai!");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ban phai nhap lai so nguyen. Vui long nhap lai!");
                sc.nextLine();
            }
        }

        for (int i = 0; i < soLuong; i++) {
            System.out.println("Phieu dat phong thu " + (i + 1) + ":");

            PhieuDatPhong pdp = new PhieuDatPhong();
            pdp.nhap(dsp);

            if (maTonTai(pdp.getMaDP())) {
                System.out.println("Ma dat phong da ton tai!");
                i--;
            } else {
                ds = Arrays.copyOf(ds, ds.length + 1);
                ds[ds.length - 1] = pdp;
            }
        }

        this.soLuong = ds.length;
    }

    public void them(PhieuDatPhong pdp1) {
        ds = Arrays.copyOf(ds, ds.length + 1);
        ds[soLuong] = pdp1;
        soLuong++;
    }

    public void them() {
        Scanner sc = new Scanner(System.in);
        int them = 0;
        while (true) {
            System.out.println("Nhap so luong can them:");
            try {
                them = sc.nextInt();
                if (them < 0) {
                    System.out.println("So luong khong hop le. Vui long nhap lai!");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Yeu cau nhap so nguyen. Vui long nhap lai!");
                sc.nextLine();
            }
        }
        for (int i = 0; i < them; i++) {
            System.out.println("Phieu dat phong thu" + (soLuong + 1) + ":");
            PhieuDatPhong pdp1 = new PhieuDatPhong();
            pdp1.nhap(this.dsp);
            if (maTonTai(pdp1.getMaDP())) {
                System.out.println("Ma dat phong da ton tai");
                i--;
            } else {
                them(pdp1);
            }
        }
    }

    public PhieuDatPhong timTheoMaDP(String maCanTim) {
        for (int i = 0; i < soLuong; i++) {
            if (ds[i].getMaDP().equals(maCanTim)) {
                System.out.printf(" %-15s %-15s %-15s %-15s %-10s\n", "Ngay dat", "Ngay tra", "Ma KH", "Ma NV",
                        "So phong", "Tong tien");
                return ds[i];
            }
        }
        return null;
    }

    public DSPhieuDatPhong timTheoMaKh(String maCanTim) {
        DSPhieuDatPhong dsTimThay = new DSPhieuDatPhong();
        for (int i = 0; i < soLuong; i++) {
            if (ds[i].getKhachHang().getMaKH().equals(maCanTim)) {
                dsTimThay.them(ds[i]);
            }
        }
        return dsTimThay;
    }

    public DSPhieuDatPhong timTheoMaNV(String maCanTim) {
        DSPhieuDatPhong dsTimThay = new DSPhieuDatPhong();
        for (int i = 0; i < soLuong; i++) {
            if (ds[i].getNV().getMaNV().equals(maCanTim)) {
                dsTimThay.them(ds[i]);
            }
        }
        return dsTimThay;
    }

    public void sua(String maCanSua) {
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean found = false;
        for (int i = 0; i < soLuong; i++) {
            if (ds[i].getMaDP().equals(maCanSua)) {
                found = true;
                do {
                    ds[i].xuat();
                    System.out.printf("%-10s %-10s %-15s %-15s", "Lua chon:", "0.Thoat", "1.Ma Khach Hang",
                            "2.Ma Nhan Vien");
                    choice = sc.nextInt();
                    sc.nextLine();
                    switch (choice) {
                        case 1:
                            System.out.println("Nhap ma khach hang moi:");
                            String maKHmoi = sc.nextLine();
                            KhachHang khMoi = new KhachHang();
                            khMoi.setMaKH(maKHmoi);
                            ds[i].setKhachHang(khMoi);
                            System.out.println("Thay doi thanh cong");
                            break;
                        case 2:
                            System.out.println("Nhap ma nhan vien moi:");
                            String maNVmoi = sc.nextLine();
                            NhanVien nvMoi = new NhanVien();
                            nvMoi.setMaNV(maNVmoi);
                            ds[i].setNV(nvMoi);
                            System.out.println("Thay doi thanh cong");
                            break;
                        case 0:
                            break;

                        default:
                            System.out.println("Lua cho khong hop le");

                    }
                } while (choice != 0);
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay ma " + maCanSua);
        }
    }

    public void xoa(String maCanXoa, DSP dsp) {
        for (int i = 0; i < soLuong; i++) {
            if (ds[i].getMaDP().equals(maCanXoa)) {

                String[] dsMa = ds[i].getDsMaPhong();
                for (String maPhong : dsMa) {
                    Phong p = dsp.timPhongTheoMa(maPhong);
                    if (p != null) {
                        p.setTT(true);
                    }
                }
                for (int j = i; j < soLuong - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                soLuong--;
                ds = Arrays.copyOf(ds, soLuong);
                System.out.println("Da xoa phieu va mo lai cac phong lien quan!");
                return;
            }
        }
        System.out.println("Khong tim thay ma can xoa!");
    }

    public void tkSL_Phong() {
        int tongPT = 0;
        int tongPV = 0;

        for (PhieuDatPhong pdp : ds) {
            String[] danhSachMa = pdp.getDsMaPhong();
            if (danhSachMa == null)
                continue;
            for (String maPhong : danhSachMa) {
                Phong p = dsp.timPhongTheoMa(maPhong);
                if (p instanceof PhongThuong)
                    tongPT++;
                else if (p instanceof PhongVip)
                    tongPV++;
            }
        }

        System.out.println("Thong ke so luong phong da dat:");
        System.out.println("Phong thuong: " + tongPT);
        System.out.println("Phong vip: " + tongPV);
        System.out.println("Tong cong: " + (tongPT + tongPV));
    }

    public void tkTong_Doanhthu() {
        float tong = 0;
        for (PhieuDatPhong pdp : ds) {
            tong += pdp.getTong();
        }
        System.out.println("Tong doanh thu:" + tong);
    }

    public void tkNhanvien() {
        for (int i = 0; i < ds.length; i++) {
            String maNVien = ds[i].getNV().getMaNV();
            boolean daThongKe = false;

            for (int j = 0; j < i; j++) {
                if (ds[j].getNV().getMaNV().equals(maNVien)) {
                    daThongKe = true;
                    break;
                }
            }

            if (!daThongKe) {
                int dem = 0;
                for (PhieuDatPhong pdp : ds) {
                    if (pdp.getNV().getMaNV().equals(maNVien))
                        dem++;
                }
                System.out.println("Nhan vien " + maNVien + " da lap " + dem + " phieu dat phong.");
            }
        }
    }

    public void tkKhachhang() {
        for (int i = 0; i < ds.length; i++) {
            String maKH = ds[i].getKhachHang().getMaKH();
            boolean daTKe = false;

            for (int j = 0; j < i; j++) {
                if (ds[j].getKhachHang().getMaKH().equals(maKH)) {
                    daTKe = true;
                    break;
                }
            }

            if (!daTKe) {
                float tongTien = 0;
                for (PhieuDatPhong pdp : ds) {
                    if (pdp.getKhachHang().getMaKH().equals(maKH))
                        tongTien += pdp.getTong();
                }
                System.out.printf(" Khach hang %s co tong chi tieu la: %.2f", maKH, tongTien);
            }
        }
    }

    public DSPhieuDatPhong TkTheoKhoangNgay(LocalDate tuNgay, LocalDate denNgay) {
        DSPhieuDatPhong kq = new DSPhieuDatPhong();
        for (PhieuDatPhong pdp : ds) {
            if (!pdp.getNgayDP().isBefore(tuNgay) && !pdp.getNgayDP().isAfter(denNgay)) {
                kq.them(pdp);
            }
        }
        return kq;
    }

    public void menuTimKiem() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n\t\t\t\t\t==========MENU TIM KIEM==========");

            System.out.printf("%-10s %-10s %-10s %-10s %-10s\n", "Lua chon:", "0.Thoat", "1. Ma Dat Phong",
                    "2. Ma Khach Hang", "3. Ma Nhan Vien");
            System.out.print("Nhap lua chon: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhap ma dat phong can tim: ");
                    String maDPCanTim = sc.nextLine();
                    PhieuDatPhong timThay = timTheoMaDP(maDPCanTim);
                    if (timThay != null)
                        timThay.xuat();
                    else
                        System.out.println("Khong tim thay ma dat phong " + maDPCanTim + ".");
                    break;
                case 2:
                    System.out.print("Nhap ma Khach Hang can tim: ");
                    String maKHCanTim = sc.nextLine();
                    DSPhieuDatPhong dsTimTheoKH = timTheoMaKh(maKHCanTim);
                    if (dsTimTheoKH.soLuong > 0)
                        dsTimTheoKH.xuat();
                    else
                        System.out.println("Khong tim thay phieu dat phong cua ma khach hang " + maKHCanTim + ".");
                    break;
                case 3:
                    System.out.print("Nhap ma Nhan Vien can tim: ");
                    String maNVCanTim = sc.nextLine();
                    DSPhieuDatPhong dsTimThay = timTheoMaNV(maNVCanTim);
                    if (dsTimThay.soLuong > 0)
                        dsTimThay.xuat();
                    else
                        System.out.println("Khong tim thay hoa don cua nhan vien " + maNVCanTim + ".");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 0);

    }

    public void menuThongKe() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n\t\t\t\t\t==========MENU THONG KE==========");
            System.out.println(
                    "Lua chon: \n0.Thoat \n1.Thong ke so luong phong da dat \n2.Thong ke tong doanh thu \n3.Thong ke theo nhan vien \n4.Thong ke theo khach hang \n5.Thong ke theo ngay");
            System.out.print("Nhap lua chon:");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    tkSL_Phong();
                    break;
                case 2:
                    tkTong_Doanhthu();
                    break;
                case 3:
                    tkNhanvien();
                    break;
                case 4:
                    tkKhachhang();
                    break;
                case 5:
                    DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate tu = null, den = null;

                    try {
                        System.out.print("Nhap tu ngay (dd/MM/yyyy): ");
                        String tuNgayStr = sc.nextLine().trim();
                        tu = LocalDate.parse(tuNgayStr, f);

                        System.out.print("Nhap den ngay (dd/MM/yyyy): ");
                        String denNgayStr = sc.nextLine().trim();
                        den = LocalDate.parse(denNgayStr, f);

                        if (den.isBefore(tu)) {
                            System.out.println(" Ngay ket thuc phai sau ngay bat dau!");
                        } else {
                            DSPhieuDatPhong kq = TkTheoKhoangNgay(tu, den);
                            System.out.println("Cac phieu trong khoang ngay:");
                            kq.xuat();
                        }
                    } catch (Exception e) {
                        System.out.println(" Dinh dang ngay khong hop le! Vui long nhap lai theo dang dd/MM/yyyy.");
                    }
                    break;
                case 0:
                    System.out.print("Da thoat thong ke.");
                    break;

                default:
                    System.out.print("Lua chon khong hop le. Vui long nhap lai!!!");
                    break;
            }
        } while (choice != 0);
    }

    public void menuPDP() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n\t\t\t\t\t==========MENU PHIEU DAT PHONG==========");

            System.out.println(
                    "Lua chon: \n0.Thoat \n1. Nhap phieu dat phong \n2. Xem danh sach phieu dat phong \n3. Them phieu dat phong \n4. Sua phieu dat phong \n5. Xoa phieu dat phong \n6. Tim kiem phieu dat phong \n7. Thong ke.");
            System.out.print("Nhap lua chon: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("\t\t\t\t\t==========NHAP DANH SACH PHIEU DAT PHONG==========");
                    dspdp.nhap();
                    break;
                case 2:
                    System.out.println("\t\t\t\t\t==========DANH SACH PHIEU DAT PHONG==========");
                    dspdp.xuat();
                    break;
                case 3:
                    System.out.println("\t\t\t\t\t==========THEM PHIEU DAT PHONG==========");
                    dspdp.them();
                    dspdp.ghiFile();
                    break;
                case 4:
                    System.out.println("\t\t\t\t\t==========SUA PHIEU DAT PHONG==========");
                    System.out.print("Nhap ma can sua: ");
                    String maCanSua = sc.nextLine();
                    dspdp.sua(maCanSua);
                    dspdp.ghiFile();
                    break;
                case 5:
                    System.out.println("\t\t\t\t\t==========XOA PHIEU DAT PHONG==========");
                    System.out.print("Nhap ma can xoa: ");
                    String maCanXoa = sc.nextLine();
                    DSP dsp = new DSP();
                    dspdp.xoa(maCanXoa, dsp);
                    dspdp.ghiFile();
                    break;
                case 6:
                    dspdp.menuTimKiem();
                    break;
                case 7:
                    dspdp.menuThongKe();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lua chon khong hop le!");

            }
        } while (choice != 0);

    }

    public void xuat() {
        if (soLuong == 0) {
            System.out.println("Danh sach phieu dat phong trong!");
            return;
        }
        System.out.println(
                "----------------------------------------------------------------------------------------------");

        for (PhieuDatPhong pdp : ds) {
            pdp.xuat();
        }
        System.out.println(
                "----------------------------------------------------------------------------------------------");
    }

}
