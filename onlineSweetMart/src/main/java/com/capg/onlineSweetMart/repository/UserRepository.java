package com.capg.onlineSweetMart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capg.onlineSweetMart.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}
