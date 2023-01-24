public abstract class MatHang {
    private static String tenMatHang;
    private static String tenTacGia;
    private static int namXuatBan;
    private static String theLoai;
    private static double giaThueTheoNgay;
    public MatHang(){

    }

    public MatHang(String tenMatHang, String tenTacGia, int namXuatBan, String theLoai, double giaThueTheoNgay) {
        this.tenMatHang = tenMatHang;
        this.tenTacGia = tenTacGia;
        this.namXuatBan = namXuatBan;
        this.theLoai = theLoai;
        this.giaThueTheoNgay = giaThueTheoNgay;
    }

    public static String getTenMatHang() {
        return tenMatHang;
    }

    public static void setTenMatHang(String tenMatHang) {
        MatHang.tenMatHang = tenMatHang;
    }

    public static String getTenTacGia() {
        return tenTacGia;
    }

    public static void setTenTacGia(String tenTacGia) {
        MatHang.tenTacGia = tenTacGia;
    }

    public static int getNamXuatBan() {
        return namXuatBan;
    }

    public static void setNamXuatBan(int namXuatBan) {
        MatHang.namXuatBan = namXuatBan;
    }

    public static String getTheLoai() {
        return theLoai;
    }

    public static void setTheLoai(String theLoai) {
        MatHang.theLoai = theLoai;
    }

    public static double getGiaThueTheoNgay() {
        return giaThueTheoNgay;
    }

    public static void setGiaThueTheoNgay(double giaThueTheoNgay) {
        MatHang.giaThueTheoNgay = giaThueTheoNgay;
    }
    public void inTTin(){
    };
}
