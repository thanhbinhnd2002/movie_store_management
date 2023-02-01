import java.util.List;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class NguoiThue {
    private String maNguoiThue;
    private String ten;
    private String soDienThoai;
    //private MatHang phimtruyen;
    private Date thoiGianMuon;
    private Date thoiGianTra;
    private double tinhtien;
    private List<MatHang> lstThue = new ArrayList<>();
    private double soTienCuoc;
    DateFormat spdf = new SimpleDateFormat("yyyy-MM-dd");
    Scanner sc = new Scanner(System.in);

    public NguoiThue(){
    }

    public NguoiThue(String maNguoiThue, String ten, String soDienThoai, Date thoiGianMuon, Date thoiGianTra, double soTienCuoc,double tinhtien) {
        this.maNguoiThue = maNguoiThue;
        this.ten = ten;
        this.soDienThoai = soDienThoai;
        this.thoiGianMuon = thoiGianMuon;
        this.thoiGianTra = thoiGianTra;
        this.soTienCuoc = soTienCuoc;
        this.tinhtien = tinhtien;
    }

    public String getMaNguoiThue() {
        return maNguoiThue;
    }

    public void setMaNguoiThue(String maNguoiThue) {
        this.maNguoiThue = maNguoiThue;
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

//    public MatHang getPhimtruyen() {
//        return phimtruyen;
//    }
//
//    public void setPhimtruyen(MatHang phimtruyen) {
//        this.phimtruyen = phimtruyen;
//    }

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




}
