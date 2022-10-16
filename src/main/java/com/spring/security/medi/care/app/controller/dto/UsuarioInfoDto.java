package com.spring.security.medi.care.app.controller.dto;

import com.spring.security.medi.care.app.commons.domain.Usuario;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Data
@Component
public class UsuarioInfoDto implements Serializable {

    private String name;
    private String estado;
    private String tipoUsuario;
    private String correoprimario;
    private long timeLogin;

    public UsuarioInfoDto(String name, String estado, String tipoUsuario, String correoprimario, long timeLogin) {
        this.name = name;
        this.estado = estado;
        this.tipoUsuario = tipoUsuario;
        this.correoprimario = correoprimario;
        this.timeLogin = timeLogin;
    }

    public UsuarioInfoDto(Usuario usuario) {
        this.name = usuario.getCodigo();
        this.estado = usuario.getEstado();
        this.tipoUsuario =  usuario.getTipoUsuarioId().getDescripcion();
        this.correoprimario = usuario.getContactoId().getCorreoPrimario();
        long diferencia= new Date().getTime()-usuario.getFechaUltimoCambio().getTime();
        this.timeLogin = TimeUnit.MILLISECONDS.toMinutes(diferencia);
    }

    public UsuarioInfoDto() {
    }

    @Override
    public String toString() {
        return "UsuarioInfoDto{" +
                "name='" + name + '\'' +
                ", rolName='" + estado + '\'' +
                ", tipoUsuario='" + tipoUsuario + '\'' +
                ", correoprimario='" + correoprimario + '\'' +
                ", timeLogin=" + timeLogin +
                '}';
    }
}
