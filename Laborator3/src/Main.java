import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        Date today = new Date();
        List<Aliment> alimente = new ArrayList<>();

        Aliment a1 = new Aliment(15.4, today, "ingredient1 ingredient2", 4.56, Categorie.Lactate);
        Carne a2 = new Carne();
        Carne a3 = new Carne(12.5, today, "ingredient1 ingredient2 ingredient3", 7.89, Categorie.Mezeluri);
        Lapte a4 = new Lapte();
        Lapte a5 = new Lapte(13.0, today, "ingredient1", 3.07, Categorie.Lactate);
        Cereale a6 = new Cereale();
        Cereale a7 = new Cereale(18.5, today, "ingredient1 ingredient2 ingredient3", 6.78, Categorie.Paine);

        alimente.add(a1);
        alimente.add(a2);
        alimente.add(a3);
        alimente.add(a4);
        alimente.add(a5);
        alimente.add(a6);
        alimente.add(a7);

        alimente.stream().sorted((p1, p2) -> p1.getCalorii().compareTo(p2.getCalorii())).forEach( p -> System.out.println(p.afisare()));



    }
}