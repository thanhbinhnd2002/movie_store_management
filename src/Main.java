//Author: Pham Thanh Binh, Nghiem Hong Dang
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main extends MySqlService {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat spdf = new SimpleDateFormat("yyyy-MM-dd");
        CuaHangThuePhim cuaHangThuePhim = new CuaHangThuePhim();
        while (true) {
            System.out.println("----------------------------");
            System.out.println("Cua hang cho thue phim truyen");
            System.out.println("1.Quan ly phim truyen");
            System.out.println("2.Quan ly nguoi thue");
            System.out.println("3.Tinh doanh thu");
            System.out.println("4.Thoat");
            System.out.println("----------------------------");
            System.out.print("Moi nhap(1-4): ");
            Scanner sc = new Scanner(System.in);
            String n = sc.nextLine();
            switch (n) {
                case "1":
                    boolean bool = true;
                    while (bool) {
                        System.out.println("----------------------");
                        System.out.println("1.Them phim truyen");
                        System.out.println("2.Xoa phim truyen");
                        System.out.println("3.Sua phim truyen");
                        System.out.println("4.Tim kiem phim truyen ");
                        System.out.println("5.Tim kiem phim truyen đang đuoc thue");
                        System.out.println("6.Hien thi phim truyen");
                        System.out.println("7.Quay lai");
                        System.out.println("----------------------");
                        System.out.print("Moi nhap(1-7): ");
                        String m = sc.nextLine();
                        switch (m) {
                            case "1":
                                boolean bool1 = true;
                                while (bool1) {
                                    System.out.println("----------------------");
                                    System.out.println("1.Them phim ");
                                    System.out.println("2.Thêm truyen ");
                                    System.out.println("3.Quay lai");
                                    System.out.println("----------------------");
                                    System.out.print("Moi chọn (1-3): ");
                                    String i = sc.nextLine();
                                    switch (i) {
                                        case "1":
                                            //Phim phim = new Phim();
                                            MatHang matHang = new Phim();
                                            System.out.println("Moi nhap thong tin: ");
                                            //sc.nextLine();
                                            System.out.print("Moi nhap ma mat hang: ");
                                            ((Phim)matHang).setMaMatHang(sc.nextLine());
                                            System.out.print("Moi nhap ten mat hang: ");
                                            ((Phim)matHang).setTenMatHang(sc.nextLine());
                                            System.out.print("Moi nhap ten tac gia: ");
                                            ((Phim)matHang).setTenTacGia(sc.nextLine());
                                            System.out.print("Moi nhap nam xuat ban: ");
                                            ((Phim)matHang).setNamXuatBan(sc.nextInt());
                                            sc.nextLine();
                                            System.out.print("Moi nhap the loai: ");
                                            ((Phim)matHang).setTheLoai(sc.nextLine());
                                            System.out.print("Moi nhap gia thue theo ngay: ");
                                            ((Phim)matHang).setGiaThueTheoNgay(sc.nextDouble());
                                            System.out.print("Moi nhap thoi gian: ");
                                            ((Phim)matHang).setThoiGian(sc.nextInt());
                                            sc.nextLine();
                                            System.out.print("Moi nhap dung luong: ");
                                            ((Phim)matHang).setDungLuong(sc.nextDouble());
                                            sc.nextLine();
                                            System.out.print("Do phan giai: ");
                                            ((Phim)matHang).setDoPhanGiai(sc.nextLine());
                                            cuaHangThuePhim.themMatHang((Phim)matHang);
                                            break;
                                        case "2":
//                                            Truyen truyen = new Truyen();
                                            MatHang matHang1 = new Truyen();
                                            System.out.println("Moi nhap thong tin: ");
                                            //sc.nextLine();
                                            System.out.print("Moi nhap ma mat hang: ");
                                            matHang1.setMaMatHang(sc.nextLine());
                                            System.out.print("Moi nhap ten mat hang: ");
                                            matHang1.setTenMatHang(sc.nextLine());
                                            System.out.print("Moi nhap ten tac gia: ");
                                            matHang1.setTenTacGia(sc.nextLine());
                                            System.out.print("Moi nhap gia thue theo ngay: ");
                                            matHang1.setGiaThueTheoNgay(sc.nextDouble());
                                            sc.nextLine();
                                            System.out.print("Moi nhap nam xuat ban: ");
                                            matHang1.setNamXuatBan(sc.nextInt());
                                            sc.nextLine();
                                            System.out.print("Moi nhap the loai: ");
                                            matHang1.setTheLoai(sc.nextLine());
                                            System.out.print("Moi nhap so trang: ");
                                            ((Truyen)matHang1).setSoTrang(sc.nextInt());
                                            sc.nextLine();
                                            System.out.print("Moi nhap kho giay: ");
                                            String str = sc.nextLine();
                                            switch (str) {
                                                case "A0":
                                                    ((Truyen)matHang1).setKhoGiay(KhoGiay.A0);
                                                    break;
                                                case "A1":
                                                    ((Truyen)matHang1).setKhoGiay(KhoGiay.A1);
                                                    break;
                                                case "A2":
                                                    ((Truyen)matHang1).setKhoGiay(KhoGiay.A2);
                                                    break;
                                                case "A3": ((Truyen)matHang1).setKhoGiay(KhoGiay.A3);break;
                                                case "A4": ((Truyen)matHang1).setKhoGiay(KhoGiay.A4);break;
                                                case "A5": ((Truyen)matHang1).setKhoGiay(KhoGiay.A5);break;
                                                default:
                                                    System.out.println("Nhap sai");
                                                    break;
                                            }
                                            System.out.print("Moi nhap ngon ngu: ");
                                            ((Truyen)matHang1).setNgonNgu(sc.nextLine());
                                            cuaHangThuePhim.themMatHang(((Truyen)matHang1));
                                            break;
                                        case "3":
                                            bool1 = false;
                                    }

                                }
                                break;
                            case "2":
                                Boolean bool2 = true;
                                while (bool2) {
                                    System.out.println("----------------------");
                                    System.out.println("1.Xoa mat hang ");
                                    System.out.println("2.Quay lai ");
                                    System.out.println("----------------------");
                                    System.out.println("Moi chon tu(1-2): ");
                                    String j = sc.nextLine();
                                    switch (j) {
                                        case "1":
                                            System.out.println("Moi nhap ma mat hang muon xoa: ");

                                            cuaHangThuePhim.xoaMatHang(sc.nextLine());
                                            break;
                                        case "2":
                                            bool2 = false;
                                            break;
                                    }
                                    //break;
                                }
                                break;

                            case "3":
                                Boolean bool4 = true;
                                while (bool4) {
                                    System.out.println("---------------------");
                                    System.out.println("1.Sua phim");
                                    System.out.println("2.Sua truyen");
                                    System.out.println("3.Quay lai");
                                    System.out.println("---------------------");
                                    System.out.println("Moi nhap tu(1-3): ");
                                    String str4 = sc.nextLine();
                                    switch (str4) {
                                        case "1":
                                            System.out.println("Moi nhap ma mat hang muan sua:");
                                            cuaHangThuePhim.chinhSuaPhim(sc.nextLine());
                                            break;
                                        case "2":
                                            System.out.println("Moi nhap ma mat hang muon sua:");
                                            cuaHangThuePhim.chinhSuaTruyen(sc.nextLine());
                                            break;
                                        case "3":
                                            bool4 = false;
                                            break;
                                    }
                                }
                                break;

                            case "4":
                                Boolean bool5 = true;
                                while (bool5) {
                                    System.out.println("-----------------------------");
                                    System.out.println("1.Tim kiem theo tên phim");
                                    System.out.println("2.Tim kiem theo tên tac gia ");
                                    System.out.println("3.Tim kiem theo the loai");
                                    System.out.println("4.Tim kiem theo ten phim/truyen,ten tac gia,the loai");
                                    System.out.println("5.Quay lai ");
                                    System.out.println("-----------------------------");
                                    System.out.print("Nhap tu(1-5): ");
                                    String str3 = sc.nextLine();
                                    switch (str3) {
                                        case "1":
                                            System.out.println("Nhap ten phim muon tim kiem: ");
                                            for (MatHang x : cuaHangThuePhim.timMHTheoTenTruyenPhim(sc.nextLine())
                                            ) {
                                                x.inTTin();
                                            }

                                            break;
                                        case "2":
                                            System.out.println("Nhap ten tac gia muon tim kiem: ");
                                            for (MatHang x : cuaHangThuePhim.timMHTheoTenTacGia(sc.nextLine())
                                            ) {
                                                x.inTTin();
                                            }
                                            break;
                                        case "3":
                                            System.out.println("Nhap ten the loai muon tim kiem: ");
                                            for (MatHang x : cuaHangThuePhim.timMHTheoTheLoai(sc.nextLine())
                                            ) {
                                                x.inTTin();
                                            }
                                            break;
                                        case "4":
                                            System.out.println("Nhap tên phim/truyen,ten tac gia,the loai muon tim kiem: ");
                                            for (MatHang x : cuaHangThuePhim.timKiem(sc.nextLine(),sc.nextLine(),sc.nextLine())
                                            ) {
                                                x.inTTin();
                                            }
                                            break;
                                        case "5":
                                            bool5 = false;
                                            break;
                                        default:
                                            System.out.println("Nhap lai");
                                            break;
                                    }

                                }break;
                            case "5":
                                System.out.println("Moi nhap ngay bat đau: ");
                                String str1 = sc.nextLine();
                                Date date1 = spdf.parse(str1);
                                System.out.println("Moi nhap ngay ket thuc:");
                                String str2 = sc.nextLine();
                                Date date2 = spdf.parse(str2);

                                for (MatHang x : cuaHangThuePhim.timKiem(date1,date2)
                                ) {
                                    x.inTTin();
                                }
                                break;
                            case "6":
                                for (MatHang x : cuaHangThuePhim.layDanhSachMatHang()
                                ) {
                                    x.inTTin();
                                }
                                break;
                            case "7":
                                bool = false;
                                break;
                            default:
                                break;
                        }
                        //break;
                    }
                    break;
                case "2":
                    Boolean bool2 = true;
                    while (bool2) {
                        System.out.println("------------------");
                        System.out.println("1.Them nguoi thue");
                        System.out.println("2.Xoa nguoi thue");
                        System.out.println("3.Sua nguoi thue");
                        System.out.println("4.Hien thi nguoi thue");
                        System.out.println("5.Quay lai");
                        System.out.println("------------------");
                        System.out.print("Chon (1-5): ");
                        String b = sc.nextLine();
                        switch (b) {
                            case "1":
                                NguoiThue nguoiThue = new NguoiThue();
                                System.out.println("Moi nhap thong tin: ");
                                System.out.print("Nhap ma nguoi thue: ");
                                nguoiThue.setMaNguoiThue(sc.nextLine());
                                System.out.print("Nhap ten nguoi thue: ");
                                nguoiThue.setTen(sc.nextLine());
                                System.out.print("Nhap so đien thoai: ");
                                nguoiThue.setSoDienThoai(sc.nextLine());
//                                System.out.print("Nhập thời gian mượn: ");
//                                String str1 = sc.nextLine();
//                                Date date1 = spdf.parse(str1);
//                                nguoiThue.setThoiGianMuon(date1);
//                                System.out.print("Nhập thời gian trả: ");
//                                String str2 = sc.nextLine();
//                                Date date2 = spdf.parse(str2);
//                                nguoiThue.setThoiGianTra(date2);
                                System.out.print("Nhap so tien cuoc: ");
                                nguoiThue.setSoTienCuoc(sc.nextDouble());
                                cuaHangThuePhim.themNguoiThue(nguoiThue);
                                cuaHangThuePhim.thueTruyenPhim(nguoiThue);
                                break;
                            case "2":
                                System.out.println("Nhap ma so nguoi thue: ");
                                cuaHangThuePhim.xoaNguoiThue(sc.nextLine());
                                break;
                            case "3":
                                System.out.println("Nhap ma so nguoi thue muon sua:");
                                cuaHangThuePhim.suaNguoiThue(sc.nextLine());
                                break;
                            case "4":
                                cuaHangThuePhim.layDanhSachNguoiThue();
                                break;
                            case "5":
                                bool2 = false;
                                break;
                            default:
                                break;
                        }

                    }break;
                case "3":
                    System.out.println("Moi nhap thoi điem tinh doanh thu: ");
                    System.out.print("Moi nhap ngay bat đau: ");
                    String str1 = sc.nextLine();
                    Date date3 = spdf.parse(str1);
                    java.sql.Date date1 = new java.sql.Date(date3.getTime());
                    System.out.print("Moi nhap ngay ket thuc:");
                    String str2 = sc.nextLine();
                    Date date4 = spdf.parse(str2);
                    java.sql.Date date2 = new java.sql.Date(date4.getTime());
                    System.out.println("Doanh thu la: "+ cuaHangThuePhim.tinhDoanhThu(date1,date2));
                    break;
                case "4":
                    System.exit(0);
            }
        }
    }
}