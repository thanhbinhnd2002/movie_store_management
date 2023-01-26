import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat spdf = new SimpleDateFormat("yyyy-MM-dd");
        CuaHangThuePhim cuaHangThuePhim = new CuaHangThuePhim();
        while (true) {
            System.out.println("----------------------------");
            System.out.println("cửa hàng cho thuê phim truyện");
            System.out.println("1.quản lý phim truyện");
            System.out.println("2.quản lý người thuê");
            System.out.println("3.Tính doanh thu");
            System.out.println("4.Thoát");
            System.out.println("----------------------------");
            System.out.print("Mời nhập(1-4): ");
            Scanner sc = new Scanner(System.in);
            String n = sc.nextLine();
            switch (n) {
                case "1":
                    boolean bool = true;
                    while (bool) {
                        System.out.println("----------------------");
                        System.out.println("1.Thêm phim truyện");
                        System.out.println("2.Xóa phim truyện");
                        System.out.println("3.Sửa phim truyện");
                        System.out.println("4.Tìm kiếm phim truyện ");
                        System.out.println("5.Tìm kiếm phim truyện đang được thuê");
                        System.out.println("6.Hiện thị phim truyện");
                        System.out.println("7.Quay lại");
                        System.out.println("----------------------");
                        System.out.print("Mời nhập(1-7): ");
                        String m = sc.nextLine();
                        switch (m) {
                            case "1":
                                boolean bool1 = true;
                                while (bool1) {
                                    System.out.println("----------------------");
                                    System.out.println("1.Thêm phim ");
                                    System.out.println("2.Thêm truyện ");
                                    System.out.println("3.Quay lại");
                                    System.out.println("----------------------");
                                    System.out.print("Mời chọn (1-3): ");
                                    String i = sc.nextLine();
                                    switch (i) {
                                        case "1":
                                            Phim phim = new Phim();
                                            System.out.println("Mời nhập thông tin: ");
                                            //sc.nextLine();
                                            System.out.print("Mời nhập mã mặt hàng: ");
                                            phim.setMaMatHang(sc.nextLine());
                                            System.out.print("Mời nhập tên mặt hàng: ");
                                            phim.setTenMatHang(sc.nextLine());
                                            System.out.print("Mời nhập tên tác giả: ");
                                            phim.setTenTacGia(sc.nextLine());
                                            System.out.print("Mời nhập năm xuất bản: ");
                                            phim.setNamXuatBan(sc.nextInt());
                                            sc.nextLine();
                                            System.out.print("Mời nhập thể loại: ");
                                            phim.setTheLoai(sc.nextLine());
                                            System.out.print("Mời nhập giá thuê theo ngày: ");
                                            phim.setGiaThueTheoNgay(sc.nextDouble());
                                            System.out.print("Mời nhập thời gian: ");
                                            phim.setThoiGian(sc.nextInt());
                                            sc.nextLine();
                                            System.out.print("Mời nhập dung lượng: ");
                                            phim.setDungLuong(sc.nextDouble());
                                            sc.nextLine();
                                            System.out.print("Độ phân giải: ");
                                            phim.setDoPhanGiai(sc.nextLine());
                                            cuaHangThuePhim.themPhim(phim);
                                            break;
                                        case "2":
                                            Truyen truyen = new Truyen();
                                            System.out.println("Mời nhập thông tin: ");
                                            //sc.nextLine();
                                            System.out.println("Mời nhập mã mặt hàng: ");
                                            truyen.setMaMatHang(sc.nextLine());
                                            System.out.println("Mời nhập tên mặt hàng: ");
                                            truyen.setTenMatHang(sc.nextLine());
                                            System.out.println("Mời nhập tên tác giả: ");
                                            truyen.setTenTacGia(sc.nextLine());
                                            System.out.println("Mời nhập giá thuê theo ngày: ");
                                            truyen.setGiaThueTheoNgay(sc.nextDouble());
                                            sc.nextLine();
                                            System.out.println("Mời nhập năm xuất bản: ");
                                            truyen.setNamXuatBan(sc.nextInt());
                                            sc.nextLine();
                                            System.out.println("Mời nhập thể loại: ");
                                            truyen.setTheLoai(sc.nextLine());
                                            System.out.println("Mời nhập số trang: ");
                                            truyen.setSoTrang(sc.nextInt());
                                            sc.nextLine();
                                            System.out.println("Mời nhập khổ giấy: ");
                                            String str = sc.nextLine();
                                            switch (str) {
                                                case "A0":
                                                    truyen.setKhoGiay(KhoGiay.A0);
                                                    break;
                                                case "A1":
                                                    truyen.setKhoGiay(KhoGiay.A1);
                                                    break;
                                                case "A2":
                                                    truyen.setKhoGiay(KhoGiay.A2);
                                                    break;
                                                default:
                                                    System.out.println("Nhập sai");
                                                    break;
                                            }
                                            System.out.println("Mời nhập ngôn ngữ: ");
                                            truyen.setNgonNgu(sc.nextLine());
                                            cuaHangThuePhim.themTruyen(truyen);
                                            break;
                                        case "3": bool1 = false;
                                    }
                                    //break;
                                }break;
                            case "2":
                                Boolean bool2 = true;
                                while (bool2) {
                                    System.out.println("----------------------");
                                    System.out.println("1.Xóa mặt hàng ");
                                    System.out.println("2.Quay lại ");
                                    System.out.println("----------------------");
                                    System.out.println("Mời chọn từ(1-2): ");
                                    String j = sc.nextLine();
                                    switch (j) {
                                        case "1":
                                            System.out.println("Mời nhập mã mặt hàng muốn xóa: ");
                                           // sc.nextLine();
                                            cuaHangThuePhim.xoaMatHang(sc.nextLine());
                                            break;
                                        case "2":
                                            bool2 = false;
                                            break;
                                    }
                                    //break;
                                }break;
                            case "3":
                                System.out.println("Mời nhập mã mặt hàng muốn sửa:");
                                //sc.nextLine();
                                cuaHangThuePhim.suaMatHang(sc.nextLine());
                                break;
                            case "4":
                                System.out.println("-----------------------------");
                                System.out.println("1.Tìm kiếm theo tên phim");
                                System.out.println("2.Tìm kiếm theo tên tác giả ");
                                System.out.println("3.Tìm kiếm theo thể loại");
                                System.out.println("4.");
                                System.out.println("-----------------------------");
                                break;
                            case "5":
                                break;
                            case "6":
                                for (MatHang x: cuaHangThuePhim.layDanhSachMatHang()
                                     ) {
                                    x.inTTin();
                                }
                                //cuaHangThuePhim.layDanhSachMatHang();
                                break;
                            case "7": bool = false;
                            break;
                            default:break;
                        }
                        //break;
                    }break;
                case "2":
                    Boolean bool2 = true;
                    while (bool2) {
                        System.out.println("------------------");
                        System.out.println("1.Thêm người thuê");
                        System.out.println("2.Xóa người thuê");
                        System.out.println("3.Sửa người thuê");
                        System.out.println("4.Hiển thị danh sách người thuê");
                        System.out.println("5.Quay lại");
                        System.out.println("------------------");
                        System.out.print("Chọn (1-5): ");
                        String b = sc.nextLine();
                        switch (b) {
                            case "1":
                                NguoiThue nguoiThue = new NguoiThue();
                                System.out.println("Mời nhập thông tin: ");
                                sc.nextLine();
                                System.out.print("Nhập mã người thuê: ");
                                nguoiThue.setMaNguoiThue(sc.nextLine());
                                System.out.print("Nhập tên người thuê: ");
                                nguoiThue.setTen(sc.nextLine());
                                System.out.print("Nhập số điện thoại: ");
                                nguoiThue.setSoDienThoai(sc.nextLine());
                                System.out.print("Nhập thời gian mượn: ");
                                String str1 = sc.nextLine();
                                Date date1 = spdf.parse(str1);
                                nguoiThue.setThoiGianMuon(date1);
                                System.out.print("Nhập thời gian trả: ");
                                String str2 = sc.nextLine();
                                Date date2 = spdf.parse(str2);
                                nguoiThue.setThoiGianMuon(date2);
                                System.out.print("Nhập số tiền cược: ");
                                nguoiThue.setSoTienCuoc(sc.nextDouble());
                                cuaHangThuePhim.themNguoiThue(nguoiThue);
                                cuaHangThuePhim.thueTruyenPhim();
                                break;
                            case "2":
                                System.out.println("Nhập mã số người thuê: ");
                                cuaHangThuePhim.xoaNguoiThue(sc.nextLine());
                                break;
                            case "3":
                                System.out.println("Nhập mã số người thuê muốn sửa:");
                                cuaHangThuePhim.suaNguoiThue(sc.nextLine());
                                break;
                            case "4":
                                System.out.println("Danh sách người thuê:");

                                //cuaHangThuePhim.hienThiNguoiThue()
                                break;
                            case "5":
                                bool2 = false;
                                break;
                            default:
                                break;
                        }
                        break;
                    }
                case "3":
                    System.out.println("Mời nhập thời điểm tính doanh thu: ");
                    break;
                case "4":
                    System.exit(0);
            }
        }
    }
}