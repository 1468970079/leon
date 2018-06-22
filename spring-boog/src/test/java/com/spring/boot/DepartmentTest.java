package com.spring.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.boot.core.Application;
import com.spring.boot.mapper.DepartmentMapper;
import com.spring.boot.model.Department;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DepartmentTest {

	    @Autowired
	    private DepartmentMapper departmentMapper;
	    
	    @Test
	    public void testInsert() {
	        Department department = new Department();
	        department.setId(1);
	        department.setName("研发部");
	        department.setDescr("开发产品");
	        this.departmentMapper.insert(department);
	    }
	    
	    @Test
	    public void testGetById() {
	        Department department = this.departmentMapper.selectByPrimaryKey(1);
	        System.out.println(department);
	    }
	    
	    @Test
	    public void testUpdate() {
	        Department department = new Department();
	        department.setId(1);
	        department.setDescr("开发高级产品");
	        this.departmentMapper.updateByPrimaryKeySelective(department);
	    }
	    
//	    @Test
	    public void testDeleteById() {
	        this.departmentMapper.deleteByPrimaryKey(1);
	    }
	
}
