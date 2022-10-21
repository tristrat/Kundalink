package calendrier;

public class jour extends semaine{
    int jour;
    public jour(int anne, String mois, int semaine,int j ){
        super(anne,mois,semaine);
        this.jour=j;
    }

}
