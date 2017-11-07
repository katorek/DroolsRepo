package com.drools.wypozyczalnia;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Klient {
    private static SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");

    private boolean klientLojalnosciowy;
    private KlasaSamochodu preferencjaSamochodu;
    private Date wynajemOd, wynajemDo;
    private Integer iloscDodatkow;
//    private

    private Date parseStringToDate(String string) {
        Date date = null;
        try {
            date = myFormat.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public Klient(boolean lojal, KlasaSamochodu pref, String dataOd, String dataDo, String[] dodatki) {
        iloscDodatkow = dodatki.length;
        wynajemOd = parseStringToDate(dataOd);
        wynajemDo = parseStringToDate(dataDo);
        long diff = wynajemDo.getTime() - wynajemOd.getTime();
        long iloscDni = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) + 1;
        System.out.println("Days: " + iloscDni);
    }
}
