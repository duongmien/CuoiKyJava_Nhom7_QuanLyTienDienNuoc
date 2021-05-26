/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account;

/**
 *
 * @author PC
 */
public class GiaDienNuoc {
    private int idGDN;
    private String doiTuong;
    private float giaDien, giaNuoc;

    public int getIdGDN() {
        return idGDN;
    }

    public String getDoiTuong() {
        return doiTuong;
    }

    public float getGiaDien() {
        return giaDien;
    }

    public float getGiaNuoc() {
        return giaNuoc;
    }

    public void setIdGDN(int idGDN) {
        this.idGDN = idGDN;
    }

    public void setDoiTuong(String doiTuong) {
        this.doiTuong = doiTuong;
    }

    public void setGiaDien(float giaDien) {
        this.giaDien = giaDien;
    }

    public void setGiaNuoc(float giaNuoc) {
        this.giaNuoc = giaNuoc;
    }
    
}
