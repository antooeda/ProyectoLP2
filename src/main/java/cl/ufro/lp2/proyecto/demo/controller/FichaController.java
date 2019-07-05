/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.lp2.proyecto.demo.controller;

import cl.ufro.lp2.proyecto.demo.dao.FichaDao;
import cl.ufro.lp2.proyecto.demo.dao.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String Hora(Model model){
        model.addAttribute("dato", "nombre de Cada Sucursal");
        return "reservarHora";
    }
    
 
    
}
