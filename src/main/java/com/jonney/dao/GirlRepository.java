package com.jonney.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jonney.pojo.Girl;

public interface GirlRepository extends JpaRepository<Girl, Integer> {

}
