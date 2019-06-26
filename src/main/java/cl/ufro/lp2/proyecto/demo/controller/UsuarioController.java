/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.lp2.proyecto.demo.controller;

import cl.ufro.lp2.proyecto.demo.dao.UsuarioDao;
import cl.ufro.lp2.proyecto.demo.modelo.Sucursal;
import cl.ufro.lp2.proyecto.demo.modelo.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Antonia
 */
@Controller
public class UsuarioController {
    @Autowired
    private UsuarioDao uDAO;
    
    @GetMapping("/crearUsuario")
    public String crearUsuario(Model model){
        //model.addAttribute("datosss", "Usuario");
        model.addAttribute("usuario", new Usuario());
        return "Formulario";
    }
    

     @PostMapping("/crearUsuario")
    public String guardarUsuario(@ModelAttribute Usuario us){
        
        //System.out.println(sucursal.getNombre());
        
        uDAO.save(us);
        return "index";
    }
    
    
    @GetMapping("/obtenerUsuarios")
    public String getUsuariosView(Model model){
        
        List<Usuario> usuarios = uDAO.findAll();
        model.addAttribute("usuarios", usuarios);
        return "usuarios";
    }
    
     @GetMapping("/Perfil/{id}")
    public String cargarSucursal(Model model, @PathVariable(value="id") Integer id){
          //model.addAttribute("dato", "Temuco");
          //model.addAttribute("sucursal", new Sucursal());
          
          
          Sucursal aDesplegar = uDAO.findById(id.intValue());
          
          model.addAttribute("usuario", aDesplegar);
      
        return "sucursalTemplate";
    }
    
  
}
