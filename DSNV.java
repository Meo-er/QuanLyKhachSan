package Do_an_OOP;

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
        System.out.println("Them sinh vien thanh cong!");

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
                        break;
                    case 2:
                        System.out.print("Nhap ten moi: ");
                        String tenMoi = sc.nextLine();
                        dsnv[i].setTen(tenMoi);
                        break;
                    case 3:
                        System.out.print("Nhap chuc vu moi: ");
                        String chucVuMoi = sc.nextLine();
                        dsnv[i].setchucvu(chucVuMoi);
                        break;
                    case 4:
                        System.out.print("Nhap luong moi: ");
                        double luongMoi = sc.nextDouble();
                        dsnv[i].setLuong(luongMoi);
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

    }

    public void xoa(String maCanXoa) {
        for (int i = 0; i < soluong; i++) {
            if (dsnv[i].getmanv().equals(maCanXoa)) {
                for (int j = i; j < soluong; j++) {
                    dsnv[j] = dsnv[j + 1];
                    soluong--;
                    return;
                }
            }

        }
        System.out.println("Khong tim thay nhan vien co ma: " + maCanXoa);
    }

    public void xuat() {
        System.out.println("========DANH SACH NHAN VIEN========");
        for (int i = 0; i < soluong; i++) {
            System.out.printf("%-10s %-15s %-10s %-15s %-10s\n",
                    "Ma NV", "Ho", "Ten", "Chuc vu", "Luong");
            dsnv[i].xuat();
        }
    }

    public static void main(String[] args) {
        DSNV dsnv = new DSNV();
        NhanVien nv1 = new NhanVien("01", "1", "1", "1", 1);
        dsnv.them(nv1);
        dsnv.sua("01");
        dsnv.xuat();
    }
}
