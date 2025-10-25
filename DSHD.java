package Doan;

import java.util.Arrays;
import java.util.Scanner;

public class DSHD {
    private HoaDon[] dshd;
    private int soluong;

    public DSHD() {
        dshd = new HoaDon[0];
        soluong = 0;
    }

    public DSHD(HoaDon[] dshd, int soluong) {
        this.dshd = dshd;
        this.soluong = soluong;
    }

    public boolean maTonTai(String maTonTai) {
        for (int i = 0; i < soluong; i++) {
            if (dshd[i].getMaHD().equals(maTonTai))
                return true;
        }
        return false;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        soluong = 0;
        while (true) {
            System.out.print("Nhap so luong hoa don: ");
            try {
                soluong = sc.nextInt();
                if (soluong < 0)
                    System.out.println("So luong khong hop le! Vui long nhap lai: ");
                else
                    break;
            } catch (Exception e) {
                System.out.println("Ban phai nhap so nguyen! Vui long nhap lai: ");
                sc.nextLine();
            }

        }
        for (int i = 0; i < soluong; i++) {
            System.out.println("Nhan vien thu " + (i + 1) + ": ");
            HoaDon hd = new HoaDon();
            hd.nhap();
            if (maTonTai(hd.getMaHD())) {
                System.out.println("Ma HD da ton tai, khong them vao danh sach.\n\nVui long nhap lai: ");
                i--;
            } else {
                dshd = Arrays.copyOf(dshd, dshd.length + 1);
                dshd[dshd.length - 1] = hd;

            }
            soluong = dshd.length;
        }
    }

    public void them(HoaDon hdMoi) {
        dshd = Arrays.copyOf(dshd, dshd.length + 1);
        dshd[soluong] = hdMoi;
        soluong++;

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
            System.out.println("Hoa don thu " + (soluong + 1));
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
        for (int i = 0; i < soluong; i++) {
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
        for (int i = 0; i < soluong; i++) {
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
        for (int i = 0; i < soluong; i++) {
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
        for (int i = 0; i < soluong; i++) {
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
        for (int i = 0; i < soluong; i++) {
            if (dshd[i].getMaHD().equals(maCanXoa)) {
                for (int j = i; j < soluong - 1; j++) {
                    dshd[j] = dshd[j + 1];
                }
                soluong--;
                dshd = Arrays.copyOf(dshd, soluong);
                System.out.println("Xoa hoa don " + maCanXoa + " thanh cong!");

                return;
            }

        }
        System.out.println("Khong tim thay hoa don co ma " + maCanXoa);
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
                    if (dsTimThay.soluong > 0)
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
                    break;
                case 2:
                    System.out.println("\t\t\t\t\t==========THEM HOA DON==========");
                    them();
                    break;
                case 3:
                    System.out.println("\t\t\t\t\t==========SUA HOA DON==========");
                    System.out.print("Nhap ma can sua: ");
                    String maCanSua = sc.nextLine();
                    sua(maCanSua);
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
                    System.out.println("Đang làm, nào xong t gửi sau.");
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
        for (int i = 0; i < soluong; i++) {
            dshd[i].xuat();
        }
    }

    public static void main(String[] args) {
        DSHD dshd = new DSHD();
        HoaDon hd1 = new HoaDon("01", "01", "01");
        dshd.them(hd1);
        dshd.menuHoaDon();
    }
}
