package com.portfolio.jh.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Jhonny
 */
public class EducacionDto {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    
    //Constructor

    public EducacionDto(String nombreE, String descripcionE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
    }
    //Getter y Setter

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }
    
}
