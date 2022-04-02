package structure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor

@XmlAccessorType(XmlAccessType.FIELD)
public class Obj implements Serializable {
    @XmlAttribute
    private String objectName;
    @XmlAttribute
    private String className;
    @XmlElement(name="property")
    private Property property;
}
