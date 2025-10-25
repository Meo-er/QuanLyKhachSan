package Doan;

import java.util.Arrays;
import java.util.Scanner;

public class DSKH {
    private KhachHang[] dskh;
    private int soluong;

    public DSKH() {
        dskh = new KhachHang[0];
        soluong = 0;
    }

    public DSKH(KhachHang[] dskh, int soluong) {
        this.dskh = dskh;
        this.soluong = soluong;

    }

    public boolean maTonTai(String maTonTai) {
        for (int i = 0; i < soluong; i++) {
            if (dskh[i].getMaKH().equals(maTonTai))
                return true;
        }
        return false;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong khach hang: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            dskh = Arrays.copyOf(dskh, dskh.length + 1);
            System.out.println("Khach hang thu " + (i + 1) + ": ");
            KhachHang kh = new KhachHang();
            kh.nhap();
            if (maTonTai(kh.getMaKH())) {
                System.out.println("Ma KH da ton tai, khong them vao danh sach.\n\nVui long nhap lai: ");
                i--;
            } else {
                dskh = Arrays.copyOf(dskh, dskh.length + 1);
                dskh[dskh.length - 1] = kh;
            }
        }
        soluong = dskh.length;
    }

    public void them(KhachHang khMoi) {
        dskh = Arrays.copyOf(dskh, dskh.length + 1);
        dskh[soluong] = khMoi;
        soluong++;

    }

    public void them() {
        Scanner sc = new Scanner(System.in);
        int them;
        do {
            System.out.print("Nhap so luong can them: ");
            them = sc.nextInt();
            sc.nextLine();
            if (them <= 0)
                System.out.println("So luong khong hop le, vui long nhap lai: ");
        } while (them <= 0);

        for (int i = 0; i < them; i++) {
            System.out.println("\nKhach hang thu " + (soluong + 1));
            KhachHang khMoi = new KhachHang();
            khMoi.nhap();
            if (maTonTai(khMoi.getMaKH())) {
                System.out.println("Ma KH da ton tai, khong them vao danh sach.\n\nVui long nhap lai: ");
                i--;
            } else
                them(khMoi);
        }
    }

    public KhachHang timKHTheoMa(String maCanTim) {
        for (int i = 0; i < soluong; i++) {
            if (dskh[i].getMaKH().equals(maCanTim)) {
                System.out.printf("%-10s %-15s %-10s %-15s %-10s\n",
                        "Ma KH", "Ho", "Ten", "SDT", "Email");
                return dskh[i];
            }
        }
        return null;
    }

    public DSKH timKHTheoHo(String hoCanTim) {
        DSKH dsTimThay = new DSKH();
        for (int i = 0; i < soluong; i++) {
            if (dskh[i].getHo().equalsIgnoreCase(hoCanTim)) {
                dsTimThay.them(dskh[i]);
            }
        }
        if (dsTimThay.soluong == 0)
            System.out.println("Khong tim thay nhan vien " + hoCanTim);
        return dsTimThay;
    }

    public DSKH timKHTheoTen(String tenCanTim) {
        DSKH dsTimThay = new DSKH();
        for (int i = 0; i < soluong; i++) {
            if (dskh[i].getTen().equalsIgnoreCase(tenCanTim)) {
                dsTimThay.them(dskh[i]);
            }
        }
        if (dsTimThay.soluong == 0)
            System.out.println("Khong tim thay khach hang " + tenCanTim);
        return dsTimThay;
    }

    public DSKH timKHTheoHoTen(String hoCanTim, String tenCanTim) {
        DSKH dsTimThay = new DSKH();
        for (int i = 0; i < soluong; i++) {
            if (dskh[i].getHo().equalsIgnoreCase(hoCanTim) && dskh[i].getTen().equalsIgnoreCase(tenCanTim)) {
                dsTimThay.them(dskh[i]);
            }
        }
        if (dsTimThay.soluong == 0)
            System.out.println("Khong tim thay khach hang " + hoCanTim + " " + tenCanTim);
        return dsTimThay;
    }

    public KhachHang timKHTheoEmail(String emailCanTim) {
        for (int i = 0; i < soluong; i++) {
            if (dskh[i].getEmail().equalsIgnoreCase(emailCanTim)) {
                return dskh[i];
            }
        }
        return null;
    }

    public KhachHang timKHTheoSDT(long sdtCanTim) {
        for (int i = 0; i < soluong; i++) {
            if (dskh[i].getSdt() == sdtCanTim) {
                return dskh[i];
            }
        }
        return null;
    }

    public void sua(String maCanSua) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < soluong; i++) {
            if (dskh[i].getMaKH().equals(maCanSua)) {
                System.out.printf("%-10s %-15s %-10s %-15s %-10s\n",
                        "Ma KH", "Ho", "Ten", "SDT", "Email");
                dskh[i].xuat();
                System.out.printf("%-10s %-10s %-10s %-10s %-15s %-15s \n",
                        "Lua chon: ", "0.Thoat", "1.Ho", "2.Ten", "3.SDT", "4.Email");
                int luaChon = sc.nextInt();
                sc.nextLine();
                switch (luaChon) {
                    case 1:
                        System.out.print("Nhap ho moi: ");
                        String hoMoi = sc.nextLine();
                        dskh[i].setHo(hoMoi);
                        break;
                    case 2:
                        System.out.print("Nhap ten moi: ");
                        String tenMoi = sc.nextLine();
                        dskh[i].setTen(tenMoi);
                        break;
                    case 3:
                        System.out.print("Nhap sdt moi: ");
                        long sdtMoi = sc.nextLong();
                        dskh[i].setSdt(sdtMoi);
                        break;
                    case 4:
                        System.out.print("Nhap email moi: ");
                        String emailMoi = sc.nextLine();
                        dskh[i].setEmail(emailMoi);
                        break;

                    case 0:
                        break;
                    default:
                        System.out.println("Lua chon khong hop le!");
                }
                while (luaChon != 0)
                    return;

            } else
                System.out.println("Khong tim thay khach hang " + maCanSua);

        }

    }

    public void xoa(String maCanXoa) {
        for (int i = 0; i < soluong; i++) {
            if (dskh[i].getMaKH().equals(maCanXoa)) {
                for (int j = i; j < soluong - 1; j++) {
                    dskh[j] = dskh[j + 1];

                }
                soluong--;
                dskh = Arrays.copyOf(dskh, soluong);
                System.out.println("Xoa khach hang " + maCanXoa + " thanh cong!");
                return;
            }

        }
        System.out.println("Khong tim thay khach hang co ma: " + maCanXoa);
    }

    public void menuTimKiem() {
        Scanner sc = new Scanner(System.in);
        int luaChon;
        do {
            System.out.println("\n\t\t\t\t\t==========MENU TIM KIEM==========");

            System.out.printf("%-10s %-10s %-10s %-10s %-10s %-15s %-15s %-15s\n", "Lua chon:", "0.Thoat", "1.Ma KH",
                    "2.Ho",
                    "3.Ten",
                    "4.Ho Ten", " 5.SDT", "6.Email");
            System.out.print("Nhap lua chon: ");
            luaChon = sc.nextInt();
            sc.nextLine();

            switch (luaChon) {
                case 1:
                    System.out.print("Nhap ma can tim: ");
                    String maCanTim = sc.nextLine();
                    KhachHang timThay = timKHTheoMa(maCanTim);
                    timThay.xuat();
                    break;
                case 2:
                    System.out.print("Nhap ho can tim: ");
                    String hoCanTim = sc.nextLine();
                    timKHTheoHo(hoCanTim);
                    DSKH dsTimThay = timKHTheoHo(hoCanTim);
                    dsTimThay.xuat();
                    break;
                case 3:
                    System.out.print("Nhap ten can tim: ");
                    String tenCanTim = sc.nextLine();
                    timKHTheoTen(tenCanTim);
                    dsTimThay = timKHTheoTen(tenCanTim);
                    dsTimThay.xuat();
                    break;
                case 4:
                    System.out.print("Nhap ho, ten can tim: ");
                    System.out.print("Ho: ");
                    hoCanTim = sc.nextLine();
                    System.out.print("Ten: ");
                    tenCanTim = sc.nextLine();
                    dsTimThay = timKHTheoHoTen(hoCanTim, tenCanTim);
                    dsTimThay.xuat();
                    break;
                case 5:
                    System.out.print("Nhap SDT can tim: ");
                    long sdtCanTim = sc.nextLong();
                    timThay = timKHTheoSDT(sdtCanTim);
                    timThay.xuat();
                case 6:
                    System.out.print("Nhap email can tim: ");
                    String emailCanTim = sc.nextLine();
                    timThay = timKHTheoEmail(emailCanTim);
                    timThay.xuat();
                    break;

                case 0:
                    return;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (luaChon != 0);

    }

    public void menuKhachHang() {
        Scanner sc = new Scanner(System.in);
        int luaChon;
        do {
            System.out.println("\n\t\t\t\t\t==========MENU KHACH HANG==========");

            System.out.println(
                    "Lua chon: \n0. Thoat \n1. Xem danh sach khach hang \n2. Them khach hang \n3. Sua khach hang \n4. Xoa khach hang \n5. Tim kiem khach hang ");
            System.out.print("Nhap lua chon: ");
            luaChon = sc.nextInt();
            sc.nextLine();
            switch (luaChon) {
                case 1:
                    System.out.println("\t\t\t\t\t==========DANH SACH KHACH HANG==========");
                    xuat();
                    break;
                case 2:
                    System.out.println("\t\t\t\t\t==========THEM KHACH HANG==========");
                    them();
                    break;
                case 3:
                    System.out.println("\t\t\t\t\t==========SUA KHACH HANG==========");
                    System.out.print("Nhap ma can sua: ");
                    String maCanSua = sc.nextLine();
                    sua(maCanSua);
                    break;
                case 4:
                    System.out.println("\t\t\t\t\t==========XOA KHACH HANG==========");
                    System.out.print("Nhap ma can xoa: ");
                    String maCanXoa = sc.nextLine();
                    xoa(maCanXoa);
                    break;
                case 5:
                    menuTimKiem();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (luaChon != 0);

    }

    public void xuat() {
        System.out.printf("%-15s %-10s %-10s %-15s %-15s \n",
                "Ma KH", "Ho", "Ten", "SDT", "Email");
        for (int i = 0; i < soluong; i++) {
            dskh[i].xuat();
        }
    }

    public static void main(String[] args) {
        DSKH ds = new DSKH();
        KhachHang kh1 = new KhachHang("1", "Dinh", "Nhat Lan", 877909216L, "nhatland15@gmail.com");
        ds.them(kh1);
        ds.menuKhachHang();
    }

}
