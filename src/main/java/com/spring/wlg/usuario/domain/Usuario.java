package com.spring.wlg.usuario.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Usuario implements Serializable {

    private Long usuarioId;
    private String codigo;
    private Short tipoUsuarioId;
    private String posicion;
    private String correoCorporativo;
    private String cedula;
    private String nss;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private LocalDateTime fechaNacimiento;
    private String genero;
    private String nacionalidad;

    public Usuario(Long usuarioId, String codigo, Short tipoUsuarioId, String posicion, String correoCoorporativo, String cedula, String nss, String nombre, String primerApellido, String segundoApellido, LocalDateTime fechaNacimiento, String genero, String nacionalidad) {
        this.usuarioId = usuarioId;
        this.codigo = codigo;
        this.tipoUsuarioId = tipoUsuarioId;
        this.posicion = posicion;
        this.correoCorporativo = correoCoorporativo;
        this.cedula = cedula;
        this.nss = nss;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.nacionalidad = nacionalidad;
    }

    public Usuario() {
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Short getTipoUsuarioId() {
        return tipoUsuarioId;
    }

    public void setTipoUsuarioId(Short tipoUsuarioId) {
        this.tipoUsuarioId = tipoUsuarioId;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getCorreoCorporativo() {
        return correoCorporativo;
    }

    public void setCorreoCorporativo(String correoCorporativo) {
        this.correoCorporativo = correoCorporativo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getUrlLogo(){

        if(correoCorporativo.contains("arssenasa")){
            return "/img/logo_ars-senasa.png";
        }

        if(correoCorporativo.contains("arsyunen")){
            return "/img/logos-png-ars-yunen.png";
        }

        if(correoCorporativo.contains("scotiabank")){
            return "/img/logo_scotiaBank.png";
        }

        if(correoCorporativo.contains("dida")){
            return "/img/dida_insituticona.png";
        }

        if(correoCorporativo.contains("sisalril")){
            return "/img/sisalril_logo.jpg";
        }

        if(correoCorporativo.contains("humano")){
            return "/img/ars_humano.png";
        }

        if(correoCorporativo.contains("afppopular")){
            return "/img/afp_popular.png";
        }

        if(correoCorporativo.contains("SIPEN")){
            return "/img/Sipen_logo.png";
        }
        if(correoCorporativo.contains("sipen")){
            return "/img/Sipen_logo.png";
        }

        if(correoCorporativo.contains("bancocaribe")){
            return "/img/bancoCaribe_logo.png";
        }

        if(correoCorporativo.contains("arsasemap")){
            return "/img/ars_asemap.png";
        }

        if(correoCorporativo.contains("afpatlantico")){
            return "/img/afp-atlantico.png";
        }

        if(correoCorporativo.contains("arssaludsegura")){
            return "/img/ars_saludsegura.png";
        }

        if(correoCorporativo.contains("aps")){
            return "/img/aps-logo.png";
        }

        if(correoCorporativo.contains("unipago") || correoCorporativo.contains("UNIPAGO")){
            return "/img/unipago_logo.png";
        }

        if(correoCorporativo.contains("tss")){
            return "/img/tss_logo.png";
        }

        if(correoCorporativo.contains("afpsiembra")){
            return "/img/AFP-Siembra.png";
        }

        if(correoCorporativo.contains("arsgma")){
            return "/img/arsGma.png";
        }

        if(correoCorporativo.contains("universal")){
            return "/img/ars-universal.png";
        }

        if(correoCorporativo.contains("afpreservas")){
            return "/img/AFP-Reservas.png";
        }

        if(correoCorporativo.contains("afpcrecer")){
            return "/img/afp-Crecer.png";
        }

        if(correoCorporativo.contains("bancentral")){
            return "/img/banco-central.jpg";
        }

        if(correoCorporativo.contains("arsfuturo")){
            return "/img/ars_futuro.png";
        }

        if(correoCorporativo.contains("inabima")){
            return "/img/Logo_Lema_inabima.png";
        }

        if(correoCorporativo.contains("arsreservas")){
            return "/img/ars_reserva.png";
        }

        if(correoCorporativo.contains("arspalic")){
            return "/img/Logo-ARS-Palic.png";
        }

        if(correoCorporativo.contains("arssemma")){
            return "/img/ars_semma.png";
        }

        if(correoCorporativo.contains("jmmb")){
            return "/img/jmmb_logo.jpg";
        }

        if(correoCorporativo.contains("arssimag")){
            return "/img/ars_png";
        }

        if(correoCorporativo.contains("hacienda")){
            return "/img/hacienda_gov.jpg";
        }

        if(correoCorporativo.contains("arsmetasalud")){
            return "/img/ars_metasalud_logo.png";
        }

        if(correoCorporativo.contains("arsrenacer")){
            return "/img/ARS-Renacer.png";
        }

        if(correoCorporativo.contains("arscmd")){
            return "/img/ARS-CMD.png";
        }

        if(correoCorporativo.contains("banesco")){
            return "/img/logo-banco-banesco.jpg";
        }

        if(correoCorporativo.contains("bhdleon")){
            return "/img/bhdLeon_logo.png";
        }

        if(correoCorporativo.contains("vimenca")){
            return "/img/banco_vimenca_logo.png";
        }
        return "/img/slider_pc_A.png";


    }

    @Override
    public String toString() {
        return "Usuario{" +
                "usuarioId=" + usuarioId +
                ", codigo='" + codigo + '\'' +
                ", tipoUsuarioId=" + tipoUsuarioId +
                ", posicion='" + posicion + '\'' +
                ", correoCorporativo='" + correoCorporativo + '\'' +
                ", cedula='" + cedula + '\'' +
                ", nss='" + nss + '\'' +
                ", nombre='" + nombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", genero='" + genero + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                '}';
    }
}
