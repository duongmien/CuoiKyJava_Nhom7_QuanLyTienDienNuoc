/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daocuaHa;
import account.KhachHang;
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
public class ActHoaDonvsTKVL {
    public List<KhachHang> getAllHD() {

        List<KhachHang> hoadons = new ArrayList<KhachHang>();
        Connection cnt = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM khachhang";
        try {
            PreparedStatement preparedStatement = cnt.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                KhachHang hoaDon = new KhachHang();
                hoaDon.setMaKH(rs.getInt("mahd"));
                hoaDon.setTenKH(rs.getString("makh"));
                hoaDon.setNgaySinh(rs.getString("ngaylap"));
                hoaDon.setGioiTinh(rs.getString("ghichu"));
                hoaDon.setSdt(rs.getString("tenkh"));
                hoaDon.setDoiTuong(rs.getString("ngaylap"));
                hoaDon.setDiaChi(rs.getString("ghichu"));
                hoaDon.setIdGDN(rs.getInt("tenkh"));
                hoadons.add(hoaDon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hoadons;

    }
}
