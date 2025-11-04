package QuanLyKhachSan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class DSP implements interfaceDS {
    private Phong[] dsp;
    private int soLuong;

    public DSP() {
        dsp = new Phong[0];
        soLuong = 0;
    }

    public DSP(Phong[] dsp, int soLuong) {
        this.dsp = dsp;
        this.soLuong = soLuong;
    }

    public boolean maTonTai(String maTonTai) {
        for (int i = 0; i < soLuong; i++) {
            if (dsp[i].getMP().equals(maTonTai))
                return true;
        }
        return false;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        int soLuong = 0;
        while (true) {
            System.out.println("Nhap so luong phong: ");
            try {
                soLuong = sc.nextInt();
                if (soLuong <= 0)
                    System.out.println("So luong phong khong hop le! Vui long nhap lai");
                else
                    break;
            } catch (Exception e) {
                System.out.println("Ban phai nhap lai so nguyen! Vui long nhap lai: ");
                sc.nextLine();
            }
        }
        dsp = new Phong[soLuong];
        soLuong = 0;
        for (int i = 0; i < soLuong; i++) {
            System.out.println("Phong thu " + (i + 1) + ": ");
            ;

            int loaiPhong = 0;
            while (true) {
                try {
                    System.out.println("1. Phong Thuong \\t2. Phong Vip");
                    System.out.print("Chon loai phong: ");
                    sc.nextLine();

                    if (loaiPhong == 1 || loaiPhong == 2) {
                        break;
                    } else {
                        System.out.print("Lua chon khong hop le! Vui long chon 1 hoac 2.");
                    }
                } catch (Exception e) {
                    System.out.println("Ban phai nhap lai so nguyen! Vui long nhap lai: ");
                    sc.nextLine();
                }
            }

            if (loaiPhong == 1) {
                dsp[i] = new PhongThuong();
            } else {
                dsp[i] = new PhongVip();
            }

            dsp[i].nhap();
            if (maTonTai(dsp[i].getMP())) {
                System.out.println("Ma phong da ton tai, khong them vao danh sach.\n\nVui long nhap lai: ");
                i--;
            } else {
                soLuong++;
            }
        }
    }

    public void them(Phong dspMoi) {
        dsp = Arrays.copyOf(dsp, dsp.length + 1);
        dsp[soLuong] = dspMoi;
        soLuong++;
    }

    public void them() {
        Scanner sc = new Scanner(System.in);
        int them = 0;
        while (true) {
            System.out.print("Nhap so luong phong can them: ");
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
            System.out.println("Phong thu " + (i + 1) + ": ");
            int loaiPhong = 0;
            while (true) {
                try {
                    System.out.println("1. Phong Thuong \t2. Phong Vip");
                    System.out.print("Chon loai phong: ");
                    loaiPhong = sc.nextInt();
                    sc.nextLine();

                    if (loaiPhong == 1 || loaiPhong == 2) {
                        break;
                    } else {
                        System.out.println("Lua chon khong hop le! Vui long chon 1 hoac 2.");
                    }
                } catch (Exception e) {
                    System.out.println("Ban phai nhap so nguyen! Vui long nhap lai: ");
                    sc.nextLine();
                }
            }
            Phong dspMoi;
            if (loaiPhong == 1) {
                dspMoi = new PhongThuong();
            } else {
                dspMoi = new PhongVip();
            }

            dspMoi.nhap();
            if (maTonTai(dspMoi.getMP())) {
                System.out.println("Ma phong da ton tai, khong them vao danh sach.\n\nVui long nhap lai: ");
                i--;
            } else {
                them(dspMoi);
            }
        }

    }

    public void xoa(String maCanXoa) {
        for (int i = 0; i < soLuong; i++) {
            if (dsp[i].getMP().equals(maCanXoa)) {
                for (int j = i; j < soLuong - 1; j++) {
                    dsp[j] = dsp[j + 1];
                }
                soLuong--;
                dsp = Arrays.copyOf(dsp, soLuong);
                System.out.println("Da xoa phong thanh cong!");
                return;
            }
        }
        System.out.println("Khong tim thay phong co ma: " + maCanXoa);
    }

    public void sua(String maCanSua) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < soLuong; i++) {
            if (dsp[i].getMP().equals(maCanSua)) {
                System.out.println("Ban co muon doi loai phong khong?");
                System.out.println("1. Co");
                System.out.println("2. Khong");
                System.out.print("Lua chon: ");
                int doiLoai = sc.nextInt();
                sc.nextLine();

                if (doiLoai == 1) {
                    System.out.println("Chon loai phong moi:");
                    System.out.println("1. Phong Thuong");
                    System.out.println("2. Phong Vip");
                    System.out.print("Chon: ");
                    int loaiMoi = sc.nextInt();
                    sc.nextLine();

                    String maPhongCu = dsp[i].getMP();
                    float donGiaCu = dsp[i].getDG();
                    int soNguoiCu = dsp[i].getSN();
                    int soGiuongCu = dsp[i].getSG();
                    boolean tinhTrangCu = dsp[i].getTT();

                    if (loaiMoi == 1) {
                        dsp[i] = new PhongThuong();
                    } else if (loaiMoi == 2) {
                        dsp[i] = new PhongVip();
                    }

                    dsp[i].setMP(maPhongCu);
                    dsp[i].setDG(donGiaCu);
                    dsp[i].setSN(soNguoiCu);
                    dsp[i].setSG(soGiuongCu);
                    dsp[i].setTT(tinhTrangCu);

                    if (loaiMoi == 1 && dsp[i] instanceof PhongThuong) {
                        PhongThuong pt = (PhongThuong) dsp[i];
                        System.out.println("Nhap cac thong tin cho Phong Thuong:");
                        System.out.print("Nhap phi dua don: ");
                        pt.setPhiDuaDon(sc.nextDouble());
                        System.out.print("Nhap phi dich vu ngoai troi: ");
                        pt.setDVNT(sc.nextDouble());
                        sc.nextLine();
                    } else if (loaiMoi == 2 && dsp[i] instanceof PhongVip) {
                        PhongVip pv = (PhongVip) dsp[i];
                        System.out.println("Nhap cac thong tin cho Phong Vip:");

                        System.out.println("Chon qua chao mung:");
                        System.out.println("1. Banh, keo mien phi moi buoi sang");
                        System.out.println("2. Nuoc trai cay mien phi moi buoi toi");
                        System.out.print("Chon: ");
                        int loaiQCM = sc.nextInt();
                        sc.nextLine();

                        if (loaiQCM == 1) {
                            pv.setQCM("Banh, keo mien phi moi buoi sang");
                        } else {
                            pv.setQCM("Nuoc trai cay mien phi moi buoi toi");
                        }

                        System.out.println("Chon loai Jacuzzi:");
                        System.out.println("1. Jacuzzi Tieu Chuan");
                        System.out.println("2. Jacuzzi Ngoai Troi");
                        System.out.println("3. Jacuzzi Trong Nha");
                        System.out.println("4. Jacuzzi Cao Cap");
                        System.out.print("Chon: ");
                        int loaiJacuzzi = sc.nextInt();
                        sc.nextLine();

                        switch (loaiJacuzzi) {
                            case 1:
                                pv.setJacuzzi("Jacuzzi Tieu Chuan");
                                break;
                            case 2:
                                pv.setJacuzzi("Jacuzzi Ngoai Troi");
                                break;
                            case 3:
                                pv.setJacuzzi("Jacuzzi Trong Nha");
                                break;
                            case 4:
                                pv.setJacuzzi("Jacuzzi Cao Cap");
                                break;
                        }
                    }

                    System.out.println("Da doi loai phong thanh cong!");
                }

                int luaChon;
                do {
                    System.out.println("\n\t\t\t\t\t==========SUA THONG TIN PHONG==========");
                    System.out.println("1. Sua don gia");
                    System.out.println("2. Sua so nguoi");
                    System.out.println("3. Sua so giuong");
                    System.out.println("4. Sua tinh trang");

                    if (dsp[i] instanceof PhongThuong) {
                        System.out.println("5. Sua phi dua don");
                        System.out.println("6. Sua phi dich vu ngoai troi");
                    } else if (dsp[i] instanceof PhongVip) {
                        System.out.println("5. Sua qua chao mung");
                        System.out.println("6. Sua loai Jacuzzi");
                    }

                    System.out.println("7. Sua tat ca");
                    System.out.println("0. Quay lai");
                    System.out.print("Chon: ");
                    luaChon = sc.nextInt();
                    sc.nextLine();

                    switch (luaChon) {
                        case 1:
                            System.out.println("Nhap don gia moi: ");
                            dsp[i].setDG(sc.nextFloat());
                            break;

                        case 2:
                            System.out.println("Nhap so nguoi moi: ");
                            dsp[i].setSN(sc.nextInt());
                            break;

                        case 3:
                            System.out.println("Nhap so giuong moi: ");
                            dsp[i].setSG(sc.nextInt());
                            break;

                        case 4:
                            System.out.print("Nhap tinh trang(con/khong con): ");
                            String tt = sc.nextLine().toLowerCase();
                            if (tt.equals("trong")) {
                                dsp[i].setTT(true);
                            } else {
                                dsp[i].setTT(false);
                            }
                            System.out.println("Da sua tinh trang!");
                            break;

                        case 5:
                            if (dsp[i] instanceof PhongThuong) {
                                System.out.print("Nhap phi dua don moi: ");
                                ((PhongThuong) dsp[i]).setPhiDuaDon(sc.nextDouble());
                                sc.nextLine();
                                System.out.println("Da sua phi dua don!");
                            } else if (dsp[i] instanceof PhongVip) {
                                System.out.println("Chon qua chao mung moi:");
                                System.out.println("1. Banh, keo mien phi moi buoi sang");
                                System.out.println("2. Nuoc trai cay mien phi moi buoi toi");
                                System.out.print("Chon: ");
                                int loaiQCM = sc.nextInt();
                                sc.nextLine();
                                if (loaiQCM == 1) {
                                    ((PhongVip) dsp[i]).setQCM("Banh, keo mien phi moi buoi sang");
                                } else {
                                    ((PhongVip) dsp[i]).setQCM("Nuoc trai cay mien phi moi buoi toi");
                                }
                                System.out.println("Da sua qua chao mung!");
                            }
                            break;

                        case 6:
                            if (dsp[i] instanceof PhongThuong) {
                                System.out.print("Nhap phi dich vu ngoai troi moi: ");
                                ((PhongThuong) dsp[i]).setDVNT(sc.nextDouble());
                                sc.nextLine();
                                System.out.println("Da sua phi dich vu!");
                            } else if (dsp[i] instanceof PhongVip) {
                                System.out.println("Chon loai Jacuzzi moi:");
                                System.out.println("1. Jacuzzi Tieu Chuan");
                                System.out.println("2. Jacuzzi Ngoai Troi");
                                System.out.println("3. Jacuzzi Trong Nha");
                                System.out.println("4. Jacuzzi Cao Cap");
                                System.out.print("Chon: ");
                                int loaiJacuzzi = sc.nextInt();
                                sc.nextLine();
                                switch (loaiJacuzzi) {
                                    case 1:
                                        ((PhongVip) dsp[i]).setJacuzzi("Jacuzzi Tieu Chuan");
                                        break;
                                    case 2:
                                        ((PhongVip) dsp[i]).setJacuzzi("Jacuzzi Ngoai Troi");
                                        break;
                                    case 3:
                                        ((PhongVip) dsp[i]).setJacuzzi("Jacuzzi Trong Nha");
                                        break;
                                    case 4:
                                        ((PhongVip) dsp[i]).setJacuzzi("Jacuzzi Cao Cap");
                                        break;
                                }
                                System.out.println("Da sua loai Jacuzzi!");
                            }
                            break;

                        case 7:
                            System.out.println("Nhap lai tat ca thong tin:");
                            dsp[i].nhap();
                            System.out.println("Da sua tat ca thong tin!");
                            break;

                        case 0:
                            System.out.println("Thoat che do sua phong!");
                            break;

                        default:
                            System.out.println("Lua chon khong hop le! Vui long chon lại.");
                            break;
                    }
                } while (luaChon != 0);
                System.out.println("\n---------------");
                return;
            }
        }
        System.out.println("Khong tim thay phong " + maCanSua);
        System.out.println("\n---------------");
    }

    public Phong timPhongTheoMa(String maPhong) {
        for (int i = 0; i < soLuong; i++) {
            if (dsp[i].getMP().equals(maPhong)) {
                return dsp[i];
            }
        }
        return null;
    }

    public DSP timPhongTheoLoai(String loaiPhong) {
        DSP dsLoai = new DSP();
        for (int i = 0; i < soLuong; i++) {
            if (loaiPhong.equalsIgnoreCase("Thuong") && dsp[i] instanceof PhongThuong) {
                dsLoai.them(dsp[i]);
            } else if (loaiPhong.equalsIgnoreCase("Vip") && dsp[i] instanceof PhongVip) {
                dsLoai.them(dsp[i]);
            }
        }
        return dsLoai;
    }

    public DSP timPhongTheoGia(float giaPhong) {
        DSP dsGia = new DSP();
        for (int i = 0; i < soLuong; i++) {
            if (dsp[i].getDG() == giaPhong) {
                dsGia.them(dsp[i]);
            }
        }
        return dsGia;
    }

    public void menuTimKiem() {
        Scanner sc = new Scanner(System.in);
        int luaChon;
        do {
            System.out.println("\n\t\t\t\t\t==========MENU TIM KIEM PHONG==========");
            System.out.println("1. Tim kiem theo ma phong");
            System.out.println("2. Tim kiem theo loai phong");
            System.out.println("3. Tim kiem theo gia phong");
            System.out.println("0. Thoat");
            System.out.print("Lua chon: ");

            luaChon = sc.nextInt();
            sc.nextLine();

            switch (luaChon) {
                case 1:
                    System.out.println("\n\t\t\t\t\t==========TIM PHONG THEO MA==========");
                    System.out.print("Nhap ma phong can tim: ");
                    String maPhong = sc.nextLine();
                    Phong dsMa = timPhongTheoMa(maPhong);
                    if (dsMa != null) {
                        if (dsMa instanceof PhongThuong) {
                            System.out.printf("%-10s %-10s %-10s %-15s %-14s %-15s %-25s %-20s\n",
                                    "Ma Phong", "Don Gia", "So Nguoi", "So Giuong", "Tinh Trang",
                                    "Loai Phong", "Phi Dua Don", "Dich Vu Ngoai Troi");
                        } else if (dsMa instanceof PhongVip) {
                            System.out.printf("%-10s %-10s %-10s %-15s %-14s %-15s %-25s %-20s\n",
                                    "Ma Phong", "Don Gia", "So Nguoi", "So Giuong", "Tinh Trang",
                                    "Loai Phong", "Qua Chao Mung", "Jacuzzi");
                        }
                        dsMa.xuat();
                    } else {
                        System.out.println("Khong tim thay phong co ma: " + maPhong);
                    }
                    break;
                case 2:
                    System.out.println("\n\t\t\t\t\t==========TIM PHONG THEO LOAI==========");
                    System.out.print("Nhap loai phong can tim: ");
                    String loaiPhong = sc.nextLine();
                    DSP dsLoai = timPhongTheoLoai(loaiPhong);
                    if (dsLoai != null) {
                        dsLoai.xuat();
                    } else {
                        System.out.println("Khong tim thay phong co loai: " + loaiPhong);
                    }
                    break;

                case 3:
                    System.out.println("\n\t\t\t\t\t==========TIM PHONG THEO GIA==========");
                    System.out.print("Nhap gia phong can tim: ");
                    float giaPhong = sc.nextFloat();
                    DSP dsGia = timPhongTheoGia(giaPhong);
                    if (dsGia.soLuong > 0) {
                        dsGia.xuat();
                    } else {
                        System.out.println("Khong tim thay phong co gia: " + giaPhong);
                    }
                    break;
                case 0:
                    System.out.println("Quay lai menu chinh");
                    break;

                default:
                    System.out.println("Lua chon khong hop le! Vui long chon lại.");
                    break;
            }
        } while (luaChon != 0);
    }

    public int[] thongKeTinhTrangPhong() {
        int[] thongKe = new int[2];

        for (int i = 0; i < soLuong; i++) {
            if (dsp[i].getTT() == true) {
                thongKe[0]++;
            } else {
                thongKe[1]++;
            }
        }

        System.out.println("\n\t\t\t\t\t==========THONG KE TINH TRANG PHONG==========");
        System.out.printf("%-20s %-20s %-20s\n", "Tong so phong", "Phong trong", "Phong da dat");
        System.out.printf("%-20d %-20d %-20d\n", soLuong, thongKe[0], thongKe[1]);
        System.out.println("\n---------------");
        return thongKe;
    }

    public void xuat() {
        if (soLuong == 0) {
            System.out.println("Khong tim thay phong!");
            return;
        }
        for (int i = 0; i < soLuong; i++) {
            if (dsp[i] instanceof PhongThuong) {
                PhongThuong pt = (PhongThuong) dsp[i];
                String tt = pt.getTT() ? "Trong" : "Da dat";
                System.out.printf("%-10s %-10s %-10s %-15s %-14s %-15s %-25s %-20s\n",
                        "Ma Phong", "Don Gia", "So Nguoi", "So Giuong", "Tinh Trang",
                        "Loai Phong", "Phi Dua Don", "Dich Vu Ngoai Troi");
            } else if (dsp[i] instanceof PhongVip) {
                PhongVip pt = (PhongVip) dsp[i];
                String tt = pt.getTT() ? "Trong" : "Da dat";
                System.out.printf("%-10s %-10s %-10s %-15s %-14s %-15s %-25s %-20s\n",
                        "Ma Phong", "Don Gia", "So Nguoi", "So Giuong", "Tinh Trang",
                        "Loai Phong", "Qua Chao Mung", "Jacuzzi");
            }
            dsp[i].xuat();
        }
    }

    public void docFile() {
        File file = new File("QuanLyKhachSan/Phong.txt");
        if (!file.exists()) {
            System.out.println("Khong tim thay file.");
            return;
        }
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 8) {
                    String maPhong = parts[0].trim();
                    float donGia = Float.parseFloat(parts[1].trim());
                    int soNguoi = Integer.parseInt(parts[2].trim());
                    int soGiuong = Integer.parseInt(parts[3].trim());
                    String tinhTrangStr = parts[4].trim().toLowerCase();
                    boolean tinhTrang = tinhTrangStr.equals("con");

                    String loaiPhong = parts[5].trim();
                    if (loaiPhong.equals("Thuong")) {
                        double phiDuaDon = Double.parseDouble(parts[6].trim());
                        double dichVuNT = Double.parseDouble(parts[7].trim());
                        PhongThuong pt = new PhongThuong(maPhong, donGia, soNguoi, soGiuong, tinhTrang, dichVuNT,
                                phiDuaDon);

                        if (!maTonTai(maPhong)) {
                            dsp = Arrays.copyOf(dsp, dsp.length + 1);
                            dsp[soLuong] = pt;
                            soLuong++;
                        }
                    } else if (loaiPhong.equals("Vip")) {
                        String quaChaoMung = parts[6].trim();
                        String Jacuzzi = parts[7].trim();
                        PhongVip pv = new PhongVip(maPhong, donGia, soNguoi, soGiuong, tinhTrang, quaChaoMung, Jacuzzi);

                        if (!maTonTai(maPhong)) {
                            dsp = Arrays.copyOf(dsp, dsp.length + 1);
                            dsp[soLuong] = pv;
                            soLuong++;
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Khong doc file duoc.");
        }
    }

    public void ghiFile() {
        File file = new File("QuanLyKhachSan/Phong.txt");
        try (PrintWriter pw = new PrintWriter(file)) {
            for (Phong p : dsp) {
                pw.println(p.toString());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Khong tao duoc file");
        }
    }

    // public static void main(String[] args) {
    // DSP dsp = new DSP();
    // Phong p2 = new PhongThuong("1", 1, 1, 1, false, 1, 1);
    // Phong p1 = new PhongVip("2", 2, 2, 2, true, "Nuoc trai cay mien phi.", "2");

    // dsp.docFile();
    // dsp.ghiFile();
    // dsp.them(p2);
    // dsp.them(p1);
    // }
}
