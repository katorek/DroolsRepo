package com.drools.wypozyczalnia;

public class Samochod {
    private KlasaSamochodu klasaSamochodu;
    private Wypozyczenie wypozyczenie;
    private boolean zajety;
    private boolean inited;


    public Samochod(KlasaSamochodu klasaSamochodu) {
        zajety = false;
        inited = false;
        this.klasaSamochodu = klasaSamochodu;
    }

    public boolean isInited() {
        return inited;
    }

    public void setInited(boolean inited) {
        this.inited = inited;
    }

    public boolean isZajety() {
        return zajety;
    }

    public void setZajety(boolean zajety) {
        this.zajety = zajety;
    }

    public KlasaSamochodu getKlasaSamochodu() {
        return klasaSamochodu;
    }

    public void setKlasaSamochodu(KlasaSamochodu klasaSamochodu) {
        this.klasaSamochodu = klasaSamochodu;
    }


}
