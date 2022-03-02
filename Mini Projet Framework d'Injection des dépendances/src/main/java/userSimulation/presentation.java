package userSimulation;

import structure.*;
import userSimulation.metier.IMetier;


public class presentation {
    public static void main(String[] args) throws Exception {
        Injector context = new Injector("objects.xml");
        IMetier metier= (IMetier) context.getObject();
        System.out.println(metier.calcul());
    }
}

