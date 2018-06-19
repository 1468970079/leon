package com.spring.boot.dao;

import com.spring.boot.model.User;

public interface UserDao {
	
    public int insert(User user);
    
    public int deleteById(Integer id);
    
    public int update(User user);
    
    public User getById(Integer id);
}
