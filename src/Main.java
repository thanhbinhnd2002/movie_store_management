import java.util.Date;

public class Main {
    public static void main(String[] args) {
        MatHang truyen = new Truyen("doraemon","fuji",2002,"truyen tranh",2000,100,KhoGiay.A2,"tieng Viet");
        truyen.inTTin();
        NguoiThue nguoiThue = new NguoiThue("Binh","0979633868",truyen,new Date(20/11/2020),200.0);
        CuaHangThuePhim cuaHangThuePhim = new CuaHangThuePhim();
        cuaHangThuePhim.themNguoiThue(nguoiThue);
        System.out.println(cuaHangThuePhim.nguoiThueList.get(0));
    }
}