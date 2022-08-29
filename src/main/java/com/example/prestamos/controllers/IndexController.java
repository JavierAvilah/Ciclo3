package com.example.prestamos.controllers;

import com.example.prestamos.entities.User;
import com.example.prestamos.services.Response;
import com.example.prestamos.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class IndexController {

    private UserService userService;

    public IndexController(UserService service){
        this.userService = service;
    }

    @RequestMapping("/") // indica el punto de inicio de la pagina
    public String index(){
        return "Joo Hola mundo";
    }

    @RequestMapping("Usuarios")
    public ArrayList<User> getUsuarios(){

        return this.userService.selecAll();

    }
    @PostMapping("create")
    public Response createuser(@RequestBody User request){
        return this.userService.creareUser(request);
    }
}
