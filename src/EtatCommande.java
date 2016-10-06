/**
 * Created by Formation on 05/10/2016.
 */
public enum EtatCommande{
    EN_ATTENTE(0),
    ANNULE(5),
    PAYE(10),
    REMBOURSE(15);

    public final int val;

    EtatCommande(int val){
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public static EtatCommande getEnum(int value){
        for (EtatCommande etat : EtatCommande.values()) {
            if(etat.val == value)
            {
                return etat;
            }
        }
        return null;
    }
}