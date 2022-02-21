package ext;

import dao.IDao;
import org.springframework.stereotype.Component;
@Component("ext")
public class DaoImplCapt implements IDao {
    @Override
    public double getData() {
        System.out.println("Version Capteurs");
        return Math.random()*95;
    }
}
