// CLASS DATE
// 
// Elena Holopainen
// Periytymisen alkeita - Luo ja tarkistaa paivamaaran
// 
// Kaytetty kurssilla ohjelmointi 3 ollutta esimerkkia paivamaaran
// oikeellisuuden tarkistamiseen.

import java.io.IOException;
// import.Round5.DateException;

public class Date {

    private int Day;
    private int Month;
    private int Year;
    static int[][] mDays = {{31, 31}, {28, 29}, {31, 31}, {30, 30}, {31, 31}, {30, 30},
                          {31, 31}, {31, 31}, {30, 30}, {31, 31}, {30, 30}, {31, 31}};
    
    // RAKENNIN
    Date(int year, int month, int day) 
            throws DateException {              
            this.Day = day;
            this.Month = month;
            this.Year = year;
            
            // System.out.println(toString());
            	     
            if (!isLegalDate(day, month, year)){
            
                // throw new DateException(String.format("Illegal date %d . %d . %d", day, month, year));
                throw new DateException(String.format("Illegal date %s", toString()));
            }
    }
    
    // Muuntaa merkkijonon oikeaan muotoon
    public String toString(){     
        String d = convertString(Day);
        String m = convertString(Month);
        String y = convertString(Year); 
        
        /*String d = Integer.toString(Day);
        String m = Integer.toString(Month);
        String y = Integer.toString(Year);        
        if (d.length() == 1){
            d = String.format("0%d", Day);}       
        if (m.length() == 1){
            m = String.format("0%d", Month);}*/
        
        String sDate = String.format("%s.%s.%s", d, m, y);               
        return sDate;
    }
    
    // KAKSIMERKKINEN NUMEROMUUNNOS (INT -> STR)
    public String convertString(int number){        
        String numericStr = Integer.toString(number);        
        if (numericStr.length() == 1){
            numericStr = String.format("0%s", numericStr);
            return numericStr; }
        else {
            return numericStr; }
    }
    
    // GETTERIT
    public int getDay() {
        return Day;
    }
    public int getMonth() {
        return Month;
    }
    public int getYear() {
        return Year;
    }
       
    // PAIVAMAARAN TARKISTUS  
    static boolean isLeapYear(int year) {
        return (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));
        }
    // Palauttaa tiedon, kuinka monta paivaa kuukaudessa month vuonna year on
    // Palautusarvo -1 vastaa virheellista kuukautta.
    static int monthDays(int month, int year) {        
        int days = -1;       
        if(1 <= month && month <= 12) {
            days = isLeapYear(year) ? mDays[month-1][1] : mDays[month-1][0];
        }
        return days;
    }
    // Funktio isLegalDate tutkii, onko parametrien day, month ja year kuvaama
    // paivamaara laillinen. Tassa vuosiluvun oletetaan olevan aina laillinen.
    static boolean isLegalDate(int day, int month, int year){
        return (1 <= day) && (day <= monthDays(month, year));
    }   
} 