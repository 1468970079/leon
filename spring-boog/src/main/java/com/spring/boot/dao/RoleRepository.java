package com.spring.boot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
