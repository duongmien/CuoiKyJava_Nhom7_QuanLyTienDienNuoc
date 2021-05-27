/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daocuaHa;

import account.KhachHang;
import account.Sotieuthu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import ketnoiSQL.JDBCConnection;

/**
 *
 * @author PC
 */
public class ActcuaHa {

    public List<KhachHang> getAllKhachHangS(String lenh) {

        List<KhachHang> hoadons = new ArrayList<KhachHang>();
        Connection cnt = JDBCConnection.getJDBCConnection();
        String sql = lenh;
        try {
            PreparedStatement preparedStatement = cnt.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                KhachHang hoaDon = new KhachHang();
                hoaDon.setMaKH(rs.getInt("makh"));
                hoaDon.setTenKH(rs.getString("tenkh"));
                hoaDon.setNgaySinh(rs.getString("ngaysinh"));
                hoaDon.setSdt(rs.getString("sdt"));
                hoaDon.setGioiTinh(rs.getString("gioitinh"));
                hoaDon.setDiaChi(rs.getString("diachi"));
                hoaDon.setTenPhuong(rs.getString("tenphuong"));
                hoaDon.setTenQuan(rs.getString("tenquan"));
                hoadons.add(hoaDon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hoadons;
    }

    public List<Sotieuthu> getAllSoTieuThu(String lenh) {

        List<Sotieuthu> sotieuthus = new ArrayList<Sotieuthu>();
        Connection cnt = JDBCConnection.getJDBCConnection();
        String sql = lenh;
        try {
            PreparedStatement preparedStatement = cnt.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Sotieuthu hoaDon = new Sotieuthu();
                hoaDon.setIdTT(rs.getInt("idtt"));
                hoaDon.setMaKH(rs.getInt("makh"));
                hoaDon.setChisocuDien(rs.getFloat("chisocuDien"));
                hoaDon.setChisomoiDien(rs.getFloat("chisomoiDien"));
                hoaDon.setChisocuNuoc(rs.getFloat("chisocuNuoc"));
                hoaDon.setChisomoiNuoc(rs.getFloat("chisomoiNuoc"));
                hoaDon.setNgayNhap(rs.getString("ngayNhap"));
                sotieuthus.add(hoaDon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sotieuthus;
    }

}
