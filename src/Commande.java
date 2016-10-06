import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by Formation on 05/10/2016.
 */

public class Commande {

    public int idCommande;
    public LocalDate dateCreationCommande;
    public LocalDate dateValidationCommande;
    public EtatCommande etatCommande;
    public float totalCommande;
    public ArrayList<Skin> basket;


}
