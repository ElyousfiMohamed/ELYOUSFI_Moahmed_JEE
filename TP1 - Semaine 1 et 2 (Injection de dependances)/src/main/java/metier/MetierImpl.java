package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("metier")
public class MetierImpl implements IMetier{
    @Autowired
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
