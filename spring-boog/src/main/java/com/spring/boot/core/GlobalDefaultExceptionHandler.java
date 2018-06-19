package com.spring.boot.core;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.boot.hello.MyException;


@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Map<String,Object> defaultExceptionHandler(Exception e){
		String code = "500";
		String msg = e.getMessage();
		if (e instanceof MyException) {
			code = ((MyException) e).getErrCode();
		}
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("code", code);
		map.put("msg", msg);
		return map;
	}
	
}
