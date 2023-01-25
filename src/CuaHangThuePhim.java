import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class CuaHangThuePhim {
    private List<NguoiThue> nguoiThueList = new ArrayList<NguoiThue>();
    private List<MatHang> matHangList = new ArrayList<MatHang>();
    private List<MatHang> matHangThueList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat spdf = new SimpleDateFormat("yyyy-MM-dd");

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
                    for (int i =0;i<matHangList.size();i++) {
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

    public boolean themMatHang(MatHang a) {
        //MatHang b = (MatHang) a;
        matHangList.add(a);
        return true;
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

    public boolean suaMatHang(String maMatHang) {
        for (MatHang x : matHangList) {
            if (x.getMaMatHang().equals(maMatHang)) {
                //x.setMaMatHang(sc.nextLine());
                System.out.print("Nhập tên mặt hàng: ");
                sc.nextLine();
                x.setTenMatHang(sc.nextLine());
                System.out.print("Nhập tên tác giả: ");
                x.setTenTacGia(sc.nextLine());
                System.out.print("Nhập tên thể loại: ");
                x.setTheLoai(sc.nextLine());
                System.out.print("Nhập giá thuê theo ngày: ");
                x.setGiaThueTheoNgay(sc.nextDouble());
                System.out.print("nhập năm xuất bản: ");
                x.setNamXuatBan(sc.nextInt());
                return true;
            } else {
                System.out.println("Không tìm thấy mặt hàng này!");
            }
        }
        return false;
    }

    public void xoaNguoiThue(String a) {
        //for (NguoiThue x : nguoiThueList) {
        for (int i = 0;i<nguoiThueList.size();i++){
            NguoiThue x = nguoiThueList.get(i);
            if (x.getMaNguoiThue().equals(a)) {
                nguoiThueList.remove(x);
                System.out.println("Xóa thành công");
            }
            else {
                System.out.println("Không tìm thấy người thuê muốn xóa");
            }
        }

    }

    public void xoaMatHang(String a) {
        //for (MatHang x : matHangList) {
        for (int i = 0;i<matHangList.size();i++){
            MatHang x = matHangList.get(i);
            if (x.getMaMatHang().equals(a)) {
                matHangList.remove(x);
                System.out.println("Xóa thành công");
            }
            else{
                System.out.println("Không tìm thấy mặt hàng này");
            }
        }
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
