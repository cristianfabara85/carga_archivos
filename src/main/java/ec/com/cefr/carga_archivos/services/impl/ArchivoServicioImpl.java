package ec.com.cefr.carga_archivos.services.impl;

import ec.com.cefr.carga_archivos.models.CampaniaDto;
import ec.com.cefr.carga_archivos.services.ArchivoServicio;
import jakarta.ejb.Stateless;

import java.io.IOException;
import java.io.InputStream;

@Stateless
public class ArchivoServicioImpl implements ArchivoServicio {


    @Override
    public CampaniaDto cargarArchivo(InputStream file) throws IOException {

        CampaniaDto response= new CampaniaDto();


        return response;
    }
}
