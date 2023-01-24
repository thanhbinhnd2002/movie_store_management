import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat spdf = new SimpleDateFormat("yyyy-MM-dd");
        //MatHang truyen = new Truyen("doraemon", "fuji", 2002, "truyen tranh", 2000, 100, KhoGiay.A2, "tieng Viet");
//        truyen.inTTin();
        //NguoiThue nguoiThue = new NguoiThue("Binh", "0979633868", truyen, spdf.parse("2023-01-22"), spdf.parse("2023-01-24"), 200.0);
        //System.out.println(nguoiThue.tinhTienChoThue());
        CuaHangThuePhim cuaHangThuePhim = new CuaHangThuePhim();
        //cuaHangThuePhim.themNguoiThue(nguoiThue);
//        System.out.println(cuaHangThuePhim.get(0));
        while (true) {
            System.out.println("----------------------------");
            System.out.println("cửa hàng cho thuê phim truyện");
            System.out.println("1.quản lý phim truyện");
            System.out.println("2.quản lý người thuê");
            System.out.println("3.Tính doanh thu");
            System.out.println("4.Thoát");
            System.out.println("----------------------------");
            System.out.print("Mời chọn(1-4): ");
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.println("----------------------");
                    System.out.println("1.Thêm phim truyện");
                    System.out.println("2.Xóa phim truyện");
                    System.out.println("3.Sửa phim truyện");
                    System.out.println("4.Tìm kiếm phim truyện ");
                    System.out.println("5.Tìm kiếm người đang thuê phim truyện");
                    System.out.println("----------------------");
                    System.out.println("Mời chọn(1-5): ");
                    int m = sc.nextInt();
                    switch (m) {
                        case 1:
                            System.out.println("----------------------");
                            System.out.println("1.Thêm phim ");
                            System.out.println("2.Thêm truyện ");
                            System.out.println("----------------------");
                            System.out.println("Mời chọn từ 1-2");
                            int i = sc.nextInt();
                            switch (i) {
                                case 1:
                                    MatHang phim = new Phim();
                                    System.out.println("Mời nhập thông tin: ");
                                    sc.nextLine();
                                    Phim.setTenMatHang(sc.nextLine());
                                    Phim.setTenTacGia(sc.nextLine());
                                    Phim.setTheLoai(sc.nextLine());
                                    Phim.setNamXuatBan(sc.nextInt());
                                    Phim.setGiaThueTheoNgay(sc.nextDouble());
                                    Phim.setDoPhanGiai(sc.nextLine());
                                    Phim.setDungLuong(sc.nextDouble());
                                    Phim.setThoiGian(sc.nextInt());
                                    cuaHangThuePhim.themMatHang(phim);
                                    break;
                                case 2:
                                MatHang truyen = new Truyen();
                                System.out.println("Mời nhập thông tin: ");
                                sc.nextLine();
                                Truyen.setTenMatHang(sc.nextLine());
                                Truyen.setTenTacGia(sc.nextLine());
                                Truyen.setTheLoai(sc.nextLine());
                                Truyen.setNamXuatBan(sc.nextInt());
                                Truyen.setGiaThueTheoNgay(sc.nextDouble());
                                Truyen.setSoTrang(sc.nextInt());
                                Truyen.setKhoGiay(sc.nextLine());
                                Truyen.setNgonNgu(sc.nextLine());
                                cuaHangThuePhim.themMatHang(truyen);
                                break;
                            }break;
                        case 2:
                            System.out.println("----------------------");
                            System.out.println("1.Xóa phim ");
                            System.out.println("2.Xóa truyện ");
                            System.out.println("----------------------");
                            System.out.println("Mời chọn từ 1-2");
                            int j = sc.nextInt();
                            switch (j) {
                                case 1:
                                    break;
                                case 2:
                                    break;
                                System.out.println("Mời nhập phim truyện muốn xóa: ");
                            }
                            break;
                        case 3:
                            break;
                        case 4:
                            System.out.println("-----------------------------");
                            System.out.println("1.Tìm kiếm theo tên phim");
                            System.out.println("2.Tìm kiếm theo tên tác giả ");
                            System.out.println("3.Tìm kiếm theo thể loại");
                            System.out.println("4.");
                            System.out.println("-----------------------------");
                            break;
                    }
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}