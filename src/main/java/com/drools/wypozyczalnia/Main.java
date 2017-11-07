package com.drools.wypozyczalnia;

import com.drools.example.HelloWorldTest;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.drools.compiler.compiler.DroolsParserException;
import org.kie.api.KieServices;
import org.kie.api.logger.KieRuntimeLogger;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.io.IOException;
import java.util.Arrays;

public class Main {
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
//        Samochod[] samochody = new Samochod[]{
//                new Samochod(KlasaSamochodu.A),
//                new Samochod(KlasaSamochodu.A),
//                new Samochod(KlasaSamochodu.B),
//                new Samochod(KlasaSamochodu.D),
//                new Samochod(KlasaSamochodu.D)
//        };
//        Arrays.stream(samochody).forEach(e -> insert(e));

        fireAllRules();
        fireAllRules();
        fireAllRules();
        fireAllRules();
        fireAllRules();
        cleanUp();
    }
}
