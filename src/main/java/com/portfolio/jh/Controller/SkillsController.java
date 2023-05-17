package com.portfolio.jh.Controller;

import com.portfolio.jh.Dto.SkillsDto;
import com.portfolio.jh.Entity.Skills;
import com.portfolio.jh.Security.Controller.Mensaje;
import com.portfolio.jh.Service.SkillsService;
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
@RequestMapping("/skills")
@CrossOrigin(origins = "https://frontend-bf8ce.web.app")
public class SkillsController {
    @Autowired
    SkillsService skillsService;
    
    
    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list(){
        List<Skills> list = skillsService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") int id){
        if(!skillsService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Skills skills = skillsService.getOne(id).get();
        return new ResponseEntity(skills, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        //variable si existe el ID
        if(!skillsService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        skillsService.delete(id);        
        return new ResponseEntity(new Mensaje("Skills eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody SkillsDto skillsdto){
        if(StringUtils.isBlank(skillsdto.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(skillsService.existsByNombre(skillsdto.getNombre()))
            return new ResponseEntity(new Mensaje("Esa skills existe"),HttpStatus.BAD_REQUEST);
        
        Skills skills = new Skills(skillsdto.getNombre(),skillsdto.getPorcentaje());
        skillsService.save(skills);
        
        return new ResponseEntity(new Mensaje("Skills agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody SkillsDto skillsdto){
        //Validamos si existe el ID
        if(!skillsService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencia
        if(skillsService.existsByNombre(skillsdto.getNombre()) && skillsService.getByNombre(skillsdto.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa skills ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(skillsdto.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Skills skills = skillsService.getOne(id).get();
        skills.setNombre(skillsdto.getNombre());
        skills.setPorcentaje(skillsdto.getPorcentaje());
        
        skillsService.save(skills);
        return new ResponseEntity(new Mensaje("Skills actualizada"), HttpStatus.OK);
    }   
}
