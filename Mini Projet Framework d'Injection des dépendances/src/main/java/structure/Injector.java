package structure;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Injector {
    public Injector(String filename) throws Exception{
        JAXBContext context = JAXBContext.newInstance(Objects.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Objects objs = (Objects) unmarshaller.unmarshal(new File(filename));

        for (Object c:objs.getObjects()) {
            System.out.println("objectName "+c.getObjectName());
            System.out.println("className "+c.getClassName());
            System.out.println("propertyName "+c.getProperty().getName());
            System.out.println("propertyRef "+c.getProperty().getRef());
        }

    }
}
