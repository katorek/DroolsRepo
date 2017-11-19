package com.drools.wypozyczalnia;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.drools.compiler.compiler.DroolsParserException;
import org.kie.api.KieServices;
import org.kie.api.logger.KieRuntimeLogger;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.io.IOException;

public class Main {
    public static KieSession kSession;
//    public static StatelessKieSession kSession;
    public static KieServices ks;
    public static KieContainer kContainer;
    public static KieRuntimeLogger kLogger;
    public static boolean initt = true;

    private static void init() {
        try {
            Logger.getLogger(Main.class).setLevel(Level.OFF);
            ks = KieServices.Factory.get();
            BasicConfigurator.configure();

            kContainer = ks.getKieClasspathContainer();
//            kSession = kContainer.newStatelessKieSession();
            kSession = kContainer.newKieSession("ksession-rules");
            kLogger = ks.getLoggers().newFileLogger(kSession, "log/test");
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

//    private static void insert(Klient k){
//        while(k.getStan()!= Stan.PODSUMOWANIE);
//        kSession.insert(k);
//    }

    private static void insert(Object o) {
//        kSession.execute(o);
        kSession.insert(o);
    }

    private static void fireAllRules() {
        kSession.fireAllRules();
    }

    private static void cleanUp() {
        kLogger.close();
    }

    public static void main(String[] args) throws DroolsParserException, IOException {
        init();
        Wypozyczalnia w = new Wypozyczalnia();

        Samochod s1 = new Samochod(KlasaSamochodu.A);
        Samochod s2 = new Samochod(KlasaSamochodu.A);
        Samochod s3 = new Samochod(KlasaSamochodu.B);
        Samochod s4 = new Samochod(KlasaSamochodu.D);
        Samochod s5 = new Samochod(KlasaSamochodu.D);

        insert(w);

        insert(s1);
        insert(s2);
        insert(s3);
        insert(s4);
        insert(s5);
        fireAllRules();

//        Wypozyczalnia w = new Wypozyczalnia();
//        insert(new Wypozyczalnia());
//
//        insert(new Samochod(KlasaSamochodu.A));
//        insert(new Samochod(KlasaSamochodu.A));
//        insert(new Samochod(KlasaSamochodu.B));
//        insert(new Samochod(KlasaSamochodu.D));
//        insert(new Samochod(KlasaSamochodu.D));

////        Klient 1
//        insert(new Klient(0, true, KlasaSamochodu.BRAK,
//                "11/11/2016", "12/11/2016", new String[]{"fotelik", "bagaznik"},
//                "12/11/2016", 66,
//                0, false));




//        Klient 2
        insert(new Klient(1,false,KlasaSamochodu.B,
                "10/11/2016","13/11/2016",new String[]{"bagaznik"},
                "13/11/2016",100,
                0,false));



        insert(new Klient(1,false,KlasaSamochodu.A,
                "11/11/2016","14/11/2016",new String[]{},
                "14/11/2016",0,
                0,false));




////        Klient 3
//        insert(new Klient(2,false,KlasaSamochodu.B,
//                "11/11/2016","16/11/2016",new String[]{"fotelik","bagaznik"},
//                "18/11/2016",1000,
//                2,true));

        fireAllRules();
        cleanUp();
    }
}
