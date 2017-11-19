package com.drools.wypozyczalnia;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Wypozyczalnia {
    public List<Wypozyczenie> wypozyczenia;

    public Wypozyczalnia() {
        wypozyczenia = new ArrayList<>(10);
    }

    public boolean canAutoBeBorrowed(Samochod s, Date s1, Date e1) {
        return wypozyczenia.stream().noneMatch(e -> Wypozyczenie.datySieNachodza(e, s1, e1, s, e.getSamochod()));
    }

    public void addWypozyczenie(Date dataOd, Date dataDo, Samochod samochod) {
        wypozyczenia.add(new Wypozyczenie(dataOd, dataDo, samochod));
    }

    public boolean isAutoBorrowedBetween(Samochod s, Date s1, Date e1) {
        return wypozyczenia.stream().anyMatch(e -> Wypozyczenie.datySieNachodza(e, s1, e1, s, e.getSamochod()));
    }

    public void addWypozyczenie(String s, String s1, Samochod sA1) {
        wypozyczenia.add(new Wypozyczenie(s, s1, sA1));
    }

    public boolean czyKlientJuzMaRezerwacjeNaDanyTermin(Klient k, Date s1, Date e1) {
        return wypozyczenia
                .stream()
                .anyMatch(e ->
                        Wypozyczenie.czyKlientJuzZarezerwowalWterminie(e, k, s1, e1));
    }

    public void addWypozyczenie(Klient k, Samochod s) {
        wypozyczenia.add(new Wypozyczenie(k, s));
    }

}
