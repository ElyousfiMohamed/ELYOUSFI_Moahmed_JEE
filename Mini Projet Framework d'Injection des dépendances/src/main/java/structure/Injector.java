package structure;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Injector {

    private java.lang.Object object;

    public Injector(String filename) throws Exception{
        JAXBContext context = JAXBContext.newInstance(Objects.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Objects objs = (Objects) unmarshaller.unmarshal(new File(filename));

        Object o = objs.getObjects().get(1);

        Class c1=Class.forName(objs.getObjects().get(0).getClassName());
        Class c2=Class.forName(o.getClassName());

        String fctName = o.getProperty().getNom().substring(0,1).toUpperCase() + o.getProperty().getNom().substring(1);

        java.lang.Object obj = c2.newInstance();
        Method meth = obj.getClass().getMethod("set"+fctName,c1.getInterfaces()[0]);
        meth.invoke(obj,c1.newInstance());

        this.object = obj;
    }

    public java.lang.Object getObject() {
        return object;
    }
}
