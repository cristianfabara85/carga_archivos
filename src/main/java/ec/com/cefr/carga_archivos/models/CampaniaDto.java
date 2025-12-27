package ec.com.cefr.carga_archivos.models;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class CampaniaDto {

    private List<Campania> campanias;
    private BigDecimal totalPresupuesto;

}
