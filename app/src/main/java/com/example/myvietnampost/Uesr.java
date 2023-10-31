package com.example.myvietnampost;

public class Uesr {

    private String HT;
    private String SDT;
    private String GMail;
    private String DCCT;
    private String Tinh;
    private String Huyen;
    private String Xa;

    public Uesr(String HT, String SDT, String GMail, String DCCT, String tinh, String huyen, String xa) {
        this.HT = HT;
        this.SDT = SDT;
        this.GMail = GMail;
        this.DCCT = DCCT;
        this.Tinh = tinh;
        this.Huyen = huyen;
        this.Xa = xa;
    }

    public String getHT() {
        return HT;
    }

    public void setHT(String HT) {
        this.HT = HT;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getGMail() {
        return GMail;
    }

    public void setGMail(String GMail) {
        this.GMail = GMail;
    }

    public String getDCCT() {
        return DCCT;
    }

    public void setDCCT(String DCCT) {
        this.DCCT = DCCT;
    }

    public String getTinh() {
        return Tinh;
    }

    public void setTinh(String tinh) {
        Tinh = tinh;
    }

    public String getHuyen() {
        return Huyen;
    }

    public void setHuyen(String huyen) {
        Huyen = huyen;
    }

    public String getXa() {
        return Xa;
    }

    public void setXa(String xa) {
        Xa = xa;
    }
}
