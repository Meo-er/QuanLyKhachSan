package QuanLyKhachSan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class DSHD {
    private HoaDon[] dshd;
    private int soLuong;

    public DSHD() {
        dshd = new HoaDon[0];
        soLuong = 0;
    }

    public DSHD(HoaDon[] dshd, int soLuong) {
        this.dshd = dshd;
        this.soLuong = soLuong;
    }

    public boolean maTonTai(String maTonTai) {
        for (int i = 0; i < soLuong; i++) {
            if (dshd[i].getMaHD().equals(maTonTai))
                return true;
        }
        return false;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        soLuong = 0;
        while (true) {
            System.out.print("Nhap so luong hoa don: ");
            try {
                soLuong = sc.nextInt();
                if (soLuong < 0)
                    System.out.println("So luong khong hop le! Vui long nhap lai: ");
                else
                    break;
            } catch (Exception e) {
                System.out.println("Ban phai nhap so nguyen! Vui long nhap lai: ");
                sc.nextLine();
            }

        }
        dshd = new HoaDon[soLuong];
        for (int i = 0; i < soLuong; i++) {
            HoaDon hdMoi = new HoaDon();
            System.out.println("Hoa don thu " + (i + 1) + ": ");
            hdMoi.nhap();

            if (maTonTai(hdMoi.getMaHD())) {
                System.out.println("Ma hoa don da ton tai, vui long nhap lai!\n");
                i--;
            } else {
                dshd[i] = hdMoi;
            }
        }
    }

    public void them(HoaDon hdMoi) {
        dshd = Arrays.copyOf(dshd, dshd.length + 1);
        dshd[soLuong] = hdMoi;
        soLuong++;

    }

    public void them() {
        Scanner sc = new Scanner(System.in);
        int them = 0;
        while (true) {
            System.out.print("Nhap so luong can them: ");
            try {
                them = sc.nextInt();
                sc.nextLine();
                if (them < 0)
                    System.out.println("So luong khong hop le, vui long nhap lai: ");
                else
                    break;
            } catch (Exception e) {
                System.out.println("Ban phai nhap so nguyen! Vui long nhap lai: ");
                sc.nextLine();
            }
        }

        for (int i = 0; i < them; i++) {
            System.out.println("Hoa don thu " + (soLuong + 1));
            HoaDon hdMoi = new HoaDon();
            hdMoi.nhap();
            if (maTonTai(hdMoi.getMaHD())) {
                System.out.println("Ma HD da ton tai, khong them vao danh sach.\n\nVui long nhap lai: ");
                i--;
            } else
                them(hdMoi);
        }
    }

    public HoaDon timTheoMaHD(String maCanTim) {
        for (int i = 0; i < soLuong; i++) {
            if (dshd[i].getMaHD().equals(maCanTim)) {
                System.out.printf("%-10s %-10s %-10s %-15s %-15s %-15s %-15s %-15s %-25.22s ", "Ma HD", "Ma DP",
                        "Ma NV",
                        "Ngay dat phong", "Ngay tra phong", "Tong tien DP", "Tong tien DV", "Tong cong",
                        "Thoi gian tao hoa don");
                return dshd[i];
            }
        }
        return null;
    }

    public HoaDon timTheoMaDP(String maCanTim) {
        for (int i = 0; i < soLuong; i++) {
            if (dshd[i].getMaDP().equals(maCanTim)) {
                System.out.printf("%-10s %-10s %-10s %-15s %-15s %-15s %-15s %-15s %-25.22s ", "Ma HD", "Ma DP",
                        "Ma NV",
                        "Ngay dat phong", "Ngay tra phong", "Tong tien DP", "Tong tien DV", "Tong cong",
                        "Thoi gian tao hoa don");
                return dshd[i];
            }
        }
        return null;
    }

    public DSHD timTheoMaNV(String maCanTim) {
        DSHD dsTimThay = new DSHD();
        for (int i = 0; i < soLuong; i++) {
            if (dshd[i].getMaNV().equals(maCanTim)) {
                dsTimThay.them(dshd[i]);

            }
        }
        return dsTimThay;
    }

    public void sua(String maCanSua) {
        Scanner sc = new Scanner(System.in);
        int luaChon;
        boolean timThay = false;
        for (int i = 0; i < soLuong; i++) {
            if (dshd[i].getMaHD().equals(maCanSua)) {
                timThay = true;
                do {
                    dshd[i].xuat();
                    System.out.printf("%-10s %-10s %-10s %-10s\n",
                            "Lua chon: ", "0. Thoat", "1. Ma DP", "2. Ma NV");
                    luaChon = sc.nextInt();
                    sc.nextLine();
                    switch (luaChon) {
                        case 1:
                            System.out.print("Nhap ma DP moi: ");
                            String maDPMoi = sc.nextLine();
                            dshd[i].setMaDP(maDPMoi);
                            System.out.println("Thay doi thanh cong!");
                            break;
                        case 2:
                            System.out.print("Nhap ma NV moi: ");
                            String maNVMoi = sc.nextLine();
                            dshd[i].setMaNV(maNVMoi);
                            System.out.println("Thay doi thanh cong!");
                            break;
                        case 0:

                            break;
                        default:
                            System.out.println("Lua chon khong hop le!");
                    }
                } while (luaChon != 0);
                break;
            }

        }
        if (!timThay) {
            System.out.print("Khong tim thay hoa don co ma " + maCanSua + ".");
        }
    }

    public void xoa(String maCanXoa) {
        for (int i = 0; i < soLuong; i++) {
            if (dshd[i].getMaHD().equals(maCanXoa)) {
                for (int j = i; j < soLuong - 1; j++) {
                    dshd[j] = dshd[j + 1];
                }
                soLuong--;
                dshd = Arrays.copyOf(dshd, soLuong);
                System.out.println("Xoa hoa don " + maCanXoa + " thanh cong!");

                return;
            }

        }
        System.out.println("Khong tim thay hoa don co ma " + maCanXoa);
    }

    public void thongKeTongDoanhThu() {
        int tongHD = soLuong;
        double tongDoanhThu = 0;
        for (HoaDon hd : dshd) {
            tongDoanhThu += hd.getTongCong();
        }
        System.out.println("Tong so hoa don: " + tongHD);
        System.out.println("Tong doanh thu: " + tongDoanhThu);
        System.out.println("Doanh thu trung binh: " + tongDoanhThu / tongHD);

    }

    public void thongKeDoanhThuTheoNV() {
        String[] dsNV = new String[0];
        System.out.printf("%-10s %-20s", "Ma NV", "Doanh thu");
        for (HoaDon hd1 : dshd) {
            String maNV = hd1.getMaNV();
            boolean tonTai = false;
            for (String s : dsNV) {
                if (s.equals(maNV)) {
                    tonTai = true;
                    break;
                }
            }
            if (!tonTai) {
                int tong = 0;
                for (HoaDon hd2 : dshd) {
                    tong += hd2.getTongCong();
                }
                System.out.printf("\n%-10s %-20s", maNV, tong);

            }
            dsNV = Arrays.copyOf(dsNV, dsNV.length + 1);
            dsNV[dsNV.length - 1] = maNV;
        }
    }

    public void menuTimKiem() {
        Scanner sc = new Scanner(System.in);
        int luaChon;
        do {
            System.out.println("\n\t\t\t\t\t==========MENU TIM KIEM==========");

            System.out.printf("%-10s %-10s %-10s %-10s %-10s\n", "Lua chon:", "0. Thoat", "1. Ma HD",
                    "2. Ma DP",
                    "3. Ma NV");
            System.out.print("Nhap lua chon: ");
            luaChon = sc.nextInt();
            sc.nextLine();

            switch (luaChon) {
                case 1:
                    System.out.print("Nhap ma HD can tim: ");
                    String maHDCanTim = sc.nextLine();
                    HoaDon timThay = timTheoMaHD(maHDCanTim);
                    if (timThay != null)
                        timThay.xuat();
                    else
                        System.out.println("Khong tim thay hoa don " + maHDCanTim + ".");
                    break;
                case 2:
                    System.out.print("Nhap ma DP can tim: ");
                    String maDPCanTim = sc.nextLine();
                    timThay = timTheoMaDP(maDPCanTim);
                    if (timThay != null)
                        timThay.xuat();
                    else
                        System.out.println("Khong tim thay hoa don cua ma dat phong " + maDPCanTim + ".");
                    break;
                case 3:
                    System.out.print("Nhap ma NV can tim: ");
                    String maNVCanTim = sc.nextLine();
                    DSHD dsTimThay = timTheoMaNV(maNVCanTim);
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
        } while (luaChon != 0);

    }

    public void xuat() {
        System.out.printf("%-10s %-10s %-10s %-15s %-15s %-15s %-15s %-15s %-15s\n", "Ma HD", "Ma DP", "Ma NV",
                "Ngay dat phong", "Ngay tra phong", "Tong tien DP", "Tong tien DV", "Tong cong",
                "Thoi gian tao hoa don");
        for (int i = 0; i < soLuong; i++) {
            dshd[i].xuat();
        }
    }

    public void ghiFile() {
        File file = new File("QuanLyKhachSan/src/Doan/HoaDon.txt");
        try (PrintWriter pw = new PrintWriter(file)) {
            for (HoaDon hd : dshd) {
                pw.println(hd.toString());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Loi ghi file!");

        }

    }

    public void docFile() {
        File file = new File("QuanLyKhachSan/src/Doan/HoaDon.txt");
        if (!file.exists()) {
            System.out.println("Khong tim thay file!");
        }
        try (Scanner sc = new Scanner(file)) {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 7) {
                    LocalDate ngayDP = LocalDate.parse(parts[3], fmt);
                    LocalDate ngayTP = LocalDate.parse(parts[4], fmt);
                    Double tongTienDP = Double.parseDouble(parts[5]);
                    Double tongTienDV = Double.parseDouble(parts[6]);
                    HoaDon hd = new HoaDon(parts[0], parts[1], parts[2], ngayDP, ngayTP, tongTienDP, tongTienDV);
                    dshd = Arrays.copyOf(dshd, dshd.length + 1);
                    dshd[dshd.length - 1] = hd;
                    soLuong++;

                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Loi doc file");
        }
    }

    // public static void main(String[] args) {
    // DSHD dshd = new DSHD();
    // dshd.docFile();
    // dshd.xuat();

    // }

}
