//Author Pham Thanh Binh, Nghiem Hong Dang
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;



public class CuaHangThuePhim extends MySqlService {
    List<MatHang> dsMH = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat spdf = new SimpleDateFormat("yyyy-MM-dd");

    //Constructor
    public CuaHangThuePhim() {
        super();
    }
    // Phương thúc layDanhSachNguoiThue để hiện thị thông tin của người thuê
    public void layDanhSachNguoiThue() {
        try {
            String sql1 = "SELECT `MaNguoiThue`, `HoTen`, `SoDienThoai`, `MaMatHang`,`ThoiGianMuon`, `ThoiGianTra`, `TienCuoc`, `TinhTien` from `nguoithue` natural join `thuemathang` where 1";
            PreparedStatement preStatement = conn.prepareStatement(sql1);
            ResultSet result = preStatement.executeQuery();
            while (result.next()) {
                System.out.println("-------------------------------");
                System.out.println("Ma nguoi thue la: "+ result.getString(1));
                System.out.println("Ho ten nguoi thue la: "+ result.getString(2));
                System.out.println("So dien thoai la: "+ result.getString(3));
                System.out.println("Ma mat hang la: "+ result.getString(4));
                System.out.println("Thoi gian muon la: "+ result.getString(5));
                System.out.println("Thoi gian tra la: "+ result.getString(6));
                System.out.println("Tien cuoc la: "+ result.getString(7));
                System.out.println("Tinh tien la: "+ result.getString(8));
                System.out.println("-------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //Phương thức thueTruyenPhim để người thuê thực hiên việc thuê truyện phim
    public void thueTruyenPhim(NguoiThue nguoiThue) throws ParseException {
        boolean bool = true;
        while (bool) {
            System.out.println("--------------");
            System.out.println("1.Thue truyen phim");
            System.out.println("2.Thoat");
            System.out.println("--------------");
            System.out.print("Moi nhap (1-2):");
            String a = sc.nextLine();

            switch (a) {
                case "1":
                    System.out.println("Moi nhap ma mat hang: ");
                    String str = sc.nextLine();
                    System.out.println("Moi nhap ngày muon: ");
                    String str2 = sc.nextLine();
                    Date date = spdf.parse(str2);
                    java.sql.Date date1 = new java.sql.Date(date.getTime());
                    nguoiThue.setThoiGianMuon(date1);
                    System.out.println("Moi nhap ngay tra: ");
                    String str3 = sc.nextLine();
                    Date date2 = spdf.parse(str3);
                    java.sql.Date date3 = new java.sql.Date(date2.getTime());
                    nguoiThue.setThoiGianTra(date3);


                    try {
                        String sql = "insert into thuemathang (MaNguoiThue,MaMatHang,ThoiGianMuon,ThoiGianTra,TienCuoc,TinhTien) values (?,?,?,?,?,?)";
                        PreparedStatement preStatement = conn.prepareStatement(sql);
                        preStatement.setString(1, nguoiThue.getMaNguoiThue());
                        preStatement.setString(2, str);
                        java.sql.Date date4 = new java.sql.Date(nguoiThue.getThoiGianMuon().getTime());
                        preStatement.setDate(3, date4);
                        java.sql.Date date5 = new java.sql.Date(nguoiThue.getThoiGianTra().getTime());
                        preStatement.setDate(4, date5);
                        preStatement.setDouble(5, nguoiThue.getSoTienCuoc());
                        double tinhtien = 0.0;
                        preStatement.setDouble(6, tinhtien);
                        int result = preStatement.executeUpdate();

                        String sql1 = " Select * from  `mathang` where MaMatHang=?  ";
                        PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);
                        //preparedStatement1.setString(1, nguoiThue.getMaNguoiThue());
                        preparedStatement1.setString(1, str);
                        ResultSet result1 = preparedStatement1.executeQuery();
                        if (result1.next()) {
                            // calculating the difference b/w startDate and endDate
                            long getDiff = nguoiThue.getThoiGianTra().getTime() - nguoiThue.getThoiGianMuon().getTime();
                            // using TimeUnit class from java.util.concurrent package
                            long getDaysDiff = TimeUnit.MILLISECONDS.toDays(getDiff);
                            tinhtien = getDaysDiff * result1.getDouble(6);
                        }

                        String sql3 = "update `thuemathang`  set TinhTien=? where MaNguoiThue=? and MaMatHang=?";
                        PreparedStatement preStatement3 = conn.prepareStatement(sql3);
                        preStatement3.setDouble(1, tinhtien);
                        preStatement3.setString(2, nguoiThue.getMaNguoiThue());
                        preStatement3.setString(3, str);
                        int result3 = preStatement3.executeUpdate();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "2":
                    bool = false;
                    break;
                default:
                    break;
            }
        }
    }

    // Phương thức themNguoiThue để thêm thông tin người thuê
    public boolean themNguoiThue(NguoiThue nguoiThue) {
        try {
            String sql1 = "insert into nguoithue values (?,?,?)";
            PreparedStatement preStatement = conn.prepareStatement(sql1);
            preStatement.setString(1, nguoiThue.getMaNguoiThue());
            preStatement.setString(2, nguoiThue.getTen());
            preStatement.setString(3, nguoiThue.getSoDienThoai());
            int result = preStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }


    //Phương thức themPhim để thêm thông tin về phim
    public boolean themMatHang(MatHang a) {
        try {
            String sql = "insert into mathang values (?,?,?,?,?,?,?,?,?,?,?,?) ";
            PreparedStatement preStatement = conn.prepareStatement(sql);

            preStatement.setString(1, a.getMaMatHang());
            preStatement.setString(2, a.getTenMatHang());
            preStatement.setString(3, a.getTenTacGia());
            preStatement.setInt(4, a.getNamXuatBan());
            preStatement.setString(5, a.getTheLoai());
            preStatement.setDouble(6, a.getGiaThueTheoNgay());
            if (a instanceof Phim){
            preStatement.setInt(7, ((Phim)a).getThoiGian());
            preStatement.setDouble(8, ((Phim)a).getDungLuong());
            preStatement.setString(9, ((Phim)a).getDoPhanGiai());
            preStatement.setInt(10, 0);
            preStatement.setString(11, "null");
            preStatement.setString(12, "null");
            }
            else {
                preStatement.setInt(7, 0);
                preStatement.setInt(8, 0);
                preStatement.setString(9, "null");
                preStatement.setInt(10, ((Truyen)a).getSoTrang());
                String str = null;
                switch (((Truyen)a).getKhoGiay()) {
                    case A0:
                        str = "A0";break;
                    case A1:
                        str = "A1";break;
                    case A2:
                        str = "A2";break;
                    case A3:
                        str = "A3";break;
                    case A4:
                        str = "A4";break;
                    case A5:
                        str = "A5";break;
                    case NULL:
                        str = "NULL";break;
                    default:
                        str = "Nhập sai";
                        break;

                }

            preStatement.setString(11, str);
            preStatement.setString(12, ((Truyen)a).getNgonNgu());}
            int result = preStatement.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

//Phương thức suaNguoiThue để sửa thông tin người thuê
    public boolean suaNguoiThue(String maNguoiThue) throws ParseException {
        NguoiThue nguoiThue = new NguoiThue();
        try {
            String sql = "update nguoithue set HoTen=?, SoDienThoai=? where MaNguoiThue=?";
            PreparedStatement preStatement = conn.prepareStatement(sql);
            //sc.nextLine();
            System.out.print("Nhap ten nguoi thue: ");
            nguoiThue.setTen(sc.nextLine());
            System.out.print("Nhap so dien thoai: ");
            nguoiThue.setSoDienThoai(sc.nextLine());

            preStatement.setString(1, nguoiThue.getTen());
            preStatement.setString(2, nguoiThue.getSoDienThoai());
            preStatement.setString(3, maNguoiThue);
            int result = preStatement.executeUpdate();
//            if (result > 0) {
//                return true;
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            String sql2 = "Update thuemathang set MaMatHang=?, ThoiGianMuon=?, ThoiGianTra=?, TienCuoc=? where MaNguoiThue=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql2);
            System.out.println("Moi nhap ma mat hang: ");
            String str = sc.nextLine();
            preparedStatement.setString(1, str);
            System.out.println("Moi nhap thoi gian muon: ");
            String str1 = sc.nextLine();
            Date date1 = spdf.parse(str1);
            java.sql.Date date3 = new java.sql.Date(date1.getTime());
            preparedStatement.setDate(2, date3);
            System.out.println("Moi nhap thoi gian tra: ");
            String str2 = sc.nextLine();
            Date date2 = spdf.parse(str2);
            java.sql.Date date4 = new java.sql.Date(date2.getTime());
            preparedStatement.setDate(3, date4);
            System.out.println("Moi nhap tien cuoc: ");
            double a = sc.nextDouble();
            preparedStatement.setDouble(4, a);
            preparedStatement.setString(5, maNguoiThue);
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    //Phương thức layDanhSachMatHang để in thông tin các mặt hàng.
    public List<MatHang> layDanhSachMatHang() {
        try {
            String sql1 = "SELECT `MaMatHang`, `TenMatHang`, `TenTacGia`, `NamXuatBan`, `TheLoai`, `GiaThueTheoNgay`, `ThoiGian`, `DungLuong`, `DoPhanGiai` from `mathang` where MaMatHang LIKE 'P%'";
            PreparedStatement preStatement = conn.prepareStatement(sql1);
            ResultSet result = preStatement.executeQuery();
            while (result.next()) {
                MatHang matHang = new Phim();
                matHang.setMaMatHang(result.getString(1));
                matHang.setTenMatHang(result.getString(2));
                matHang.setTenTacGia(result.getString(3));
                matHang.setNamXuatBan(result.getInt(4));
                matHang.setTheLoai(result.getString(5));
                matHang.setGiaThueTheoNgay(result.getDouble(6));
                ((Phim)matHang).setThoiGian(result.getInt(7));
                ((Phim)matHang).setDungLuong(result.getDouble(8));
                ((Phim)matHang).setDoPhanGiai(result.getString(9));
                dsMH.add(matHang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String sql2 = "SELECT `MaMatHang`, `TenMatHang`, `TenTacGia`, `NamXuatBan`, `TheLoai`, `GiaThueTheoNgay`, `SoTrang`, `KhoGiay`, `NgonNgu` from `mathang` where MaMatHang LIKE 'T%'";
            PreparedStatement preStatement = conn.prepareStatement(sql2);
            ResultSet result = preStatement.executeQuery();
            while (result.next()) {
                MatHang matHang = new Truyen();
                ((Truyen)matHang).setMaMatHang(result.getString(1));
                ((Truyen)matHang).setTenMatHang(result.getString(2));
                ((Truyen)matHang).setTenTacGia(result.getString(3));
                ((Truyen)matHang).setNamXuatBan(result.getInt(4));
                ((Truyen)matHang).setTheLoai(result.getString(5));
                ((Truyen)matHang).setGiaThueTheoNgay(result.getDouble(6));
                ((Truyen)matHang).setSoTrang(result.getInt(7));
                String str = result.getString(8);
                switch (str) {
                    case "A0":
                        ((Truyen)matHang).setKhoGiay(KhoGiay.A0);break;
                    case "A1":
                        ((Truyen)matHang).setKhoGiay(KhoGiay.A1);break;
                    case "A2":
                        ((Truyen)matHang).setKhoGiay(KhoGiay.A2);break;
                    case "A3":
                        ((Truyen)matHang).setKhoGiay(KhoGiay.A3);break;
                    case "A4":
                        ((Truyen)matHang).setKhoGiay(KhoGiay.A4);break;
                    case "A5":
                        ((Truyen)matHang).setKhoGiay(KhoGiay.A5);break;
                    case "NULL":
                        ((Truyen)matHang).setKhoGiay(KhoGiay.NULL);break;
                    default:
                        ((Truyen)matHang).setKhoGiay(null);break;
                }
                ((Truyen)matHang).setNgonNgu(result.getString(9));
                dsMH.add(((Truyen)matHang));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        for (MatHang x: dsMH){
//            x.inTTin();
//        }
        return dsMH;
    }

    //Phương thức chinhSuaPhim để sửa thông tin của phim
    public boolean chinhSuaPhim(String maMatHang) {
        MatHang matHang = new Phim();
        try {
            String sql = "update mathang set TenMatHang=?, TenTacGia=?, NamXuatBan=?, TheLoai=?,GiaThueTheoNgay=?, ThoiGian=?, DungLuong=?, DoPhanGiai=? where MaMatHang=?";
            PreparedStatement preStatement = conn.prepareStatement(sql);
            System.out.print("Nhap ten mat hang: ");
            ((Phim)matHang).setTenMatHang(sc.nextLine());
            System.out.print("Nhap ten tac gia: ");
            ((Phim)matHang).setTenTacGia(sc.nextLine());
            System.out.print("Nhap nam xuat ban: ");
            ((Phim)matHang).setNamXuatBan(sc.nextInt());
            sc.nextLine();
            System.out.print("Nhap ten the loai: ");
            ((Phim)matHang).setTheLoai(sc.nextLine());
            System.out.print("Nhap gia thue theo ngay: ");
            ((Phim)matHang).setGiaThueTheoNgay(sc.nextDouble());

            System.out.println("Nhap Thoi gian: ");
            ((Phim)matHang).setThoiGian(sc.nextInt());
            sc.nextLine();
            System.out.println("Nhap dung luong: ");
            ((Phim)matHang).setDungLuong(sc.nextDouble());
            sc.nextLine();
            System.out.println("Nhap đo phan giai: ");
            ((Phim)matHang).setDoPhanGiai(sc.nextLine());
            preStatement.setString(1, ((Phim)matHang).getTenMatHang());
            preStatement.setString(2, ((Phim)matHang).getTenTacGia());
            preStatement.setInt(3, ((Phim)matHang).getNamXuatBan());
            preStatement.setString(4, ((Phim)matHang).getTheLoai());
            preStatement.setDouble(5, ((Phim)matHang).getGiaThueTheoNgay());
            preStatement.setInt(6, ((Phim)matHang).getThoiGian());
            preStatement.setDouble(7, ((Phim)matHang).getDungLuong());
            preStatement.setString(8, ((Phim)matHang).getDoPhanGiai());
            preStatement.setString(9, maMatHang);
            //if (preStatement.setString(9,maMatHang) != "")
            int result = preStatement.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //Phương thức chinhSuaTruyen để sửa thông tin truyện

    public boolean chinhSuaTruyen(String MaMatHang) {
        MatHang matHang = new Truyen();
        try {
            String sql = "update mathang set TenMatHang=?, TenTacGia=?, NamXuatBan=?, TheLoai=?,GiaThueTheoNgay=?, SoTrang=?, KhoGiay=?, NgonNgu=? where MaMatHang=?";
            PreparedStatement preStatement = conn.prepareStatement(sql);
            System.out.print("Nhap ten mat hang: ");
            ((Truyen)matHang).setTenMatHang(sc.nextLine());
            System.out.print("Nhap ten tac gia: ");
            ((Truyen)matHang).setTenTacGia(sc.nextLine());
            System.out.print("nhap nam xuat ban: ");
            ((Truyen)matHang).setNamXuatBan(sc.nextInt());
            sc.nextLine();
            System.out.print("Nhap ten the loai: ");
            ((Truyen)matHang).setTheLoai(sc.nextLine());
            System.out.print("Nhap gia thue theo ngay: ");
            ((Truyen)matHang).setGiaThueTheoNgay(sc.nextDouble());
            sc.nextLine();
            System.out.println("Nhap so trang: ");
            ((Truyen)matHang).setSoTrang(sc.nextInt());
            sc.nextLine();
            System.out.println("Nhap ngon ngu: ");
            ((Truyen)matHang).setNgonNgu(sc.nextLine());
            System.out.println("Nhap kho giay: ");
            String str = sc.nextLine();
            switch (str) {
                case "A0":
                    ((Truyen)matHang).setKhoGiay(KhoGiay.A0); break;
                case "A1":
                    ((Truyen)matHang).setKhoGiay(KhoGiay.A1); break;
                case "A2":
                    ((Truyen)matHang).setKhoGiay(KhoGiay.A2); break;
                case "A3":
                    ((Truyen)matHang).setKhoGiay(KhoGiay.A3); break;
                case "A4":
                    ((Truyen)matHang).setKhoGiay(KhoGiay.A4); break;
                case "A5":
                    ((Truyen)matHang).setKhoGiay(KhoGiay.A5); break;
                case "NULL":
                    ((Truyen)matHang).setKhoGiay(KhoGiay.NULL); break;
                default:
                    ((Truyen)matHang).setKhoGiay(KhoGiay.NULL); break;
            }
            preStatement.setString(1, ((Truyen)matHang).getTenMatHang());
            preStatement.setString(2, ((Truyen)matHang).getTenTacGia());
            preStatement.setInt(3, ((Truyen)matHang).getNamXuatBan());
            preStatement.setString(4, ((Truyen)matHang).getTheLoai());
            preStatement.setDouble(5, ((Truyen)matHang).getGiaThueTheoNgay());
            preStatement.setInt(6, ((Truyen)matHang).getSoTrang());
            String str1 = null;
            switch (((Truyen)matHang).getKhoGiay()) {
                case A0:
                    str1 = "A0";
                    break;
                case A1:
                    str1 = "A1";
                    break;
                case A2:
                    str1 = "A2";
                    break;
                case A3:
                    str1 = "A3";
                    break;
                case A4:
                    str1 = "A4";
                    break;
                case A5:
                    str1 = "A5";
                    break;
                case NULL:
                    str1 = "NULL";

            }
            preStatement.setString(7, str1);
            preStatement.setString(8, ((Truyen)matHang).getNgonNgu());
            preStatement.setString(9, MaMatHang);
            int result = preStatement.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //Phương thức xoaNguoiThue để xóa thông tin ngươi thuê

    public boolean xoaNguoiThue(String a) {
        try {
//            String sql = "delete from thuemathang where MaNguoiThue=?";
//            PreparedStatement preStatement = conn.prepareStatement(sql);
//            preStatement.setString(1, a);
//            int result = preStatement.executeUpdate();
//            if (result > 0) {
//                return true;
//            }
            String sql = "delete from nguoithue where MaNguoiThue=?";
            PreparedStatement preStatement1 = conn.prepareStatement(sql);
            preStatement1.setString(1, a);
            int result1 = preStatement1.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return false;

    }
    
    //Phương thức xoaMatHang để xóa thông tin mat hang
    public boolean xoaMatHang(String a) {
        try {
            String sql = "delete from mathang  where MaMatHang=?";
            PreparedStatement preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, a);
            int result = preStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Xoa thanh cong");
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Xoa that bai");
        return false;
    }

    //Phuong thuc timMHTheoTenTruyenPhim để tìm kiếm thông tin mặt hàng theo tên mặt hàng
    public List<MatHang> timMHTheoTenTruyenPhim(String tenTruyenPhim) {
        List<MatHang> lsMH = new ArrayList<>();
        try {
            String sql1 = "Select * from mathang where TenMatHang =? and MaMatHang LIKE 'T%'";
            PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);
            preparedStatement1.setString(1, tenTruyenPhim);
            ResultSet result = preparedStatement1.executeQuery();
            while (result.next()) {
                MatHang matHang = new Truyen();
                matHang.setMaMatHang(result.getString(1));
                matHang.setTenMatHang(result.getString(2));
                matHang.setTenTacGia(result.getString(3));
                matHang.setNamXuatBan(result.getInt(4));
                matHang.setTheLoai(result.getString(5));
                matHang.setGiaThueTheoNgay(result.getDouble(6));
                ((Truyen)matHang).setSoTrang(result.getInt(10));
                switch (result.getString(11)) {
                    case "A0":
                        ((Truyen)matHang).setKhoGiay(KhoGiay.A0);break;
                    case "A1":
                        ((Truyen)matHang).setKhoGiay(KhoGiay.A1);break;
                    case "A2":
                        ((Truyen)matHang).setKhoGiay(KhoGiay.A2);break;
                    case "A3":
                        ((Truyen)matHang).setKhoGiay(KhoGiay.A3);break;
                    case "A4":
                        ((Truyen)matHang).setKhoGiay(KhoGiay.A4);break;
                    case "A5":
                        ((Truyen)matHang).setKhoGiay(KhoGiay.A5);break;
                    case "NULL":
                        ((Truyen)matHang).setKhoGiay(KhoGiay.NULL);break;
                    default:
                        ((Truyen)matHang).setKhoGiay(KhoGiay.NULL);break;
                }
                ((Truyen)matHang).setNgonNgu(result.getString(12));
                lsMH.add(((Truyen)matHang));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String sql1 = "Select * from mathang where TenMatHang =? and MaMatHang LIKE 'P%'";
            PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);
            preparedStatement1.setString(1, tenTruyenPhim);
            ResultSet result = preparedStatement1.executeQuery();
            while (result.next()) {
                MatHang matHang = new Phim();
                matHang.setMaMatHang(result.getString(1));
                matHang.setTenMatHang(result.getString(2));
                matHang.setTenTacGia(result.getString(3));
                matHang.setNamXuatBan(result.getInt(4));
                matHang.setTheLoai(result.getString(5));
                matHang.setGiaThueTheoNgay(result.getDouble(6));
                ((Phim)matHang).setThoiGian(result.getInt(7));
                ((Phim)matHang).setDungLuong(result.getDouble(8));
                ((Phim)matHang).setDoPhanGiai(result.getString(9));
                lsMH.add(((Phim)matHang));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return lsMH;
    }

    // Tìm kiếm thông tin mặt hàng theo tên tác giả
    public List<MatHang> timMHTheoTenTacGia(String tenTacGia) {
        List<MatHang> lsMH = new ArrayList<>();
        try {
            String sql1 = "Select * from mathang where TenTacGia =? and MaMatHang LIKE 'T%'";
            PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);
            preparedStatement1.setString(1, tenTacGia);
            ResultSet result = preparedStatement1.executeQuery();
            while (result.next()) {
                MatHang matHang = new Truyen();
                matHang.setMaMatHang(result.getString(1));
                matHang.setTenMatHang(result.getString(2));
                matHang.setTenTacGia(result.getString(3));
                matHang.setNamXuatBan(result.getInt(4));
                matHang.setTheLoai(result.getString(5));
                matHang.setGiaThueTheoNgay(result.getDouble(6));
                ((Truyen)matHang).setSoTrang(result.getInt(10));
                switch (result.getString(11)) {
                    case "A0":
                        ((Truyen)matHang).setKhoGiay(KhoGiay.A0);break;
                    case "A1":
                        ((Truyen)matHang).setKhoGiay(KhoGiay.A1);break;
                    case "A2":
                        ((Truyen)matHang).setKhoGiay(KhoGiay.A2);break;
                    case "A3":
                        ((Truyen)matHang).setKhoGiay(KhoGiay.A3);break;
                    case "A4":
                        ((Truyen)matHang).setKhoGiay(KhoGiay.A4);break;
                    case "A5":
                        ((Truyen)matHang).setKhoGiay(KhoGiay.A5);break;
                    case "NULL":
                        ((Truyen)matHang).setKhoGiay(KhoGiay.NULL);break;
                    default:
                        ((Truyen)matHang).setKhoGiay(KhoGiay.NULL);break;
                }
                ((Truyen)matHang).setNgonNgu(result.getString(12));
                lsMH.add(((Truyen)matHang));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String sql1 = "Select * from mathang where TenTacGia =? and MaMatHang LIKE 'P%'";
            PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);
            preparedStatement1.setString(1, tenTacGia);
            ResultSet result = preparedStatement1.executeQuery();
            while (result.next()) {
                MatHang matHang = new Phim();
                matHang.setMaMatHang(result.getString(1));
                matHang.setTenMatHang(result.getString(2));
                matHang.setTenTacGia(result.getString(3));
                matHang.setNamXuatBan(result.getInt(4));
                matHang.setTheLoai(result.getString(5));
                matHang.setGiaThueTheoNgay(result.getDouble(6));
                ((Phim)matHang).setThoiGian(result.getInt(7));
                ((Phim)matHang).setDungLuong(result.getDouble(8));
                ((Phim)matHang).setDoPhanGiai(result.getString(9));
                lsMH.add(((Phim)matHang));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return lsMH;
    }

    // tìm kiếm theo thể loại
    public List<MatHang> timMHTheoTheLoai(String tenTheLoai) {
        List<MatHang> lsMH = new ArrayList<>();
        try {
            String sql1 = "Select * from mathang where TheLoai =? and MaMatHang LIKE 'T%'";
            PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);
            preparedStatement1.setString(1, tenTheLoai);
            ResultSet result = preparedStatement1.executeQuery();
            while (result.next()) {
                MatHang matHang = new Truyen();
                matHang.setMaMatHang(result.getString(1));
                matHang.setTenMatHang(result.getString(2));
                matHang.setTenTacGia(result.getString(3));
                matHang.setNamXuatBan(result.getInt(4));
                matHang.setTheLoai(result.getString(5));
                matHang.setGiaThueTheoNgay(result.getDouble(6));
                ((Truyen)matHang).setSoTrang(result.getInt(10));
                switch (result.getString(11)) {
                    case "A0":
                        ((Truyen)matHang).setKhoGiay(KhoGiay.A0);break;
                    case "A1":
                        ((Truyen)matHang).setKhoGiay(KhoGiay.A1);break;
                    case "A2":
                        ((Truyen)matHang).setKhoGiay(KhoGiay.A2);break;
                    case "A3":
                        ((Truyen)matHang).setKhoGiay(KhoGiay.A3);break;
                    case "A4":
                        ((Truyen)matHang).setKhoGiay(KhoGiay.A4);break;
                    case "A5":
                        ((Truyen)matHang).setKhoGiay(KhoGiay.A5);break;
                    case "NULL":
                        ((Truyen)matHang).setKhoGiay(KhoGiay.NULL);break;
                    default:
                        ((Truyen)matHang).setKhoGiay(KhoGiay.NULL);break;
                }
                ((Truyen)matHang).setNgonNgu(result.getString(12));
                lsMH.add(((Truyen)matHang));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String sql1 = "Select * from mathang where TheLoai =? and MaMatHang LIKE 'P%'";
            PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);
            preparedStatement1.setString(1, tenTheLoai);
            ResultSet result = preparedStatement1.executeQuery();
            while (result.next()) {
                MatHang matHang = new Phim();
                matHang.setMaMatHang(result.getString(1));
                matHang.setTenMatHang(result.getString(2));
                matHang.setTenTacGia(result.getString(3));
                matHang.setNamXuatBan(result.getInt(4));
                matHang.setTheLoai(result.getString(5));
                matHang.setGiaThueTheoNgay(result.getDouble(6));
                ((Phim)matHang).setThoiGian(result.getInt(7));
                ((Phim)matHang).setDungLuong(result.getDouble(8));
                ((Phim)matHang).setDoPhanGiai(result.getString(9));
                lsMH.add(((Phim)matHang));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return lsMH;
    }

    // tìm kiếm theo Tên mặt hàng, Tên tác giả, tên thể loại
    public List<MatHang> timKiem(String tenMatHang, String tenTacGia, String tenTheLoai) {
        List<MatHang> lsMH = new ArrayList<>();
        try {
            String sql1 = "Select * from mathang where TenMatHang=? and TenTacGia=? and TheLoai =? and MaMatHang LIKE 'T%'";
            PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);
            preparedStatement1.setString(1, tenMatHang);
            preparedStatement1.setString(2, tenTacGia);
            preparedStatement1.setString(3, tenTheLoai);
            ResultSet result = preparedStatement1.executeQuery();
            while (result.next()) {
                MatHang matHang = new Truyen();
                matHang.setMaMatHang(result.getString(1));
                matHang.setTenMatHang(result.getString(2));
                matHang.setTenTacGia(result.getString(3));
                matHang.setNamXuatBan(result.getInt(4));
                matHang.setTheLoai(result.getString(5));
                matHang.setGiaThueTheoNgay(result.getDouble(6));
                ((Truyen)matHang).setSoTrang(result.getInt(10));
                switch (result.getString(11)) {
                    case "A0":
                        ((Truyen)matHang).setKhoGiay(KhoGiay.A0);break;
                    case "A1":
                        ((Truyen)matHang).setKhoGiay(KhoGiay.A1);break;
                    case "A2":
                        ((Truyen)matHang).setKhoGiay(KhoGiay.A2);break;
                    case "A3":
                        ((Truyen)matHang).setKhoGiay(KhoGiay.A3);break;
                    case "A4":
                        ((Truyen)matHang).setKhoGiay(KhoGiay.A4);break;
                    case "A5":
                        ((Truyen)matHang).setKhoGiay(KhoGiay.A5);break;
                    case "NULL":
                        ((Truyen)matHang).setKhoGiay(KhoGiay.NULL);break;
                    default:
                        ((Truyen)matHang).setKhoGiay(KhoGiay.NULL);break;
                }
                ((Truyen)matHang).setNgonNgu(result.getString(12));
                lsMH.add(((Truyen)matHang));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String sql1 = "Select * from mathang where TenMatHang=? and TenTacGia=? and TheLoai =? and MaMatHang LIKE 'P%'";
            PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);
            preparedStatement1.setString(1, tenMatHang);
            preparedStatement1.setString(2, tenTacGia);
            preparedStatement1.setString(3, tenTheLoai);
            ResultSet result = preparedStatement1.executeQuery();
            while (result.next()) {
                MatHang matHang = new Phim();
                matHang.setMaMatHang(result.getString(1));
                matHang.setTenMatHang(result.getString(2));
                matHang.setTenTacGia(result.getString(3));
                matHang.setNamXuatBan(result.getInt(4));
                matHang.setTheLoai(result.getString(5));
                matHang.setGiaThueTheoNgay(result.getDouble(6));
                ((Phim)matHang).setThoiGian(result.getInt(7));
                ((Phim)matHang).setDungLuong(result.getDouble(8));
                ((Phim)matHang).setDoPhanGiai(result.getString(9));
                lsMH.add(((Phim)matHang));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return lsMH;
    }

    // tìm kiếm các mặt hàng đang được thuê theo ngày nhập vào - ngày kết thúc
    public List<MatHang> timKiem(Date start, Date end) {
        List<MatHang> lsMH = new ArrayList<>();
        try {
            String sql1 = "SELECT * FROM `mathang` NATURAL JOIN `thuemathang` WHERE MaMatHang LIKE 'P%' and ThoiGianTra<? and ThoiGianTra >?";
            PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);
            String str1 = spdf.format(end);
            preparedStatement1.setString(1, str1);
            String str2 = spdf.format(start);
            preparedStatement1.setString(2, str2);
            ResultSet result = preparedStatement1.executeQuery();
            while (result.next()) {
                MatHang matHang = new Phim();
                matHang.setMaMatHang(result.getString(1));
                matHang.setTenMatHang(result.getString(2));
                matHang.setTenTacGia(result.getString(3));
                matHang.setNamXuatBan(result.getInt(4));
                matHang.setTheLoai(result.getString(5));
                matHang.setGiaThueTheoNgay(result.getDouble(6));
                ((Phim)matHang).setThoiGian(result.getInt(7));
                ((Phim)matHang).setDungLuong(result.getDouble(8));
                ((Phim)matHang).setDoPhanGiai(result.getString(9));
                lsMH.add(((Phim)matHang));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String sql2 = "SELECT * FROM `mathang` NATURAL JOIN `thuemathang` WHERE MaMatHang LIKE 'T%' and ThoiGianTra<? and ThoiGianTra >?";
            PreparedStatement preparedStatement1 = conn.prepareStatement(sql2);
            String str1 = spdf.format(end);
            preparedStatement1.setString(1, str1);
            String str2 = spdf.format(start);
            preparedStatement1.setString(2, str2);
            ResultSet result = preparedStatement1.executeQuery();
            while (result.next()) {
                MatHang matHang = new Truyen();
                matHang.setMaMatHang(result.getString(1));
                matHang.setTenMatHang(result.getString(2));
                matHang.setTenTacGia(result.getString(3));
                matHang.setNamXuatBan(result.getInt(4));
                matHang.setTheLoai(result.getString(5));
                matHang.setGiaThueTheoNgay(result.getDouble(6));
                ((Truyen)matHang).setSoTrang(result.getInt(10));
                switch (result.getString(11)) {
                    case "A0":
                        ((Truyen)matHang).setKhoGiay(KhoGiay.A0);break;
                    case "A1":
                        ((Truyen)matHang).setKhoGiay(KhoGiay.A1);break;
                    case "A2":
                        ((Truyen)matHang).setKhoGiay(KhoGiay.A2);break;
                    case "A3":
                        ((Truyen)matHang).setKhoGiay(KhoGiay.A3);break;
                    case "A4":
                        ((Truyen)matHang).setKhoGiay(KhoGiay.A4);break;
                    case "A5":
                        ((Truyen)matHang).setKhoGiay(KhoGiay.A5);break;
                    case "NULL":
                        ((Truyen)matHang).setKhoGiay(KhoGiay.A5);break;
                    default:
                        ((Truyen)matHang).setKhoGiay(KhoGiay.NULL);break;
                }
                ((Truyen)matHang).setNgonNgu(result.getString(12));
                lsMH.add(((Truyen)matHang));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return lsMH;

    }

    // tính doanh thu
    public double tinhDoanhThu(java.sql.Date start, java.sql.Date end) {
        double doanhthu = 0.0;
        try {
            String sql = " Select *from `thuemathang` natural join `mathang` where ThoiGianTra<=? and ThoiGianTra>=?  ";
            PreparedStatement preparedStatement1 = conn.prepareStatement(sql);
            //String str1 = spdf.format(end);
            preparedStatement1.setDate(1, end);
            //String str2 = spdf.format(start);
            preparedStatement1.setDate(2, start);
            ResultSet result = preparedStatement1.executeQuery();
            while (result.next()) {
                NguoiThue nguoiThue = new NguoiThue();
                //MatHang matHang = new MatHang();
                Date date1 = spdf.parse(result.getString(3));
                nguoiThue.setThoiGianMuon(date1);
                Date date2 = spdf.parse(result.getString(4));
                nguoiThue.setThoiGianTra(date2);

                try {
                    // calculating the difference b/w startDate and endDate
                    long getDiff = nguoiThue.getThoiGianTra().getTime() - nguoiThue.getThoiGianMuon().getTime();
                    // using TimeUnit class from java.util.concurrent package
                    long getDaysDiff = TimeUnit.MILLISECONDS.toDays(getDiff);
                    //time = (int) getDaysDiff;
                    doanhthu += getDaysDiff * result.getDouble(11);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String sql = " Select *from `thuemathang` natural join `mathang` where ThoiGianTra>? and ThoiGianMuon<=? and ThoiGianMuon>=? ";
            PreparedStatement preparedStatement1 = conn.prepareStatement(sql);
            //String str1 = spdf.format(end);
            preparedStatement1.setDate(1, end);
            preparedStatement1.setDate(2, end);
            preparedStatement1.setDate(3, start);

            ResultSet result = preparedStatement1.executeQuery();
            while (result.next()) {
                NguoiThue nguoiThue = new NguoiThue();
                //MatHang matHang = new MatHang();
                Date date1 = spdf.parse(result.getString(3));
                nguoiThue.setThoiGianMuon(date1);
                Date date2 = spdf.parse(result.getString(4));
                nguoiThue.setThoiGianTra(date2);

                try {
                    // calculating the difference b/w startDate and endDate
                    long getDiff = nguoiThue.getThoiGianTra().getTime() - nguoiThue.getThoiGianMuon().getTime();
                    // using TimeUnit class from java.util.concurrent package
                    long getDaysDiff = TimeUnit.MILLISECONDS.toDays(getDiff);
                    //time = (int) getDaysDiff;
                    doanhthu += result.getDouble(5);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return doanhthu;
    }
}
