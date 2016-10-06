import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by Formation on 06/10/2016.
 */
public class CommandeService {

    public static ArrayList<Commande> listCommande = new ArrayList<>();

    public static void initListCommandes(){
        ArrayList<Commande> alc = new ArrayList<>();
        ArrayList<Skin> als = new ArrayList<>();
            Skin s = new Skin();
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 2; i++) {
                 s = SkinService.createSkin("nom"+i,100,"description commande "+j);
                 als.add(s);
            }
            listCommande.add(creerCommandeAvecBasket(als));
        }
    }

    public static Commande creerCommande() {
        Commande c = new Commande();
        c.etatCommande = EtatCommande.EN_ATTENTE;
        c.idCommande = CommandeService.getIndexListCommande();
        c.dateCreationCommande = LocalDate.now();
        c.basket = new ArrayList<Skin>();
        return c;
    }

    public static Commande creerCommandeAvecBasket(ArrayList<Skin> listSkin) {
        Commande c = new Commande();
        c.etatCommande = EtatCommande.EN_ATTENTE;
        c.idCommande = CommandeService.getIndexListCommande();
        c.dateCreationCommande = LocalDate.now();
        c.basket = listSkin;
        return c;
    }

    public static int getIndexListCommande(){
        if (listCommande == null){
            return 0;
        }
        return listCommande.size()+1;
    }

    public void afficherPanier(Commande commande) {
        System.out.println("Voici le contenu de ton panier : ");
        for (Skin skin : commande.basket) {
            System.out.println(skin.nom + "  " + skin.prix + "  ");
            commande.totalCommande = commande.totalCommande + skin.prix;
        }
    }
}
