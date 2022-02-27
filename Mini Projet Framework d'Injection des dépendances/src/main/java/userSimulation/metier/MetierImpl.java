package userSimulation.metier;

import userSimulation.dao.IDao;

public class MetierImpl implements IMetier{
    private IDao dao;

    /*public MetierImpl() {
    }

    public MetierImpl(IDao dao) {
        this.dao = dao;
    }*/

    @Override
    public double calcul() {
        return dao.getData()*5/Math.sin(15);
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
