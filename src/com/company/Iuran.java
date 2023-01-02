package com.company;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Iuran {
    private BigDecimal BiayaIuran;
    private LocalDate tanggal;

    public Iuran (BigDecimal biayaIuran, LocalDate tanggal){
        this.BiayaIuran = biayaIuran;
        this.tanggal = tanggal;
    }

    public BigDecimal getBiayaIuran() {
        return BiayaIuran;
    }

    public void setBiayaIuran(BigDecimal biayaIuran) {
        BiayaIuran = biayaIuran;
    }

    public LocalDate getTanggal() {
        return tanggal;
    }

    public void setTanggal(LocalDate tanggal) {
        this.tanggal = tanggal;
    }
}
