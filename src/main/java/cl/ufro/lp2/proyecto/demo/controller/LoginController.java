
package cl.ufro.lp2.proyecto.demo.controller;

import cl.ufro.lp2.proyecto.demo.dao.LoginDao;
import cl.ufro.lp2.proyecto.demo.dao.SucursalDao;
import cl.ufro.lp2.proyecto.demo.dao.UsuarioDao;
import cl.ufro.lp2.proyecto.demo.modelo.Sucursal;
import cl.ufro.lp2.proyecto.demo.modelo.Usuario;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Estefanie
 */
@Controller
public class LoginController {
     
    @Autowired
    private UsuarioDao uDAO;
    private LoginDao lDAO;
    
      
    @GetMapping("/loginUsuario")
    public String mostrarLogin(HttpServletRequest request,Model model, @ModelAttribute("usuario") Usuario usuarioLogueado){
        
        if(usuarioLogueado==null){
            model.addAttribute("usuario", new Usuario());
            return "login";
        }else{
            return "index";
        }
    }
     @ModelAttribute("usuario")
    public Usuario getUsuario(HttpServletRequest request) {
        // Obtener la sesion
        HttpSession sesion = request.getSession(false);
       
        // Si hay sesion
        if (sesion != null) {
            // Obtener objeto de usuario
            Object objeto = sesion.getAttribute("usuarioLogueado");
 
            // Si el objeto es de tipo UsuarioBase
            if (objeto instanceof Usuario) {
                return (Usuario) objeto;
            }
        }
 
        // No hay objeto, retornar null
        return null;
    }
    
    
  
    
    @GetMapping("/Contacto")
    public String verContacto(Model model){
        model.addAttribute("dato", "nombre de Cada Sucursal");
        return "Contacto";
    }
    
    
     @PostMapping("/loginUsuario")
    public String login(Model model, @ModelAttribute("userName")String userName, @ModelAttribute("contraseña")String contraseña, HttpServletRequest request){
        Usuario usuarioBd = uDAO.findByUserNameAndContraseña(userName, contraseña);
        
        if(usuarioBd!=null){
            request.getSession().setAttribute("usuarioLogueado", usuarioBd);
            return "index";
        }else{
            model.addAttribute("usuario", new Usuario());
            model.addAttribute("error",true);
            model.addAttribute("mensaje_error", "Usuario o Contraseña incorrectos. Intentalo de nuevo");
        return "login";
        }
    }
    
    @PostMapping("logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return"redirect:/";
    }
    
    
    @GetMapping("/login")
    public String getSucursalesView(Model model){
        
        List<Usuario> usuario = uDAO.findAll();
        
        model.addAttribute("usuario", usuario);
        
        
        return "usuario";
    }
}