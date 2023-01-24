public class Truyen extends MatHang{
    private static int soTrang;
    private static KhoGiay khoGiay;
    private static String ngonNgu;
    public Truyen(){
        super();

    }

    public Truyen(String tenMatHang, String tenTacGia, int namXuatBan, String theLoai, double giaThueTheoNgay, int soTrang, KhoGiay khoGiay, String ngonNgu) {
        super(tenMatHang, tenTacGia, namXuatBan, theLoai, giaThueTheoNgay);
        this.soTrang = soTrang;
        this.khoGiay = khoGiay;
        this.ngonNgu = ngonNgu;
    }

    public static int getSoTrang() {
        return soTrang;
    }

    public static void setSoTrang(int soTrang) {
        Truyen.soTrang = soTrang;
    }

    public static KhoGiay getKhoGiay() {
        return khoGiay;
    }

    public static void setKhoGiay(KhoGiay khoGiay) {
        Truyen.khoGiay = khoGiay;
    }

    public static String getNgonNgu() {
        return ngonNgu;
    }

    public static void setNgonNgu(String ngonNgu) {
        Truyen.ngonNgu = ngonNgu;
    }

    @Override
    public void inTTin() {
        super.inTTin();
        System.out.println("ten Phim la: "+ MatHang.getTenMatHang());
        System.out.println("ten dao dien la: "+MatHang.getTenTacGia());
        System.out.println("nam xuat ban la: "+ MatHang.getNamXuatBan());
        System.out.println("the loai la: "+ MatHang.getTheLoai());
        System.out.println("so trang la:"+ soTrang);
        System.out.println("kho giay la: "+ khoGiay);
        System.out.println("ngon ngu la: "+ ngonNgu);
    }
}
