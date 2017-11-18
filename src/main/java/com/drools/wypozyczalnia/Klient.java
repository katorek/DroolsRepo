package com.drools.wypozyczalnia;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Klient {
    private static SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");

    private boolean klientLojalnosciowy;
    private KlasaSamochodu preferencjaSamochodu;
    private Date wynajemOd, wynajemDo, dataZwrotu;
    private int iloscDodatkow;
    private Long iloscDni;
    private int iloscPrzejechanychKm;
    private int iloscZbugionychKolpakow;
    private boolean isKlientLojalnosciowy, zgubionyDowod;
    private boolean isInited;
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
     *
     * @param isKlientLojalnosciowy boolean
     * @param pref KlasaSamochodu
     * @param dataOd Date "dd/mm/yyyy"
     * @param dataDo Date "dd/mm/yyyy"
     * @param dodatki String[]
     * @param dataZwrotu Date "dd/mm/yyyy"
     * @param iloscPrzejechanychKm int
     * @param iloscZgubionychKolpakow int
     * @param zgubionyDowod boolean
     */
    public Klient(boolean isKlientLojalnosciowy, KlasaSamochodu pref,
                  String dataOd, String dataDo, String[] dodatki,
                  String dataZwrotu, int iloscPrzejechanychKm,
                  int iloscZgubionychKolpakow, boolean zgubionyDowod) {
        this.isKlientLojalnosciowy = isKlientLojalnosciowy;
        this.preferencjaSamochodu = pref;
        this.wynajemOd = parseStringToDate(dataOd);
        this.wynajemDo = parseStringToDate(dataDo);
        this.dataZwrotu = parseStringToDate(dataZwrotu);
        this.iloscDodatkow = dodatki.length;
        this.iloscDni = iloscDni(this.dataZwrotu, wynajemOd);
        this.iloscPrzejechanychKm = iloscPrzejechanychKm;
        this.iloscZbugionychKolpakow = iloscZgubionychKolpakow;
        this.zgubionyDowod = zgubionyDowod;
        isInited = false;
    }

    private Long iloscDni(Date dataOd, Date dataDo) {
        long diff = dataDo.getTime() - dataOd.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) + 1;
    }

    public boolean isInited() {
        return isInited;
    }

    public void setInited(boolean inited) {
        isInited = inited;
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
}
