package ec.com.cefr.cargaarchivos.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PresupuestoAgrupadoEmpresaDto {

    private String nombreEmpresa;
    private Double presupuestoAcumulado;
}
