package com.example.prestamos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("solicitud")
public class SolicitudPrestamoController extends BaseController {

    @GetMapping("solicitud")
    public String solicitud(Model data){
        data.addAttribute("usuarioauntenticado",seguridad());
        data.addAttribute("tituoloPagina","Solicitud prestamo");
        return "solicitudprestamo/solicitud";

    }
}
