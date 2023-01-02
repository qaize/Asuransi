package com.company.Enum;

public enum MetodePembayaran {
    CREDIT_CARD(" Credit Card","CC"),
    AUTO_DEBIT("Auto Debit","AD"),
    VOUCHER_PRABAYAR("Voucher Prabayar","VP");

    private String pembayaran;
    private String inisial;

     MetodePembayaran(String pembayaran,String inisial){
        this.pembayaran = pembayaran;
        this.inisial = inisial;
    }


    public static MetodePembayaran metodePembayaran(String metode) {
        if(metode.equals("AD")){

            return MetodePembayaran.AUTO_DEBIT;
        }

        else if(metode.equals("CC")){
            return MetodePembayaran.CREDIT_CARD;
        }

        else {
            return MetodePembayaran.VOUCHER_PRABAYAR;

        }


    }

    public String getInisial() {
        return this.inisial;
    }

    public String getPembayaran() {
        return pembayaran;
    }

    public void setPembayaran(String pembayaran) {
        this.pembayaran = pembayaran;
    }
}
