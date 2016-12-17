package com.jonney;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jonney.dao.GirlRepository;
import com.jonney.pojo.Girl;

@RestController
public class GirlController {

	
	@Autowired
	private GirlRepository girlRepository;
	
	/**
	 * 查询所有女生列表
	 * @return
	 */
	@GetMapping("/girls")
	public List<Girl> girlList() {
		return girlRepository.findAll();
	}
	
	
	/**
	 * 添加一个女生
	 * @param cupSize
	 * @param age
	 * @return
	 */
	@PostMapping("/girls")
	public Girl girlAdd(@RequestParam("cupSize") String cupSize,
			@RequestParam("age") Integer age){
		
		Girl girl = new Girl();
		girl.setCupSize(cupSize);
		girl.setAge(age);
		
		return girlRepository.save(girl);
	}
	
	/**
	 * 查询一个女生
	 * @param id
	 * @return
	 */
	@GetMapping("/girls/{id}")
	public Girl girlFindOne(@PathVariable("id") Integer id) {
		
		return girlRepository.getOne(id);
		
	}
	
	
	@PutMapping("/girls/{id}")
	public Girl updateGirl(@PathVariable("id") Integer id,@RequestParam("cupSize") String cupSize,
			@RequestParam("age") Integer age){
		
		Girl girl = new Girl();
		girlRepository.getOne(id);
		girl.setAge(age);
		girl.setCupSize(cupSize);
		
		return girlRepository.save(girl);
		
	}
	
}
