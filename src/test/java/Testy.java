import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Testy {
    private static SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");

    private Date parseStringToDate(String string) {
        Date date = null;
        try {
            date = myFormat.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    @Test
    public void testDatyNachodza(){
        String s1 = "10/10/2000", e1= "15/10/2000";
        String s2 = "12/10/2000", e2= "16/10/2000";
        String s3 = "11/10/2000", e3= "14/10/2000";
        String s4 = "16/10/2000", e4= "18/10/2000";

        Date[] d1 = new Date[]{parseStringToDate(s1),parseStringToDate(e1)};
        Date[] d2 = new Date[]{parseStringToDate(s2),parseStringToDate(e2)};
        Date[] d3 = new Date[]{parseStringToDate(s3),parseStringToDate(e3)};
        Date[] d4 = new Date[]{parseStringToDate(s4),parseStringToDate(e4)};


//        assertEquals("Nachodza sie daty",true, Wypozyczenie.datySieNachodza(d1[0],d1[1],d2[0],d2[1]));
//
//        assertEquals("Nachodza sie daty",true, Wypozyczenie.datySieNachodza(d2[0],d2[1],d3[0],d3[1]));
//
//        assertEquals("Nie nachodza sie daty",false, Wypozyczenie.datySieNachodza(d3[0],d3[1],d4[0],d4[1]));
//
//        assertEquals("start 2 = koniec 1",true, Wypozyczenie.datySieNachodza(d2[0],d2[1],d4[0],d4[1]));

    }

//    @Test
//    public void klientTest(){
//        Klient k = new Klient(false, KlasaSamochodu.BRAK,
//                "11/11/2015","12/11/2015",new String[]{"fotelik","bagaznik"},
//                "12/11/2015",0,
//                0,false);
//        assertEquals("0", 0,k.getIloscDodatkowychDni());
//
//        k = new Klient(false, KlasaSamochodu.BRAK,
//                "11/11/2015","12/11/2015",new String[]{"fotelik","bagaznik"},
//                "14/11/2015",0,
//                0,false);
//        assertEquals("2", 2,k.getIloscDodatkowychDni());
//    }
}
