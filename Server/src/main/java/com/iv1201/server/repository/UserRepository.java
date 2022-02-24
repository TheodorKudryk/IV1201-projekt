package com.iv1201.server.repository;


import com.iv1201.server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author theok
 */
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
