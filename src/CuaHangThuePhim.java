import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CuaHangThuePhim {
    private List<NguoiThue> nguoiThueList = new ArrayList<NguoiThue>();
    private List<MatHang> matHangList = new ArrayList<MatHang>();
    public boolean themNguoiThue(NguoiThue a){
        nguoiThueList.add(a);
        return true;
    }
    public boolean themMatHang(MatHang a){
        //MatHang b = (MatHang) a;
        matHangList.add(a);
        return true;
    }
    public void suaNguoiThue(NguoiThue nguoiThue){
        if (nguoiThueList.contains(nguoiThue) == true){
//            NguoiThue b = new NguoiThue();
//            int i = nguoiThueList.indexOf(a);
//            nguoiThueList.set(i,b);


        }
        else {
            System.out.println("Không tìm thấy người thuê này!");
        }
    }
    public void suaMatHang(MatHang matHang){
        if (matHangList.contains(matHang) == true){

        }
        else {
            System.out.println("Không tìm thấy mặt hàng này!");
        }
    }
    public void xoaNguoiThue(NguoiThue a){
        nguoiThueList.remove(a);
    }
    public void xoaMatHang(MatHang a){
        matHangList.remove(a);
    }
    public List<MatHang> timMHTheoTenTruyenPhim(String tenTruyenPhim){
        List<MatHang> lsMH = new ArrayList<>();
        for (Object x : matHangList){
            MatHang matHang = (MatHang) x;
            if (matHang.getTenMatHang().equals(tenTruyenPhim)){
                lsMH.add(matHang);
            }
        }
        return lsMH;
    }
    public List<MatHang> timMHTheoTenTacGia(String tenTacGia){
        List<MatHang> lsMH = new ArrayList<>();
        for (Object x : matHangList){
            MatHang matHang = (MatHang) x;
            if (matHang.getTenMatHang().equals(tenTacGia)){
                lsMH.add(matHang);
            }
        }
        return lsMH;
    }
    public List<MatHang> timMHTheoTheLoai(String tenTheLoai){
        List<MatHang> lsMH = new ArrayList<>();
        for (Object x : matHangList){
            MatHang matHang = (MatHang) x;
            if (matHang.getTenMatHang().equals(tenTheLoai)){
                lsMH.add(matHang);
            }
        }
        return lsMH;
    }
}
