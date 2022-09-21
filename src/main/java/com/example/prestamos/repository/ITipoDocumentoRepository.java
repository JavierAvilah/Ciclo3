package com.example.prestamos.repository;

import com.example.prestamos.entities.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ITipoDocumentoRepository extends JpaRepository<TipoDocumento,Integer> {

    Optional<TipoDocumento> findByNombre(String nombre);




}
