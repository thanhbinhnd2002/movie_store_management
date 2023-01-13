public class Truyen extends MatHang{
    private int soTrang;
    private KhoGiay khoGiay;
    private String ngonNgu;

    public Truyen(String tenMatHang, String tenTacGia, int namXuatBan, String theLoai, double giaThueTheoNgay, int soTrang, KhoGiay khoGiay, String ngonNgu) {
        super(tenMatHang, tenTacGia, namXuatBan, theLoai, giaThueTheoNgay);
        this.soTrang = soTrang;
        this.khoGiay = khoGiay;
        this.ngonNgu = ngonNgu;
    }

    public int getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }

    public KhoGiay getKhoGiay() {
        return khoGiay;
    }

    public void setKhoGiay(KhoGiay khoGiay) {
        this.khoGiay = khoGiay;
    }

    public String getNgonNgu() {
        return ngonNgu;
    }

    public void setNgonNgu(String ngonNgu) {
        this.ngonNgu = ngonNgu;
    }

    @Override
    public void inTTin() {
        super.inTTin();
        System.out.println("ten Phim la: "+ this.getTenMatHang());
        System.out.println("ten dao dien la: "+this.getTenTacGia());
        System.out.println("nam xuat ban la: "+ this.getNamXuatBan());
        System.out.println("the loai la: "+ this.getTheLoai());
        System.out.println("so trang la:"+ soTrang);
        System.out.println("kho giay la: "+ khoGiay);
        System.out.println("ngon ngu la: "+ ngonNgu);
    }
}
