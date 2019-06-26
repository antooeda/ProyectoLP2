
package cl.ufro.lp2.proyecto.demo.controller;

import cl.ufro.lp2.proyecto.demo.dao.LoginDao;
import cl.ufro.lp2.proyecto.demo.dao.SucursalDao;
import cl.ufro.lp2.proyecto.demo.dao.UsuarioDao;
import cl.ufro.lp2.proyecto.demo.modelo.Sucursal;
import cl.ufro.lp2.proyecto.demo.modelo.Usuario;
import java.util.List;
import java.util.Optional;
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
    private UsuarioDao uDAO;
    
    @GetMapping("/loginUsuario")
    public String ingresarLogin(Model model){
        model.addAttribute("usuario", new Usuario());
        return "login";
    }
    
    @GetMapping("/Contacto")
    public String verContacto(Model model){
        model.addAttribute("dato", "nombre de Cada Sucursal");
        return "Contacto";
    }
    
    
     @PostMapping("/loginUsuarioForm")
    public String loginForm(@ModelAttribute Usuario usuario){
        
        //System.out.println(sucursal.getNombre());
        Optional<Usuario> optional = this.uDAO.findByUserName( usuario.getUserName() );
        
        if ( optional.isPresent() ) {
            Usuario usuarioBD = optional.get();
            
            if ( usuarioBD.getContraseña().equals(usuario.getContraseña())) {
                
            }
        }
        
        return "index";
    }
    
    
    @GetMapping("/login")
    public String getSucursalesView(Model model){
        
        List<Usuario> usuario = uDAO.findAll();
        
        model.addAttribute("usuario", usuario);
        
        
        return "usuario";
    }
}
