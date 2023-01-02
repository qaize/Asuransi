package com.company;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class Polis {
    private Nasabah pemilikPolis;
    private Nasabah TertanggunganAsuransi;
    private Produk produk;
    private LocalDate tanggalMulaiPolis;
    private String manfaatProduk;
    private List<Iuran> iuran;
    private Kendaraan kendaraan;

    public Polis(Nasabah pemilikPolis,Produk produk, Nasabah tertanggunganAsuransi,
                 LocalDate tanggalMulaiPolis, String manfaatProduk, List<Iuran> iuran) {

        this.TertanggunganAsuransi = tertanggunganAsuransi;
        this.produk = produk;
        this.tanggalMulaiPolis = tanggalMulaiPolis;
        this.manfaatProduk = manfaatProduk;
        this.iuran = iuran;
        this.pemilikPolis = pemilikPolis;

    }
    public Polis(Nasabah pemilikPolis,Kendaraan kendaraan,Produk produk,
                 LocalDate tanggalMulaiPolis, List<Iuran> iuran) {


        this.kendaraan = kendaraan;
        this.produk = produk;
        this.tanggalMulaiPolis = tanggalMulaiPolis;
        this.iuran = iuran;
        this.pemilikPolis = pemilikPolis;

    }


    public Nasabah getTertanggunganAsuransi() {
        return TertanggunganAsuransi;
    }

    public void setTertanggunganAsuransi(Nasabah tertanggunganAsuransi) {
        TertanggunganAsuransi = tertanggunganAsuransi;
    }

    public LocalDate getTanggalMulaiPolis() {
        return this.tanggalMulaiPolis;
    }

    public void setTanggalMulaiPolis(LocalDate tanggalMulaiPolis) {
        this.tanggalMulaiPolis = tanggalMulaiPolis;
    }

    public String getManfaatProduk() {
        return manfaatProduk;
    }

    public void setManfaatProduk(String manfaatProduk) {
        this.manfaatProduk = manfaatProduk;
    }

    public Produk getProduk() {
        return produk;
    }

    public void setProduk(Produk produk) {
        this.produk = produk;
    }

    public List<Iuran> getIuran() {
        return iuran;
    }

    public void setIuran(List<Iuran> iuran) {
        this.iuran = iuran;
    }

    public Kendaraan getKendaraan() {
        return kendaraan;
    }

    public void setKendaraan(Kendaraan kendaraan) {
        this.kendaraan = kendaraan;
    }

    public void printPolis(int i) {

        if (produk.getJenisProduk().getLabel().equals("Kendaraan")) {

            System.out.println("=======================POLICY INFO "+(String.format("%d",i))+"===============================");
            System.out.println("Produk : "+produk.getNamaProduk());
            System.out.println("Tanggal Mulai Dijalankan : " + Helper.FormatTanggal(getTanggalMulaiPolis(),"dd MMMM yyyy"));
            System.out.println("Jenis Kendaraan   : " + kendaraan.getJenisKendaraan().getLabel());
            System.out.println("Nomor Polisi      : " + kendaraan.getNoPolisi());
            System.out.println("Nomor STNK       : " + kendaraan.getNoSTNK());
            System.out.println("Merek Kendaraan   : " + kendaraan.getMerekKendaraan());
            System.out.println("Model Kendaraan   : " + kendaraan.getMerekKendaraan());
            System.out.println("Warna Kendaraan   : " + kendaraan.getWarnaKendaraan());
        } else {

            System.out.println("=======================POLICY INFO "+(String.format("%d",i))+"===============================");

            System.out.println(String.format("""
                            Tertanggung : %s %s
                            Product     : %s
                            Tanggal Mulai Dijalankan : %s
                            Manfaat     : %s

                            """, getTertanggunganAsuransi().getNamaDpn(),
                    getTertanggunganAsuransi().getNamaBlkng(),
                    getProduk().getNamaProduk(),
                    Helper.FormatTanggal(getTanggalMulaiPolis(), "dd MMMM yyyy"),
                    getManfaatProduk()));

        }
    }

    public void printIuran(int i){

        Locale indo = new Locale("id","ID");
        System.out.println("=======================PAYMENT "+(String.format("%d",i))+"===============================");
        for (Iuran iu : getIuran()
        ) {
            System.out.println(String.format("%s %s ",Helper.FormatTanggal(iu.getTanggal(),"dd MMMM yyyy"),
                    NumberFormat.getCurrencyInstance(indo).format(iu.getBiayaIuran())));
        }
        System.out.println("===============================================================");
    }


}
