package QuanLyKhachSan;

import java.io.File;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class DSPNH {
    private PhieuNH[] ds = new PhieuNH[0];
    private int slphieu;

    // ==== Getter & Setter ====
    public int getslphieu() {
        return slphieu;
    }

    public void setslphieu(int slphieu) {
        this.slphieu = slphieu;
    }

    public void setDS(PhieuNH[] ds) {
        this.ds = ds;
        this.slphieu = ds.length;
    }

    public boolean kiemTraMaDuyNhat(String ma) {
        for (PhieuNH p : ds)
            if (p.getmanh().equalsIgnoreCase(ma))
                return false;
        return true;
    }

    // ==== Nhập danh sách phiếu ====
    Scanner sc = new Scanner(System.in);

    public void nhapds() {
        System.out.print("Nhap so luong phieu nhap: ");
        slphieu = sc.nextInt();
        sc.nextLine();

        ds = new PhieuNH[slphieu];
        for (int i = 0; i < slphieu; i++) {
            System.out.println("\n===== Nhap phieu thu " + (i + 1) + " =====");
            ds[i] = new PhieuNH();
            ds[i].nhap(); // trong PhieuNH.nhap() đã tự gọi dsctpnh.nhap()
        }
    }

    // ==== Thêm phiếu mới ====

    public boolean them(PhieuNH p) {
        if (kiemTraMaDuyNhat(p.getmanh())) {
            ds = Arrays.copyOf(ds, ds.length + 1);
            ds[ds.length - 1] = new PhieuNH(p);
            return true;
        }
        return false;
    }

    public void themphieunh() {
        ds = Arrays.copyOf(ds, ds.length + 1);
        PhieuNH pnh = new PhieuNH();
        pnh.nhap(); // nhập cả phiếu và danh sách chi tiết
        ds[ds.length - 1] = pnh;
        System.out.println("✅ Da them phieu nhap hang moi!");
    }

    // ==== Xuất danh sách ====
    public void xuat() {
        if (slphieu == 0) {
            System.out.println("Khong co phieu nhap nao trong danh sach!");
            return;
        }

        System.out.println("===== DANH SACH PHIEU NHAP =====");

        for (int i = 0; i < slphieu; i++) {
            PhieuNH p = ds[i];
            System.out.println("-------------------------------------------");
            p.xuat();

            // Xuất chi tiết
            ChiTietPNH[] dsct = p.getDS().getDS();
            if (dsct == null || dsct.length == 0) {
                System.out.println("  (Khong co chi tiet)");
            } else {
                System.out.println("  --- Chi tiet phieu ---");
                System.out.printf("  %-8s %-20s %-10s %-10s %-12s\n", "MaSP", "TenSP", "SL", "DonGia", "ThanhTien");
                for (int j = 0; j < dsct.length; j++) {
                    ChiTietPNH c = dsct[j];
                    float tt = c.getSoluong() * c.getDongia();
                    System.out.printf("  %-8s %-20s %-10d %-10.0f %-12.0f\n",
                            c.getMasp(), c.getTensp(), c.getSoluong(), c.getDongia(), tt);
                }
            }

            System.out.println("  >> Tong tien phieu: " + p.getThanhTien());
        }

        System.out.println("===========================================");
    }

    // ==== Tìm phiếu ====
    public PhieuNH timphieutheoma(String ma) {
        for (PhieuNH p : ds) {
            if (p.getmanh().equalsIgnoreCase(ma)) {
                return p;
            }
        }
        return null;
    }

    public PhieuNH timphieutheoma() {
        System.out.print("Nhap ma phieu can tim: ");
        String ma = sc.nextLine();
        PhieuNH p = timphieutheoma(ma);
        if (p != null) {
            System.out.println("\n==> Thong tin phieu:");
            p.xuat();
            p.xuatChiTiet();
        } else {
            System.out.println("Khong tim thay phieu co ma " + ma);
        }
        return p;
    }

    // ==== Sửa phiếu ====
    public void suaphieu() {
        System.out.print("Nhap ma phieu can sua: ");
        String ma = sc.nextLine();
        PhieuNH p = timphieutheoma(ma);
        if (p == null) {
            System.out.println("Khong tim thay phieu voi ma " + ma);
            return;
        }

        int choice;
        do {
            System.out.println("\n===== MENU SUA PHIEU NHAP =====");
            System.out.println("1. Sua ma nha cung cap");
            System.out.println("2. Sua nhan vien lap phieu");
            System.out.println("3. Sua ngay nhap");
            System.out.println("4. Sua danh sach chi tiet phieu");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhap ma nha cung cap moi: ");
                    p.setmancc(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Nhap ma nhan vien moi: ");
                    p.setmanv(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Nhap ngay moi (yyyy-MM-dd): ");
                    String ngay = sc.nextLine();
                    p.setdate(LocalDate.parse(ngay, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                    break;
                case 4:
                    System.out.println("Nhap lai danh sach chi tiet phieu:");
                    p.getDS().nhap(p.getmanh());
                    break;
                case 0:
                    System.out.println("Thoat sua phieu.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 0);
    }

    // ==== Xóa phiếu ====
    public void xoaPhieuNH(String ma) {
        int index = -1;
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getmanh().equalsIgnoreCase(ma)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < ds.length - 1; i++) {
                ds[i] = ds[i + 1];
            }
            ds = Arrays.copyOf(ds, ds.length - 1);
            System.out.println("Da xoa phieu nhap co ma: " + ma);
        } else {
            System.out.println("Khong tim thay phieu co ma: " + ma);
        }
    }

    public void xoaPhieuNH() {
        System.out.print("Nhap ma phieu can xoa: ");
        String ma = sc.nextLine();
        xoaPhieuNH(ma);
    }

    // ==== Thống kê ====
    public void thongkePNH() {
        if (ds.length == 0) {
            System.out.println("Danh sach phieu nhap rong!");
            return;
        }

        int tongPhieu = ds.length;
        int tongSoLuong = 0;
        float tongGiaTri = 0;

        PhieuNH phieuMaxGT = ds[0];
        PhieuNH phieuMaxSL = ds[0];
        PhieuNH phieuMinSL = ds[0];

        for (PhieuNH p : ds) {
            int tongSLPhieu = p.getDS().tongSoLuong();
            float tongTienPhieu = p.getThanhTien();

            tongSoLuong += tongSLPhieu;
            tongGiaTri += tongTienPhieu;

            if (tongTienPhieu > phieuMaxGT.getThanhTien())
                phieuMaxGT = p;
            if (tongSLPhieu > phieuMaxSL.getDS().tongSoLuong())
                phieuMaxSL = p;
            if (tongSLPhieu < phieuMinSL.getDS().tongSoLuong())
                phieuMinSL = p;
        }

        System.out.println("\n===== THONG KE PHIEU NHAP HANG =====");
        System.out.println("Tong so phieu nhap: " + tongPhieu);
        System.out.println("Tong so luong hang nhap: " + tongSoLuong);
        System.out.println("Tong gia tri nhap: " + tongGiaTri);

        System.out.println("\n--- Phieu co gia tri cao nhat ---");
        phieuMaxGT.xuat();

        System.out.println("\n--- Phieu co nhieu san pham nhat ---");
        phieuMaxSL.xuat();

        System.out.println("\n--- Phieu co it san pham nhat ---");
        phieuMinSL.xuat();
    }

    public void docFile() {
        try {
            File fPhieu = new File("QuanLyKhachSan/PhieuNH.txt");
            File fCT = new File("QuanLyKhachSan/ChiTietPNH.txt");

            if (!fPhieu.exists() || !fCT.exists()) {
                System.out.println("Khong tim thay file du lieu!");
                return;
            }

            // ====== Đọc danh sách chi tiết trước ======
            DanhSachChiTietPNH dsct = new DanhSachChiTietPNH();
            dsct.docFile("QuanLyKhachSan/ChiTietPNH.txt");

            Scanner f = new Scanner(fPhieu);
            slphieu = 0;
            ds = new PhieuNH[0];

            while (f.hasNextLine()) {
                String line = f.nextLine().trim();
                if (line.equals(""))
                    continue;

                String[] t = line.split(",");
                if (t.length == 4) {
                    String maPNH = t[0];
                    String maNV = t[1];
                    String maNCC = t[2];
                    LocalDate ngay = LocalDate.parse(t[3], DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                    PhieuNH p = new PhieuNH(maPNH, maNV, maNCC, ngay);

                    // Gắn chi tiết tương ứng
                    ChiTietPNH[] ctTheoPhieu = dsct.getChiTietTheoMaPhieu(maPNH);
                    p.setDS(ctTheoPhieu);

                    // Thêm vào danh sách
                    PhieuNH[] tam = new PhieuNH[slphieu + 1];
                    for (int i = 0; i < slphieu; i++)
                        tam[i] = ds[i];
                    tam[slphieu] = p;
                    ds = tam;
                    slphieu++;
                }
            }

            f.close();
            System.out.println("Doc file DSPNH thanh cong (" + slphieu + " phieu).");

        } catch (Exception e) {
            System.out.println("Loi doc file DSPNH: " + e.getMessage());
        }
    }

    public void ghiFile() {
        try (PrintWriter pw = new PrintWriter("QuanLyKhachSan/PhieuNH.txt")) {
            for (PhieuNH p : ds) {
                pw.println(p.toString());
                p.getDS().ghiFile(p.getmanh());
            }
        } catch (Exception e) {
            System.out.println("Loi ghi file: " + e);
        }
    }

    // public static void main(String[] args) {
    // DSPNH dspnh = new DSPNH();
    // dspnh.docFile();
    // dspnh.menuphieunh();
    // }
}
