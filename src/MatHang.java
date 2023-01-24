public abstract class MatHang {
    private String tenMatHang;
    private String tenTacGia;
    private int namXuatBan;
    private String theLoai;
    private static double giaThueTheoNgay;

    public MatHang(String tenMatHang, String tenTacGia, int namXuatBan, String theLoai, double giaThueTheoNgay) {
        this.tenMatHang = tenMatHang;
        this.tenTacGia = tenTacGia;
        this.namXuatBan = namXuatBan;
        this.theLoai = theLoai;
        this.giaThueTheoNgay = giaThueTheoNgay;
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

    public static double getGiaThueTheoNgay() {
        return giaThueTheoNgay;
    }

    public void setGiaThueTheoNgay(double giaThueTheoNgay) {
        this.giaThueTheoNgay = giaThueTheoNgay;
    }
    public void inTTin(){
    };
}
