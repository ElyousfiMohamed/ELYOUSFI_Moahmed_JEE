package structure;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Injector {

    public Injector(String filename) throws Exception{
        JAXBContext context = JAXBContext.newInstance(Objects.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Objects objs = (Objects) unmarshaller.unmarshal(new File(filename));

        Class c1=Class.forName(objs.getObjects().get(0).getClassName());
        Class c2=Class.forName(objs.getObjects().get(1).getClassName());


    }
}
