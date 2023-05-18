package com.portfolio.jh.Controller;

import com.portfolio.jh.Dto.PersonaDto;
import com.portfolio.jh.Entity.Persona;
import com.portfolio.jh.Security.Controller.Mensaje;
import com.portfolio.jh.Service.ImpPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jhonny
 */
@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = "https://frontend-bf8ce.web.app")
public class PersonaController {
    
    @Autowired
    ImpPersonaService impPersonaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = impPersonaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!impPersonaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        Persona persona = impPersonaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    /*
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        //variable si existe el ID
        if(!impPersonaService.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        impPersonaService.delete(id);        
        return new ResponseEntity(new Mensaje("ID eliminada"), HttpStatus.OK);
    }*/
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody PersonaDto personadto){
        if(StringUtils.isBlank(personadto.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(impPersonaService.existsByNombre(personadto.getNombre()))
            return new ResponseEntity(new Mensaje("Esa experiencia existe"),HttpStatus.BAD_REQUEST);
        
        Persona persona = new Persona(personadto.getNombre(), personadto.getApellido(),
                personadto.getTitulo(), personadto.getSobreMi(), personadto.getImg(), personadto.getBanner());
        impPersonaService.save(persona);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody PersonaDto personadto){
        //Validamos si existe el ID
        if(!impPersonaService.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de experiencia
        if(impPersonaService.existsByNombre(personadto.getNombre()) && impPersonaService.getByNombre(personadto.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ess nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if(StringUtils.isBlank(personadto.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Persona persona = impPersonaService.getOne(id).get();
        
        persona.setNombre(personadto.getNombre());
        persona.setApellido(personadto.getApellido());
        persona.setTitulo(personadto.getTitulo());
        persona.setSobreMi(personadto.getSobreMi());
        persona.setImg(personadto.getImg());
        persona.setBanner(personadto.getBanner());
        
        impPersonaService.save(persona);
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
    }   
}

