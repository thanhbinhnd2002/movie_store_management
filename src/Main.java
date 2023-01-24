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
                                    Phim phim = new Phim();
                                    System.out.println("Mời nhập thông tin: ");
                                    sc.nextLine();
                                    phim.setMaMatHang(sc.nextLine());
                                    phim.setTenMatHang(sc.nextLine());
                                    phim.setTenTacGia(sc.nextLine());
                                    phim.setNamXuatBan(sc.nextInt());
                                    phim.setTheLoai(sc.nextLine());
                                    phim.setGiaThueTheoNgay(sc.nextDouble());
                                    phim.setThoiGian(sc.nextInt());
                                    phim.setDungLuong(sc.nextDouble());
                                    phim.setDoPhanGiai(sc.nextLine());
                                    cuaHangThuePhim.themMatHang(phim);
                                    break;
                                case 2:
                                Truyen truyen = new Truyen();
                                System.out.println("Mời nhập thông tin: ");
                                sc.nextLine();
                                truyen.setMaMatHang(sc.nextLine());

                                String str = sc.nextLine();
                                switch (str){
                                    case "A0": truyen.setKhoGiay(KhoGiay.A0);break;
                                    case "A1": truyen.setKhoGiay(KhoGiay.A1);break;
                                    case "A2": truyen.setKhoGiay(KhoGiay.A2);break;
                                    default:
                                        System.out.println("Nhập sai");
                                        break;
                                }
                                cuaHangThuePhim.themMatHang(truyen);
                                break;
                            }break;
                        case 2:
                            System.out.println("----------------------");
                            System.out.println("1.Xóa mặt hàng ");
                            System.out.println("2.Xóa người thuê ");
                            System.out.println("----------------------");
                            System.out.println("Mời chọn từ 1-2");
                            int j = sc.nextInt();
                            switch (j) {
                                case 1:
                                    System.out.println("Mời nhập mã mặt hàng muốn xóa: ");
                                    cuaHangThuePhim.xoaMatHang(sc.nextLine());
                                    break;
                                case 2:
                                    System.out.println("Mời nhập mã người thuê muốn xóa: ");
                                    cuaHangThuePhim.xoaNguoiThue(sc.nextLine());
                                    break;

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