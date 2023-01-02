package com.company;

import com.company.Enum.FrekuensiPembayaran;
import com.company.Enum.JenisProduk;
import com.company.Enum.TanggunganAsuransi;

import java.util.List;

public class Produk {
    private String namaProduk;
    private JenisProduk jenisProduk;
    private FrekuensiPembayaran frekuensiPembayaran;
    private String manfaat;
    private TanggunganAsuransi tanggunganAsuransi;

    public Produk(String namaProduk,JenisProduk jenisProduk, FrekuensiPembayaran frekuensiPembayaran,String manfaat,TanggunganAsuransi tanggunganAsuransi){
        this.namaProduk = namaProduk;
        this.jenisProduk = jenisProduk;
        this.frekuensiPembayaran = frekuensiPembayaran;
        this.manfaat = manfaat;
        this.tanggunganAsuransi = tanggunganAsuransi;
    }


    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public JenisProduk getJenisProduk() {
        return jenisProduk;
    }

    public void setJenisProduk(JenisProduk jenisProduk) {
        this.jenisProduk = jenisProduk;
    }

    public FrekuensiPembayaran getFrekuensiPembayaran() {
        return frekuensiPembayaran;
    }

    public void setFrekuensiPembayaran(FrekuensiPembayaran frekuensiPembayaran) {
        this.frekuensiPembayaran = frekuensiPembayaran;
    }


    public String getManfaat() {
        return manfaat;
    }

    public void setManfaat(String manfaat) {
        this.manfaat = manfaat;
    }

    public TanggunganAsuransi getTanggunganAsuransi() {
        return tanggunganAsuransi;
    }

}
