package com.capg.onlineSweetMart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.onlineSweetMart.entity.SweetItems;
@Repository
public interface SweetItemRepository extends JpaRepository<SweetItems, Integer>{

}
