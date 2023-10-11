package com.practice.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.user.Model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByName(String name);
}
