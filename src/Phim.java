public class Phim extends MatHang{
    private static int thoiGian;
    private static double dungLuong;
    private static String doPhanGiai;
    public Phim(){

    }

    public Phim(String tenMatHang, String tenTacGia, int namXuatBan, String theLoai, double giaThueThepNgay, int thoiGian, double dungLuong, String doPhanGiai) {
        super(tenMatHang, tenTacGia, namXuatBan, theLoai, giaThueThepNgay);
        this.thoiGian = thoiGian;
        this.dungLuong = dungLuong;
        this.doPhanGiai = doPhanGiai;
    }

    public static int getThoiGian() {
        return thoiGian;
    }

    public static void setThoiGian(int thoiGian) {
        Phim.thoiGian = thoiGian;
    }

    public static double getDungLuong() {
        return dungLuong;
    }

    public static void setDungLuong(double dungLuong) {
        Phim.dungLuong = dungLuong;
    }

    public static String getDoPhanGiai() {
        return doPhanGiai;
    }

    public static void setDoPhanGiai(String doPhanGiai) {
        Phim.doPhanGiai = doPhanGiai;
    }

    @Override
    public void inTTin() {
        super.inTTin();
        System.out.println("ten Phim la: "+ this.getTenMatHang());
        System.out.println("ten dao dien la: "+this.getTenTacGia());
        System.out.println("nam xuat ban la: "+ this.getNamXuatBan());
        System.out.println("the loai la : "+ this.getTheLoai());
        System.out.println("thoi gian la: "+ thoiGian);
        System.out.println("dung luong la: "+ dungLuong);
        System.out.println("do phan giai la: "+ doPhanGiai);
    }
}
