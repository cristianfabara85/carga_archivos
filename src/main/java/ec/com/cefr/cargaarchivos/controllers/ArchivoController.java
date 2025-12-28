package ec.com.cefr.cargaarchivos.controllers;

import ec.com.cefr.cargaarchivos.services.ArchivoServicio;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/campania")
@Produces(MediaType.APPLICATION_JSON)
public class ArchivoController {

    @Inject
    private ArchivoServicio archivoServicio;

    @GET
    public Response listar() {
        return Response.ok(archivoServicio.listar()).build();
    }

}
