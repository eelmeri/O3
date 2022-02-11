// CLASS DATETIME
// 
// Elena Holopainen
// Periytymisen alkeita - Luo ja tarkistaa kellonajan
//

import java.io.IOException;
// import.Round5.DateException;


// Peritaan Date: lisataan peraan "extends Date"
public class DateTime extends Date {
    private int Second;
    private int Minute;
    private int Hour;
    private int Day;
    private int Month;
    private int Year;
    
    // static int[][] mDays = {{31, 31}, {28, 29}, {31, 31}, {30, 30}, {31, 31}, {30, 30},
    //                       {31, 31}, {31, 31}, {30, 30}, {31, 31}, {30, 30}, {31, 31}};
    
    // RAKENNIN
    // Rakennin tarkistaa, onko kellonaika laillinen (t 0-23, m ja s 0-59)
    // Jos laiton -> DateException viestilla: “Illegal time hour:minute:second”
    DateTime(int year, int month, int day, int hour, int minute, int second) 
            throws DateException {   
            
            // Alustetaan muuttujat
            super(year, month, day);  // Alustetaan ensin yliluokka Date
            this.Second = second;
            this.Minute = minute;
            this.Hour = hour;            
                               
            // APUTULOSTE (poista lopuksi)
            // System.out.println("Lisatty:");
            // System.out.println(toString());
            // System.out.printf("%d %d %d %d %d %d", day, month, year, hour, minute, second);
            // System.out.println();
            
            if (!isLegalTime(second, minute, hour)){       
                throw new DateException(String.format("Illegal time %s:%s:%s", 
                        convertString(hour), 
                        convertString(minute), 
                        convertString(hour)));
                // throw new DateException(String.format("Illegal time %s", toString()));
            }
    }
    
    // TO STRING: Palauttaa tulostukseen sopivan merkkijonon
    // Yliluokan funktiota saadaan kutsuttua: super.toString()
    public String toString(){      
        // Muunnetaan oikeanlaiseen str muotoon
        // Kaytetaan apufunktiota, joka lisaa tarvittaessa nollan tulosteeseen
        String sec = convertString(Second);
        String min = convertString(Minute);
        String h = convertString(Hour);
        String dStr = super.toString();   
        
        /*if (sec.length() == 1){
            sec = String.format("0%d", Second);}       
        if (min.length() == 1){
            min = String.format("0%d", Minute);}
        if (min.length() == 1){
            h = String.format("0%d", Hour);} */ 
        
        String sDateTime = String.format("%s %s:%s:%s", dStr, h, min, sec);               
        return sDateTime;  // "xx.xx.xxxx hour:minute:second"
    }

    // GETTERIT (ok)
    public int getHour() {
        return Hour;
    }
    public int getMinute() {
        return Minute;
    }
    public int getSecond() {
        return Second;
    }
    
    // KAKSIMERKKINEN NUMEROMUUNNOS (INT -> STR)
    public String convertString(int number){
        
        String numericStr = Integer.toString(number);
        
        if (numericStr.length() == 1){
            numericStr = String.format("0%s", numericStr);
            return numericStr;
        }
        else {
            return numericStr;
        }
    }
       
    // KELLONAJAN TARKISTUS
    // isLegalTime tutkii, onko sekuntien, minuuttien ja tuntien parametrit ok
    static boolean isLegalTime(int s, int m, int h){
        // Alarajojen tarkistus
        if ((s > 0) && (m > 0) && (h > 0)) {
            // Ylarajojen tarkistus
            if ((s < 60) && (m < 60) && (h < 24)){
                return true;
            }
        }
        return false;
    }
}