package com.example.prestamos.controllers;


import com.example.prestamos.entities.TipoDocumento;
import com.example.prestamos.services.Response;
import com.example.prestamos.services.TipoDocumentoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@Controller
@RequestMapping("tipodocumento")
public class DocumentoController {

    private TipoDocumentoService tipoDocumentoService;

    public DocumentoController(TipoDocumentoService tipoDocumentoService) {
        this.tipoDocumentoService = tipoDocumentoService;
    }

    @GetMapping("index")
    public String index(Model documentos){

        ArrayList<TipoDocumento> documentosDB = tipoDocumentoService.selecAll();
        documentos.addAttribute("misdocumentos",documentosDB);

        return "documento/index";
    }

    @GetMapping("create")
    public String create(){
        return "documento/create";
    }

    @PostMapping("createdoc")
    public RedirectView crate(TipoDocumento data){

        Response response = tipoDocumentoService.crateDocument(data);
        return new RedirectView("/tipodocumento/index");


    }

}
