package structure;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Injector {

    private Object object;

    public Injector(String filename) throws Exception{
        JAXBContext context = JAXBContext.newInstance(Objs.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Objs objs = (Objs) unmarshaller.unmarshal(new File(filename));

        Obj o = objs.getObjs().get(1);

        Class c1=Class.forName(objs.getObjs().get(0).getClassName());
        Class c2=Class.forName(o.getClassName());

        /****** Partie setter ******/
        /*String fctName = o.getProperty().getNom().substring(0,1).toUpperCase() + o.getProperty().getNom().substring(1);

        Object obj = c2.newInstance();
        Method meth = c2.getMethod("set"+fctName,c1.getInterfaces());
        meth.invoke(obj,c1.newInstance());

        this.object = obj;*/


        /****** Partie constructor ******/

        /* Constructor constructor = c2.getConstructor(c1.getInterfaces());
        Object obj = constructor.newInstance(c1.newInstance());

        this.object = obj;*/


        /****** Partie Attribut ******/
        String attName = o.getProperty().getNom();

        Object obj = c2.newInstance();
        c2.getDeclaredField(attName).set(obj,c1.newInstance());

        this.object = obj;

    }

    public Object getObject() {
        return object;
    }
}
