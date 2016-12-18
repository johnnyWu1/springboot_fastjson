package com.jonney;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jonney.dao.GirlRepository;
import com.jonney.pojo.Girl;

@RestController
public class GirlController {

	Logger logger = LoggerFactory.getLogger(GirlController.class);

	@Autowired
	private GirlRepository girlRepository;

	/**
	 * 查询所有女生列表
	 * 
	 * @return
	 */
	@GetMapping("/girls")
	public List<Girl> girlList() {
		return girlRepository.findAll();
	}

	/**
	 * 添加一个女生
	 * 
	 * @param cupSize
	 * @param age
	 * @return
	 */
	@PostMapping("/girls")
	public Girl girlAdd(@RequestParam("cupSize") String cupSize, @RequestParam("age") Integer age) {

		Girl girl = new Girl();
		girl.setCupSize(cupSize);
		girl.setAge(age);

		return girlRepository.save(girl);
	}

	/**
	 * 查询一个女生
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/girls/{id}")
	public Girl girlFindOne(@PathVariable("id") Integer id) {
		Girl one = girlRepository.getOne(id);
		return one;

	}
	
	/**
	 * 更新一个女生
	 * @param id
	 * @param cupSize
	 * @param age
	 * @return
	 */
	@PutMapping("/girls/{id}")
	public Girl girlUpdate(@PathVariable("id") Integer id, @RequestParam("cupSize") String cupSize,
			@RequestParam("age") Integer age) {

		Girl girl = new Girl();
		girl.setId(id);
		girl.setAge(age);
		girl.setCupSize(cupSize);

		return girlRepository.save(girl);
	}
	
	/**
	 * 删除一个女生
	 * @param id
	 */
	@DeleteMapping("/girls/{id}")
	public void girlDelete(@PathVariable("id") Integer id){
		girlRepository.delete(id);
	}
	
	/**
	 * 处理未查询到女生的异常
	 * @param e
	 * @return
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler
	public Object handleNotFound(Exception e) {
		return e.getMessage();
	}
	
	/**
	 * 通过女生年龄查询
	 * @param age
	 * @return
	 */
	@GetMapping("/girls/age/{age}")
	public List<Girl> girlListByAge(@PathVariable Integer age) {
		return girlRepository.findByAge(age);
	}

}
