package ec.com.cefr.cargaarchivos;

import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;


@ApplicationPath("/api")
public class CsvApplication extends ResourceConfig {
    public CsvApplication() {
        packages("ec.com.cefr.cargaarchivos.controllers");
        register(MultiPartFeature.class);
    }
}