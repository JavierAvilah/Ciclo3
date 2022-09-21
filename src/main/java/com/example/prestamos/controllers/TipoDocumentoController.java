package com.example.prestamos.controllers;

import com.example.prestamos.entities.TipoDocumento;
import com.example.prestamos.services.Response;
import com.example.prestamos.services.TipoDocumentoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
public class TipoDocumentoController {


    private TipoDocumentoService tipoDocumentoService;

    public TipoDocumentoController(TipoDocumentoService tipoDocumentoService) {
        this.tipoDocumentoService = tipoDocumentoService;
    }

    @RequestMapping("get")
    public ArrayList <TipoDocumento> get(){
        return this.tipoDocumentoService.selecAll();
    }

    @PostMapping("documento")
    public Response createnew(@RequestBody TipoDocumento data){return tipoDocumentoService.crateDocument(data);}


}
