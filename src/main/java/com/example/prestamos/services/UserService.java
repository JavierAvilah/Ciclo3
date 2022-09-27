package com.example.prestamos.services;

import com.example.prestamos.entities.User;
import com.example.prestamos.excepcion.ServiceExepcion;
import com.example.prestamos.repository.IUSerRepository;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
        BCryptPasswordEncoder encriptarPass = new BCryptPasswordEncoder();
        data.setPassword(encriptarPass.encode(data.getPassword()));
        Response response = new Response();
        this.userRepository.save(data);
        response.setCode(200);
        response.setMessage("registrado");

        return response;
    }

    public List<User> consulta(){

        //List <User> lista = userRepository.findBynombresAndApellidos("Sandra","Hincapie");
        List<User> lista = userRepository.obtenerDireccion("Sandra");
        return lista;
    }

    public String opcion(String nombre, String apellido){

        User usuario = userRepository.findBynombresAndApellidos(nombre,apellido).orElseThrow();

        if (usuario.getDireccion()== null){
            throw new ServiceExepcion("No se encontro una localidad asociada con el nombre indicado");
        }else {

            return usuario.getDireccion().getLocalidad();
        }

    }

    public User getuser(int id){

        Optional <User> usuario = userRepository.findById(id);

        if (usuario.isPresent()){return usuario.get();

        }else {return null;}}


    public Response deleteuser(int id){

        Response response = new Response();

        if (getuser(id) == null){
            response.setCode(500);
            response.setMessage("El usuario no existe");
            return response;
        }

        userRepository.deleteById(id);
        response.setCode(200);
        response.setMessage("Usuario eliminado");

        return response;
    }

    public Response updateUser(User u){

        Response response = new Response();

        if (u.getId() == 0){
            response.setMessage("debe introducir un id");
            response.setCode(500);
            return response;

        }


        if(!userRepository.findById(u.getId()).isPresent()){
            response.setMessage("Usuario no existe");
            response.setCode(500);
            return response;
        }

        User data = getuser(u.getId());
        data.setNombres(u.getNombres());
        data.setApellidos(u.getApellidos());
        userRepository.save(data);
        response.setCode(200);
        response.setMessage("Usuario registrado");

        return response;
    }
    public Response validatePassword(String nombres, String apellidos, String password){

       Response response = new Response();

       if (!userRepository.findBynombresAndApellidos(nombres,apellidos).isPresent()){

           response.setCode(500);
           response.setMessage("El usuario no existe");
           return response;
       }

       User user = userRepository.findBynombresAndApellidos(nombres,apellidos).get();

       String passwordUser= user.getPassword();

       if (user.getPassword().equals(password)){

           response.setCode(200);
           response.setMessage("Login Correcto");
           return response;
       }


        response.setCode(500);
        response.setMessage("Contraseña invalida");
        return response;

    }

    public Response validateLogin (User data){

        Response response = new Response();

        if (data.getPassword() == null || data.getCorreo()== null){
            response.setCode(500);
            response.setMessage("debe ingresar su correo y password");
            return response;

        }

        if ( !EmailValidator.getInstance().isValid(data.getCorreo())){
            response.setCode(500);
            response.setMessage("Correo no valido");
            return response;
        }

        if (userRepository.findByCorreoAndPassword(data.getCorreo(), data.getPassword()).isPresent()){
            response.setCode(200);
            response.setMessage("Registro exitoso!");
            return response;
        }else {
            response.setCode(500);
            response.setMessage("El usuario registrado con direccion de correo: " + data.getCorreo() + " no existe!");
            return response;
        }

    }
    public User selectByUserName(String username){
        User existe = this.userRepository.findByCorreo(username);
        return existe;
    }
}
