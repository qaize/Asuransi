package com.company.Enum;

public enum TanggunganAsuransi {
    KELUARGA("Keluarga"),
    SENDIRI("Sendiri");

    private String label;
    TanggunganAsuransi(String label){
        this.label = label;

    }
    public TanggunganAsuransi getTanggungan(String input){
        if(input.equals("Keluarga")){
            return TanggunganAsuransi.KELUARGA;
        }
        else{
            return TanggunganAsuransi.SENDIRI;
        }
    }

    public String getLabel() {
        return label;
    }
}
