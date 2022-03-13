
package com.iv1201.server.repository;


import com.iv1201.server.entity.Password_reset_token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface PasswordResetTokenRepository extends JpaRepository<Password_reset_token, Long> {

    Password_reset_token findByToken(String token);

    Password_reset_token findByEmail(String email);
}