package com.spring.boot.mapper;

import com.spring.boot.model.Department;
import com.spring.boot.model.DepartmentCriteria;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface DepartmentMapper {
    long countByExample(DepartmentCriteria example);

    int deleteByExample(DepartmentCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    List<Department> selectByExampleWithRowbounds(DepartmentCriteria example, RowBounds rowBounds);

    List<Department> selectByExample(DepartmentCriteria example);

    Department selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Department record, @Param("example") DepartmentCriteria example);

    int updateByExample(@Param("record") Department record, @Param("example") DepartmentCriteria example);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}