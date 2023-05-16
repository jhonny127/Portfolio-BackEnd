package com.portfolio.jh.Service;

import com.portfolio.jh.Entity.Persona;
import com.portfolio.jh.Repository.PersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jhonny
 */
@Service
@Transactional
public class ImpPersonaService {
    
    @Autowired
    PersonaRepository persoRepository;

    public List<Persona> list(){
        return persoRepository.findAll();
    }
    
    public Optional<Persona> getOne(int id){
        return persoRepository.findById(id);
    }
    public Optional<Persona> getByNombre(String nombre){
         return persoRepository.findByNombre(nombre);
     }
    
    public void save(Persona persona){
        persoRepository.save(persona);
    }
    
    public void delete(int id){
        persoRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return persoRepository.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return persoRepository.existsByNombre(nombre);
    }
}