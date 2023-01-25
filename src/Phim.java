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
        System.out.print("Mã mặt hàng: "+ this.getMaMatHang());
        System.out.print("ten Phim la: "+ this.getTenMatHang());
        System.out.print("ten dao dien la: "+this.getTenTacGia());
        System.out.print("nam xuat ban la: "+ this.getNamXuatBan());
        System.out.print("the loai la : "+ this.getTheLoai());
        System.out.print("thoi gian la: "+ thoiGian);
        System.out.print("dung luong la: "+ dungLuong);
        System.out.print("do phan giai la: "+ doPhanGiai);
    }
}
