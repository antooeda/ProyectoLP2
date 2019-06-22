
package cl.ufro.lp2.proyecto.demo.controller;

import cl.ufro.lp2.proyecto.demo.dao.LoginDao;
import cl.ufro.lp2.proyecto.demo.dao.SucursalDao;
import cl.ufro.lp2.proyecto.demo.modelo.Sucursal;
import cl.ufro.lp2.proyecto.demo.modelo.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Estefanie
 */
@Controller
public class LoginController {
     
    @Autowired
    private LoginDao lDAO;
    
    @GetMapping("/loginUsuario")
    public String ingresarLogin(Model model){
        model.addAttribute("dato", "nombre de Cada Sucursal");
        return "login";
    }
    
    @GetMapping("/Contacto")
    public String verContacto(Model model){
        model.addAttribute("dato", "nombre de Cada Sucursal");
        return "Contacto";
    }
    @GetMapping("/Pago")
    public String pagar(Model model){
        model.addAttribute("dato", "nombre de Cada Sucursal");
        return "Pago";
    }
    
    
    
     @PostMapping("/loginUsuarioForm")
    public String loginForm(@ModelAttribute Usuario usuario){
        
        //System.out.println(sucursal.getNombre());
        
        lDAO.save(usuario);
        return "index";
    }
    
    
    @GetMapping("/login")
    public String getSucursalesView(Model model){
        
        List<Usuario> usuario = lDAO.findAll();
        
        model.addAttribute("usuario", usuario);
        
        
        return "usuario";
    }
}
