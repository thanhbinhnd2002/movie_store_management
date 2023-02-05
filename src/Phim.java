// Author: Nghiem Hong Dang
public class Phim extends MatHang{
    private  int thoiGian;
    private  double dungLuong;
    private  String doPhanGiai;
    public Phim(){

    }
    public Phim(String maMatHang, String tenMatHang, String tenTacGia, int namXuatBan, String theLoai, double giaThueTheoNgay, int thoiGian, double dungLuong, String doPhanGiai) {
        super(maMatHang, tenMatHang, tenTacGia, namXuatBan, theLoai, giaThueTheoNgay);
        this.thoiGian = thoiGian;
        this.dungLuong = dungLuong;
        this.doPhanGiai = doPhanGiai;
    }


    public int getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(int thoiGian) {
        this.thoiGian = thoiGian;
    }

    public double getDungLuong() {
        return dungLuong;
    }

    public void setDungLuong(double dungLuong) {
        this.dungLuong = dungLuong;
    }

    public String getDoPhanGiai() {
        return doPhanGiai;
    }

    public void setDoPhanGiai(String doPhanGiai) {
        this.doPhanGiai = doPhanGiai;
    }

    @Override
    public void inTTin() {
        super.inTTin();
        System.out.println("-------------------------------------");
        System.out.println("Ma mat hang: "+ this.getMaMatHang());
        System.out.println("ten Phim la: "+ this.getTenMatHang());
        System.out.println("ten dao dien la: "+this.getTenTacGia());
        System.out.println("nam xuat ban la: "+ this.getNamXuatBan());
        System.out.println("the loai la : "+ this.getTheLoai());
        System.out.println("thoi gian la: "+ thoiGian + " p");
        System.out.println("dung luong la: "+ dungLuong + " Gb");
        System.out.println("do phan giai la: "+ doPhanGiai);
        System.out.println("-------------------------------------");
    }
}
