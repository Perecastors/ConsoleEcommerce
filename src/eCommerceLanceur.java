import com.sun.org.apache.xml.internal.serializer.utils.SystemIDResolver;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Formation on 06/10/2016.
 */
public class eCommerceLanceur {

    public static void test(String[] args) {
    }

    public static void main(String[] args) {

        //Initialisation du site

        CommandeService.initListCommandes();
        CatalogueService.initializeCatalogue();
        JoueurService.initializeListJoueur();


        Scanner scan = new Scanner(System.in);
        //afficher message de bienvenue
        boolean continu=true;
        while(continu){
            System.out.println("==============================");
            System.out.println("Bienvenue sur eCommerce Skins");
            System.out.println("==============================");
            System.out.println("");
            System.out.println("Que voulez vous faire ? ");
            System.out.println("1-Creer Skin");
            System.out.println("2-Lister Skin");
            System.out.println("3-Creer Joueur");
            System.out.println("4-Lister Joueur");
            System.out.println("5-Ajouter Skin au panier");
            System.out.println("6-Voir détails d'un panier");
            System.out.println("0-Quitter l'application");
            System.out.print("Votre choix : ");
            int choix = Integer.parseInt(scan.nextLine());
            System.out.println("");
            //analyse du choix
            switch (choix){
                //creer Skin
                case 1:
                    CatalogueService.affichageCreationSkin();
                    break;
                //lister skin
                case 2:
                    CatalogueService.afficherCatalogue();
                    break;
                //Creer joueur
                case 3:
                    JoueurService.afficherCreationJoueur();
                    break;
                //lister joueur
                case 4:
                    JoueurService.afficherListeJoueur();
                    break;
                //ajouter skin au panier
                case 5:
                    break;
                //voir detail d'un panier
                case 6:
                    break;
                //Quittez l'appli
                case 0:
                    continu=false;
                    break;


            }
        }
}
}
