
package com.portfolio.jh.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Jhonny
 */
public class PersonaDto {
    @NotBlank
    private String nombre; 
    @NotBlank
    private String apellido;
    @NotBlank
    private String titulo;
    @NotBlank
    private String sobreMi;
    @NotBlank
    private String img;
    @NotBlank
    private String banner;
    
    //Constructor

    public PersonaDto() {
    }

    public PersonaDto(String nombre, String apellido, String titulo, String sobreMi, String img, String banner) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.sobreMi = sobreMi;
        this.img = img;
        this.banner = banner;
    }
    //Getter y Setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSobreMi() {
        return sobreMi;
    }

    public void setSobreMi(String sobreMi) {
        this.sobreMi = sobreMi;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }
    
}
