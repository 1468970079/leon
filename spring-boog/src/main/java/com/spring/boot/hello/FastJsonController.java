package com.spring.boot.hello;


import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.boot.model.User;

@Controller
@RequestMapping("fastjson")
public class FastJsonController {

	@RequestMapping("/test")
	@ResponseBody
//	@CrossOrigin(origins="http://localhost:8088")
	public User testFastJson() {
		User user = new User();
		user.setId(1);
		user.setUsername("json");
		user.setPassword("json123");
		user.setBirthday(new Date());
		
		return user;
	}
	
}
