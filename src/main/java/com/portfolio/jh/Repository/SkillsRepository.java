package com.portfolio.jh.Repository;

import com.portfolio.jh.Entity.Skills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jhonny
 */
@Repository
public interface SkillsRepository  extends JpaRepository<Skills, Integer>{
    public Optional<Skills> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);    
}
