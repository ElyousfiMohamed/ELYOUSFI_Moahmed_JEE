package structure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlRootElement(name = "objs")
public class Objs implements Serializable {
    @XmlElement(name = "obj")
    private List<Obj> objs = new ArrayList<>();
    public void addObject(Obj o) {
        objs.add(o);
    }
}

