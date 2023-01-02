package com.company.Enum;

public enum JenisKendaraan {
    MOBIL("Mobil")
    ,MOTOR("Motor");

    private String label;

    JenisKendaraan(String label){
        this.label = label;
    }

    public  static JenisKendaraan getJenisKendaraan (String kendaraan){
        if(kendaraan.equals("Motor")){
            return JenisKendaraan.MOTOR;
        }
        else{
            return JenisKendaraan.MOBIL;
        }

    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
