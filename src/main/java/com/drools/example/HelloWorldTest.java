package com.drools.example;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.drools.compiler.compiler.DroolsParserException;
import org.kie.api.KieServices;
import org.kie.api.logger.KieRuntimeLogger;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.io.IOException;

public class HelloWorldTest {
    static KieSession kSession;
    static KieServices ks;
    static KieContainer kContainer;
    static KieRuntimeLogger kLogger;
    public static boolean initt = true;

    private static void init(){
        try{
            Logger.getLogger(HelloWorldTest.class).setLevel(Level.OFF);
            ks = KieServices.Factory.get();
            BasicConfigurator.configure();

            kContainer = ks.getKieClasspathContainer();
            kSession = kContainer.newKieSession("ksession-rules");
            kLogger = ks.getLoggers().newFileLogger(kSession, "test");
        }catch(Throwable t){
            t.printStackTrace();
        }
    }

    private static void insert(Object o){ kSession.insert(o);
    }

    private static void fireAllRules(){ kSession.fireAllRules();
    }

    private static void cleanUp(){ kLogger.close();
    }



    public static void main(String[] args) throws DroolsParserException, IOException {
        init();
        fireAllRules();
        cleanUp();
    }

    public static enum Plec {NIEZNANA,MEZCZYZNA,KOBIETA};

    public static class Osoba {
        public String imie;
        public Plec plec;
        private Osoba matka,ojciec;

        public void setPlec(Plec plec){
            this.plec = plec;
        }

        public Osoba(String imie) {
            this.imie=imie;
            this.plec = Plec.NIEZNANA;
            //this.plec = (imie.charAt(imie.length()-1)=='a')?Plec.KOBIETA:Plec.MEZCZYZNA;
        }

        public String toString() {
            return imie;
        }

        public Plec getPlec(){
            return this.plec;
        }

    }

    public static class Relacja {

        public boolean o1Matka(){
            return osoby[0].getPlec() ==Plec.KOBIETA;
        }

        public Osoba[] osoby=new Osoba[2];
        public String relacja;

        public Relacja(Osoba o1, Osoba o2, String relacja) {
            this.osoby[0]=o1;
            this.osoby[1]=o2;
            this.relacja=relacja;

        }

        public Osoba o1(){
            return osoby[0];
        }

        public Osoba o2(){
            return osoby[1];
        }

    }

}
