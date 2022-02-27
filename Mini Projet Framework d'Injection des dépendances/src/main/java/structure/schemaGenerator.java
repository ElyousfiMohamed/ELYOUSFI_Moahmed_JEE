package structure;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class schemaGenerator {
    public static void main(String[] args) throws Exception {
        JAXBContext context = JAXBContext.newInstance(Objects.class);
        context.generateSchema(new SchemaOutputResolver() {
            @Override
            public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
                File f = new File("objects.xsd");
                StreamResult res = new StreamResult(f);
                res.setSystemId(f.getName());
                return res;
            }
        });
    }
}
