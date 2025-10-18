package Doan;

import java.util.Arrays;
import java.util.Scanner;

public class DSNV {
    private NhanVien[] dsnv;
    private int soluong;

    public DSNV() {
        dsnv = new NhanVien[0];
        soluong = 0;
    }

    public DSNV(NhanVien[] dsnv, int soluong) {
        this.dsnv = dsnv;
        this.soluong = soluong;

    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong nhan vien: ");
        soluong = sc.nextInt();
        for (int i = 0; i < soluong; i++) {
            dsnv = Arrays.copyOf(dsnv, dsnv.length + 1);
            System.out.println("Nhan vien thu " + (i + 1) + ": ");
            dsnv[i] = new NhanVien();
            dsnv[i].nhap();
        }
    }

    public void them(NhanVien nvMoi) {
        dsnv = Arrays.copyOf(dsnv, dsnv.length + 1);
        dsnv[soluong] = nvMoi;
        soluong++;

    }

    public void them() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong can them: ");
        int them = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < them; i++) {
            System.out.println("Nhan vien thu " + (soluong + 1));
            NhanVien nvMoi = new NhanVien();
            nvMoi.nhap();
            them(nvMoi);
        }
    }

    public NhanVien timNVTheoMa(String maCanTim) {
        for (int i = 0; i < soluong; i++) {
            if (dsnv[i].getmanv().equals(maCanTim)) {
                return dsnv[i];
            }
        }
        System.out.println("Khong tim thay ma " + maCanTim);
        return null;
    }

    public DSNV timNVTheoHo(String hoCanTim) {
        DSNV dsTimThay = new DSNV();
        for (int i = 0; i < soluong; i++) {
            if (dsnv[i].getHo().equalsIgnoreCase(hoCanTim)) {
                dsTimThay.them(dsnv[i]);
            }
        }
        if (dsTimThay.soluong == 0)
            System.out.println("Khong tim thay nhan vien " + hoCanTim);
        return dsTimThay;
    }

    public DSNV timNVTheoTen(String tenCanTim) {
        DSNV dsTimThay = new DSNV();
        for (int i = 0; i < soluong; i++) {
            if (dsnv[i].getTen().equalsIgnoreCase(tenCanTim)) {
                dsTimThay.them(dsnv[i]);
            }
        }
        if (dsTimThay.soluong == 0)
            System.out.println("Khong tim thay nhan vien " + tenCanTim);
        return dsTimThay;
    }

    public DSNV timNVTheoHoTen(String hoCanTim, String tenCanTim) {
        DSNV dsTimThay = new DSNV();
        for (int i = 0; i < soluong; i++) {
            if (dsnv[i].getHo().equalsIgnoreCase(hoCanTim) && dsnv[i].getTen().equalsIgnoreCase(tenCanTim)) {
                dsTimThay.them(dsnv[i]);
            }
        }
        if (dsTimThay.soluong == 0)
            System.out.println("Khong tim thay nhan vien " + hoCanTim + " " + tenCanTim);
        return dsTimThay;
    }

    public DSNV timNVTheoChucVu(String chucVuCanTim) {
        DSNV dsTimThay = new DSNV();
        for (int i = 0; i < soluong; i++) {
            if (dsnv[i].getchucvu().equalsIgnoreCase(chucVuCanTim)) {
                dsTimThay.them(dsnv[i]);

            }
        }
        if (dsTimThay.soluong == 0)
            System.out.println("Khong tim thay nhan vien co chuc vu " + chucVuCanTim);
        return dsTimThay;
    }

    public void sua(String maCanSua) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < soluong; i++) {
            if (dsnv[i].getmanv().equals(maCanSua)) {
                dsnv[i].xuat();
                System.out.printf("%-10s %-10s %-10s %-10s %-15s %-15s \n",
                        "Lua chon: ", "0.Thoat", "1.Ho", "2.Ten", "3.Chuc vu", "4.Luong");
                int luaChon = sc.nextInt();
                sc.nextLine();
                switch (luaChon) {
                    case 1:
                        System.out.print("Nhap ho moi: ");
                        String hoMoi = sc.nextLine();
                        dsnv[i].setHo(hoMoi);
                        System.out.println("Thay doi thanh cong!");
                        break;
                    case 2:
                        System.out.print("Nhap ten moi: ");
                        String tenMoi = sc.nextLine();
                        dsnv[i].setTen(tenMoi);
                        System.out.println("Thay doi thanh cong!");
                        break;
                    case 3:
                        System.out.print("Nhap chuc vu moi: ");
                        String chucVuMoi = sc.nextLine();
                        dsnv[i].setchucvu(chucVuMoi);
                        System.out.println("Thay doi thanh cong!");
                        break;
                    case 4:
                        System.out.print("Nhap luong moi: ");
                        double luongMoi = sc.nextDouble();
                        dsnv[i].setLuong(luongMoi);
                        System.out.println("Thay doi thanh cong!");
                        break;
                    case 0:

                        break;
                    default:
                        System.out.println("Lua chon khong hop le!");
                }
                while (luaChon != 0)
                    return;

            }

        }
        System.out.print("Khong tim thay nhan vien co ma " + maCanSua);

    }

    public void xoa(String maCanXoa) {
        for (int i = 0; i < soluong; i++) {
            if (dsnv[i].getmanv().equals(maCanXoa)) {
                for (int j = i; j < soluong - 1; j++) {
                    dsnv[j] = dsnv[j + 1];

                }
                soluong--;
                dsnv = Arrays.copyOf(dsnv, soluong);
                return;
            }

        }
        System.out.println("Khong tim thay nhan vien co ma: " + maCanXoa);
    }

    public void menuTimKiem() {
        Scanner sc = new Scanner(System.in);
        int luaChon;
        do {
            System.out.println("\n\t\t\t\t\t==========MENU TIM KIEM==========");

            System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s\n", "Lua chon:", "0.Thoat", "1.Ma NV", "2.Ho",
                    "3.Ten",
                    "4.Ho Ten", " 5.Chuc vu");
            System.out.print("Nhap lua chon: ");
            luaChon = sc.nextInt();
            sc.nextLine();

            switch (luaChon) {
                case 1:
                    System.out.print("Nhap ma can tim: ");
                    String maCanTim = sc.nextLine();
                    NhanVien timThay = timNVTheoMa(maCanTim);
                    timThay.xuat();
                    break;
                case 2:
                    System.out.print("Nhap ho can tim: ");
                    String hoCanTim = sc.nextLine();
                    timNVTheoHo(hoCanTim);
                    DSNV dsTimThay = timNVTheoHo(hoCanTim);
                    dsTimThay.xuat();
                    break;
                case 3:
                    System.out.print("Nhap ten can tim: ");
                    String tenCanTim = sc.nextLine();
                    timNVTheoTen(tenCanTim);
                    dsTimThay = timNVTheoTen(tenCanTim);
                    dsTimThay.xuat();
                    break;
                case 4:
                    System.out.print("Nhap ho, ten can tim: ");
                    System.out.print("Ho: ");
                    hoCanTim = sc.nextLine();
                    System.out.print("Ten: ");
                    tenCanTim = sc.nextLine();
                    dsTimThay = timNVTheoHoTen(hoCanTim, tenCanTim);
                    dsTimThay.xuat();
                    break;
                case 5:
                    System.out.print("Nhap chuc vu can tim: ");
                    String chucVuCanTim = sc.nextLine();
                    dsTimThay = timNVTheoChucVu(chucVuCanTim);
                    dsTimThay.xuat();
                    break;
                case 0:
                    return;
            }
        } while (luaChon != 0);

    }

    public void menuNhanVien() {
        Scanner sc = new Scanner(System.in);
        int luaChon;
        do {
            System.out.println("\n\t\t\t\t\t==========MENU NHAN VIEN==========");

            System.out.println(
                    "Lua chon: \n0.Thoat \n1. Xem danh sach nhan vien \n2.Them nhan vien \n3.Sua nhan vien \n4.Xoa nhan vien \n5.Tim kiem nhan vien \n6.");
            System.out.print("Nhap lua chon: ");
            luaChon = sc.nextInt();
            sc.nextLine();
            switch (luaChon) {
                case 1:
                    System.out.println("\t\t\t\t\t==========DANH SACH NHAN VIEN==========");
                    xuat();
                    break;
                case 2:
                    System.out.println("\t\t\t\t\t==========THEM NHAN VIEN==========");
                    them();
                    break;
                case 3:
                    System.out.println("\t\t\t\t\t==========SUA NHAN VIEN==========");
                    System.out.print("Nhap ma can sua: ");
                    String maCanSua = sc.nextLine();
                    sua(maCanSua);
                    break;
                case 4:
                    System.out.println("\t\t\t\t\t==========XOA NHAN VIEN==========");
                    System.out.print("Nhap ma can xoa: ");
                    String maCanXoa = sc.nextLine();
                    sua(maCanXoa);
                    break;
                case 5:
                    menuTimKiem();
                    break;
                case 0:
                    return;

            }
        } while (luaChon != 0);

    }

    public void xuat() {
        System.out.printf("%-10s %-15s %-10s %-15s %-10s\n",
                "Ma NV", "Ho", "Ten", "Chuc vu", "Luong");
        for (int i = 0; i < soluong; i++) {

            dsnv[i].xuat();
        }
    }

    public static void main(String[] args) {
        DSNV dsnv = new DSNV();
        NhanVien nv1 = new NhanVien("01", "1", "1", "1", 1);
        dsnv.them(nv1);
        dsnv.menuNhanVien();
    }
}
