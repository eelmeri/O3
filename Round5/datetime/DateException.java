// POIKKEUSLUOKKA DATE EXCEPTION
// 
// Elena Holopainen
// Periytymisen alkeita - Luo ja tarkistaa kellonajan
//

// Tulostaan exception messagen
public class DateException extends Exception {
    public DateException(String msg) {
        super(msg);
    }
}