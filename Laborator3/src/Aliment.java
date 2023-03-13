import java.util.Date;

public class Aliment
{
    private Double pret;
    private Date dataExp;
    private String ingrediente;
    private Double calorii;
    private Categorie categorie;

    public Aliment()
    {
        this.pret = 0D;
        this.dataExp = new Date();
        this.ingrediente = "";
        this.calorii = 0D;
        this.categorie = null;
    }

    public Aliment(Double pret, Date dataExp, String ingrediente, Double calorii, Categorie categorie)
    {
        this.pret = pret;
        this.dataExp = dataExp;
        this.ingrediente = ingrediente;
        this.calorii = calorii;
        this.categorie = categorie;
    }

    public Double getPret() {
        return pret;
    }

    public void setPret(Double pret) {
        this.pret = pret;
    }

    public Date getDataExp() {
        return dataExp;
    }

    public void setDataExp(Date dataExp) {
        this.dataExp = dataExp;
    }

    public String getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }

    public Double getCalorii() {
        return calorii;
    }

    public void setCalorii(Double calorii) {
        this.calorii = calorii;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
    public String afisare()
    {
        return getClass().getSimpleName() + "[calorii = " + calorii + "]";
    }
}
