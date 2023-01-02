package com.company;

import com.company.Enum.JenisKelamin;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;

public class Helper {

    public static String generateNewNoNasabah(Integer noProspect){
        String result = "";
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatingBulan = DateTimeFormatter.ofPattern("MM");
        DateTimeFormatter formatingTahun = DateTimeFormatter.ofPattern("yyyy");
        result = String.format("%s/%s/%d",formatingBulan.format(now),formatingTahun.format(now),noProspect);

        return result;
    }
    public static JenisKelamin getEnum(String input){

        if(input=="L"){
            return JenisKelamin.LAKI_LAKI;
        }

        return JenisKelamin.PEREMPUAN;

    }
    public static String FormatTanggal(LocalDate tanggal,String pattern){
        Locale indo = new Locale("id","ID");
        DateTimeFormatter formatan = DateTimeFormatter.ofPattern(pattern,indo);
        return formatan.format(tanggal);
    }

}
