package ec.com.cefr.carga_archivos.services;

import ec.com.cefr.carga_archivos.models.CampaniaDto;

import java.io.IOException;
import java.io.InputStream;

public interface ArchivoServicio {

    CampaniaDto cargarArchivo(InputStream file) throws IOException;

}
