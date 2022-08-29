package com.example.prestamos.services;

import com.example.prestamos.entities.User;
import com.example.prestamos.repository.IUSerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service // Inyeccion de dependecia es decir que con esto inicializa como inyeccion de dependencia
public class UserService {

    private IUSerRepository userRepository;

    public UserService (IUSerRepository rep){
        this.userRepository =rep;
    }

    public ArrayList<User> selecAll(){
        return (ArrayList<User>) this.userRepository.findAll();
    }

    public Response creareUser(User data){
        Response response = new Response();
        this.userRepository.save(data);
        response.setCode(200);
        response.setMessage("registrado");

        return response;
    }

}
