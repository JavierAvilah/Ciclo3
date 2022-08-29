package com.example.prestamos.repository;

import com.example.prestamos.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // indica que va hacer un repositorio
public interface IUSerRepository extends JpaRepository<User,Integer> {


}
