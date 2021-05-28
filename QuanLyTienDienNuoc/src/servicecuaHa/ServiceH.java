/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicecuaHa;

import account.HoaDon;
import account.KhachHang;
import account.Sotieuthu;
import daocuaHa.ActcuaHa;
import java.util.List;

/**
 *
 * @author PC
 */
public class ServiceH {

    private ActcuaHa ActH;

    public ServiceH() {
        ActH = new ActcuaHa();
    }

    //Khách hàng
    public List<KhachHang> getAllKhachHang(String lenh) {
        return ActH.getAllKhachHangS(lenh);
    }

    //Số tiêu thụ
    public List<Sotieuthu> getAllSoTieuThu(String lenh) {
        return ActH.getAllSoTieuThu(lenh);
    }
    
    //HoaDon
    public List<HoaDon> getAllHoaDon(String lenh) {
        return ActH.getAllHoaDons(lenh);
    }
}
