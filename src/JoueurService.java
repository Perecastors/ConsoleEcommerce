import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Formation on 06/10/2016.
 */
public class JoueurService {

    public static ArrayList<Joueur> listJoueur = new ArrayList<Joueur>();

    public static void initializeListJoueur(){
        ArrayList<Skin> als = new ArrayList<Skin>();
        Skin s = new Skin();
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 2; i++) {
                s = SkinService.createSkin("nom"+i,100,"description commande "+j);
                als.add(s);
            }
            listJoueur.add(creerJoueurAvecSkins("nom"+j,"prenom"+j,"pseudo"+j, als));
        }
    }

    private static Joueur creerJoueurAvecSkins(String nom,String prenom,String pseudo,ArrayList<Skin> als) {
        Joueur j = new Joueur();
        j.nom = nom;
        j.prenom = prenom;
        j.pseudo = pseudo;
        j.CollectionSkin = als;

        return j;
    }

    public static Joueur creeJoueur(String nom,String prenom,String pseudo){
        Joueur j = new Joueur();
        j.nom = nom;
        j.prenom = prenom;
        j.pseudo = pseudo;
        j.CollectionSkin = new ArrayList<Skin>();

        return j;
    }


    public static void afficherCreationJoueur() {
        System.out.println("==================");
        System.out.println("Creation de joueur");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nom du joueur : ");
        String nom=scanner.nextLine();
        System.out.print("prenom du joueur : ");
        String prenom=scanner.nextLine();
        String pseudo;
        boolean pseudoValide=false;
        do {
            System.out.print("pseudo du joueur : ");
            pseudo = scanner.nextLine();
            if(pseudo.isEmpty())
            {
                System.out.println("Vous n'avez pas entré de pseudo:veuillez recommencer");
            }
        }while (pseudoValide);

        if(listJoueur.add(JoueurService.creeJoueur(nom,prenom,pseudo)))
        {
            System.out.println("Félicitations, le joueur :"+nom +" vient d'être ajouter dans la base");
        }
        else{
            System.out.println("Erreur ajout de joueur");
        };
    }

    public static void afficherListeJoueur() {
        System.out.println("Voici la liste des joueur : ");
        System.out.println("    Prenom nom      |  pseudo   | nombre de skins ");
        for (Joueur joueur : listJoueur) {
            System.out.println(String.format("%20s",joueur.prenom +" " + joueur.nom) + "|" + String.format("%10s",joueur.pseudo)+" | " + joueur.CollectionSkin.size() + " skin(s)");
        }
    }
}
