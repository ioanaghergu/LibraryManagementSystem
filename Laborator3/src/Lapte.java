import java.util.Date;
public class Lapte extends Aliment
{
    public Lapte()
    {
        super();
        this.setCalorii(3.05);
    }

    public Lapte(Double pret, Date dataExp, String ingrediente, Double calorii, Categorie categorie)
    {
        super(pret, dataExp, ingrediente, calorii, categorie);
    }
}
