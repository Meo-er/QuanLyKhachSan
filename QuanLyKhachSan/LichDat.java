package QuanLyKhachSan;

import java.time.LocalDate;

public class LichDat {
    private LocalDate ngayDat;
    private LocalDate ngayTra;

    public LichDat(LocalDate ngayDat, LocalDate ngayTra) {
        this.ngayDat = ngayDat;
        this.ngayTra = ngayTra;
    }

    public boolean trungThoiGian(LocalDate nd, LocalDate nt) {

        return !(nt.isBefore(ngayDat) || nd.isAfter(ngayTra));
    }
}
