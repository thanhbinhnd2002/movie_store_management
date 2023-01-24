import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CuaHangThuePhim {
    private List<NguoiThue> nguoiThueList = new ArrayList<NguoiThue>();
    private List<MatHang> matHangList = new ArrayList<MatHang>();
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat spdf = new SimpleDateFormat("yyyy-MM-dd");

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
                x.setMaNguoiThue(sc.nextLine());
                x.setTen(sc.nextLine());
                x.setSoDienThoai(sc.nextLine());
                x.setPhimtruyen(sc.nextLine());
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

        }
//        else {
//            System.out.println("Không tìm thấy người thuê này!");
    }

}

    public void suaMatHang(String maMatHang) {
        if (matHangList.contains(matHang) == true) {

        } else {
            System.out.println("Không tìm thấy mặt hàng này!");
        }
    }

    public void xoaNguoiThue(String a) {
        for (NguoiThue x : nguoiThueList) {
            if (x.getMaNguoiThue().equals(a)) {
                nguoiThueList.remove(x);
            }
        }

    }

    public void xoaMatHang(String a) {
        for (MatHang x : matHangList) {
            if (x.getMaMatHang().equals(a)) {
                nguoiThueList.remove(x);
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
