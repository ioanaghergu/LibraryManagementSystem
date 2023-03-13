import java.util.Date;
public class Carne extends Aliment
{
    public Carne()
    {
        super();
        this.setCalorii(1.05);
    }
    public Carne(Double pret, Date dataExp, String ingrediente, Double calorii, Categorie categorie)
    {
        super(pret, dataExp, ingrediente, calorii, categorie);
    }
}
