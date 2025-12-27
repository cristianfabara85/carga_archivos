package ec.com.cefr.carga_archivos.controllers;

import ec.com.cefr.carga_archivos.services.impl.ArchivoServicioImpl;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataParam;

import java.io.IOException;
import java.io.InputStream;

@Path("/campania")
@Consumes(MediaType.MULTIPART_FORM_DATA)
@Produces(MediaType.APPLICATION_JSON)
public class ArchivoController {

    @Inject
    private ArchivoServicioImpl archivoServicio;

    @POST
    @Path("/upload")
    public Response cargarCSV(@FormDataParam("file") InputStream file) throws IOException {
        return Response.ok(archivoServicio.cargarArchivo(file)).build();
    }


}
