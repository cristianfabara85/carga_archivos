package ec.com.cefr.carga_archivos;

import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;


@ApplicationPath("/api")
public class CsvApplication extends ResourceConfig {
    public CsvApplication() {
        packages("ec.com.cefr.carga_archivos");
        register(MultiPartFeature.class);
    }
}