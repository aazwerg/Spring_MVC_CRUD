package com.example.spring_mvc_crud.repositories;

import com.example.spring_mvc_crud.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(Role.ALLNAMES name);
}
