package QuanLyKhachSan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class DSPSDDV {
    private PhieuSuDungDV[] dspsddv;
    int soLuong;
    private DSDV dsdv;

    public DSPSDDV() {
        dspsddv = new PhieuSuDungDV[0];
        soLuong = 0;
    }

    public DSPSDDV(DSDV dsdv) {
        this.dsdv = dsdv;
        dspsddv = new PhieuSuDungDV[0];
        soLuong = 0;
        if (this.dsdv != null) {
            this.dsdv.docFile();
        }
    }

    public DSPSDDV(PhieuSuDungDV[] dspsddv, int soLuong) {
        this.dspsddv = dspsddv;
        this.soLuong = soLuong;
    }

    public boolean maTonTai(String maTonTai) {
        for (int i = 0; i < soLuong; i++) {
            if (dspsddv[i].getMasddv().equals(maTonTai))
                return true;
        }
        return false;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        int soLuong = 0;
        while (true) {
            System.out.print("Nhap so luong phieu sddv: ");
            try {
                soLuong = sc.nextInt();
                sc.nextLine();
                if (soLuong <= 0)
                    System.out.println("So luong phieu khong hop le! Vui long nhap lai");
                else
                    break;
            } catch (Exception e) {
                System.out.println("Ban phai nhap lai so nguyen! Vui long nhap lai");
                sc.nextLine();
            }
        }

        for (int i = 0; i < soLuong; i++) {
            System.out.println("Phieu thu " + (i + 1) + ": ");
            PhieuSuDungDV psd = new PhieuSuDungDV();
            psd.nhap(dsdv); // Truyền dsDV vào
            if (maTonTai(psd.getMasddv())) {
                System.out.println("Ma phieu SDDV da ton tai, khong them vao danh sach.\nVui long nhap lai: ");
                i--;
            } else {
                dspsddv = Arrays.copyOf(dspsddv, dspsddv.length + 1);
                dspsddv[dspsddv.length - 1] = psd;
                this.soLuong++;
            }
        }
    }

    public void them(PhieuSuDungDV dsMoi) {
        dspsddv = Arrays.copyOf(dspsddv, dspsddv.length + 1);
        dspsddv[soLuong] = dsMoi;
        soLuong++;
    }

    public void them() {
        Scanner sc = new Scanner(System.in);
        int them = 0;
        while (true) {
            System.out.print("Nhap so phieu can them: ");
            try {
                them = sc.nextInt();
                sc.nextLine();
                if (them <= 0)
                    System.out.println("So luong phieu khong hop le! Vui long nhap lai");
                else
                    break;
            } catch (Exception e) {
                System.out.println("So phieu khong hop le! Vui long nhap so nguyen");
                sc.nextLine();
            }
        }
        for (int i = 0; i < them; i++) {
            System.out.println("So phieu thu " + (soLuong + 1));
            PhieuSuDungDV dsMoi = new PhieuSuDungDV();
            dsMoi.nhap(dsdv); // Truyền dsDV vào

            if (maTonTai(dsMoi.getMasddv())) {
                System.out.println("Ma phieu da ton tai, khong them vao danh sach.\nVui long nhap lai: ");
                i--;
            } else
                them(dsMoi);
        }
    }

    public PhieuSuDungDV timTheoMaPSDDV(String maCanTim) {
        for (int i = 0; i < soLuong; i++) {
            if (dspsddv[i].getMasddv().equals(maCanTim)) {
                return dspsddv[i];
            }
        }
        return null;
    }

    public PhieuSuDungDV timTheoMaDP(String maCanTim) {
        for (int i = 0; i < soLuong; i++) {
            if (dspsddv[i].getMadp().equals(maCanTim)) {
                return dspsddv[i];
            }
        }
        return null;
    }

    public DSPSDDV timTheoMaKH(String maCanTim) {
        DSPSDDV dsTimThay = new DSPSDDV();
        for (int i = 0; i < soLuong; i++) {
            if (dspsddv[i].getMakh().equals(maCanTim)) {
                dsTimThay.them(dspsddv[i]);
            }
        }
        return dsTimThay;
    }

    public void menuTimKiem() {
        Scanner sc = new Scanner(System.in);
        int luaChon;
        do {
            System.out.println("\n========== MENU TIM KIEM PHIEU SDDV ==========");
            System.out.println("1. Tim phieu sddv theo ma sddv");
            System.out.println("2. Tim phieu sddv theo ma dat phong");
            System.out.println("3. Tim phieu sddv theo ma khach hang");
            System.out.println("0. Thoat");
            System.out.print("Lua chon: ");

            luaChon = sc.nextInt();
            sc.nextLine();
            switch (luaChon) {
                case 1:
                    System.out.println("\n==========TIM THEO MA SDDV==========");
                    System.out.print("Nhap ma phieu SDDV: ");
                    String maPSDDV = sc.nextLine();
                    PhieuSuDungDV psddv = timTheoMaPSDDV(maPSDDV);
                    if (psddv != null) {
                        System.out.println("Tim thay phieu:");
                        psddv.xuat();
                    } else {
                        System.out.println("Khong tim thay phieu!");
                    }
                    break;
                case 2:
                    System.out.println("\n==========TIM THEO MA DP==========");
                    System.out.print("Nhap ma DP: ");
                    String maDP = sc.nextLine();
                    PhieuSuDungDV dp = timTheoMaDP(maDP);
                    if (dp != null) {
                        System.out.println("Tim thay phieu:");
                        dp.xuat();
                    } else {
                        System.out.println("Khong tim thay phieu!");
                    }
                    break;
                case 3:
                    System.out.println("\n==========TIM THEO MA KH==========");
                    System.out.print("Nhap ma KH: ");
                    String maKH = sc.nextLine();
                    DSPSDDV dsKH = timTheoMaKH(maKH);
                    if (dsKH.soLuong > 0) {
                        System.out.println("Tim thay " + dsKH.soLuong + " phieu:");
                        dsKH.xuat();
                    } else {
                        System.out.println("Khong tim thay phieu!");
                    }
                    break;
                case 0:
                    System.out.println("Thoat");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }
        } while (luaChon != 0);
    }

    public void sua(String maCanSua) {
        Scanner sc = new Scanner(System.in);
        int luaChon;
        boolean timThay = false;
        for (int i = 0; i < soLuong; i++) {
            if (dspsddv[i].getMasddv().equals(maCanSua)) {
                timThay = true;
                do {
                    System.out.println("\n==========SUA PHIEU SDDV==========");
                    System.out.println("1. Sua ma khach hang");
                    System.out.println("2. Sua ma dat phong");
                    System.out.println("0. Thoat");
                    System.out.print("Lua chon: ");

                    luaChon = sc.nextInt();
                    sc.nextLine();
                    switch (luaChon) {
                        case 1:
                            System.out.print("Nhap ma khach hang moi: ");
                            String maKHMoi = sc.nextLine();
                            dspsddv[i].setMakh(maKHMoi);
                            System.out.println("Thay doi thanh cong!");
                            break;
                        case 2:
                            System.out.print("Nhap ma dat phong moi: ");
                            String maDPMoi = sc.nextLine();
                            dspsddv[i].setMadp(maDPMoi);
                            System.out.println("Thay doi thanh cong!");
                            break;
                        case 0:
                            System.out.println("Thoat");
                            break;
                        default:
                            System.out.println("Lua chon khong hop le!");
                            break;
                    }
                } while (luaChon != 0);
                break;
            }
        }
        if (!timThay) {
            System.out.println("Khong tim thay phieu sddv co ma " + maCanSua);
        }
    }

    public void xoa(String maCanXoa) {
        for (int i = 0; i < soLuong; i++) {
            if (dspsddv[i].getMasddv().equals(maCanXoa)) {
                for (int j = i; j < soLuong - 1; j++) {
                    dspsddv[j] = dspsddv[j + 1];
                }
                soLuong--;
                dspsddv = Arrays.copyOf(dspsddv, soLuong);
                System.out.println("Xoa phieu sddv " + maCanXoa + " thanh cong!");
                return;
            }
        }
        System.out.println("Khong tim thay ma phieu co ma " + maCanXoa);
    }

    public int[] thongKeThanhTien() {
        int[] thongKe = new int[5];

        for (int i = 0; i < soLuong; i++) {
            double thanhTien = dspsddv[i].getThanhtien();
            if (thanhTien < 100000) {
                thongKe[0]++;
            } else if (thanhTien < 500000) {
                thongKe[1]++;
            } else if (thanhTien < 1000000) {
                thongKe[2]++;
            } else if (thanhTien < 2000000) {
                thongKe[3]++;
            } else {
                thongKe[4]++;
            }
        }
        System.out.println("\n========== THONG KE THANH TIEN ==========");
        System.out.printf("%-15s %-15s %-15s %-15s %-15s\n",
                "< 100K", "100K-500K", "500K-1TR", "1TR-2TR", "> 2TR");
        System.out.printf("%-15d %-15d %-15d %-15d %-15d\n",
                thongKe[0], thongKe[1], thongKe[2], thongKe[3], thongKe[4]);
        return thongKe;
    }

    public void xuat() {
        if (soLuong <= 0) {
            System.out.println("Khong co phieu su dung dich vu nao");
            return;
        }
        System.out.printf("%-15s %-15s %-15s %-15s\n",
                "Ma SDDV", "Ma Dat Phong", "Ma KH", "Thanh Tien");
        for (int i = 0; i < soLuong; i++) {
            PhieuSuDungDV p = dspsddv[i];
            System.out.printf("%-15s %-15s %-15s %-15.2f\n",
                    p.getMasddv(), p.getMadp(), p.getMakh(), p.getThanhtien());
        }
    }

    public void docFile() {
        File file = new File("QuanLyKhachSan/PhieuSDDV.txt");
        if (!file.exists()) {
            System.out.println("Khong tim thay file.");
            return;
        }
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String masddv = parts[0].trim();
                    String madp = parts[1].trim();
                    String makh = parts[2].trim();
                    double thanhtien = Double.parseDouble(parts[3].trim());

                    PhieuSuDungDV phieu = new PhieuSuDungDV(masddv, madp, makh, thanhtien);
                    them(phieu);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Loi doc file");
        }
    }

    public void ghiFile() {
        File file = new File("QuanLyKhachSan/PhieuSDDV.txt");
        try (PrintWriter pw = new PrintWriter(file)) {
            for (PhieuSuDungDV phieu : dspsddv)
                pw.println(phieu.toString());
        } catch (FileNotFoundException e) {
            System.out.println("Loi ghi file");
        }

    }

    // public static void main(String[] args) {
    // DSDV dsdv = new DSDV();
    // // Thêm dữ liệu mẫu cho dịch vụ
    // dsdv.docFile("QuanLyKhachSan/DichVu.txt");

    // DSPSDDV ds = new DSPSDDV(dsdv);
    // ds.docFile();
    // ds.menuPSDDV();
    // ds.ghiFile();
    // }
}