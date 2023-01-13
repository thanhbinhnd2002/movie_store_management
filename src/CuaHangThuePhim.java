import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CuaHangThuePhim {
    List<NguoiThue> nguoiThueList = new ArrayList<NguoiThue>();
    List<MatHang> matHangList = new ArrayList<MatHang>();
    public void themNguoiThue(NguoiThue a){
        nguoiThueList.add(a);
    }
    public void themMatHang(MatHang a){
        //MatHang b = (MatHang) a;
        matHangList.add(a);
    }
    public void suaNguoiThue(NguoiThue a){
        if (nguoiThueList.contains(a) == true){
            NguoiThue b = new NguoiThue();
            int i = nguoiThueList.indexOf(a);
            nguoiThueList.set(i,b);
        }
        else {
            System.out.println("Không tìm thấy người thuê này!");
        }
    }
    public void suaMatHang(MatHang a){
        if (matHangList.contains(a) == true){

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

}
