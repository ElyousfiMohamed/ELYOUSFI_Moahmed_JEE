package userSimulation.metier;

import annotations.Autowired;
import userSimulation.dao.IDao;

public class MetierImpl implements IMetier{

    @Autowired
    public IDao dao;

    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    public MetierImpl() {
    }

    @Override
    public double calcul() {
        return dao.getData()*5/Math.sin(15);
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
