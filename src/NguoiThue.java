import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class NguoiThue {
    private String ten;
    private String soDienThoai;
    private MatHang phimtruyen;
    private Date thoiGianMuon;
    private Date thoiGianTra;

    private double soTienCuoc;
    DateFormat spdf = new SimpleDateFormat("yyyy-MM-dd");
    Scanner sc = new Scanner(System.in);

    public NguoiThue(){
    }

    public NguoiThue(String ten, String soDienThoai, MatHang phimtruyen, Date thoiGianMuon, Date thoiGianTra, double soTienCuoc) {
        this.ten = ten;
        this.soDienThoai = soDienThoai;
        this.phimtruyen = phimtruyen;
        this.thoiGianMuon = thoiGianMuon;
        this.thoiGianTra = thoiGianTra;
        this.soTienCuoc = soTienCuoc;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public MatHang getPhimtruyen() {
        return phimtruyen;
    }

    public void setPhimtruyen(MatHang phimtruyen) {
        this.phimtruyen = phimtruyen;
    }

    public Date getThoiGianMuon() {
        return thoiGianMuon;
    }

    public void setThoiGianMuon(Date thoiGianMuon) {
        this.thoiGianMuon = thoiGianMuon;
    }

    public Date getThoiGianTra() {
        return thoiGianTra;
    }

    public void setThoiGianTra(Date thoiGianTra) {
        this.thoiGianTra = thoiGianTra;
    }

    public double getSoTienCuoc() {
        return soTienCuoc;
    }

    public void setSoTienCuoc(double soTienCuoc) {
        this.soTienCuoc = soTienCuoc;
    }

    public int tinhKhoangThoiGian(Date start, Date end) {

//        Date currentDate = new Date();
//        Date date1 = null;
//        Date date2 = null;
        int time = 0;
        try {
            // calculating the difference b/w startDate and endDate
            //String startDate = sc.nextLine();
            //String endDate = spdf.format(currentDate);
            //String endDate = sc.nextLine();

//            try {
//                date1 = spdf.parse(startDate);
//            } catch (ParseException ex) {
//                throw new RuntimeException(ex);
//            }
//            try {
//                date2 = spdf.parse(endDate);
//            } catch (ParseException ex) {
//                throw new RuntimeException(ex);
//            }

            //long getDiff = date2.getTime() - date1.getTime();
            long getDiff = end.getTime() - start.getTime();
            // using TimeUnit class from java.util.concurrent package
            long getDaysDiff = TimeUnit.MILLISECONDS.toDays(getDiff);
            time = (int) getDaysDiff;

            //System.out.println("Differance between date " + startDate + " and " + endDate + " is " + getDaysDiff + " days.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return time;
    }
    public double tinhTienChoThue(){
        double tienthue;
        tienthue = this.tinhKhoangThoiGian(thoiGianMuon,thoiGianTra)*MatHang.getGiaThueTheoNgay();
        return tienthue;
    }
}
