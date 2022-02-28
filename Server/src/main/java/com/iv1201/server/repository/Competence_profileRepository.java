package com.iv1201.server.repository;

import com.iv1201.server.entity.Competence_profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
/**
 *
 * @author theok
 */
public interface Competence_profileRepository extends JpaRepository<Competence_profile,Integer> {
    
    @Override
    Competence_profile save(Competence_profile profile);
}
