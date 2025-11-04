package QuanLyKhachSan;

import java.util.Scanner;

public class QLKS {
    private DSP dsp = new DSP();
    private DSNV dsnv = new DSNV();
    private DSKH dskh = new DSKH();
    private DSHD dshd = new DSHD();
    private DSPhieuDatPhong dspdp = new DSPhieuDatPhong();
    private DSPNH dspnh = new DSPNH();
    private DSDV dsdv = new DSDV();
    private DSPSDDV dspsddv;
    Scanner sc = new Scanner(System.in);

    public QLKS() {
        this.dspsddv = new DSPSDDV(this.dsdv);
    }

    public QLKS(DSP dsp, DSNV dsnv, DSKH dskh, DSHD dshd, DSPhieuDatPhong dspdp, DSPNH dspnh, DSDV dsdv,
            DSPSDDV dspsddv) {
        this.dsp = dsp;
        this.dsnv = dsnv;
        this.dskh = dskh;
        this.dshd = dshd;
        this.dspdp = dspdp;
        this.dspnh = dspnh;
        this.dsdv = dsdv;
        this.dspsddv = dspsddv;
    }

    public QLKS(QLKS qlks) {
        this.dsp = qlks.dsp;
        this.dsnv = qlks.dsnv;
        this.dskh = qlks.dskh;
        this.dshd = qlks.dshd;
        this.dspdp = qlks.dspdp;
        this.dspnh = qlks.dspnh;
        this.dsdv = qlks.dsdv;
        this.dspsddv = qlks.dspsddv;
    }

    public DSP getDsp() {
        return dsp;
    }

    public DSNV getDsnv() {
        return dsnv;
    }

    public DSKH getDskh() {
        return dskh;
    }

    public DSHD getDshd() {
        return dshd;
    }

    public DSPhieuDatPhong getDspDatPhong() {
        return dspdp;
    }

    public DSPNH getDspnh() {
        return dspnh;
    }

    public DSDV getDsDsdv() {
        return dsdv;
    }

    public DSPSDDV getDspsddv() {
        return dspsddv;
    }

    public void setDsp(DSP dsp) {
        this.dsp = dsp;
    }

    public void setDsnv(DSNV dsnv) {
        this.dsnv = dsnv;
    }

    public void setDskh(DSKH dskh) {
        this.dskh = dskh;
    }

    public void setDshd(DSHD dshd) {
        this.dshd = dshd;
    }

    public void setDspdp(DSPhieuDatPhong dspdp) {
        this.dspdp = dspdp;
    }

    public void setDspnh(DSPNH dspnh) {
        this.dspnh = dspnh;
    }

    public void setDsdv(DSDV dsdv) {
        this.dsdv = dsdv;
    }

    public void setDspsddv(DSPSDDV dspsddv) {
        this.dspsddv = dspsddv;
    }

    public void docTatCaFile() {
        dsp.docFile();
        dsnv.docFile();
        dskh.docFile();
        dshd.docFile();
        dspnh.docFile();
        dsdv.docFile();
        dspsddv.docFile();
    }

    public void ghiTatCaFile() {
        dsp.ghiFile();
        dsnv.ghiFile();
        dskh.ghiFile();
        dshd.ghiFile();
        dspnh.ghiFile();
        dsdv.ghiFile();
        dspsddv.ghiFile();
    }

    public void menuDSP() {
        int luaChon;
        do {
            System.out.println("\n\t\t\t\t\t==========MENU DANH SACH PHONG==========");
            System.out.println("1. Xem danh sach phong");
            System.out.println("2. Them phong");
            System.out.println("3. Sua phong");
            System.out.println("4. Xoa phong");
            System.out.println("5. Menu tim phong");
            System.out.println("6. Thong ke tinh trang phong");
            System.out.println("0. Thoat");
            System.out.print("Lua chon: ");
            luaChon = sc.nextInt();
            sc.nextLine();

            switch (luaChon) {
                case 1:
                    System.out.println("\t\t\t\t\t==========DANH SACH PHONG==========");
                    dsp.xuat();
                    break;
                case 2:
                    System.out.println("\t\t\t\t\t==========THEM PHONG==========");
                    dsp.them();
                    dsp.ghiFile();
                    break;
                case 3:
                    System.out.println("\t\t\t\t\t==========Sua PHONG ==========");
                    System.out.print("Nhap ma can sua: ");
                    String maCanSua = sc.nextLine();
                    dsp.sua(maCanSua);
                    dsp.ghiFile();
                    break;
                case 4:
                    System.out.println("\t\t\t\t\t==========XOA PHONG==========");
                    System.out.print("Nhap ma can xoa: ");
                    String maCanXoa = sc.nextLine();
                    dsp.xoa(maCanXoa);
                    dsp.ghiFile();
                    break;
                case 5:
                    dsp.menuTimKiem();
                    dsp.ghiFile();
                    break;
                case 6:
                    dsp.thongKeTinhTrangPhong();
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le! Vui long chon lại.");
                    break;
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
                    dsnv.xuat();
                    break;
                case 2:
                    System.out.println("\t\t\t\t\t==========THEM NHAN VIEN==========");
                    dsnv.them();
                    dsnv.ghiFile();
                    break;
                case 3:
                    System.out.println("\t\t\t\t\t==========SUA NHAN VIEN==========");
                    System.out.print("Nhap ma can sua: ");
                    String maCanSua = sc.nextLine();
                    dsnv.sua(maCanSua);
                    dsnv.ghiFile();
                    break;
                case 4:
                    System.out.println("\t\t\t\t\t==========XOA NHAN VIEN==========");
                    System.out.print("Nhap ma can xoa: ");
                    String maCanXoa = sc.nextLine();
                    dsnv.xoa(maCanXoa);
                    dsnv.ghiFile();
                    break;
                case 5:
                    dsnv.menuTimKiem();
                    break;
                case 6:
                    dsnv.thongKeLuong();
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
                    "Lua chon: \n0. Thoat \n1. Xem danh sach khach hang \n2. Them khach hang \n3. Sua khach hang \n4. Xoa khach hang \n5. Tim kiem khach hang \n6.Thong ke");
            System.out.print("Nhap lua chon: ");
            luaChon = sc.nextInt();
            sc.nextLine();
            switch (luaChon) {
                case 1:
                    System.out.println("\t\t\t\t\t==========DANH SACH KHACH HANG==========");
                    dskh.xuat();
                    break;
                case 2:
                    System.out.println("\t\t\t\t\t==========THEM KHACH HANG==========");
                    dskh.them();
                    dskh.ghiFile();
                    break;
                case 3:
                    System.out.println("\t\t\t\t\t==========SUA KHACH HANG==========");
                    System.out.print("Nhap ma can sua: ");
                    String maCanSua = sc.nextLine();
                    dskh.sua(maCanSua);
                    dskh.ghiFile();
                    break;
                case 4:
                    System.out.println("\t\t\t\t\t==========XOA KHACH HANG==========");
                    System.out.print("Nhap ma can xoa: ");
                    String maCanXoa = sc.nextLine();
                    dskh.xoa(maCanXoa);
                    dskh.ghiFile();
                    break;
                case 5:
                    dskh.menuTimKiem();
                    break;
                case 6:
                    System.out.println("\t\t\t\t\t==========THONG KE SO LUONG KHACH HANG==========");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (luaChon != 0);
    }

    public void menuHoaDon() {
        Scanner sc = new Scanner(System.in);
        int luaChon;
        do {
            System.out.println("\n\t\t\t\t\t==========MENU HOA DON==========");

            System.out.println(
                    "Lua chon: \n0. Thoat \n1. Xem danh sach hoa don \n2. Them hoa don \n3. Sua hoa don \n4. Xoa hoa don \n5. Tim kiem hoa don \n6. Thong ke.");
            System.out.print("Nhap lua chon: ");
            luaChon = sc.nextInt();
            sc.nextLine();
            switch (luaChon) {
                case 1:
                    System.out.println("\t\t\t\t\t==========DANH SACH HOA DON==========");
                    dshd.xuat();
                    break;
                case 2:
                    System.out.println("\t\t\t\t\t==========THEM HOA DON==========");
                    dshd.them();
                    dshd.ghiFile();
                    break;
                case 3:
                    System.out.println("\t\t\t\t\t==========SUA HOA DON==========");
                    System.out.print("Nhap ma can sua: ");
                    String maCanSua = sc.nextLine();
                    dshd.sua(maCanSua);
                    dshd.ghiFile();
                    break;
                case 4:
                    System.out.println("\t\t\t\t\t==========XOA HOA DON==========");
                    System.out.print("Nhap ma can xoa: ");
                    String maCanXoa = sc.nextLine();
                    dshd.xoa(maCanXoa);
                    dshd.ghiFile();
                    break;
                case 5:
                    dshd.menuTimKiem();
                    break;
                case 6:
                    System.out.println("\t\t\t\t\t==========THONG KE DOANH THU==========");
                    dshd.thongKeDoanhThuTheoNV();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (luaChon != 0);
    }

    public void menuphieunh() {
        int choice;

        do {
            System.out.println("\n===== MENU PHIEU NHAP HANG =====");
            System.out.println("1. Nhap danh sach phieu nhap hang");
            System.out.println("2. Xem danh sach phieu nhap hang");
            System.out.println("3. Them phieu nhap hang moi");
            System.out.println("4. Sua thong tin phieu nhap hang");
            System.out.println("5. Xoa phieu nhap hang");
            System.out.println("6. Tim phieu theo ma");
            System.out.println("7. Thong ke phieu nhap hang");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    dspnh.nhapds();
                    break;
                case 2:
                    dspnh.xuat();
                    break;
                case 3:
                    dspnh.themphieunh();
                    dspnh.ghiFile();
                    break;
                case 4:
                    dspnh.suaphieu();
                    dspnh.ghiFile();
                    break;
                case 5:
                    dspnh.xoaPhieuNH();
                    dspnh.ghiFile();
                    break;
                case 6:
                    dspnh.timphieutheoma();
                    break;
                case 7:
                    dspnh.thongkePNH();
                    break;
                case 0:
                    System.out.println("Thoat menu.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 0);
    }

    public void menudichvu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n===== MENU DICH VU =====");
            System.out.println("1. Nhap danh sach dich vu");
            System.out.println("2. Xem danh sach dich vu");
            System.out.println("3. Them dich vu");
            System.out.println("4. Xoa dich vu");
            System.out.println("5. Sua thong tin dich vu");
            System.out.println("6. Tim dich vu theo ma");
            System.out.println("7. Tim dich vu theo ten");
            System.out.println("8. Thong ke dich vu");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    dsdv.nhapds();
                    break;
                case 2:
                    dsdv.xuatds();
                    break;
                case 3:
                    dsdv.themdv();
                    dsdv.ghiFile();
                    break;
                case 4:
                    dsdv.xoadv();
                    dsdv.ghiFile();
                    break;
                case 5:
                    dsdv.suathongtindv();
                    dsdv.ghiFile();
                    break;
                case 6:
                    dsdv.timtheomadv();
                    break;
                case 7:
                    dsdv.timtheotendv();
                    break;
                case 8:
                    dsdv.thongke();
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 0);
    }

    public void menuPSDDV() {
        Scanner sc = new Scanner(System.in);
        int luaChon;
        do {
            System.out.println("\n========== MENU QUAN LY PHIEU SDDV ==========");
            System.out.println("1. Xem danh sach phieu");
            System.out.println("2. Them phieu");
            System.out.println("3. Sua phieu");
            System.out.println("4. Xoa phieu");
            System.out.println("5. Tim kiem phieu");
            System.out.println("6. Thong ke thanh tien");
            System.out.println("0. Thoat");
            System.out.print("Lua chon: ");

            luaChon = sc.nextInt();
            sc.nextLine();
            switch (luaChon) {
                case 1:
                    System.out.println("\n========== DANH SACH PHIEU SU DUNG DICH VU ==========");
                    dspsddv.xuat();
                    break;
                case 2:
                    System.out.println("\n========== THEM PHIEU SU DUNG DICH VU ==========");
                    dspsddv.them();
                    dspsddv.ghiFile();
                    break;
                case 3:
                    System.out.println("\n========== SUA PHIEU SU DUNG DICH VU ==========");
                    System.out.print("Nhap ma phieu can sua: ");
                    String maCanSua = sc.nextLine();
                    dspsddv.sua(maCanSua);
                    dspsddv.ghiFile();
                    break;
                case 4:
                    System.out.println("\n========== XOA PHIEU SU DUNG DICH VU ==========");
                    System.out.print("Nhap ma phieu can xoa: ");
                    String maCanXoa = sc.nextLine();
                    dspsddv.xoa(maCanXoa);
                    dspsddv.ghiFile();
                    break;
                case 5:
                    dspsddv.menuTimKiem();
                    dspsddv.ghiFile();
                    break;
                case 6:
                    System.out.println("\n========== THONG KE THANH TIEN ==========");
                    dspsddv.thongKeThanhTien();
                    break;
                case 0:
                    System.out.println("Thoat!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }

        } while (luaChon != 0);
    }

    public void menuQLKS() {
        int luaChon;
        do {
            System.out.println("\n\t\t\t\t\t==========MENU XAY DUNG UNG DUNG QUAN LY KHACH SAN==========");
            System.out.println("1. Danh sach phong");
            System.out.println("2. Danh sach nhan vien");
            System.out.println("3. Danh sach khach hang");
            System.out.println("4. Danh sach hoa don");
            System.out.println("5. Danh sach phieu dat phong");
            System.out.println("6. Danh sach phieu nhap hang");
            System.out.println("7. Danh sach dich vu");
            System.out.println("8. Danh sach phieu su dung dich vu");
            System.out.println("0. Thoat");
            System.out.print("Lua chon: ");
            luaChon = sc.nextInt();
            sc.nextLine();

            switch (luaChon) {
                case 1:
                    menuDSP();
                    break;
                case 2:
                    menuNhanVien();
                    break;
                case 3:
                    menuKhachHang();
                    break;
                case 4:
                    menuHoaDon();
                    break;
                case 5:
                    dspdp.menuPDP();
                    break;
                case 6:
                    menuphieunh();
                    break;
                case 7:
                    menudichvu();
                    break;
                case 8:
                    menuPSDDV();
                    break;

                default:
                    System.out.println("Lua chon khong hop le! Vui long chon lại.");
                    break;
            }
        } while (luaChon != 0);
    }

    public static void main(String[] args) {
        QLKS qlks = new QLKS();
        qlks.docTatCaFile();
        qlks.menuQLKS();
    }
}
