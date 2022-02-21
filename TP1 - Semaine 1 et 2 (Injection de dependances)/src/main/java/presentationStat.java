import dao.DaoImpl;
import ext.DaoImplCapt;
import metier.MetierImpl;

public class presentationStat {
    public static void main(String[] args) {
        MetierImpl metier=new MetierImpl();
        metier.setDao(new DaoImpl());
        System.out.println(metier.calcul());

        System.out.println("**********************");

        MetierImpl metierCapt=new MetierImpl();
        metierCapt.setDao(new DaoImplCapt());
        System.out.println(metierCapt.calcul());
    }
}

