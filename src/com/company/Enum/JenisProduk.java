package com.company.Enum;

public enum JenisProduk {
    KESEHATAN("Kesehatan"),
    JIWA("Jiwa"),
    KENDARAAN("Kendaraan");

    private String label;

    JenisProduk(String label){
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public JenisProduk getJenisProduk(String jenis){
        if(jenis.equals("Jiwa")){
            return JenisProduk.JIWA;

        }
        else if(jenis.equals("Kesehatan")){
            return JenisProduk.KESEHATAN;
        }
        else {
            return JenisProduk.KENDARAAN;
        }

    }
}
