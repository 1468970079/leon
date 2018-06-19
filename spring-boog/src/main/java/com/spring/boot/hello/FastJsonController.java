package com.spring.boot.hello;


import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.boot.model.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(value = "FastJson测试", tags = {"测试接口"})
@Controller
@RequestMapping("fastjson")
public class FastJsonController {

	@ApiOperation("获取用户信息")
	@ApiImplicitParam(name = "name", value = "用户名", dataType = "string", paramType = "query")
	@PostMapping("/test/{name}")
	@ResponseBody
//	@CrossOrigin(origins="http://localhost:8088")
	public User testFastJson(@PathVariable("name") String name) {
		User user = new User();
		user.setId(1);
		user.setUsername(name);
		user.setPassword("json123");
		user.setBirthday(new Date());
		
		return user;
	}
	
}
