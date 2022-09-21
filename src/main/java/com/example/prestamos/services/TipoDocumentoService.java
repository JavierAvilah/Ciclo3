package com.example.prestamos.services;

import com.example.prestamos.entities.TipoDocumento;
import com.example.prestamos.repository.ITipoDocumentoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TipoDocumentoService {


    private ITipoDocumentoRepository tipoDocumentoRepository;

    public TipoDocumentoService(ITipoDocumentoRepository tipoDocumentoRepository) {
        this.tipoDocumentoRepository = tipoDocumentoRepository;
    }

    public ArrayList <TipoDocumento> selecAll(){
        return (ArrayList<TipoDocumento>) this.tipoDocumentoRepository.findAll();
    }
    public Response crateDocument(TipoDocumento data){


        Optional<TipoDocumento> documento = tipoDocumentoRepository.findByNombre(data.getNombre());


        if(documento.isPresent()){
            Response response = new Response();
            response.setMessage("Documento ya existe");
            response.setCode(200);
            return response;
        }


        Response response = new Response();
        this.tipoDocumentoRepository.save(data);
        response.setMessage("Registrado correctamente");
        response.setCode(200);

        return response;
    }
}
