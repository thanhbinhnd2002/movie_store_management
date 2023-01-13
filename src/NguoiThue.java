import java.util.Date;

public class NguoiThue {
    private String ten;
    private String soDienThoai;
    private MatHang phimtruyen;
    private Date thoigian;
    private double soTienCuoc;
    public NguoiThue(){

    }

    public NguoiThue(String ten, String soDienThoai, MatHang phimtruyen, Date thoigian, double soTienCuoc) {
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

    public Date getThoigian() {
        return thoigian;
    }

    public void setThoigian(Date thoigian) {
        this.thoigian = thoigian;
    }

    public double getSoTienCuoc() {
        return soTienCuoc;
    }

    public void setSoTienCuoc(double soTienCuoc) {
        this.soTienCuoc = soTienCuoc;
    }
}
