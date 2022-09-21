package com.example.prestamos.repository;

import com.example.prestamos.entities.Direccion;
import com.example.prestamos.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository // indica que va hacer un repositorio
public interface IUSerRepository extends JpaRepository<User,Integer> {

    Optional<User> findBynombresAndApellidos(String nombres, String apellidos);

    @Query(
            value = "select * from users where nombres LIKE %:filtro%",
            nativeQuery = true
    )
    List <User> obtenerDireccion (@Param("filtro")String filtro);

    Optional<User> findByCorreoAndPassword(String correo, String password);




}
