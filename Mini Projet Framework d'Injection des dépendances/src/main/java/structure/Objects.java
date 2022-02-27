package structure;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "objects")
public class Objects implements Serializable {
    @XmlElement(name = "object")
    private List<Object> objects = new ArrayList<>();
    public void addObject(Object o) {
        objects.add(o);
    }

    public List<Object> getObjects() {
        return objects;
    }

    public void setObjects(List<Object> objects) {
        this.objects = objects;
    }
}
