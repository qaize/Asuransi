package com.company.Enum;

public enum JenisKelamin {
    LAKI_LAKI("Laki-Laki ","L")
    ,PEREMPUAN("Perempuan","P");

    private String kelamin;
    private String insial;

    JenisKelamin(String kelamin,String insial){
        this.kelamin = kelamin;
        this.insial = insial;
    }

    public String getKelamin(){
        return this.kelamin;
    }
    public String getInsial(String insial){

        return this.insial;
    }

}
