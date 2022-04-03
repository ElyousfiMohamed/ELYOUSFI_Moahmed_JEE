package userSimulation;

import annotations.Injector2;
import structure.*;
import userSimulation.metier.IMetier;


public class presentation {
    public static void main(String[] args) throws Exception {
        Injector2 context = new Injector2("userSimulation");
        IMetier metier= (IMetier) context.getObject();
        System.out.println(metier.calcul());




        /* Injector context = new Injector("objs.xml");
        IMetier metier= (IMetier) context.getObject();
        System.out.println(metier.calcul()); */
    }
}

