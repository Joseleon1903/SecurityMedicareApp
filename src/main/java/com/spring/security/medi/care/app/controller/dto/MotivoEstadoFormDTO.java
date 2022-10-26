package com.spring.security.medi.care.app.controller.dto;

import com.spring.security.medi.care.app.commons.domain.MotivoEstado;
import com.spring.security.medi.care.app.commons.htmvalidation.DupicatedMotivoEstado;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@Component
@DupicatedMotivoEstado
public class MotivoEstadoFormDTO implements Serializable {

    private static final long serialVersionUID = 5774481794489170592L;
    private Long motivoId;

    @NotEmpty
    private String descripcion;

    @NotEmpty
    private String estado;

    public MotivoEstadoFormDTO(Long motivoId, String descripcion, String estado) {
        this.motivoId = motivoId;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public MotivoEstadoFormDTO() {
        this.motivoId = null;
        this.descripcion = "";
        this.estado = "";
    }

    @Override
    public String toString() {
        return "MotivoEstadoFormDTO{" +
                "motivoId=" + motivoId +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }

    public static MotivoEstado toEntity(MotivoEstadoFormDTO motivoIn){
        MotivoEstado motivo = new MotivoEstado();
        motivo.setMotivoId(motivoIn.getMotivoId());
        motivo.setDescripcion(motivoIn.getDescripcion());
        motivo.setEstado(motivoIn.getEstado());
        return motivo;
    }
}