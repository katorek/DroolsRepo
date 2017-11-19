package com.drools.wypozyczalnia;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Wypozyczenie {
    private Date dataOd;
    private Date dataDo;
    private Samochod samochod;
    private Klient klient;

    private static SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");

    Wypozyczenie(Klient k, Samochod s) {
        this(k.getWynajemOd(), k.getWynajemDo(),s);
    }

    private static Date parseStringToDate(String string) {
        Date date = null;
        try {
            date = myFormat.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    Wypozyczenie(String s, String s1, Samochod sA1) {
        this(parseStringToDate(s), parseStringToDate(s1), sA1);
    }

//    private static boolean datySieNachodza(Date s1, Date e1, Date s2, Date e2, Samochod auto1, Samochod auto2) {
//        return auto1.equals(auto2) && datySieNachodza(s1, e1, s2, e2); // ten sam dzien -> nie nachodza sie
////        return (s1.before(e2) || s1.equals(e2)) && (s2.before(e1) || s2.equals(e1)); //ten sam dzien -> nachodza sie
//    }

    private static boolean datySieNachodza(Date s1, Date e1, Date s2, Date e2){
        return s1.before(e2) && s2.before(e1);
    }

    Wypozyczenie(Date dataOd, Date dataDo, Samochod samochod) {
        this.dataOd = dataOd;
        this.dataDo = dataDo;
        this.samochod = samochod;
    }

    Wypozyczenie(Date dataOd, Date dataDo, Samochod samochod, Klient klient){
        this(dataOd, dataDo, samochod);
        this.klient = klient;
    }

    Samochod getSamochod() {
        return samochod;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    public void setSamochod(Samochod samochod) {
        this.samochod = samochod;
    }

    public Date getDataOd() {
        return dataOd;
    }

    public void setDataOd(Date dataOd) {
        this.dataOd = dataOd;
    }

    public Date getDataDo() {
        return dataDo;
    }

    public void setDataDo(Date dataDo) {
        this.dataDo = dataDo;
    }

    static boolean datySieNachodza(Wypozyczenie e, Date s1, Date e1, Samochod auto1, Samochod auto2) {
        return auto1.equals(auto2) && datySieNachodza(e.dataOd, e.dataDo, s1, e1);
    }

    static boolean czyKlientJuzZarezerwowalWterminie(Wypozyczenie w, Klient k, Date s1, Date s2){
        return w.getKlient().getId() == k.getId() && datySieNachodza(s1,s2,w.dataOd,w.dataDo);
    }
//    public static boolean datySieNachodza(Wypozyczenie e, Date s1, Date e1) {
//        return datySieNachodza(e.dataOd, e.dataDo, s1, e1);
//    }
}
