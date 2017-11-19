package com.drools.wypozyczalnia;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Klient {
    private static SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");

    private boolean klientLojalnosciowy;
    private KlasaSamochodu preferencjaSamochodu;

    private KlasaSamochodu faktyczneAuto;

    private Date wynajemOd, wynajemDo, dataZwrotu;
    private int iloscDodatkow;
    private Long iloscDni;
    private int iloscPrzejechanychKm;
    private int iloscZbugionychKolpakow;
    private boolean isKlientLojalnosciowy, zgubionyDowod;
    private boolean czyWynajal;
    private boolean czyZwraca;
    private double cenaWypozyczenie;
    private double cenaOddania;
    private int id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Klient klient = (Klient) o;

        return id == klient.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    private Stan stan;

    public Stan getStan() {
        return stan;
    }

    public void setStan(Stan stan) {
        this.stan = stan;
    }

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


    /**
     * @param isKlientLojalnosciowy   boolean
     * @param pref                    KlasaSamochodu
     * @param dataOd                  Date "dd/mm/yyyy"
     * @param dataDo                  Date "dd/mm/yyyy"
     * @param dodatki                 String[]
     * @param dataZwrotu              Date "dd/mm/yyyy"
     * @param iloscPrzejechanychKm    int
     * @param iloscZgubionychKolpakow int
     * @param zgubionyDowod           boolean
     */
    public Klient(int id, boolean isKlientLojalnosciowy, KlasaSamochodu pref,
                  String dataOd, String dataDo, String[] dodatki,
                  String dataZwrotu, int iloscPrzejechanychKm,
                  int iloscZgubionychKolpakow, boolean zgubionyDowod) {
        this.id = id;
        this.stan = Stan.INICJALIZACJA;
        this.cenaWypozyczenie = 0;
        this.cenaOddania = 0;
        this.isKlientLojalnosciowy = isKlientLojalnosciowy;
        this.preferencjaSamochodu = pref;
        this.faktyczneAuto = preferencjaSamochodu;
        this.wynajemOd = parseStringToDate(dataOd);
        this.wynajemDo = parseStringToDate(dataDo);
        this.dataZwrotu = parseStringToDate(dataZwrotu);
        this.iloscDodatkow = dodatki.length;
        this.iloscDni = iloscDni(wynajemOd, this.dataZwrotu);
        this.iloscPrzejechanychKm = iloscPrzejechanychKm;
        this.iloscZbugionychKolpakow = iloscZgubionychKolpakow;
        this.zgubionyDowod = zgubionyDowod;
        czyWynajal = false;
    }

    public boolean czyZwraca() {
        return czyZwraca;
    }

    public void setCzyZwraca(boolean czyZwraca) {
        this.czyZwraca = czyZwraca;
    }

    public KlasaSamochodu getFaktyczneAuto() {
        return faktyczneAuto;
    }

    public void setFaktyczneAuto(KlasaSamochodu faktyczneAuto) {
        this.faktyczneAuto = faktyczneAuto;
    }

    public double getCenaWypozyczenie() {
        return cenaWypozyczenie;
    }

    public void setCenaWypozyczenie(double cenaWypozyczenie) {
        this.cenaWypozyczenie = cenaWypozyczenie;
    }

    public void dodajDoCeny(double val) {
        this.cenaWypozyczenie += val;
    }

    public void dodajDoCenyOddania(double val) {
//        System.err.println("v:"+val);
        this.cenaOddania += val;
    }


    private Long iloscDni(Date dataOd, Date dataDo) {
//        System.out.println("d1:"+dataOd+",d2"+dataDo);
        long diff = dataDo.getTime() - dataOd.getTime();
//        System.out.println("diff: "+diff+", Time: "+TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) + 1);
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) + 1;
    }

    public int getIloscDodatkowychDni() {
        long diff = dataZwrotu.getTime() - wynajemDo.getTime();
        return (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public boolean czyWynajal() {
        return czyWynajal;
    }

    public void setCzyWynajal(boolean czyWynajal) {
        this.czyWynajal = czyWynajal;
    }

    public KlasaSamochodu getPreferencjaSamochodu() {
        return preferencjaSamochodu;
    }

    public void setPreferencjaSamochodu(KlasaSamochodu preferencjaSamochodu) {
        this.preferencjaSamochodu = preferencjaSamochodu;
    }

    public Date getWynajemOd() {
        return wynajemOd;
    }

    public void setWynajemOd(Date wynajemOd) {
        this.wynajemOd = wynajemOd;
    }

    public Date getWynajemDo() {
        return wynajemDo;
    }

    public void setWynajemDo(Date wynajemDo) {
        this.wynajemDo = wynajemDo;
    }

    public Date getDataZwrotu() {
        return dataZwrotu;
    }

    public void setDataZwrotu(Date dataZwrotu) {
        this.dataZwrotu = dataZwrotu;
    }

    public int getIloscDodatkow() {
        return iloscDodatkow;
    }

    public void setIloscDodatkow(int iloscDodatkow) {
        this.iloscDodatkow = iloscDodatkow;
    }

    public int getIloscDni() {
        return Math.toIntExact(iloscDni);
    }

    public void setIloscDni(Long iloscDni) {
        this.iloscDni = iloscDni;
    }

    public int getIloscPrzejechanychKm() {
        return iloscPrzejechanychKm;
    }

    public void setIloscPrzejechanychKm(int iloscPrzejechanychKm) {
        this.iloscPrzejechanychKm = iloscPrzejechanychKm;
    }

    public int getIloscZbugionychKolpakow() {
        return iloscZbugionychKolpakow;
    }

    public void setIloscZbugionychKolpakow(int iloscZbugionychKolpakow) {
        this.iloscZbugionychKolpakow = iloscZbugionychKolpakow;
    }

    public boolean isKlientLojalnosciowy() {
        return isKlientLojalnosciowy;
    }

    public void setKlientLojalnosciowy(boolean klientLojalnosciowy) {
        isKlientLojalnosciowy = klientLojalnosciowy;
    }

    public boolean isZgubionyDowod() {
        return zgubionyDowod;
    }

    public void setZgubionyDowod(boolean zgubionyDowod) {
        this.zgubionyDowod = zgubionyDowod;
    }

    public double getCenaOddania() {
        return cenaOddania;
    }

    public void reset() {
        this.stan = Stan.INICJALIZACJA;
        this.cenaWypozyczenie = 0;
        this.cenaOddania = 0;
    }

    public void set(int id, boolean isKlientLojalnosciowy, KlasaSamochodu pref,
                    String dataOd, String dataDo, String[] dodatki,
                    String dataZwrotu, int iloscPrzejechanychKm,
                    int iloscZgubionychKolpakow, boolean zgubionyDowod) {
        this.id = id;
        this.stan = Stan.INICJALIZACJA;
        this.cenaWypozyczenie = 0;
        this.cenaOddania = 0;
        this.isKlientLojalnosciowy = isKlientLojalnosciowy;
        this.preferencjaSamochodu = pref;
        this.faktyczneAuto = preferencjaSamochodu;
        this.wynajemOd = parseStringToDate(dataOd);
        this.wynajemDo = parseStringToDate(dataDo);
        this.dataZwrotu = parseStringToDate(dataZwrotu);
        this.iloscDodatkow = dodatki.length;
        this.iloscDni = iloscDni(wynajemOd, this.dataZwrotu);
        this.iloscPrzejechanychKm = iloscPrzejechanychKm;
        this.iloscZbugionychKolpakow = iloscZgubionychKolpakow;
        this.zgubionyDowod = zgubionyDowod;
        czyWynajal = false;
    }

    public int getId() {
        return id;
    }
}
