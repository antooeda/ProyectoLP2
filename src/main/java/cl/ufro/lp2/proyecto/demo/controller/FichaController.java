/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.lp2.proyecto.demo.controller;

import cl.ufro.lp2.proyecto.demo.dao.FichaDao;
import cl.ufro.lp2.proyecto.demo.dao.UsuarioDao;
import cl.ufro.lp2.proyecto.demo.modelo.Ficha;
import cl.ufro.lp2.proyecto.demo.modelo.Pago;
import cl.ufro.lp2.proyecto.demo.modelo.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Antonia
 */
@Controller
public class FichaController {

    @Autowired
    FichaDao fDao;
    @Autowired
    UsuarioDao uDao;

    @GetMapping("/reservarHora")
    public String Hora(Model model) {
        model.addAttribute("ficha", new Ficha());
        return "reservarHora";
    }

    @PostMapping("/reservarHora")
    public String guardarHora(@ModelAttribute Ficha ficha, @ModelAttribute("usuario") Usuario usuarioLogueado) {
        ficha.setIdUsuario(usuarioLogueado);
        fDao.save(ficha);
        return "index";

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
   
}