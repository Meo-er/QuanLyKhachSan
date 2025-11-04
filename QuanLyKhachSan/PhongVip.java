package QuanLyKhachSan;

import java.util.Scanner;

public class PhongVip extends Phong {
    private String quaChaoMung;
    private String Jacuzzi;

    public PhongVip() {
    }

    public PhongVip(String maPhong, float donGia, int soNguoi, int soGiuong, boolean tinhTrang, String quaChaoMung,
            String Jacuzzi) {
        super(maPhong, donGia, soNguoi, soGiuong, tinhTrang);
        this.quaChaoMung = quaChaoMung;
        this.Jacuzzi = Jacuzzi;
    }

    public PhongVip(PhongVip pv) {
        super(pv.getMP(), pv.getDG(), pv.getSN(), pv.getSG(), pv.getTT());
        this.quaChaoMung = pv.quaChaoMung;
        this.Jacuzzi = pv.Jacuzzi;
    }

    public String getQCM() {
        return quaChaoMung;
    }

    public void setQCM(String quaChaoMung) {
        this.quaChaoMung = quaChaoMung;
    }

    public String getJacuzzi() {
        return Jacuzzi;
    }

    public void setJacuzzi(String Jacuzzi) {
        this.Jacuzzi = Jacuzzi;
    }

    public String getLoaiPhong() {
        return "Vip";
    }

    public void nhap() {
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.println("=== NHAP THONG TIN PHONG VIP ===");
        System.out.println("Nhap qua chao mung: ");
        System.out.println("1. Banh, keo mien phi.");
        System.out.println("2. Nuoc trai cay mien phi.");
        System.out.print("Lua chon: ");
        int loaiQCM = sc.nextInt();
        sc.nextLine();

        switch (loaiQCM) {
            case 1:
                quaChaoMung = "Banh, keo mien phi.";
                break;
            case 2:
                quaChaoMung = "Nuoc trai cay mien phi.";
                break;
            default:
                System.out.println("Lua chon khong hop le! Mac dinh: Banh keo mien phi.");
                quaChaoMung = "Banh keo mien phi.";
                break;
        }
        System.out.println("Da chon: " + quaChaoMung);

        System.out.println("Chon loai Jacuzzi: ");
        System.out.println("1. Jacuzzi Tieu Chuan");
        System.out.println("2. Jacuzzi Ngoai Troi");
        System.out.println("3. Jacuzzi Trong Nha");
        System.out.println("4. Jacuzzi Cao Cap");
        System.out.print("Lua chon: ");
        int loaiJacuzzi = sc.nextInt();
        sc.nextLine();

        switch (loaiJacuzzi) {
            case 1:
                Jacuzzi = "Jacuzzi Tieu Chuan";
                break;
            case 2:
                Jacuzzi = "Jacuzzi Ngoai Troi";

                break;
            case 3:
                Jacuzzi = "Jacuzzi Trong Nha";

                break;
            case 4:
                Jacuzzi = "Jacuzzi Cao Cap";
                break;
            default:
                System.out.println("Lua chon khong hop le! Mac dinh: Jacuzzi Tieu Chuan");
                Jacuzzi = "Jacuzzi Tieu Chuan";
                break;
        }

        System.out.println("Da chon: " + Jacuzzi);
    }

    public void xuat() {
        super.xuat();
        System.out.printf("%-15s %-25s %-20s\n",
                getLoaiPhong(), this.getQCM(), this.getJacuzzi());
    }

    @Override
    public String toString() {
        String tinhTrangStr = getTT() ? "con" : "khong con";
        return getMP() + "," + getDG() + "," + getSN() + "," + getSG() + "," +
                tinhTrangStr + ",Vip," + quaChaoMung + "," + Jacuzzi;
    }

}
