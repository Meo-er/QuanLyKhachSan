package QuanLyKhachSan;

import java.util.*;
import java.io.*;

public class DanhSachChiTietPNH {


    private ChiTietPNH[] ds = new ChiTietPNH[0];
    private Scanner sc = new Scanner(System.in);

    // ==================== CONSTRUCTOR ====================
    public DanhSachChiTietPNH() {}

    public DanhSachChiTietPNH(ChiTietPNH[] ds2) {
        ds = Arrays.copyOf(ds2, ds2.length);
    }

    public DanhSachChiTietPNH(DanhSachChiTietPNH other) {
        ds = Arrays.copyOf(other.ds, other.ds.length);
    }


    public void setDS(ChiTietPNH[] dsct) {
        this.ds = Arrays.copyOf(dsct, dsct.length);
    }
    
    public ChiTietPNH[] getDS() {
        return ds;
    }

    // ==================== KIỂM TRA MÃ TRÙNG ====================
    public boolean kiemTraMaDuyNhat(String ma) {
        for (ChiTietPNH ctpnh : ds)
            if (ma.equals(ctpnh.getMasp()))
                return false;
        return true;
    }

    // ==================== NHẬP DANH SÁCH ====================
    public void nhap(String maPhieuNH) {
        System.out.print("Nhap so luong chi tiet phieu nhap hang can them: ");
        int sl = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < sl; i++) {
            int lan = 5;
            boolean thanhCong = false;
            System.out.println("\nNhap thong tin chi tiet phieu nhap thu " + (i + 1) + ":");

            while (lan > 0 && !thanhCong) {
                ChiTietPNH ctpnh = new ChiTietPNH();
                ctpnh.nhap(maPhieuNH); // dùng hàm nhập của ChiTietPNH

                if (them(ctpnh))
                    thanhCong = true;
                else {
                    System.out.println("Ma san pham da ton tai! Vui long nhap lai.");
                    lan--;
                }
            }

            if (!thanhCong) {
                System.out.println("Da nhap qua so lan quy dinh!");
                return;
            }
        }
    }

    // ==================== THÊM ====================
    public boolean them(ChiTietPNH ctpnh) {
        if (kiemTraMaDuyNhat(ctpnh.getMasp())) {
            ds = Arrays.copyOf(ds, ds.length + 1);
            ds[ds.length - 1] = new ChiTietPNH(ctpnh);
            return true;
        }
        return false;
    }

    public void them(String ma) {
        ChiTietPNH ctpnh = new ChiTietPNH();
        ctpnh.nhap(ma);
        if (them(ctpnh))
            System.out.println("Them thanh cong!");
        else
            System.out.println("Ma san pham bi trung!");
    }

    // ==================== SỬA ====================
    public void sua() {
        System.out.print("Nhap ma san pham muon sua: ");
        String masp = sc.nextLine();
        sua(masp);
    }

    public void sua(String masp) {
        for (ChiTietPNH ctpnh : ds) {
            if (masp.equals(ctpnh.getMasp())) {
                System.out.println("Ban muon sua gi?");
                System.out.println("1. Ma san pham");
                System.out.println("2. Ten san pham");
                System.out.println("3. So luong");
                System.out.println("4. Don gia");
                int chon = sc.nextInt();
                sc.nextLine();

                switch (chon) {
                    case 1:
                        System.out.print("Nhap ma san pham moi: ");
                        ctpnh.setMasp(sc.nextLine());
                        break;
                    case 2:
                        System.out.print("Nhap ten san pham moi: ");
                        ctpnh.setTensp(sc.nextLine());
                        break;
                    case 3:
                        System.out.print("Nhap so luong moi: ");
                        ctpnh.setSoluong(sc.nextInt());
                        sc.nextLine();
                        break;
                    case 4:
                        System.out.print("Nhap don gia moi: ");
                        ctpnh.setDongia(sc.nextFloat());
                        sc.nextLine();
                        break;
                    default:
                        System.out.println("Lua chon khong hop le!");
                }
                System.out.println("Sua thong tin thanh cong!");
                return;
            }
        }
        System.out.println("Khong tim thay san pham co ma: " + masp);
    }

    // ==================== XÓA ====================
    public void xoa() {
        System.out.print("Nhap ma san pham muon xoa: ");
        String masp = sc.nextLine();
        xoa(masp);
    }

    public void xoa(String masp) {
        for (int i = 0; i < ds.length; i++) {
            if (masp.equals(ds[i].getMasp())) {
                for (int j = i; j < ds.length - 1; j++)
                    ds[j] = ds[j + 1];
                ds = Arrays.copyOf(ds, ds.length - 1);
                System.out.println("Xoa thanh cong!");
                return;
            }
        }
        System.out.println("Khong tim thay san pham co ma: " + masp);
    }

    // ==================== XUẤT ====================
    public void xuatTieuDe() {
        System.out.printf("%-8s %-8s %-20s %-9s %-10s %-12s \n","Ma PNH", "Ma SP", "Ten SP", "So luong", "Don gia", "Thanh tien");
    }

    public void xuatDuoi() {
    }

    public void xuat() {
        xuatTieuDe();
        for (ChiTietPNH ctpnh : ds)
            ctpnh.xuat();
    }

    public ChiTietPNH[] getChiTietTheoMaPhieu(String maPNH) {
        ChiTietPNH[] kq = new ChiTietPNH[0];
        int sl = 0;

        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getMapnh().equalsIgnoreCase(maPNH)) {
                ChiTietPNH[] tam = new ChiTietPNH[sl + 1];
                for (int j = 0; j < sl; j++)
                    tam[j] = kq[j];
                tam[sl] = ds[i];
                kq = tam;
                sl++;
            }
        }
        return kq;
    }
    // ==================== TÌM KIẾM ====================
    public void timKiemTheoMaSP() {
        System.out.print("Nhap ma san pham muon tim: ");
        String masp = sc.nextLine();
        timKiemTheoMaSP(masp);
    }

    public void timKiemTheoMaSP(String masp) {
        boolean found = false;
        for (ChiTietPNH ctpnh : ds) {
            if (masp.equals(ctpnh.getMasp())) {
                xuatTieuDe();
                ctpnh.xuat();
                xuatDuoi();
                found = true;
            }
        }
        if (!found)
            System.out.println("Khong tim thay san pham nao!");
    }

    // ==================== THỐNG KÊ ====================
    public Map<String, Integer> thongKeTheoMaSP() {
        Map<String, Integer> count = new HashMap<>();
        for (ChiTietPNH ctpnh : ds)
            count.put(ctpnh.getMasp(), count.getOrDefault(ctpnh.getMasp(), 0) + ctpnh.getSoluong());
        for (Map.Entry<String, Integer> e : count.entrySet())
            System.out.println("Ma SP: " + e.getKey() + " - Tong so luong nhap: " + e.getValue());
        return count;
    }

    // ==================== TÍNH TỔNG TIỀN ====================
    public float tinhTongTien() {
        float tong = 0;
        for (ChiTietPNH ctpnh : ds)
            tong += ctpnh.getThanhTien();
        return tong;
    }

    // ==================== TÍNH TỔNG SỐ LƯỢNG ====================
    public int tongSoLuong() {
        int tong = 0;
        for (ChiTietPNH ctpnh : ds)
            tong += ctpnh.getSoluong();
        return tong;
    }


    // ==================== FILE ====================
    public void docFile(String fileName) {
        File file = new File(fileName);
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
                    ds[ds.length - 1] = new ChiTietPNH(parts[0], parts[1],parts[2],Integer.parseInt(parts[3]), Float.parseFloat(parts[4]));
                }
            }
        } catch (Exception e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }

    public void ghiFile(String fileName) {
        try (PrintWriter w = new PrintWriter(new FileWriter(fileName))) {
            for (ChiTietPNH ctpnh : ds)
                w.println(ctpnh.toString());
        } catch (Exception e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    // ==================== MAIN TEST ====================
    public static void main(String[] args) {
        DanhSachChiTietPNH dsp = new DanhSachChiTietPNH();
        dsp.docFile("Doan/ChitietPNH.txt");
        dsp.xuat();
    }
}