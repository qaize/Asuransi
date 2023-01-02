package com.company;

import com.company.Enum.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Asuransi {
    private static String namaPerusahaan;

    private static final HashMap<Integer, Prospect> listProspect = new HashMap<>();
    private static final HashMap<String, Nasabah> listNasabah = new HashMap<>();
    private static final List<Produk> listProduk = new LinkedList<>();
    private static final List<Polis> listPolisNasabah = new LinkedList<>();


    /*All menu*/
    public static void menuUtama() {
        setNamaPerusahaan("Asuransi Vita bona");

        System.out.println(getNamaPerusahaan());

        boolean check = false;
        Scanner inp = new Scanner(System.in);
        String pilih = "";
        String paragraf = """
                Pilih lah salah satu menu di bawah ini:
                1.	Menu Prospect
                2.	Menu Customer
                3.	Exit Application                   
                """;
        do {
            try {

                System.out.println(paragraf);
                System.out.print("Pilih : ");
                pilih = inp.next();
                check = true;
                if (!(Integer.parseInt(pilih) > 0 && Integer.parseInt(pilih) < 5)) {
                    System.out.println("pilih angka 1-4");
                    check = false;
                }

            } catch (Exception exception) {
                System.out.println("Mohon Input angka ");
                check = false;
            }
        }
        while (!check);

        switch (Integer.parseInt(pilih)) {
            case 1: {
                menuProspect();
                break;

            }
            case 2: {
                menuCostumer();
                break;
            }
            case 3: {
                System.exit(0);
                break;
            }

            default: {
                System.out.println("Input yang bener");
                break;
            }
        }
    }

    public static void menuProspect() {

        showProspectAll();
        String paragraf = """
                Pilih lah salah satu menu di bawah ini:
                1.	Add Prospect
                2.	Prospect To Customer
                3.	Main Menu
                4.	Exit Application         
                """;

        boolean check = false;
        Scanner inp = new Scanner(System.in);
        String pilih = "";
        do {
            try {
                System.out.println(paragraf);
                System.out.print("Pilih : ");
                pilih = inp.next();
                check = true;
                if (!(Integer.parseInt(pilih) > 0 && Integer.parseInt(pilih) < 5)) {
                    System.out.println("pilih angka 1-4");
                    check = false;
                }

            } catch (Exception exception) {
                System.out.println("Input angka");
                check = false;
            }
        }
        while (!check);

        switch (Integer.parseInt(pilih)) {
            case 1: {

                setProspect();
                break;
            }
            case 2: {
                convertProspectToNasabah();
                break;
            }
            case 3: {
                menuUtama();
                break;
            }
            case 4: {
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Input yang bener");
                break;
            }
        }
        menuProspect();
    }

    public static void menuCostumer() {

        String paragraf = """
                Pilih Menu yang ingin dipilih
                1.	Buy Product
                2.	Detail Policy
                3.	Main Menu
                4.	Exit Application  
                """;

        boolean check = false;
        Scanner inp = new Scanner(System.in);
        String pilih = "";
        do {
            showNasabahAll();
            try {

                System.out.println(paragraf);
                System.out.print("Pilih : ");
                pilih = inp.next();
                check = true;
                if (!(Integer.parseInt(pilih) > 0 && Integer.parseInt(pilih) < 5)) {
                    System.out.println("pilih angka 1-4");
                    check = false;
                }

            } catch (Exception exception) {
                System.out.println("Input angka");
                check = false;
            }
        }
        while (!check);

        switch (Integer.parseInt(pilih)) {
            case 1: {
                beliProduk();
                break;

            }
            case 2: {
                detailPolis();
                break;
            }
            case 3: {
                menuUtama();
                break;
            }
            case 4: {
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Input yang bener");
                break;
            }
        }

    }
    /*Menu Customer*/
    public static void detailPolis() {
        showNasabahAll();
        String noCostumer = "";
        int i = 1;
        Nasabah nasabah;
        Scanner inp = new Scanner(System.in);
        System.out.print("Pilih no Costumer : ");
        noCostumer = inp.next();
        if (listNasabah.containsKey(noCostumer)) {
            nasabah = listNasabah.get(noCostumer);

            System.out.println("======================Costumer Info========================");
            System.out.printf(
                    "No : %s, %s %s, %s, %s (%s), %s,\nNoKTP : %s,Status di KK : %s, Payment Method : %s " +
                            "\n ============================================================%n",
                    nasabah.getNoNasabah(), nasabah.getNamaDpn(), nasabah.getNamaBlkng(),
                    nasabah.getJenisKelamin().getKelamin(), Helper.FormatTanggal(nasabah.getTglLahir(), "dd MMMM yyyy"), nasabah.getTempatLahir(),
                    nasabah.getPerkerjaan(), nasabah.getNoKtp(), nasabah.getStatusDiKK().getLabel(),
                    nasabah.getMetodePembayaran().getPembayaran()

            );

            if (nasabah.getPolisNasabah() != null) {
                for (Polis pol : nasabah.getPolisNasabah()
                ) {
                    if (pol != null) {
                        pol.printPolis(i);
                        pol.printIuran(i);
                        i++;
                    } else {
                        System.out.println("Customer Belum memiliki Polis, kembali ke menu utama");
                        menuCostumer();
                    }

                }
                menuUtama();

            } else {
                System.out.println("Costumer belum memiliki polis");
                menuUtama();
            }

        } else {
            System.out.println("Nasabah yang anda input tidak tersedia");
            menuCostumer();
        }


    }
    public static void beliProduk() {
        Scanner inp = new Scanner(System.in);
        Scanner inp2 = new Scanner(System.in);
        String namaProduk = "";
        boolean check = false;
        if (listNasabah.isEmpty()) {
            System.out.println("Data Costumer Tidak Tersedia\n");
            menuCostumer();
        } else {
            for (Map.Entry nsb : listNasabah.entrySet()
            ) {
                Nasabah nasabah = (Nasabah) nsb.getValue();
                System.out.printf(
                        "No : %s, %s %s, %s, %s (%s), %s,\nNoKTP : %s,Status di KK : %s, Payment Method : %s " +
                                "\n=========================================================================%n",
                        nasabah.getNoNasabah(), nasabah.getNamaDpn(), nasabah.getNamaBlkng(),
                        nasabah.getJenisKelamin().getKelamin(), Helper.FormatTanggal(nasabah.getTglLahir(), "dd MMMM yyyy"), nasabah.getTempatLahir(),
                        nasabah.getPerkerjaan(), nasabah.getNoKtp(), nasabah.getStatusDiKK().getLabel(),
                        nasabah.getMetodePembayaran().getPembayaran()
                );
            }


            do {
                Nasabah nasabah;
                try {
                    System.out.println("Pilih No Kostumer ");
                    String noKostumer = inp.next();
                    if (listNasabah.containsKey(noKostumer)) {
                        nasabah = listNasabah.get(noKostumer);
                    } else {
                        System.out.println("Data Kostumer Tidak Tersedia, coba lagi");
                        continue;
                    }
                    if (!(nasabah.getHashValidateProduk().size() == listProduk.size())) {
                        System.out.println("Produk yang tersedia untuk " + noKostumer);
                        System.out.println("==========================================================");
                        nasabah.printProdukSisa();
                        System.out.println("==========================================================");
                    } else {
                        System.out.println("Semua produk telah terbeli oleh " + noKostumer);
                    }
                    do {
                        System.out.println("Pilih Nama produk : ");
                        namaProduk = inp2.nextLine();
                        if (getProdukByNama(namaProduk) == nasabah.getHashValidateProduk().get(namaProduk)) {
                            System.out.println("Produk tidak tersedia atau Nasabah ini telah menerbitkan produk ini, silahkan coba lagi");
                        } else {
                            break;
                        }
                    } while (!(getProdukByNama(namaProduk) == nasabah.getHashValidateProduk().get(namaProduk)));


                    if (namaProduk.equals("Sehat bersama")) {
                        produk(getProdukByNama(namaProduk), nasabah);
                        check = true;
                    } else if (namaProduk.equals("Sehat Extra")) {
                        produk(getProdukByNama(namaProduk), nasabah);
                        check = true;
                    } else if (namaProduk.equals("Life Keluarga")) {
                        produk(getProdukByNama(namaProduk), nasabah);
                        check = true;
                    } else if (namaProduk.equals("Life Special")) {
                        produk(getProdukByNama(namaProduk), nasabah);
                        check = true;
                    } else if (namaProduk.equals("Protection")) {
                        produk(getProdukByNama(namaProduk), nasabah);
                        check = true;
                    } else if (namaProduk.equals("Protection Plus")) {
                        produk(getProdukByNama(namaProduk), nasabah);
                        check = true;
                    } else {
                        System.out.println("Maaf produk Yang anda inputkan tidak tersedia");
                        continue;
                    }

                } catch (Exception exception) {
                    System.out.println("Terjadi Kesalahan Mohon inputkan ulang");
                    continue;
                }
            } while (!check);
            System.out.println("Sukses, Polis sudah diterbitkan");
            menuUtama();
        }

    }
    public static void showNasabahAll() {


        System.out.println("=========================================================================");
        if (listNasabah.isEmpty()) {
            System.out.println("Data Nasabah Tidak Tersedia\n");

        } else {

            for (Map.Entry nsb : listNasabah.entrySet()
            ) {
                Nasabah nasabah = (Nasabah) nsb.getValue();
                System.out.printf(
                        "No : %s, %s %s, %s, %s (%s), %s,\nNoKTP : %s,Status di KK : %s, Payment Method : %s " +
                                "\n =========================================================================%n",
                        nasabah.getNoNasabah(), nasabah.getNamaDpn(), nasabah.getNamaBlkng(),
                        nasabah.getJenisKelamin().getKelamin(), Helper.FormatTanggal(nasabah.getTglLahir(), "dd MMMM yyyy"), nasabah.getTempatLahir(),
                        nasabah.getPerkerjaan(), nasabah.getNoKtp(), nasabah.getStatusDiKK().getLabel(),
                        nasabah.getMetodePembayaran().getPembayaran()
                );

            }
        }
    }

    public static void produk(Produk data, Nasabah nasabah) {
//        HashMap<String,Produk> temp = new HashMap<>();
        LocalDate today = LocalDate.now();
        Scanner inp = new Scanner(System.in);
        Kendaraan kendaraan;
        List<Iuran> listiuran = new LinkedList<>();
        String jenisKendaraan = "";

        Iuran biaya;
        long usia = ChronoUnit.YEARS.between(nasabah.getTglLahir(), today);
        if (data.getJenisProduk().getLabel().equals("Kendaraan")) {
            System.out.println("Input Data Kendaraan : ");
            boolean cek = false;
            do {

                System.out.println("Jenis Kendaraan : ");
                jenisKendaraan = inp.next();
//                jenisKendaraan.toLowerCase();
                if (!(jenisKendaraan.equals("Mobil") || jenisKendaraan.equals("Motor"))) {
                    System.out.println(" mohon Input (mobil / motor)");
                    continue;
                } else {
                    cek = true;
                }

            } while (!cek);

            System.out.println("Nomor Polisi : ");
            String nomorPolisi = inp.next();
            System.out.println("Nomor STNK : ");
            String noSTNK = inp.next();
            System.out.println("Merek Kendaraan : ");
            String merekKendaraan = inp.next();
            System.out.println("Model Kendaraan : ");
            String modelKendaraan = inp.next();
            System.out.println("Warna Kendaraan : ");
            String warnaKendaraan = inp.next();

            kendaraan = new Kendaraan(JenisKendaraan.getJenisKendaraan(jenisKendaraan), nomorPolisi, noSTNK, merekKendaraan, modelKendaraan, warnaKendaraan);

            if (data.getNamaProduk().equals("Protection")) {

                int angsuran = 3;
                int count = 1;
                while (angsuran > 0) {
                    if (count == 1) {
                        biaya = new Iuran(new BigDecimal(2000000), today);
                        count--;
                    } else {
                        biaya = new Iuran(new BigDecimal(2000000), today.plusYears(1));
                        today = today.plusYears(1);
                    }
                    listiuran.add(biaya);
                    angsuran--;
                }
            } else if (data.getNamaProduk().equals("Protection Plus")) {

                int angsuran = 3;
                int count = 1;
                while (angsuran > 0) {
                    if (count == 1) {
                        biaya = new Iuran(new BigDecimal(2500000), today);
                        count--;
                    } else {
                        biaya = new Iuran(new BigDecimal(2500000), today.plusYears(1));
                        today = today.plusYears(1);
                    }
                    listiuran.add(biaya);
                    angsuran--;
                }
            }

            nasabah.setListPolisNasabah(new Polis(nasabah, kendaraan, data, LocalDate.now(), listiuran));
            nasabah.setHashValidateProduk(data.getNamaProduk(), data);
        } else if (data.getTanggunganAsuransi().getLabel().equals("Keluarga")) {
            String noCostumerTertanggung = "";
            do {
                System.out.print("Pilih Costumer yang tertanggung : ");
                noCostumerTertanggung = inp.next();
                if (!(listNasabah.containsKey(noCostumerTertanggung))) {
                    System.out.println("Data costumer tidak tersedia");
                }
            } while (!listNasabah.containsKey(noCostumerTertanggung));

            if (data.getNamaProduk().equals("Sehat bersama")) {
                if (usia > 0 && usia < 20) {
                    int angsuran = 3;
                    int count = 1;
                    while (angsuran > 0) {
                        if (count == 1) {
                            biaya = new Iuran(new BigDecimal(200000), today);
                            count--;
                        } else {
                            biaya = new Iuran(new BigDecimal(200000), today.plusMonths(1));
                            today = today.plusMonths(1);
                        }
                        listiuran.add(biaya);
                        angsuran--;
                    }
                } else if (usia > 20) {
                    int angsuran = 3;
                    int count = 1;
                    while (angsuran > 0) {
                        if (count == 1) {
                            biaya = new Iuran(new BigDecimal(400000), today);
                            count--;
                        } else {
                            biaya = new Iuran(new BigDecimal(400000), today.plusMonths(1));
                            today = today.plusMonths(1);
                        }
                        listiuran.add(biaya);
                        angsuran--;
                    }
                }

            } else if (data.getNamaProduk().equals("Life Keluarga")) {
                if (usia > 0 && usia < 20) {
                    int angsuran = 3;
                    int count = 1;
                    while (angsuran > 0) {
                        if (count == 1) {
                            biaya = new Iuran(new BigDecimal(250000), today);
                            count--;
                        } else {
                            biaya = new Iuran(new BigDecimal(250000), today.plusMonths(1));
                            today = today.plusMonths(1);
                        }
                        listiuran.add(biaya);
                        angsuran--;
                    }
                } else if (usia > 20) {
                    int angsuran = 3;
                    int count = 1;
                    while (angsuran > 0) {
                        if (count == 1) {
                            biaya = new Iuran(new BigDecimal(450000), today);
                            count--;
                        } else {
                            biaya = new Iuran(new BigDecimal(450000), today.plusMonths(1));
                            today = today.plusMonths(1);
                        }
                        listiuran.add(biaya);
                        angsuran--;
                    }
                }

            }
            nasabah.setListPolisNasabah(new Polis(nasabah, data, getNasabah(noCostumerTertanggung), LocalDate.now(), data.getManfaat(), listiuran));
            nasabah.setHashValidateProduk(data.getNamaProduk(), data);
        } else {

            if (data.getNamaProduk().equals("Sehat Extra")) {

                if (usia > 0 && usia < 20) {
                    int angsuran = 3;
                    int count = 1;
                    while (angsuran > 0) {
                        if (count == 1) {
                            biaya = new Iuran(new BigDecimal(300000), today);
                            count--;
                        } else {
                            biaya = new Iuran(new BigDecimal(300000), today.plusMonths(1));
                            today = today.plusMonths(1);
                        }
                        listiuran.add(biaya);
                        angsuran--;
                    }
                } else if (usia > 20) {
                    int angsuran = 3;
                    int count = 1;
                    while (angsuran > 0) {
                        if (count == 1) {
                            biaya = new Iuran(new BigDecimal(400000), today);
                            count--;
                        } else {
                            biaya = new Iuran(new BigDecimal(400000), today.plusMonths(1));
                            today = today.plusMonths(1);
                        }
                        listiuran.add(biaya);
                        angsuran--;
                    }
                }

            } else if (data.getNamaProduk().equals("Life Special")) {

                if (usia > 0 && usia < 20) {
                    int angsuran = 3;
                    int count = 1;
                    while (angsuran > 0) {
                        if (count == 1) {
                            biaya = new Iuran(new BigDecimal(3600000), today);
                            count--;
                        } else {
                            biaya = new Iuran(new BigDecimal(3600000), today.plusMonths(1));
                            today = today.plusMonths(1);
                        }
                        listiuran.add(biaya);
                        angsuran--;
                    }
                } else if (usia > 20) {
                    int angsuran = 3;
                    int count = 1;
                    while (angsuran > 0) {
                        if (count == 1) {
                            biaya = new Iuran(new BigDecimal(4800000), today);
                            count--;
                        } else {
                            biaya = new Iuran(new BigDecimal(4800000), today.plusYears(1));
                            today = today.plusYears(1);
                        }
                        listiuran.add(biaya);
                        angsuran--;
                    }
                }

            }
            nasabah.setListPolisNasabah(new Polis(nasabah, data, nasabah, LocalDate.now(), data.getManfaat(), listiuran));
            nasabah.setHashValidateProduk(data.getNamaProduk(), data);

        }
    }

    public static void setProduk() {
        Produk sb = new Produk("Sehat bersama", JenisProduk.KESEHATAN,
                FrekuensiPembayaran.BULANAN, "Claim perawatan kelas 1.", TanggunganAsuransi.KELUARGA);
        Produk se = new Produk("Sehat Extra", JenisProduk.KESEHATAN,
                FrekuensiPembayaran.BULANAN, "Claim perawatan kelas VIP.", TanggunganAsuransi.SENDIRI);

        Produk lk = new Produk("Life Keluarga", JenisProduk.JIWA,
                FrekuensiPembayaran.BULANAN, "Mendapatkan 500.000.000 apabila terjadi sesuatu pada tertanggung.", TanggunganAsuransi.KELUARGA);

        Produk ls = new Produk("Life Special", JenisProduk.JIWA,
                FrekuensiPembayaran.TAHUNAN, "Mendapatkan 800.000.000 apabila terjadi sesuatu pada tertanggung.", TanggunganAsuransi.SENDIRI);

        Produk pt = new Produk("Protection", JenisProduk.KENDARAAN,
                FrekuensiPembayaran.TAHUNAN, "Mendapat ganti rugi sampai 100.000.000 bila terjadi sesuatu.", TanggunganAsuransi.SENDIRI);
        Produk pp = new Produk("Protection Plus", JenisProduk.KENDARAAN,
                FrekuensiPembayaran.TAHUNAN, "Mendapat ganti rugi total lost apa bila terjadi sesuatu.", TanggunganAsuransi.SENDIRI);
        listProduk.add(sb);
        listProduk.add(se);
        listProduk.add(lk);
        listProduk.add(ls);
        listProduk.add(pt);
        listProduk.add(pp);
    }
    public static Produk getProdukByNama(String nama) {
        for (Produk prd : listProduk
        ) {
            if (prd.getNamaProduk().equals(nama)) {
                return prd;
            }
        }
        return null;
    }

    /*Membuat Data*/ /*Prospect*/ /*Nasabah*/
    public static void convertProspectToNasabah() {
        Scanner input = new Scanner(System.in);
        String pilih = "";
        String noKtp = "";
        String statusKK = "";
        String paymentMethod = "";
        boolean check = false;
        do {
            try {
                System.out.print("Ketik nomor prospect yang ingin dijadikan nasabah : ");
                pilih = input.next();
                Prospect prospect = listProspect.get(Integer.parseInt(pilih));
                if (prospect.getStatus() == Status.NASABAH) {
                    System.out.println("Maaf nomor ini sudah menjadi nasabah");
                    continue;
                }

                if (listProspect.containsKey(Integer.parseInt(pilih))) {
                    boolean validateInput = false;
                    do {
                        try {
                            System.out.print("Nomor KTP : ");
                            noKtp = input.next();
                            if (validateNoKTP(noKtp)) {
                                System.out.println("Nomor KTP telah Terdaftar, silahkan input lagi ");
                                validateInput = false;
                                continue;

                            } else {
                                boolean cek = false;
                                do {
                                    System.out.print("Status KK : ");
                                    statusKK = input.next();
                                    statusKK.toLowerCase();
                                    if (!(statusKK.equals("ayah") || statusKK.equals("anak") || statusKK.equals("ibu"))) {
                                        System.out.println("Harus inputkan ayah/anak/ibu");
                                        cek = false;
                                        continue;
                                    } else {
                                        cek = true;
                                    }

                                } while (!cek);

                                do {
                                    System.out.print("Payment Method (CC/AC/VP) : ");
                                    paymentMethod = input.next();
                                    paymentMethod.toUpperCase();
                                    if (!(paymentMethod.equals("CC") || paymentMethod.equals("AC") || paymentMethod.equals("VP"))) {
                                        System.out.println("Harus inputkan (CC/AC/VP)");
                                        cek = false;
                                        continue;
                                    } else {
                                        cek = true;
                                        validateInput = true;
                                    }

                                } while (!cek);


                            }

                        } catch (Exception exception) {
                            System.out.println("Masukan Data yang sesuai");
                            validateInput = false;
                        }
                    } while (!validateInput);
                    prospect.setStatus(Status.NASABAH);
                    listNasabah.put(Helper.generateNewNoNasabah(Integer.parseInt(pilih)), new Nasabah(Integer.parseInt(pilih), Helper.generateNewNoNasabah(Integer.parseInt(pilih)), prospect.getNamaDpn(),
                            prospect.getNamaBlkng(), noKtp, prospect.getTglLahir(), prospect.getTempatLahir(), prospect.getJenisKelamin(),
                            prospect.getPerkerjaan(), StatusKK.getKK(statusKK), MetodePembayaran.metodePembayaran(paymentMethod)));
                    check = true;
                } else {
                    System.out.println("Nomor Prospect Tidak tersedia");
                    check = false;
                }
            } catch (Exception exception) {
                System.out.println("Inputkan angka");
                check = false;
            }
        } while (!check);
        System.out.println("Prospect : " + pilih + " Berhasil dikonversi ke nasabah dengan nomor nasabah : " + Helper.generateNewNoNasabah(Integer.parseInt(pilih)));
        menuUtama();
    }
    public static void setProspect() {
        System.out.println("Masukan data anda :");
        Integer noProspect = listProspect.size() + 1;
        boolean cek = false;
        LocalDate tanggalParse = null;
        String Kelamin = "";
        Scanner addData = new Scanner(System.in);
        System.out.print(" Nama Depan : ");
        String namaDpn = addData.next();
        System.out.print(" Nama Belakang : ");
        String namaBlkng = addData.next();
        do {
            try {
                System.out.print(" Tanggal Lahir (dd/MM/yyyy) : ");
                String tglLahir = addData.next();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                tanggalParse = LocalDate.parse(tglLahir, formatter);
                cek = true;
            } catch (Exception exception) {
                System.out.println("Format tanggal tidak sesuai");
                cek = false;
            }
        }
        while (!cek);
        System.out.print(" Tempat Lahir : ");
        String tmptLahir = addData.next();
        cek = false;
        do {
            System.out.print(" Jenis Kelamin (P/L) : ");
            Kelamin = addData.next();
            Kelamin.toUpperCase();
            if (!(Kelamin.equals("L") || Kelamin.equals("P"))) {
                System.out.println("Hanya bisa input p/l");
                continue;
            } else {
                cek = true;
            }
        } while (!cek);

        System.out.print(" Perkerjaan : ");
        String perkerjaan = addData.next();


        listProspect.put(listProspect.size() + 1, new Prospect(noProspect, namaDpn, namaBlkng,
                tanggalParse, tmptLahir, Kelamin.equals("L") ? JenisKelamin.LAKI_LAKI : JenisKelamin.PEREMPUAN,
                perkerjaan, Status.PROSPECT));
        menuUtama();
    }
    public static void showProspectAll() {

        if (listProspect.isEmpty()) {
            System.out.println("Data belum ada\n");
        } else {

            for (Map.Entry prs : listProspect.entrySet()
            ) {
                Prospect prospect = (Prospect) prs.getValue();
                System.out.printf(
                        "No : %d, %s %s, %s, %s(%s), %s, %s %n",
                        prospect.getNoProspect(), prospect.getNamaDpn(), prospect.getNamaBlkng(),
                        prospect.getJenisKelamin(), Helper.FormatTanggal(prospect.getTglLahir(), "dd MMMM yyyy"), prospect.getTempatLahir(),
                        prospect.getPerkerjaan(), prospect.getStatus()
                );

            }
        }
    }

    /*Validate*/
    public static boolean validateNoKTP(String noKtp) {
        for (Map.Entry ktp : listNasabah.entrySet()
        ) {
            Nasabah nasabah = (Nasabah) ktp.getValue();
            if (nasabah.getNoKtp().equals(noKtp)) {
                return true;
            }

        }
        return false;
    }
    public static Nasabah getNasabah(String nasabah) {
        Nasabah nas = new Nasabah();
        for (Map.Entry nsb : listNasabah.entrySet()
        ) {
            Nasabah nasabah1 = (Nasabah) nsb.getValue();
            if (nasabah1.getNoNasabah().equals(nasabah)) {
                return nasabah1;
            }

        }
        return nas;
    }


    /*Data Dummy*/
    public static void setDataProspect() {

        listProspect.put(1, new Prospect(1, "tralala", "sana", LocalDate.of(1998, 2, 12),
                "Mataram", JenisKelamin.LAKI_LAKI, "makan", Status.PROSPECT));
        listProspect.put(2, new Prospect(2, "asd", "dea", LocalDate.of(1998, 2, 12),
                "Mataram", JenisKelamin.LAKI_LAKI, "makan", Status.PROSPECT));
        listProspect.put(3, new Prospect(3, "iwan", "fas", LocalDate.of(1998, 2, 12),
                "Mataram", JenisKelamin.LAKI_LAKI, "makan", Status.PROSPECT));
    }
    public static String getNamaPerusahaan() {
        return namaPerusahaan;
    }
    public static void setNamaPerusahaan(String namaPerusahaan) {
        Asuransi.namaPerusahaan = namaPerusahaan;
    }
    public static List<Produk> getListProduk() {
        return Asuransi.listProduk;
    }


}
