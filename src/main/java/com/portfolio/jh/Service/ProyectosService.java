package com.portfolio.jh.Service;

import com.portfolio.jh.Entity.Proyectos;
import com.portfolio.jh.Repository.ProyectosRepository;
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
public class ProyectosService {
    @Autowired
    ProyectosRepository proyectosRepository;
    
    public List<Proyectos> list(){
        return proyectosRepository.findAll();
    }
    
    public Optional<Proyectos> getOne(int id){
        return proyectosRepository.findById(id);
    }
    
    public Optional<Proyectos> getByNombre(String nombre){
        return proyectosRepository.findByNombre(nombre);
    }
    
    public void save(Proyectos proyectos){
        proyectosRepository.save(proyectos);
    }
    
    public void delete(int id){
        proyectosRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return proyectosRepository.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return proyectosRepository.existsByNombre(nombre);
    }    
}
