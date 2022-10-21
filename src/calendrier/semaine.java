package calendrier;

public class semaine extends Mois{
    int numSemaine;
    public semaine(int Anne , String mois ,int numSemaine){
        super(Anne,mois);
        this.numSemaine=numSemaine;
    }
}
