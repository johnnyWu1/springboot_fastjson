package com.jonney.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jonney.pojo.Girl;

public interface GirlRepository extends JpaRepository<Girl, Integer> {
	
	/**
	 * 通过年龄查询
	 * @param age
	 * @return
	 */
	public List<Girl> findByAge(Integer age);
}
