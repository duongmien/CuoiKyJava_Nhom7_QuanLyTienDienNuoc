/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account;

import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class KhachHangTK {
    private String tenkh, ngaytao;
    private double tong;
    private int makh;

    public String getTenkh() {
        return tenkh;
    }

    public String getNgaytao() {
        return ngaytao;
    }

    public double getTong() {
        return tong;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public void setNgaytao(String ngaytao) {
        this.ngaytao = ngaytao;
    }

    public void setTong(double tong) {
        this.tong = tong;
    }

    public int getMakh() {
        return makh;
    }

    public void setMakh(int makh) {
        this.makh = makh;
    }
    
}
