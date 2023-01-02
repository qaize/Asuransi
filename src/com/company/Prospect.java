package com.company;

import com.company.Enum.JenisKelamin;
import com.company.Enum.Status;

import java.time.LocalDate;

public class Prospect extends Person {
    private Integer noProspect;
    private Status status;

    public Prospect(Integer noProspect,String namaDpn, String namaBlkng, LocalDate tglLahir, String tempatLahir,
                    JenisKelamin jenisKelamin, String perkerjaan, Status status){
        super(namaDpn,namaBlkng,tglLahir,tempatLahir,jenisKelamin,perkerjaan);
        this.noProspect = noProspect;
        this.status = status;
    }

    public Integer getNoProspect() {return noProspect;}
    public void setNoProspect(Integer noProspect) {this.noProspect = noProspect;}

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
