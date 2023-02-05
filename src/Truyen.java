// Author: Pham Thanh Binh
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
        System.out.println("Ma truyen la: "+ this.getMaMatHang());
        System.out.println("Ten truyen la: "+ this.getTenMatHang());
        System.out.println("Ten tac gia la: "+this.getTenTacGia());
        System.out.println("Nam xuat ban la: "+ this.getNamXuatBan());
        System.out.println("The loai la: "+ this.getTheLoai());
        System.out.println("So trang la:"+ soTrang);
        System.out.println("Kho giay la: "+ khoGiay);
        System.out.println("Ngon ngu la: "+ ngonNgu);
        System.out.println("-------------------------------------");
    }
}
