package userSimulation.ext;

import userSimulation.dao.IDao;

public class DaoImplCapt implements IDao {
    @Override
    public double getData() {
        System.out.println("Version Capteurs");
        return Math.random()*95;
    }
}
