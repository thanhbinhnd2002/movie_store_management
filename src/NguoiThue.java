import java.util.Date;

public class NguoiThue {
    private String ten;
    private String soDienThoai;
    private MatHang phimtruyen;
    private int thoigian;
    private double soTienCuoc;
    public NguoiThue(){

    }

    public NguoiThue(String ten, String soDienThoai, MatHang phimtruyen, int thoigian, double soTienCuoc) {
        this.ten = ten;
        this.soDienThoai = soDienThoai;
        this.phimtruyen = phimtruyen;
        this.thoigian = thoigian;
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

    public int getThoigian() {
        return thoigian;
    }

    public void setThoigian(int thoigian) {
        this.thoigian = thoigian;
    }

    public double getSoTienCuoc() {
        return soTienCuoc;
    }

    public void setSoTienCuoc(double soTienCuoc) {
        this.soTienCuoc = soTienCuoc;
    }
    public double tinhTienChoThue(){
        double tienthue;
        tienthue = thoigian*MatHang.getGiaThueTheoNgay();
        return tienthue;
    }
}
