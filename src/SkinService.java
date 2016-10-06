/**
 * Created by Formation on 06/10/2016.
 */
public class SkinService {

    public static Skin createSkin(String nom,float prix,String description)
    {
        Skin s = new Skin();
        s.nom = nom;
        s.description = description;
        s.idSkin= CatalogueService.getNextIndexCatalogueSkin();
        s.prix=prix;
        return s;
    }
}
