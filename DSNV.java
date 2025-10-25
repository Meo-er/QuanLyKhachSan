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

    public boolean maTonTai(String maTonTai) {
        for (int i = 0; i < soluong; i++) {
            if (dsnv[i].getMaNV().equals(maTonTai))
                return true;
        }
        return false;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        int soluong = 0;
        while (true) {
            System.out.print("Nhap so luong nhan vien: ");
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
            NhanVien nv = new NhanVien();
            nv.nhap();
            if (maTonTai(nv.getMaNV())) {
                System.out.println("Ma NV da ton tai, khong them vao danh sach.\n\nVui long nhap lai: ");
                i--;
            } else {
                dsnv = Arrays.copyOf(dsnv, dsnv.length + 1);
                dsnv[dsnv.length - 1] = nv;

            }
            soluong = dsnv.length;
        }
    }

    public void them(NhanVien nvMoi) {
        dsnv = Arrays.copyOf(dsnv, dsnv.length + 1);
        dsnv[soluong] = nvMoi;
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
            System.out.println("Nhan vien thu " + (soluong + 1));
            NhanVien nvMoi = new NhanVien();
            nvMoi.nhap();
            if (maTonTai(nvMoi.getMaNV())) {
                System.out.println("Ma NV da ton tai, khong them vao danh sach.\n\nVui long nhap lai: ");
                i--;
            } else
                them(nvMoi);
        }
    }

    public NhanVien timNVTheoMa(String maCanTim) {
        for (int i = 0; i < soluong; i++) {
            if (dsnv[i].getMaNV().equals(maCanTim)) {
                System.out.printf("%-10s %-15s %-10s %-15s %-10s\n",
                        "Ma NV", "Ho", "Ten", "Chuc vu", "Luong");
                return dsnv[i];
            }
        }
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
        int luaChon;
        boolean timThay = false;
        for (int i = 0; i < soluong; i++) {
            if (dsnv[i].getMaNV().equals(maCanSua)) {
                timThay = true;
                do {
                    dsnv[i].xuat();
                    System.out.printf("%-10s %-10s %-10s %-10s %-15s %-15s \n",
                            "Lua chon: ", "0.Thoat", "1.Ho", "2.Ten", "3.Chuc vu", "4.Luong");
                    luaChon = sc.nextInt();
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
                } while (luaChon != 0);
                break;
            }

        }
        if (!timThay) {
            System.out.print("Khong tim thay nhan vien co ma " + maCanSua);
        }
    }

    public void xoa(String maCanXoa) {
        for (int i = 0; i < soluong; i++) {
            if (dsnv[i].getMaNV().equals(maCanXoa)) {
                for (int j = i; j < soluong - 1; j++) {
                    dsnv[j] = dsnv[j + 1];
                }
                soluong--;
                dsnv = Arrays.copyOf(dsnv, soluong);
                System.out.println("Xoa nhan vien " + maCanXoa + " thanh cong!");

                return;
            }

        }
        System.out.println("Khong tim thay nhan vien co ma " + maCanXoa);
    }

    public int[] thongKeLuong() {
        int thucTap = 0, loai3 = 0, loai2 = 0, loai1 = 0;
        System.out.println("\n\t\t\t\t\t==========THONG KE LUONG THANG==========");
        for (int i = 0; i < soluong; i++) {
            if (dsnv[i].getLuong() <= 5000000)
                thucTap++;
            else if (dsnv[i].getLuong() > 5000000 && dsnv[i].getLuong() <= 10000000)
                loai3++;
            else if (dsnv[i].getLuong() > 10000000 && dsnv[i].getLuong() <= 20000000)
                loai2++;
            else
                loai1++;
        }
        System.out.print(
                "Loai 1: " + loai1 + "\tLoai 2: " + loai2 + "\tLoai 3: " + loai3 + "\tThuc tap sinh: " + thucTap);
        return new int[] { loai1, loai2, loai3, thucTap };
    }

    public void menuTimKiem() {
        Scanner sc = new Scanner(System.in);
        int luaChon;
        do {
            System.out.println("\n\t\t\t\t\t==========MENU TIM KIEM==========");

            System.out.printf("%-10s %-10s %-10s %-10s %-10s %-15s %-10s\n", "Lua chon:", "0. Thoat", "1. Ma NV",
                    "2. Ho",
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
                    if (timThay != null)
                        timThay.xuat();
                    else
                        System.out.println("Khong tim thay nhan vien " + maCanTim);
                    break;
                case 2:
                    System.out.print("Nhap ho can tim: ");
                    String hoCanTim = sc.nextLine();
                    DSNV dsTimThay = timNVTheoHo(hoCanTim);
                    if (dsTimThay.soluong > 0)
                        dsTimThay.xuat();
                    break;
                case 3:
                    System.out.print("Nhap ten can tim: ");
                    String tenCanTim = sc.nextLine();
                    dsTimThay = timNVTheoTen(tenCanTim);
                    if (dsTimThay.soluong > 0)
                        dsTimThay.xuat();
                    break;
                case 4:
                    System.out.println("Nhap ho, ten can tim: ");
                    System.out.print("Ho: ");
                    hoCanTim = sc.nextLine();
                    System.out.print("Ten: ");
                    tenCanTim = sc.nextLine();
                    dsTimThay = timNVTheoHoTen(hoCanTim, tenCanTim);
                    if (dsTimThay.soluong > 0)
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
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (luaChon != 0);

    }

    public void menuNhanVien() {
        Scanner sc = new Scanner(System.in);
        int luaChon;
        do {
            System.out.println("\n\t\t\t\t\t==========MENU NHAN VIEN==========");

            System.out.println(
                    "Lua chon: \n0. Thoat \n1. Xem danh sach nhan vien \n2. Them nhan vien \n3. Sua nhan vien \n4. Xoa nhan vien \n5. Tim kiem nhan vien \n6. Thong ke luong thang.");
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
                    xoa(maCanXoa);
                    break;
                case 5:
                    menuTimKiem();
                    break;
                case 6:
                    thongKeLuong();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lua chon khong hop le!");

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
        NhanVien nv2 = new NhanVien("02", "1", "1", "1", 1);

        dsnv.them(nv1);
        dsnv.them(nv2);
        dsnv.nhap();
        dsnv.menuNhanVien();
    }
}
