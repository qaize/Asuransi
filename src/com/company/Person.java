package com.company;

import com.company.Enum.JenisKelamin;

import java.time.LocalDate;

public class Person {

    private String namaDpn;
    private String namaBlkng;
    private LocalDate tglLahir;
    private String tempatLahir;
    private JenisKelamin jenisKelamin;
    private String perkerjaan;

    public Person(){};
    public Person (String namaDpn,String namaBlkng,LocalDate tglLahir,
                   String tempatLahir,JenisKelamin jenisKelamin,String perkerjaan){

        this.namaDpn = namaDpn;
        this.namaBlkng = namaBlkng;
        this.tglLahir = tglLahir;
        this.tempatLahir = tempatLahir;
        this.jenisKelamin = jenisKelamin;
        this.perkerjaan = perkerjaan;

    }


    public String getNamaDpn() {
        return namaDpn;
    }

    public void setNamaDpn(String namaDpn) {
        this.namaDpn = namaDpn;
    }

    public String getNamaBlkng() {
        return namaBlkng;
    }

    public void setNamaBlkng(String namaBlkng) {
        this.namaBlkng = namaBlkng;
    }

    public LocalDate getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(LocalDate tglLahir) {
        this.tglLahir = tglLahir;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public JenisKelamin getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(JenisKelamin jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getPerkerjaan() {
        return perkerjaan;
    }

    public void setPerkerjaan(String perkerjaan) {
        this.perkerjaan = perkerjaan;
    }
}
