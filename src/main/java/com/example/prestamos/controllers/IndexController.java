package com.example.prestamos.controllers;

import com.example.prestamos.entities.Direccion;
import com.example.prestamos.entities.TipoDocumento;
import com.example.prestamos.entities.User;
import com.example.prestamos.services.Response;
import com.example.prestamos.services.TipoDocumentoService;
import com.example.prestamos.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class IndexController {


    private UserService userService;

    public IndexController(UserService service){
        this.userService = service;
    }

    public String miVista(){
        return "mi vista";
    }

    @RequestMapping("saludo") // indica el punto de inicio de la pagina
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

    @RequestMapping("consulta")
    public List<User> getConsulta(){
        return this.userService.consulta();
    }

    @RequestMapping("opcion/{nombre}/{apellido}")
    public String option (@PathVariable String nombre, String apellido){

        return userService.opcion(nombre,apellido);
    }

    @RequestMapping("buscar/{id}")
    public User findUser(@PathVariable int id){
        return userService.getuser(id);
    }

    @DeleteMapping ("borrar/{id}")
    public Response deleteUser(@PathVariable int id){

        return userService.deleteuser(id);
    }

    @PutMapping("update")
    public Response updateuser(@RequestBody User data){
        return userService.updateUser(data);
    }

    @RequestMapping ("validar/{nombres}/{apellidos}/{password}")
    public Response validatePass(@PathVariable String nombres,@PathVariable String apellidos, @PathVariable String password){

        return userService.validatePassword(nombres,apellidos,password);
    }

    @PostMapping ("validateLogin")
    public Response validateLogin(@RequestBody User data){
        return userService.validateLogin(data);
    }


}
