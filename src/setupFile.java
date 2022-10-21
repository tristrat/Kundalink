import java.io.*;
import java.time.YearMonth;
import java.util.Calendar;




public class setupFile {
    Calendar cal = Calendar.getInstance();





    public void creationFichier(){
        File myFile = new File("C:\\Users\\kundalink");

        for (int a = 0;a<10;a++)
        {
            String nomFileAnne=String.valueOf(a+cal.get(Calendar.YEAR));
            File anne = new File("!c\\Users\\kundalink\\"+nomFileAnne);
            for (int m=1;m<13;m++){
                File mois = new File("!c\\Users\\kundalink\\"+nomFileAnne+"\\"+m);
                int nbjour= YearMonth.of(a,m).lengthOfMonth();
                for (int j=1;j<=nbjour;j++){
                    File jour = new File("!c\\Users\\kundalink\\"+nomFileAnne+"\\"+m+"\\"+j);
                }

            }

        }
    }




}
