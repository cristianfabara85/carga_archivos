package ec.com.cefr.cargaarchivos.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CampaniaDto {

    private List<Campania> campanias;
    private Double totalPresupuesto;

}
