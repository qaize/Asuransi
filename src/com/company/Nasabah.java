package com.company;

import com.company.Enum.JenisKelamin;
import com.company.Enum.MetodePembayaran;
import com.company.Enum.StatusKK;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Nasabah extends Person {
    private Integer noProspectCalon;
    private String noNasabah;
    private String noKtp;
    private StatusKK statusDiKK;
    private MetodePembayaran metodePembayaran;
    private  HashMap<String,Produk> hashValidateProduk = new HashMap<>();
    private  List<Polis> listPolisLokal = new LinkedList<>();


    public Nasabah(){}

    public Nasabah(Integer noProspect, String noNasabah, String namaDpn, String namaBlkng,String noKtp, LocalDate tglLahir, String tempatLahir,
                   JenisKelamin jenisKelamin, String perkerjaan, StatusKK statusDiKK,MetodePembayaran metodePembayaran){
        super(namaDpn,namaBlkng,tglLahir,tempatLahir,jenisKelamin,perkerjaan);
        this.noProspectCalon = noProspect;
        this.noNasabah = noNasabah;
        this.noKtp = noKtp;
        this.statusDiKK = statusDiKK;
        this.metodePembayaran = metodePembayaran;
    }

    public  HashMap<String, Produk> getHashValidateProduk() {
        return hashValidateProduk;
    }

    public  void setHashValidateProduk(String data,Produk produk) {
        this.hashValidateProduk.put(data,produk);
    }
    public  void setListPolisNasabah(Polis data){
        this.listPolisLokal.add(data);
    }
    public  List<Polis> getPolisNasabah(){
        return this.listPolisLokal;
    }
    public String getNoNasabah() {
        return noNasabah;
    }
    public String getNoKtp() {
        return noKtp;
    }
    public StatusKK getStatusDiKK() {
        return statusDiKK;
    }
    public MetodePembayaran getMetodePembayaran() {
        return metodePembayaran;
    }
    public void  printProdukSisa(){
        HashMap<String,Produk> hashPolis = new HashMap<>();

        {
            for (Produk prd : Asuransi.getListProduk()
            ) {
                hashPolis.put(prd.getNamaProduk(), prd);

            }
        }
        for (Map.Entry cek : hashPolis.entrySet()
             ) {
            if(!(cek.getValue().equals(hashValidateProduk.get(cek.getKey())))){
                Produk produk =(Produk) cek.getValue();
                System.out.println(produk.getNamaProduk());
            }

        }




    }


}
