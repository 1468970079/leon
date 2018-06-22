package com.spring.boot.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.boot.mapper.DepartmentMapper;
import com.spring.boot.model.Department;
import com.spring.boot.service.DepartmentService;

@Controller
@RequestMapping("department")
@ResponseBody
public class DepartmentController {


    @Autowired
    private DepartmentService departmentService;
	
    @RequestMapping("getById")
    public Department druid(Integer id) {
    	Department result = departmentService.getDepartmentById(id);
    	System.out.println(result);
    	return result;
    }
    
}
