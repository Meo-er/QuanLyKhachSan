package Doan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class DSChiTietHD {
    private ChiTietHoaDon[] dsct;
    private int soluong;

    public DSChiTietHD() {
        dsct = new ChiTietHoaDon[0];
        soluong = 0;
    }

    public DSChiTietHD(ChiTietHoaDon[] dsct, int soluong) {
        this.dsct = dsct;
        this.soluong = soluong;
        ;
    }

    public boolean maTonTai(String maTonTai) {
        for (int i = 0; i < soluong; i++) {
            if (dsct[i].getMaChiTiet().equals(maTonTai))
                return true;
        }
        return false;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong chi tiet hoa don: ");
        soluong = sc.nextInt();
        sc.nextLine();
        dsct = new ChiTietHoaDon[soluong];
        for (int i = 0; i < soluong; i++) {
            ChiTietHoaDon ctMoi = new ChiTietHoaDon();
            System.out.print("Nhap chi tiet thu " + (i + 1) + ":");
            ctMoi.nhap();

            if (maTonTai(ctMoi.getMaChiTiet())) {
                System.out.println("Ma chi tiet nay da ton tai! Vui long nhap lai: ");
                i--;
            } else
                dsct[i] = ctMoi;
        }
    }

    public void xuat() {
        System.out.printf("%-12s %-12s %-12s %-12s %-12s\n",
                "Loai", "Ma", "Don gia", "SL", "Thanh tien");
        for (ChiTietHoaDon ct : dsct) {
            ct.xuat();
        }
    }

    public void them(ChiTietHoaDon ctMoi) {
        dsct = Arrays.copyOf(dsct, dsct.length + 1);
        dsct[dsct.length - 1] = ctMoi;
        soluong++;
    }

    public void them() {
        Scanner sc = new Scanner(System.in);
        int them = 0;
        System.out.print("Nhap so luong can them: ");
        them = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < soluong; i++) {
            System.out.print("Chi tiet thu: " + (i + 1) + ":");
            ChiTietHoaDon ctMoi = new ChiTietHoaDon();
            ctMoi.nhap();
            if (maTonTai(ctMoi.getMaChiTiet())) {
                System.out.print("Ma CT da ton tai, khong them vao danh sach. Vui long nhap lai: ");
                i--;
            } else
                them(ctMoi);
        }

    }

    public void sua() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma chi muon sua: ");
        String maCanSua = sc.nextLine();
        sua(maCanSua);
    }

    public void sua(String maCanSua) {
        Scanner sc = new Scanner(System.in);
        int luaChon;
        boolean timThay = false;
        for (int i = 0; i < soluong; i++) {
            if (dsct[i].getMaHD().equals(maCanSua)) {
                timThay = true;
                do {
                    dsct[i].xuat();
                    System.out.printf("%-10s %-10s %-10s %-10s\n",
                            "Lua chon: ", "0. Thoat", "1.Ma CT ", "2. Loai", "3.Don gia", "4.So luong");
                    luaChon = sc.nextInt();
                    sc.nextLine();
                    switch (luaChon) {
                        case 1:
                            System.out.print("Nhap ma CT moi: ");
                            String maCTMoi = sc.nextLine();
                            dsct[i].setMaChiTiet(maCTMoi);
                            System.out.println("Thay doi thanh cong!");
                            break;
                        case 2:
                            System.out.print("Nhap loai moi: ");
                            String loaiMoi = sc.nextLine();
                            dsct[i].setLoai(loaiMoi);
                            System.out.println("Thay doi thanh cong!");
                            break;
                        case 3:
                            System.out.print("Nhap don gia moi: ");
                            double donGiaMoi = sc.nextDouble();
                            sc.nextLine();
                            dsct[i].setDonGia(donGiaMoi);
                            System.out.println("Thay doi thanh cong!");
                            break;
                        case 4:
                            System.out.print("Nhap so luong moi: ");
                            int soLuongMoi = sc.nextInt();
                            sc.nextLine();
                            dsct[i].setSoLuong(soLuongMoi);
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
        System.out.print("Nhap ma hoa don can xoa chi tiet: ");
        String maCanXoa = sc.nextLine();
        xoa(maCanXoa);
    }

    public void xoa(String maCanXoa) {
        for (int i = 0; i < soluong; i++) {
            dsct[i].getMaHD().equals(maCanXoa);
            for (int j = i; j < soluong - 1; j++) {
                dsct[j] = dsct[j + 1];
            }
            soluong--;
            dsct = Arrays.copyOf(dsct, dsct.length);
            System.out.print("Xoa chi tiet co ma " + maCanXoa + " cua hoa don " + dsct[i].getMaHD() + " thanh cong!");
            return;
        }
        System.out.println("Khong tim thay chi tiet cua hoa don" + maCanXoa);
    }

    public DSChiTietHD timTheoMaHD(String maCanTim) {
        DSChiTietHD dsTimThay = new DSChiTietHD();
        for (int i = 0; i < soluong; i++) {
            if (dsct[i].getMaHD().equalsIgnoreCase(maCanTim))
                dsTimThay.them(dsct[i]);
        }
        return dsTimThay;
    }

    public DSChiTietHD timTheoLoai(String loaiCanTim) {
        DSChiTietHD dsTimThay = new DSChiTietHD();
        for (int i = 0; i < soluong; i++) {
            if (dsct[i].getLoai().equalsIgnoreCase(loaiCanTim))
                dsTimThay.them(dsct[i]);
        }
        return dsTimThay;
    }

    public DSChiTietHD timTheoMaCT(String maCanTim) {
        DSChiTietHD dsTimThay = new DSChiTietHD();
        for (int i = 0; i < soluong; i++) {
            if (dsct[i].getMaChiTiet().equalsIgnoreCase(maCanTim))
                dsTimThay.them(dsct[i]);
        }
        return dsTimThay;
    }

    public void menuTimKiem() {
        Scanner sc = new Scanner(System.in);
        System.out.println("MENU TIM KIEM");
        int luaChon = 0;
        do {
            System.out.println(
                    "Lua chon: \n0.Thoat \t1.Tim theo ma HD. \t2.Tim theo loai CT \t3.Tim theo ma CT");
            System.out.print("Nhap lua chon: ");
            luaChon = sc.nextInt();
            sc.nextLine();
            switch (luaChon) {
                case 1:
                    System.out.print("Nhap ma HD can tim: ");
                    String canTim = sc.nextLine();
                    DSChiTietHD dsTimThay = timTheoMaHD(canTim);
                    if (dsTimThay != null) {
                        dsTimThay.xuat();
                    } else
                        System.out.println("Khong tim thay ma HD can tim.");
                    break;
                case 2:
                    System.out.print("Nhap loai CT can tim(PHONG/DICHVU): ");
                    canTim = sc.nextLine();
                    dsTimThay = timTheoLoai(canTim);
                    if (dsTimThay != null) {
                        dsTimThay.xuat();
                    } else
                        System.out.println("Khong tim thay loai CT can tim.");
                    break;
                case 3:
                    System.out.print("Nhap ma CT can tim(P/DV): ");
                    canTim = sc.nextLine();
                    dsTimThay = timTheoMaCT(canTim);
                    if (dsTimThay != null) {
                        dsTimThay.xuat();
                    } else
                        System.out.println("Khong tim thay ma CT can tim.");
                    break;

                case 0:
                    break;
            }
        } while (luaChon != 0);
    }

    public void ghiFile() {
        File file = new File("QuanLyKhachSan/src/Doan/CTHD.txt");
        try (PrintWriter pw = new PrintWriter(file)) {
            for (ChiTietHoaDon ct : dsct) {
                pw.println(ct.toString());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file!");
        }

    }

    public void docFile() {
        File file = new File("QuanLyKhachSan/src/Doan/CTHD.txt");
        if (!file.exists()) {
            System.out.println("Khong tim thay file!");
        }
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    double dongia = Double.parseDouble(parts[3]);
                    int soluong = Integer.parseInt(parts[4]);
                    double thanhtien = Double.parseDouble(parts[5]);
                    ChiTietHoaDon ct = new ChiTietHoaDon(parts[0], parts[1], parts[2], dongia, soluong, thanhtien);
                    them(ct);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Khong doc duoc file CTHD!");
        }
    }

    public void thongKeSoLuongTungLoai() {
        int demphong = 0, demdv = 0;
        for (ChiTietHoaDon ct : dsct) {
            if (ct.getLoai().equalsIgnoreCase("PHONG"))
                demphong++;
            else
                demdv++;
        }
        System.out.print("So luong phong: " + demphong);
        System.out.print("So luong dich vu: " + demdv);

    }

    public void menuCTHD() {
        Scanner sc = new Scanner(System.in);
        int luaChon;
        do {
            System.out.println("\n\t\t\t\t\t==========MENU CHI TIET HOA DON==========");

            System.out.println(
                    "Lua chon: \n0. Thoat \n1. Xem danh sach CTHD \n2. Them CTHD \n3. Sua CTHD \n4. Xoa CT CUA HD \n5. Tim kiem CTHD \n6. Thong ke.");
            System.out.print("Nhap lua chon: ");
            luaChon = sc.nextInt();
            sc.nextLine();
            switch (luaChon) {
                case 1:
                    System.out.println("\t\t\t\t\t==========DANH SACH CTHD==========");
                    xuat();
                    ghiFile();
                    break;
                case 2:
                    System.out.println("\t\t\t\t\t==========THEM CTHD==========");
                    them();
                    ghiFile();
                    break;
                case 3:
                    System.out.println("\t\t\t\t\t==========SUA CTHD==========");
                    sua();
                    ghiFile();
                    break;
                case 4:
                    System.out.println("\t\t\t\t\t==========XOA CTHD==========");
                    xoa();
                    ghiFile();
                    break;
                case 5:
                    menuTimKiem();
                    break;
                case 6:
                    System.out.println("\t\t\t\t\t==========THONG KE SO LUONG PHONG/DICH VU DUOC DUNG==========");
                    thongKeSoLuongTungLoai();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (luaChon != 0);

    }

    public static void main(String[] args) {
        DSChiTietHD dsct = new DSChiTietHD();
        dsct.docFile();
        dsct.menuTimKiem();
        dsct.them();
        dsct.ghiFile();
    }
}
