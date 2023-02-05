// Author: Pham Thanh Binh
public abstract class MatHang {
    private  String maMatHang;
    private  String tenMatHang;
    private  String tenTacGia;
    private  int namXuatBan;
    private  String theLoai;
    private  double giaThueTheoNgay;
    //private Dat

    public MatHang() {
    }

    public MatHang(String maMatHang, String tenMatHang, String tenTacGia, int namXuatBan, String theLoai, double giaThueTheoNgay) {
        this.maMatHang = maMatHang;
        this.tenMatHang = tenMatHang;
        this.tenTacGia = tenTacGia;
        this.namXuatBan = namXuatBan;
        this.theLoai = theLoai;
        this.giaThueTheoNgay = giaThueTheoNgay;
    }

    public String getMaMatHang() {
        return maMatHang;
    }

    public void setMaMatHang(String maMatHang) {
        this.maMatHang = maMatHang;
    }

    public String getTenMatHang() {
        return tenMatHang;
    }

    public void setTenMatHang(String tenMatHang) {
        this.tenMatHang = tenMatHang;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public double getGiaThueTheoNgay() {
        return giaThueTheoNgay;
    }

    public void setGiaThueTheoNgay(double giaThueTheoNgay) {
        this.giaThueTheoNgay = giaThueTheoNgay;
    }

    public void inTTin(){
    };
}
