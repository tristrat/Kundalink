package calendrier;
import java.io.*;
import java.util.Calendar;
import java.lang.String;

public class Anne {
    Calendar cal = Calendar.getInstance();
    int numAnne;
    public Anne(int x){
        this.numAnne =x;
    }
    public Anne(){
        this.numAnne=cal.get(Calendar.YEAR);
    }





}
