package com.iv1201.server.repository;

import com.iv1201.server.entity.Competence_profile;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author theok
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface Competence_profileRepository extends JpaRepository<Competence_profile,Integer> {
    
    @Override
    Competence_profile save(Competence_profile profile);
    
    List<Competence_profile> findAllById(int id);
}
