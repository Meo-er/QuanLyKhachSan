package Doan;

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
        System.out.print("Nhap so luong hoa don: ");
        soLuong = sc.nextInt();
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
        dshd[dshd.length - 1] = hdMoi;
        soLuong++;

    }

    public void them() {
        Scanner sc = new Scanner(System.in);
        int them = 0;
        System.out.print("Nhap so luong can them: ");

        them = sc.nextInt();
        sc.nextLine();

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
        for (HoaDon hd : dshd) {
            if (hd.getMaHD().equals(maCanTim))
                return hd;
        }
        return null;
    }

    public HoaDon timTheoMaDP(String maCanTim) {
        for (HoaDon hd : dshd) {
            if (hd.getMaDP().equals(maCanTim))
                return hd;
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

    public void sua() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma HD can sua: ");
        String maCanSua = sc.nextLine();
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

    public void xoa() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma HD can xoa: ");
        String maCanXoa = sc.nextLine();
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

    public void menuHoaDon() {
        Scanner sc = new Scanner(System.in);
        int luaChon;
        do {
            System.out.println("\n\t\t\t\t\t==========MENU HOA DON==========");

            System.out.println(
                    "Lua chon: \n0. Thoat \n1. Xem danh sach hoa don \n2. Them hoa don \n3. Sua hoa don \n4. Xoa hoa don \n5. Tim kiem hoa don \n6. Thong ke.");
            System.out.print("Nhap lua chon: ");
            luaChon = sc.nextInt();
            sc.nextLine();
            switch (luaChon) {
                case 1:
                    System.out.println("\t\t\t\t\t==========DANH SACH HOA DON==========");
                    xuat();
                    ghiFile();
                    break;
                case 2:
                    System.out.println("\t\t\t\t\t==========THEM HOA DON==========");
                    them();
                    ghiFile();
                    break;
                case 3:
                    System.out.println("\t\t\t\t\t==========SUA HOA DON==========");
                    System.out.print("Nhap ma can sua: ");
                    sua();
                    ghiFile();
                    break;
                case 4:
                    System.out.println("\t\t\t\t\t==========XOA HOA DON==========");
                    System.out.print("Nhap ma can xoa: ");
                    String maCanXoa = sc.nextLine();
                    xoa(maCanXoa);
                    break;
                case 5:
                    menuTimKiem();
                    break;
                case 6:
                    System.out.println("\t\t\t\t\t==========THONG KE DOANH THU==========");
                    thongKeDoanhThuTheoNV();
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
        File file = new File("QuanLyKhachSan/src/Doan/Hoadon.txt");
        try (PrintWriter pw = new PrintWriter(file)) {
            for (HoaDon hd : dshd) {
                pw.println(hd.toString());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Loi ghi file!");

        }

    }

    public void docFile() {
        File file = new File("QuanLyKhachSan/src/Doan/Hoadon.txt");

        if (!file.exists()) {
            System.out.println("Khong tim thay file hoa don!");
        }

        try (Scanner sc = new Scanner(file)) {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 8) {
                    LocalDate ngayDP = LocalDate.parse(parts[3], fmt);
                    LocalDate ngayTP = LocalDate.parse(parts[4], fmt);
                    Double tongTienDP = Double.parseDouble(parts[5]);
                    Double tongTienDV = Double.parseDouble(parts[6]);
                    Double tongcong = Double.parseDouble(parts[7]);
                    HoaDon hd = new HoaDon(parts[0], parts[1], parts[2], ngayDP, ngayTP, tongTienDP, tongTienDV,
                            tongcong);
                    them(hd);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Loi doc file hoa don");
        }

    }

    public static void main(String[] args) {
        DSHD dshd = new DSHD();
        dshd.docFile();
        dshd.xuat();
        dshd.menuHoaDon();
        dshd.ghiFile();
    }

}
