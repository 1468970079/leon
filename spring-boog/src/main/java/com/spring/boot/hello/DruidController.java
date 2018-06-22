package com.spring.boot.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.boot.mapper.DepartmentMapper;
import com.spring.boot.model.Department;

@Controller
@RequestMapping("druidTest")
public class DruidController {


    @Autowired
    private DepartmentMapper departmentMapper;
	
    @GetMapping("getById")
    @ResponseBody
    public Department druid(Integer id) {
    	Department result = departmentMapper.selectByPrimaryKey(id);
    	System.out.println(result);
    	return result;
    }
    
}
