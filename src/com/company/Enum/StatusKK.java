package com.company.Enum;

public enum StatusKK {
    KEPALA_RUMAH_TANGGA("ayah"),
    ISTRI("ibu"),
    ANAK("anak");

    private String label;

    StatusKK(String label){
        this.label = label;
    }

    public static StatusKK getKK(String label){
        if(label.equals("ayah")){
            return StatusKK.KEPALA_RUMAH_TANGGA;
        }
        else if (label.equals("ibu")){
            return StatusKK.ISTRI;
        }
        else{
            return StatusKK.ANAK;
        }
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
