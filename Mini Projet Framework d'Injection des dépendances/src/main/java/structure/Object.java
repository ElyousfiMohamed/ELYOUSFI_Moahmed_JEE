package structure;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
public class Object implements Serializable {
    @XmlAttribute
    private String objectName;
    @XmlAttribute
    private String className;
    @XmlElement(name="property")
    private Property property;

    @Override
    public String toString() {
        return "Object{" +
                "objectName='" + objectName + '\'' +
                ", className='" + className + '\'' +
                ", property=" + property +
                '}';
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}
