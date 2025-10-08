import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class PhieuDatPhong{
    private String maDatPhong;
    private LocalDate ngay;
    private String maKhachHang;
    private String maNhanVien;
    private int sl_Phong;
    private int tongTien;
    public PhieuDatPhong(){
        maDatPhong="";
        ngay=null;
        maKhachHang="";
        maNhanVien="";
        sl_Phong=0;
        tongTien=0;
    }
    public PhieuDatPhong(String maDP, LocalDate date,String maKH,String maNV, int sl, int sum){
        this.maDatPhong=maDP;
        this.ngay=date;
        this.maKhachHang=maKH;
        this.maNhanVien=maNV;
        this.sl_Phong=sl;
        this.tongTien=sum;

    }
    public PhieuDatPhong(PhieuDatPhong d){
        this.maDatPhong=d.maDatPhong;
        this.ngay=d.ngay;
        this.maKhachHang=d.maKhachHang;
        this.maNhanVien=d.maNhanVien;
        this.sl_Phong=d.sl_Phong;
        this.tongTien=d.tongTien;
    }
    public String getMaDP(){ return maDatPhong;}
    public void setMaDP(String maDP){this.maDatPhong=maDP;}
    public LocalDate getNgay(){return ngay;}
    public void setNgay(LocalDate date){this.ngay=date;}
    public String getMaKH(){return maKhachHang;}
    public void setMaKH(String maKH){this.maKhachHang=maKH;}
    public String getMaNV(){return maNhanVien;}
    public void setMaNV(String maNV){this.maNhanVien=maNV;}
    public int getSl(){return sl_Phong;}
    public void setSl(int sl){this.sl_Phong=sl;}
    public int getTong(){return tongTien;}
    public void setTong(int sum){this.tongTien=sum;}

    public void nhap(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhap ma dat phong:");
        maDatPhong=sc.nextLine();
        System.out.print("Ngay dat phong:");
        String date=sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        ngay = LocalDate.parse(date, formatter);
        System.out.print("Ma khach hang:");
        maKhachHang=sc.nextLine();
        System.out.print("Ma nhan vien:");
        maNhanVien=sc.nextLine();
        System.out.print("So luong phong:");
        sl_Phong=sc.nextInt();
        System.out.print("Tong tien:");
        tongTien=sc.nextInt();
        
    }
    public void xuat(){
        System.out.println("Ma dat phong:"+maDatPhong);
        if(ngay!=null){System.out.print("Ngay dat phong:"+ngay);}
        else{System.out.println("Ngay dat phong: chua co");}
        System.out.println("Ma khach hang:"+maKhachHang);
        System.out.println("Ma nhan vien:"+maNhanVien);
        System.out.println("So luong phong:"+sl_Phong);
        System.out.println("Tong tien:"+tongTien); 
        System.out.println("--- //---//---//---//---//---");
    }  
      
}

