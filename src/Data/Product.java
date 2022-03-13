/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author ADMIN
 */
public class Product {
    private String ID,tenSP,gia,trangThai;

    public String getId() {
        return ID;
    }

    public void setId(String id) {
        this.ID = id;
    }
        public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }
        public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }
        public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangthai) {
        this.trangThai = trangthai;
    }
}
