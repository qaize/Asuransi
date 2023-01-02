package com.company.Enum;

public enum Status {
    PROSPECT("Prospect"),NASABAH("Nasabah");

    private String label;
    Status (String label){
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
