package com.drools.wypozyczalnia;

public enum KlasaSamochodu {
    A("ekonomiczny", "A", 59.00, 69.00, 10.00, 10.00),
    B("kompakt", "B", 69.00, 79.00, 10.00, 10.00),
    D("duzy", "D", 79.00, 89.00, 10.00, 10.00),
    ERROR("ups", "", 0, 0, 0, 0),
    BRAK("", "", 0, 0, 0, 0);

    private String typ;
    private String skrot;
    private double powyzej3Dni;
    private double ponizej3Dni;
    private double fotelik;
    private double bagaznik;


    KlasaSamochodu(String typ, String skrot, double powyzej3Dni, double ponizej3Dni, double fotelik, double bagaznik) {
        this.typ = typ;
        this.skrot = skrot;
        this.powyzej3Dni = powyzej3Dni;
        this.ponizej3Dni = ponizej3Dni;
        this.fotelik = fotelik;
        this.bagaznik = bagaznik;
    }

    public static KlasaSamochodu wyzszaKlasa(KlasaSamochodu ks) {
        switch (ks) {
            case A:
                return B;
            case B:
                return D;
            case D:
                return ERROR;
        }
        return ERROR;
    }

    public String getTyp() {
        return typ;
    }

    public String getSkrot() {
        return skrot;
    }

    public double getPowyzej3Dni() {
        return powyzej3Dni;
    }

    public double getPonizej3Dni() {
        return ponizej3Dni;
    }

    public double getFotelik() {
        return fotelik;
    }

    public double getBagaznik() {
        return bagaznik;
    }

    @Override
    public String toString() {
        return skrot;
    }

    public double getCena(int iloscDni) {
        if (iloscDni > 3) {
//            System.out.println("Dni: "+iloscDni+" * "+powyzej3Dni+" = "+ iloscDni * powyzej3Dni);
            return iloscDni * powyzej3Dni;
        } else {
//            System.out.println("Dni: "+iloscDni+" * "+ponizej3Dni+" = "+ iloscDni * ponizej3Dni);
            return iloscDni * ponizej3Dni;
        }
    }
}
