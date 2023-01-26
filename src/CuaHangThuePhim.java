import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class CuaHangThuePhim extends MySqlService {
    private List<NguoiThue> nguoiThueList = new ArrayList<NguoiThue>();
    private List<MatHang> matHangList = new ArrayList<MatHang>();
    private List<MatHang> matHangThueList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat spdf = new SimpleDateFormat("yyyy-MM-dd");

    public CuaHangThuePhim() {
        super();
    }

    public int tinhKhoangThoiGian(Date start, Date end) {
        int time = 0;
        try {
            // calculating the difference b/w startDate and endDate
            long getDiff = end.getTime() - start.getTime();
            // using TimeUnit class from java.util.concurrent package
            long getDaysDiff = TimeUnit.MILLISECONDS.toDays(getDiff);
            time = (int) getDaysDiff;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return time;
    }

    public double tinhTienChoThue(NguoiThue nguoiThue) {
        //NguoiThue nguoiThue = new NguoiThue();
        double tienthue = 0;
        int soNgayMuon = this.tinhKhoangThoiGian(nguoiThue.getThoiGianMuon(), nguoiThue.getThoiGianTra());
        for (MatHang x : matHangThueList) {
            tienthue = soNgayMuon * x.getGiaThueTheoNgay();
        }
        return tienthue;
    }

    public void thueTruyenPhim() {
        boolean bool = true;
        while (bool) {
            System.out.println("--------------");
            System.out.println("1.Thuê truyện phim");
            System.out.println("2.Tính tiền cho thuê");
            System.out.println("3.Thoát");
            System.out.println("--------------");
            System.out.print("Mời nhập (1-3):");
            String a = sc.nextLine();

            switch (a) {
                case "1":
                    System.out.println("Các mặt hàng hiện có: ");
                    for (MatHang x : matHangList) {
                        x.inTTin();
                    }
                    System.out.println("Nhâp mã mặt hàng muốn mượn: ");
                    String str = sc.nextLine();
                    //for (MatHang x : matHangList) {
                    for (int i = 0; i < matHangList.size(); i++) {
                        MatHang x = matHangList.get(i);
                        if (str.equals(x.getMaMatHang())) {
                            matHangThueList.add(x);
                            //
                            matHangList.remove(x);
                            //
                        } else {
                            System.out.println("Không tìm thấy mặt hàng muốn mượn");
                        }
                        //}
                    }
                    break;
                case "2":
                    //System.out.println(tinhTienChoThue());
                    break;
                case "3":
                    bool = false;
                    break;
                default:
                    break;
            }
        }
    }

    public boolean themNguoiThue(NguoiThue a) {
        nguoiThueList.add(a);
        return true;
    }

    public boolean themTruyen(Truyen a) {
//        matHangList.add(a);
//        return true;
        try {
            String sql = "insert into mathangtonkho values (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, a.getMaMatHang());
            preStatement.setString(2, a.getTenMatHang());
            preStatement.setString(3, a.getTenTacGia());
            preStatement.setInt(4, a.getNamXuatBan());
            preStatement.setString(5, a.getTheLoai());
            preStatement.setDouble(6, a.getGiaThueTheoNgay());
            preStatement.setInt(7, 0);
            preStatement.setInt(8, 0);
            preStatement.setString(9, "null");
            preStatement.setInt(10, a.getSoTrang());
            String str = null;
            switch (a.getKhoGiay()) {
                case A0:
                    str = "A0";
                case A1:
                    str = "A1";
                case A2:
                    str = "A2";
                default:
                    break;

            }
            preStatement.setString(11, str);
            preStatement.setString(12, a.getNgonNgu());
            int result = preStatement.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    public boolean themPhim(Phim a) {
        //MatHang b = (MatHang) a;
        //matHangList.add(a);

        //return true;
        try {
            String sql = "insert into mathangtonkho values (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, a.getMaMatHang());
            preStatement.setString(2, a.getTenMatHang());
            preStatement.setString(3, a.getTenTacGia());
            preStatement.setInt(4, a.getNamXuatBan());
            preStatement.setString(5, a.getTheLoai());
            preStatement.setDouble(6, a.getGiaThueTheoNgay());
            preStatement.setInt(7, a.getThoiGian());
            preStatement.setDouble(8, a.getDungLuong());
            preStatement.setString(9, a.getDoPhanGiai());
            preStatement.setInt(10, 0);
            preStatement.setString(11, "null");
            preStatement.setString(12, "null");
            int result = preStatement.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public void suaNguoiThue(String maNguoiThue) throws ParseException {
        for (NguoiThue x : nguoiThueList) {
            if (x.getMaNguoiThue().equals(maNguoiThue)) {
                //x.setMaNguoiThue(sc.nextLine());
                x.setTen(sc.nextLine());
                x.setSoDienThoai(sc.nextLine());
//
                String str1 = sc.nextLine();
                Date date1 = spdf.parse(str1);
                x.setThoiGianMuon(date1);
                String str2 = sc.nextLine();
                Date date2 = spdf.parse(str2);
                x.setThoiGianTra(date2);
                x.setSoTienCuoc(sc.nextDouble());
            }

//            NguoiThue b = new NguoiThue();
//            int i = nguoiThueList.indexOf(a);
//            nguoiThueList.set(i,b);
            else {
                System.out.println("Không tìm thấy người thuê này!");
            }
//
        }

    }


    public List<MatHang> layDanhSachMatHang() {
        List<MatHang> dsMH = new ArrayList<>();
        try {
            String sql1 = "SELECT `MaMatHang`, `TenMatHang`, `TenTacGia`, `NamXuatBan`, `TheLoai`, `GiaThueTheoNgay`, `ThoiGian`, `DungLuong`, `DoPhanGiai` from `mathangtonkho` where MaMatHang LIKE 'P%'";
            PreparedStatement preStatement = conn.prepareStatement(sql1);
            ResultSet result = preStatement.executeQuery();
            while (result.next()) {
                Phim matHang = new Phim();
                matHang.setMaMatHang(result.getString(1));
                matHang.setTenMatHang(result.getString(2));
                matHang.setTenTacGia(result.getString(3));
                matHang.setNamXuatBan(result.getInt(4));
                matHang.setTheLoai(result.getString(5));
                matHang.setGiaThueTheoNgay(result.getDouble(6));
                matHang.setThoiGian(result.getInt(7));
                matHang.setDungLuong(result.getDouble(8));
                matHang.setDoPhanGiai(result.getString(9));
                dsMH.add(matHang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String sql2 = "SELECT `MaMatHang`, `TenMatHang`, `TenTacGia`, `NamXuatBan`, `TheLoai`, `GiaThueTheoNgay`, `SoTrang`, `KhoGiay`, `NgonNgu` from `mathangtonkho` where MaMatHang LIKE 'T%'";
            PreparedStatement preStatement = conn.prepareStatement(sql2);
            ResultSet result = preStatement.executeQuery();
            while (result.next()) {
                Truyen truyen = new Truyen();
                truyen.setMaMatHang(result.getString(1));
                truyen.setTenMatHang(result.getString(2));
                truyen.setTenTacGia(result.getString(3));
                truyen.setNamXuatBan(result.getInt(4));
                truyen.setTheLoai(result.getString(5));
                truyen.setGiaThueTheoNgay(result.getDouble(6));
                truyen.setSoTrang(result.getInt(7));
                String str = result.getString(8);
                switch (str) {
                    case "A0":
                        truyen.setKhoGiay(KhoGiay.A0);
                    case "A1":
                        truyen.setKhoGiay(KhoGiay.A1);
                    case "A2":
                        truyen.setKhoGiay(KhoGiay.A2);
                    default:
                        truyen.setKhoGiay(null);
                }
                truyen.setNgonNgu(result.getString(9));
                dsMH.add(truyen);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        for (MatHang x: dsMH){
//            x.inTTin();
//        }
        return dsMH;
    }
    public boolean kiemTraMatHang(String maMatHang){
        try {
            String sql = "select * from mathangtonkho where MaMatHang=? ";
            PreparedStatement preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, maMatHang);

            ResultSet result = preStatement.executeQuery();
            if (result.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean chinhSuaPhim(String maMatHang) {
        Phim phim = new Phim();
        try {
            String sql = "update mathangtonkho set TenMatHang=?, TenTacGia=?, NamXuatBan=?, TheLoai=?,GiaThueTheoNgay=?, ThoiGian=?, DungLuong=?, DoPhanGiai=? where MaMatHang=?";
            PreparedStatement preStatement = conn.prepareStatement(sql);
            System.out.print("Nhập tên mặt hàng: ");
            phim.setTenMatHang(sc.nextLine());
            System.out.print("Nhập tên tác giả: ");
            phim.setTenTacGia(sc.nextLine());
            System.out.print("nhập năm xuất bản: ");
            phim.setNamXuatBan(sc.nextInt());
            sc.nextLine();
            System.out.print("Nhập tên thể loại: ");
            phim.setTheLoai(sc.nextLine());
            System.out.print("Nhập giá thuê theo ngày: ");
            phim.setGiaThueTheoNgay(sc.nextDouble());
            
            System.out.println("Nhập Thời gian: ");
            phim.setThoiGian(sc.nextInt());
            sc.nextLine();
            System.out.println("Nhập dung lượng: ");
            phim.setDungLuong(sc.nextDouble());
            System.out.println("Nhập độ phân giải: ");
            phim.setDoPhanGiai(sc.nextLine());
            preStatement.setString(1, phim.getTenMatHang());
            preStatement.setString(2, phim.getTenTacGia());
            preStatement.setInt(3, phim.getNamXuatBan());
            preStatement.setString(4, phim.getTheLoai());
            preStatement.setDouble(5, phim.getGiaThueTheoNgay());
            preStatement.setInt(6, phim.getThoiGian());
            preStatement.setDouble(7, phim.getDungLuong());
            preStatement.setString(8, phim.getDoPhanGiai());
            preStatement.setString(9,maMatHang);
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

    public boolean chinhSuaTruyen(String MaMatHang) {
        Truyen truyen = new Truyen();
        try {
            String sql = "update mathangtonkho set TenMatHang=?, TenTacGia=?, NamXuatBan=?, TheLoai=?,GiaThueTheoNgay=?, SoTrang=?, KhoGiay=?, NgonNgu=? where MaMatHang=?";
            PreparedStatement preStatement = conn.prepareStatement(sql);
            System.out.print("Nhập tên mặt hàng: ");
            sc.nextLine();
            truyen.setTenMatHang(sc.nextLine());
            System.out.print("Nhập tên tác giả: ");
            truyen.setTenTacGia(sc.nextLine());
            System.out.print("nhập năm xuất bản: ");
            truyen.setNamXuatBan(sc.nextInt());
            sc.nextLine();
            System.out.print("Nhập tên thể loại: ");
            truyen.setTheLoai(sc.nextLine());
            System.out.print("Nhập giá thuê theo ngày: ");
            truyen.setGiaThueTheoNgay(sc.nextDouble());
            System.out.println("Nhập ngôn ngữ: ");
            truyen.setNgonNgu(sc.nextLine());
            System.out.println("Nhập khổ giấy: ");
            String str = sc.nextLine();
            switch (str){
                case "A0": truyen.setKhoGiay(KhoGiay.A0);
                case "A1": truyen.setKhoGiay(KhoGiay.A1);
                case "A2": truyen.setKhoGiay(KhoGiay.A2);
                case "A3": truyen.setKhoGiay(KhoGiay.A3);
                case "A4": truyen.setKhoGiay(KhoGiay.A4);
                case "A5": truyen.setKhoGiay(KhoGiay.A5);
                default: truyen.setKhoGiay(KhoGiay.NULL);
            }
            System.out.println("Nhập ngôn ngữ: ");
            truyen.setNgonNgu(sc.nextLine());
            preStatement.setString(1, truyen.getTenMatHang());
            preStatement.setString(2, truyen.getTenTacGia());
            preStatement.setInt(3, truyen.getNamXuatBan());
            preStatement.setString(4, truyen.getTheLoai());
            preStatement.setDouble(5, truyen.getGiaThueTheoNgay());
            preStatement.setInt(6, truyen.getSoTrang());
            String str1 = null;
            switch (truyen.getKhoGiay()) {
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

            }
            preStatement.setString(7, str1);
            preStatement.setString(8, truyen.getNgonNgu());
            int result = preStatement.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean xoaNguoiThue(String a) {
        try {
            String sql = "delete from nguoithue where MaNguoiThue=?";
            PreparedStatement preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, a);
            int result = preStatement.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    public boolean xoaMatHang(String a) {
        try {
            String sql = "delete from truyentonkho  where MaMatHang=?";
            PreparedStatement preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, a);
            int result = preStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Xóa thành công");
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Xóa thất bại");
        return false;
    }

    public List<MatHang> timMHTheoTenTruyenPhim(String tenTruyenPhim) {
        List<MatHang> lsMH = new ArrayList<>();
        for (Object x : matHangList) {
            MatHang matHang = (MatHang) x;
            if (matHang.getTenMatHang().equals(tenTruyenPhim)) {
                lsMH.add(matHang);
            }
        }
        return lsMH;
    }

    public List<MatHang> timMHTheoTenTacGia(String tenTacGia) {
        List<MatHang> lsMH = new ArrayList<>();
        for (Object x : matHangList) {
            MatHang matHang = (MatHang) x;
            if (matHang.getTenMatHang().equals(tenTacGia)) {
                lsMH.add(matHang);

            }
        }

        return lsMH;
    }

    public List<MatHang> timMHTheoTheLoai(String tenTheLoai) {
        List<MatHang> lsMH = new ArrayList<>();
        for (Object x : matHangList) {
            MatHang matHang = (MatHang) x;
            if (matHang.getTenMatHang().equals(tenTheLoai)) {
                lsMH.add(matHang);
            }
        }
        return lsMH;
    }

    public List<MatHang> timKiem(String tenTheLoai) {
        List<MatHang> lsMH = new ArrayList<>();
        for (Object x : matHangList) {
            MatHang matHang = (MatHang) x;
            if (matHang.getTenMatHang().equals(tenTheLoai)) {
                lsMH.add(matHang);
            }
        }
        return lsMH;
    }

}
