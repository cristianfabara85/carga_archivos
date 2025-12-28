package ec.com.cefr.cargaarchivos.services.impl;

import ec.com.cefr.cargaarchivos.models.Campania;
import ec.com.cefr.cargaarchivos.models.CampaniaDto;
import ec.com.cefr.cargaarchivos.repositories.ArchivoRepository;
import ec.com.cefr.cargaarchivos.services.ArchivoServicio;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class ArchivoServicioImpl implements ArchivoServicio {

    @Inject
    private ArchivoRepository archivoRepository;

    @Override
    public CampaniaDto cargarArchivo(InputStream file) throws IOException {

        CampaniaDto response= new CampaniaDto();

        List<Campania> campanias= new ArrayList<>();

        BufferedReader reader= new BufferedReader(new InputStreamReader(file, StandardCharsets.UTF_8));
        String row;
        while ((row = reader.readLine()) != null) {

            row=row.replace("\uFEFF","").trim();

            String[] linea= row.split(",", -1);
            if(linea.length!=8){
                throw new RuntimeException("Formato de archivo Invalido");
            }

            String msg=validarCampos(linea);
            if(!msg.isEmpty()){
                throw new RuntimeException("Error en los campos:"+msg);
            }

            try {
                Campania campania=armarCampania(linea);
                campanias.add(campania);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }


        }

            campanias.forEach(camp->{
                archivoRepository.save(camp);
            });
            response.setCampanias(campanias.stream().sorted(Comparator.comparing(Campania::getPresupuesto)).collect(Collectors.toList()));
            response.setTotalPresupuesto(campanias.stream().map(Campania::getPresupuesto).reduce(0.0,Double::sum));

        return response;
    }

    @Override
    public List<Campania> listar() {
        return archivoRepository.findAll();
    }

    private String validarCampos(String[] linea) {
        String valido="";

        if(!linea[0].matches("\\d+"))
            valido=" \t,Código de campaña inválido";

        if(!linea[1].matches("[a-zA-Z]{1,5}"))
            valido="\t ,Acrónimo inválido";

        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(Boolean.FALSE);
        try {
           sdf.parse(linea[5]);
        } catch (Exception e) {
            throw new RuntimeException(" \t ,Formato de fecha inválido");
        }

        if(!linea[6].matches("\\d+"))
            valido="\t ,Número de clientes inválido";

        if(!linea[7].matches("\\d+(\\.\\d+)?"))
            valido="\t ,Presupuesto inválido";

        return valido;
    }


    private Campania armarCampania(String[] linea) throws ParseException {
        Campania campania= new Campania();
        campania.setCodigoCampania(Long.valueOf(linea[0]));
        campania.setAcronimo(linea[1]);
        campania.setRuc(linea[2]);
        campania.setNombreEmpresa(linea[3]);
        campania.setDescripcion(linea[4]);
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        campania.setFecha(sdf.parse(linea[5]));
        campania.setNumeroClientes(Integer.valueOf(linea[6]));
        campania.setPresupuesto(Double.valueOf(linea[7]));
        return campania;
    }
}
