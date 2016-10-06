import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Formation on 06/10/2016.
 */
public class CatalogueService {

    public static ArrayList<Skin> catalogueSkin = new ArrayList<Skin>() {};

    public static void initializeCatalogue()
    {
        catalogueSkin.add(SkinService.createSkin("Ahri popstar", 10, "la plus belle des ahri"));
        catalogueSkin.add(SkinService.createSkin("Brand zombie", 5, "Bienvenue a Zombieland"));
        catalogueSkin.add(SkinService.createSkin("Corki Arcade", 12, "ma machine de guerre et moi , on est TopGun"));
        catalogueSkin.add(SkinService.createSkin("Dr Mundo Trader", 7, "MUUUNNNNDOOO !!!!"));
        catalogueSkin.add(SkinService.createSkin("Ekkolier", 20, "ce qui compte c'est pas d'avoir beaucoup de temps, c'est de savoir s'en servir"));
        catalogueSkin.add(SkinService.createSkin("Fizz de la toundra", 13, "A taaaaaable !"));
    }

    public static ArrayList<Skin> getCatalogueSkin()
    {
        if(catalogueSkin ==null){
            initializeCatalogue();
        }
        return catalogueSkin;
    }

    public static int getNextIndexCatalogueSkin(){
        if(catalogueSkin == null){
            return 0;
        }
        return catalogueSkin.size()+1;
    }

    public static void afficherCatalogue() {
        System.out.println("Voici le catalogue de la semaine : ");
        System.out.println("    Nom du skin     |  Prix   |       Description       ");
        for (Skin skin : catalogueSkin) {
            System.out.println(String.format("%20s",skin.nom) + "|" + String.format("%8s",skin.prix + "€")+" |" + skin.description);
        }
    }

    public static void affichageCreationSkin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---- Creation de skin ----");
        System.out.print("Nom du skin : ");
        String nom=scanner.nextLine();
        System.out.print("description du skin : ");
        String description=scanner.nextLine();
        System.out.print("prix du skin : ");
        boolean prixvalide=false;
        float prix=0;
        do {
            try {
                prix = Float.parseFloat(scanner.nextLine());
                prixvalide=true;
            } catch (Exception e) {
                System.out.println("saisie de prix incorrect");
                prixvalide=false;
            }
        }while (!prixvalide);

        if(catalogueSkin.add(SkinService.createSkin(nom,prix,description)))
        {
            System.out.println("Félicitations, le skin :"+nom +" vient d'être ajouter au catalogue");
        }
        else{
            System.out.println("Erreur ajout de skin");
        };
    }
}
