package com.example.prestamos.controllers;

import com.example.prestamos.entities.TipoDocumento;
import com.example.prestamos.entities.User;
import com.example.prestamos.services.Response;
import com.example.prestamos.services.TipoDocumentoService;
import com.example.prestamos.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@Controller
@RequestMapping("login")
public class LoginController {

    UserService userService;
    TipoDocumentoService documentoService;

    public LoginController(UserService userService,TipoDocumentoService documentoService) {
        this.userService = userService;
        this.documentoService = documentoService;
    }

    @GetMapping("login")
    public String login(){
        return "Login/login";
    }

    @GetMapping("registro")
    public String registro(Model tiposdocumento){

        ArrayList<TipoDocumento> tipoDocumentosDB = this.documentoService.selecAll();
        tiposdocumento.addAttribute("misdocumentos",tipoDocumentosDB);
        return "Login/Registro";
    }

    @PostMapping("postlogin")
    public RedirectView postLogin(User data){

        Response response = userService.validateLogin(data);

        if (response.getCode()==200){

            return new RedirectView("/inicio");

        }else {
            return  new RedirectView("/login/error");
        }

    }

    @GetMapping("error")
    public String loginError(){return "Login/error";}
}
