package com.capg.onlineSweetMart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.capg.onlineSweetMart.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	@Query(value = "SELECT * FROM users WHERE email = :userName",nativeQuery = true)
    User loadUserByUsername(@Param("userName") String userName);
}
