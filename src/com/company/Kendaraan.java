package com.company;

import com.company.Enum.FrekuensiPembayaran;
import com.company.Enum.JenisKendaraan;
import com.company.Enum.JenisProduk;

import java.util.List;

public class Kendaraan {

    private JenisKendaraan jenisKendaraan;
    private String noPolisi;
    private String noSTNK;
    private String merekKendaraan;
    private String modelKendaraan;
    private String warnaKendaraan;

        public Kendaraan (JenisKendaraan jenisKendaraan, String noPolisi, String noSTNK,
                      String merekKendaraan, String modelKendaraan, String warnaKendaraan){
        this.jenisKendaraan = jenisKendaraan;
        this.noPolisi = noPolisi;
        this.noSTNK = noSTNK;
        this.merekKendaraan = merekKendaraan;
        this.modelKendaraan = modelKendaraan;
        this.warnaKendaraan = warnaKendaraan;

    }


    public JenisKendaraan getJenisKendaraan() {
        return jenisKendaraan;
    }

    public void setJenisKendaraan(JenisKendaraan jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }

    public String getNoPolisi() {
        return this.noPolisi;
    }

    public void setNoPolisi(String noPolisi) {
        this.noPolisi = noPolisi;
    }

    public String getNoSTNK() {
        return this.noSTNK;
    }

    public void setNoSTNK(String noSTNK) {
        this.noSTNK = noSTNK;
    }

    public String getMerekKendaraan() {
        return this.merekKendaraan;
    }

    public void setMerekKendaraan(String merekKendaraan) {
        this.merekKendaraan = merekKendaraan;
    }

    public String getModelKendaraan() {
        return this.modelKendaraan;
    }

    public void setModelKendaraan(String modelKendaraan) {
        this.modelKendaraan = modelKendaraan;
    }

    public String getWarnaKendaraan() {
        return this.warnaKendaraan;
    }

    public void setWarnaKendaraan(String warnaKendaraan) {
        this.warnaKendaraan = warnaKendaraan;
    }
}
