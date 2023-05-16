package com.portfolio.jh.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Jhonny
 */
public class ProyectosDto {
    @NotBlank
    private String nombre;
    @NotBlank
    private String fecha;
    @NotBlank
    private String descripcion;
    
    //Constructor

    public ProyectosDto() {
    }

    public ProyectosDto(String nombre, String fecha, String descripcion) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }
    //Getter y Setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
