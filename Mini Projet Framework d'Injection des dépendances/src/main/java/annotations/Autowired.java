package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, // Setter
        ElementType.CONSTRUCTOR, // Constructeur
        ElementType.FIELD}) // Accès direct
@Retention(RetentionPolicy.RUNTIME)
public @interface Autowired {

}
