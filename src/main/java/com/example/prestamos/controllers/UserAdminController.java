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
@RequestMapping("admin")
public class UserAdminController extends BaseController{

    //private UserService userService;
    private TipoDocumentoService documentoService;

    public UserAdminController(TipoDocumentoService documentoService) {
        this.documentoService = documentoService;
    }

    @GetMapping("usuarios")
    public String usuariosRegistrados(Model user){

        ArrayList <User> userDB = this.userService.selecAll();
        user.addAttribute("usuarioauntenticado",seguridad());
        user.addAttribute("usuarios",userDB);
        return "useradmin/usuariosregistrados";
    }

    @GetMapping("edituser/{id}")
    public String editUser (@PathVariable int id, Model data){
        User user = this.userService.getuser(id);
        ArrayList<TipoDocumento> documentos = this.documentoService.selecAll();
        data.addAttribute("usuarioauntenticado",seguridad());
        data.addAttribute("user",user);
        data.addAttribute("misdocumentos",documentos);

        return "useradmin/edituser";
    }

    @PostMapping("edituser")
    public RedirectView edituser(User data){

        Response response= userService.updateUser(data);
        System.out.println(response.getMessage());

        return new RedirectView("/admin/usuarios");
    }

    @GetMapping("deleteuser/{id}")
    public RedirectView deleteUser(@PathVariable int id){
        Response response = userService.deleteuser(id);
        return new RedirectView("/admin/usuarios");
    }
    @GetMapping("documentos")
    public String prueba(Model data){

        return "useradmin/tipodocumento";
    }
}
