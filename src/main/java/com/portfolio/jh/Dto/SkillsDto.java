package com.portfolio.jh.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Jhonny
 */
public class SkillsDto {
    @NotBlank
    private String nombre;
    @NotBlank
    private int porcentaje;
    
    //Constructor
    public SkillsDto() {
    }

    public SkillsDto(String nombre, int porcentaje) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }   
    
    //Getter y Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    
    
}
