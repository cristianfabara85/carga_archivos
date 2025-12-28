package ec.com.cefr.cargaarchivos.services;

import ec.com.cefr.cargaarchivos.models.Campania;
import ec.com.cefr.cargaarchivos.models.CampaniaDto;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface ArchivoServicio {

    CampaniaDto cargarArchivo(InputStream file) throws IOException;

    List<Campania> listar();

}
