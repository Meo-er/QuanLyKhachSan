package QuanLyKhachSan;

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;

public class DSDV {
    private DichVu[] ds = new DichVu[0];
    private int Soluong;

    public int getsoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }

    // private static final Scanner sc = new Scanner(System.in); //tao 1 scanner
    // dung chung cho tat ca

    public void themdv() {
        ds = Arrays.copyOf(ds, ds.length + 1);
        ds[ds.length - 1] = new DichVu();
        ds[ds.length - 1].nhap();
    }

    public void nhapds() {
        System.out.print("Nhap so luong dich vu: ");
        Scanner sc = new Scanner(System.in);
        setSoluong(sc.nextInt());
        sc.nextLine();
        for (int i = 0; i < Soluong; i++) {
            System.out.println("\n--- Nhap dich vu thu " + (i + 1) + "---");
            themdv();
        }
    }

    public void xuatds() {
        if (ds.length == 0) {
            System.out.println("Danh sach dich vu rong");
            return;
        }
        System.out.println("===== DANH SACH DICH VU =====");
        System.out.printf("%-9s %-15s %-15s %-15s %-15s\n", "Ma DV", "Ten DV", "Don gia", "So luong", "Mo ta");
        for (DichVu dv : ds) {
            dv.xuat();
        }
    }

    public void xoadv(String madv) {
        int index = -1;
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getmadv().equalsIgnoreCase(madv)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < ds.length - 1; i++) {
                ds[i] = ds[i + 1];
            }
            ds = Arrays.copyOf(ds, ds.length - 1);
            System.out.println("Da xoa dich vu co ma: " + madv);
        } else
            System.out.println("Khong tim thay ma dich vu: " + madv);
    }

    public void xoadv() {
        System.out.print("Nhap ma dich vu can xoa: ");
        Scanner sc = new Scanner(System.in);
        String madv = sc.nextLine();
        xoadv(madv);
    }

    public void suathongtindv() {
        System.out.print("Nhap ma dich vu can sua: ");
        Scanner sc = new Scanner(System.in);
        String ma = sc.nextLine();
        boolean found = false;
        for (DichVu dv : ds) {
            if (dv.getmadv().equalsIgnoreCase(ma)) {
                found = true;
                System.out.println("Chon thong tin can sua");
                System.out.println("1.Ten dich vu");
                System.out.println("2.Don gia");
                System.out.println("3.So luong");
                System.out.println("4.Mo ta");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Nhap ten dich vu moi: ");
                        dv.settendv(sc.nextLine());
                        break;
                    case 2:
                        System.out.print("Nhap don gia moi: ");
                        dv.setdongia(sc.nextFloat());
                        break;
                    case 3:
                        System.out.print("Nhap so luong moi: ");
                        dv.setsoluong(sc.nextInt());
                        sc.nextLine();
                        break;
                    case 4:
                        System.out.print("Nhap mo ta moi: ");
                        dv.setmota(sc.nextLine());
                        break;

                    default:
                        System.out.println("Lua chon khong hop le");
                }
            }
        }
        if (!found)
            System.out.println("Khong tim thay ma dich vu: " + ma);
    }

    public void suathongtindv(String madv, String suatt, String ttmoi) {
        for (DichVu dv : ds) {
            if (dv.getmadv().equalsIgnoreCase(madv)) {
                if (suatt.equalsIgnoreCase("ten dich vu"))
                    dv.settendv(ttmoi);
                else if (suatt.equalsIgnoreCase("don gia"))
                    dv.setdongia(Float.parseFloat(ttmoi));
                else if (suatt.equalsIgnoreCase("so luong"))
                    dv.setsoluong(Integer.parseInt(ttmoi));
                else if (suatt.equalsIgnoreCase("mo ta"))
                    dv.setmota(ttmoi);
                System.out.println("Da cap nhat thong tin dich vu co ma: " + madv);
                return;
            }
        }
        System.out.println("Khong tim thay dich vu co ma: " + madv);
    }

    public DichVu timtheomadv(String ma) {
        for (DichVu dv : ds) {
            if (dv.getmadv().equalsIgnoreCase(ma)) {
                dv.xuat();
                return dv;
            }
        }
        System.out.println("khong tim thay dich vu co ma: " + ma);
        return null;
    }

    public DichVu timtheomadv() {
        System.out.print("Nhap ma dich vu can tim: ");
        Scanner sc = new Scanner(System.in);
        String ma = sc.nextLine();
        return timtheomadv(ma);
    }

    private DichVu[] themvaomang(DichVu[] mang, DichVu dvmoi) {
        DichVu[] mangmoi = Arrays.copyOf(mang, mang.length + 1);
        mangmoi[mangmoi.length - 1] = dvmoi;
        return mangmoi;
    }

    public DichVu[] timtheotendv(String tendv) {
        DichVu[] ketqua = new DichVu[0];
        for (DichVu dv : ds) {
            if (dv.gettendv().contains(tendv)) {
                ketqua = themvaomang(ketqua, dv);
            }
        }
        if (ketqua.length == 0) {
            System.out.println("khong tim thay ten dich vu:" + tendv);
            return null;
        }
        System.out.println("Cac dich vu tim thay:");
        for (DichVu dv : ketqua)
            dv.xuat();
        return ketqua;
    }

    public DichVu[] timtheotendv() {
        System.out.print("Nhap ten dich vu can tim: ");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        String tendv = sc.nextLine();
        return timtheotendv(tendv);
    }

    public String[] thongke() {
        if (ds.length == 0) {
            System.out.println("Danh sach dich vu rong!");
            return null;
        }

        int tongDV = ds.length;
        int tongSL = 0;
        float tongGiaTri = 0;
        float maxGia = ds[0].getdongia();
        float minGia = ds[0].getdongia();
        DichVu dvMaxGia = ds[0];
        DichVu dvMinGia = ds[0];
        DichVu dvMaxSL = ds[0];
        DichVu dvMinSL = ds[0];

        for (DichVu dv : ds) {
            tongSL += dv.getsoluong();
            tongGiaTri += dv.getdongia() * dv.getsoluong();

            if (dv.getdongia() > maxGia) {
                maxGia = dv.getdongia();
                dvMaxGia = dv;
            }
            if (dv.getdongia() < minGia) {
                minGia = dv.getdongia();
                dvMinGia = dv;
            }
            if (dv.getsoluong() > dvMaxSL.getsoluong()) {
                dvMaxSL = dv;
            }
            if (dv.getsoluong() < dvMinSL.getsoluong()) {
                dvMinSL = dv;
            }
        }

        // ====== In ra màn hình ======
        System.out.println("\n===== THONG KE DICH VU =====");
        System.out.println("Tong so dich vu: " + tongDV);
        System.out.println("Tong so luong dich vu con lai: " + tongSL);
        System.out.println("Tong gia tri dich vu: " + tongGiaTri);

        System.out.println("\n--- Dich vu co gia cao nhat ---");
        System.out.printf("%-9s %-15s %-15s %-15s %-15s\n", "Ma DV", "Ten DV", "Don gia", "So luong", "Mo ta");
        dvMaxGia.xuat();

        System.out.println("\n--- Dich vu co gia thap nhat ---");
        System.out.printf("%-9s %-15s %-15s %-15s %-15s\n", "Ma DV", "Ten DV", "Don gia", "So luong", "Mo ta");
        dvMinGia.xuat();

        System.out.println("\n--- Dich vu co so luong nhieu nhat ---");
        System.out.printf("%-9s %-15s %-15s %-15s %-15s\n", "Ma DV", "Ten DV", "Don gia", "So luong", "Mo ta");
        dvMaxSL.xuat();

        System.out.println("\n--- Dich vu co so luong it nhat ---");
        System.out.printf("%-9s %-15s %-15s %-15s %-15s\n", "Ma DV", "Ten DV", "Don gia", "So luong", "Mo ta");
        dvMinSL.xuat();

        // ====== Trả về mảng String (vừa có thể in, vừa có thể dùng lại) ======
        String[] kq = {
                String.valueOf(tongDV),
                String.valueOf(tongSL),
                String.valueOf(tongGiaTri),
                dvMaxGia.gettendv(),
                dvMinGia.gettendv(),
                dvMaxSL.gettendv(),
                dvMinSL.gettendv()
        };
        return kq;
    }

    public void docFile() {
        File file = new File("QuanLyKhachSan/DichVu.txt");
        if (!file.exists()) {
            System.out.println("File khong ton tai!");
            return;
        }
        try (Scanner f = new Scanner(file)) {
            while (f.hasNextLine()) {
                String line = f.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    ds = Arrays.copyOf(ds, ds.length + 1);
                    ds[ds.length - 1] = new DichVu(parts[0], parts[1], Float.parseFloat(parts[2]),
                            Integer.parseInt(parts[3]), parts[4]);
                }
            }
        } catch (Exception e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }

    public void ghiFile() {
        File file = new File("QuanLyKhachSan/DichVu.txt");
        try (PrintWriter w = new PrintWriter(file)) {
            for (DichVu dv : ds)
                w.println(dv.toString());
        } catch (Exception e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    // public static void main(String[] args) {
    // DSDV dsdv = new DSDV();
    // dsdv.docFile("QuanLyKhachSan/DichVu.txt");
    // dsdv.ghiFile("QuanLyKhachSan/DichVu.txt");
    // dsdv.menudichvu();
    // }
}