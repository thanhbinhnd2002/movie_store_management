import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MatHang truyen = new Truyen("doraemon", "fuji", 2002, "truyen tranh", 2000, 100, KhoGiay.A2, "tieng Viet");
        truyen.inTTin();
        NguoiThue nguoiThue = new NguoiThue("Binh", "0979633868", truyen, 20, 200.0);
        CuaHangThuePhim cuaHangThuePhim = new CuaHangThuePhim();
        cuaHangThuePhim.themNguoiThue(nguoiThue);
//        System.out.println(cuaHangThuePhim.get(0));
        System.out.println("----------------------------");
        System.out.println("cửa hàng cho thuê phim truyện");
        System.out.println("1.quản lý phim truyện");
        System.out.println("2.quản lý người thuê");
        System.out.println("3.Tính doanh thu");
        System.out.println("4.Thoát");
        System.out.println("----------------------------");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        switch (n) {
            case 1:
                System.out.println("----------------------");
                System.out.println("1.Thêm phim truyện");
                System.out.println("2.Xóa phim truyện");
                System.out.println("3.Sửa phim truyện");
                System.out.println("4.Tìm kiếm phim truyện ");
                System.out.println("----------------------");
                int m = sc.nextInt();
                switch (m) {
                    case 1:
                        break;
                    case 2:
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
                }
                break;
            case 2:break;
            case 3:break;
            case 4: System.exit(0);
        }
    }
}