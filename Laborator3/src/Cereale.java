import java.util.Date;
public class Cereale extends Aliment
{
    public Cereale()
    {
        super();
        this.setCalorii(2.56);
    }

    public Cereale(Double pret, Date dataExp, String ingrediente,Double calorii, Categorie categorie)
    {
        super(pret, dataExp, ingrediente, calorii, categorie);
    }
}
