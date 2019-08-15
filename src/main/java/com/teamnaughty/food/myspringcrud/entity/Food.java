package com.teamnaughty.food.myspringcrud.entity;

import javax.persistence.*;

@Entity
@Table(name = "bang8update2")
public class Food {
    @Id
    private String name;

    @Column(name = "quantity")
    private String soLuong;

    @Column(name = "calo")
    private int calo;

    @Column(name = "fat")
    private int beo;

    @Column(name = "protein")
    private int dam;

    @Column(name = "carbon")
    private int botDuong;

    @Column(name = "fiber")
    private int xo;

    public Food(){
        name = "food";
        soLuong = "0";
        calo = 0;
        dam =0;
        beo =0;
        botDuong = 0;
        xo = 0;
    }

    public Food(String ten, String soLuong, int calo, int dam, int beo, int botDuong, int xo) {
        this.name = ten;
        this.soLuong = soLuong;
        this.calo = calo;
        this.dam = dam;
        this.beo = beo;
        this.botDuong = botDuong;
        this.xo = xo;
    }

    public String getTen() {
        return name;
    }

    public void setTen(String ten) {
        this.name = ten;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public int getCalo() {
        return calo;
    }

    public void setCalo(int calo) {
        this.calo = calo;
    }

    public int getDam() {
        return dam;
    }

    public void setDam(int dam) {
        this.dam = dam;
    }

    public int getBeo() {
        return beo;
    }

    public void setBeo(int beo) {
        this.beo = beo;
    }

    public int getBotDuong() {
        return botDuong;
    }

    public void setBotDuong(int botDuong) {
        this.botDuong = botDuong;
    }

    public int getXo() {
        return xo;
    }

    public void setXo(int xo) {
        this.xo = xo;
    }
}
