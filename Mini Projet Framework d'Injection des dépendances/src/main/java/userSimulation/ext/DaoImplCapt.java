package userSimulation.ext;

import annotations.Component;
import userSimulation.dao.IDao;

@Component
public class DaoImplCapt implements IDao {
    @Override
    public double getData() {
        System.out.println("Version Capteurs");
        return Math.random()*95;
    }
}
