package com.portfolio.jh.Controller;

import com.portfolio.jh.Dto.ProyectosDto;
import com.portfolio.jh.Entity.Proyectos;
import com.portfolio.jh.Security.Controller.Mensaje;
import com.portfolio.jh.Service.ProyectosService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/proyectos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProyectosController {
   @Autowired
    ProyectosService proyectosService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list(){
        List<Proyectos> list = proyectosService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id")int id){
        if(!proyectosService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Proyectos educacion = proyectosService.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!proyectosService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        proyectosService.delete(id);
        return new ResponseEntity(new Mensaje("Proyectos eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProyectosDto proyectosdto){
        if(StringUtils.isBlank(proyectosdto.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(proyectosService.existsByNombre(proyectosdto.getNombre())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }        
        Proyectos proyectos = new Proyectos(proyectosdto.getNombre(), proyectosdto.getFecha(), proyectosdto.getDescripcion());
        proyectosService.save(proyectos);
        
        return new ResponseEntity(new Mensaje("Proyectos creada"), HttpStatus.OK);       
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ProyectosDto proyectosdto){
        if(!proyectosService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(proyectosService.existsByNombre(proyectosdto.getNombre()) && proyectosService.getByNombre(proyectosdto.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(proyectosdto.getNombre())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Proyectos proyectos = proyectosService.getOne(id).get();
        
        proyectos.setNombre(proyectosdto.getNombre());
        proyectos.setFecha(proyectosdto.getFecha());
        proyectos.setDescripcion(proyectosdto.getDescripcion());
        
        proyectosService.save(proyectos);
        
        return new ResponseEntity(new Mensaje("Proyectos actualizada"), HttpStatus.OK);
    }
} 

