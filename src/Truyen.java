public class Truyen extends MatHang{
    private  int soTrang;
    private  KhoGiay khoGiay;
    private  String ngonNgu;
    public Truyen(){
        super();

    }

    public Truyen(String maMatHang, String tenMatHang, String tenTacGia, int namXuatBan, String theLoai, double giaThueTheoNgay, int soTrang, KhoGiay khoGiay, String ngonNgu) {
        super(maMatHang, tenMatHang, tenTacGia, namXuatBan, theLoai, giaThueTheoNgay);
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
        System.out.println("-------------------------------------");
        System.out.println("Mã truyện là: "+ this.getMaMatHang());
        System.out.println("Tên truyện là: "+ this.getTenMatHang());
        System.out.println("Tên tác giả là: "+this.getTenTacGia());
        System.out.println("Năm xuất bản là: "+ this.getNamXuatBan());
        System.out.println("Thể loại là: "+ this.getTheLoai());
        System.out.println("Số trang là:"+ soTrang);
        System.out.println("Khổ giấy là: "+ khoGiay);
        System.out.println("Ngôn ngữ là: "+ ngonNgu);
        System.out.println("-------------------------------------");
    }
}
