/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.lp2.proyecto.demo.controller;

import cl.ufro.lp2.proyecto.demo.dao.PagoDao;
import cl.ufro.lp2.proyecto.demo.modelo.Pago;
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
public class PagoController {
    
    @Autowired
    private PagoDao pDAO;
    
    @GetMapping("/Pago")
    public String pagar(Model model){
        model.addAttribute("pago", new Pago());
        return "Pago";
    }
    
     @PostMapping("/Pago")
    public String guardarUsuario(@ModelAttribute Pago pag){
        pDAO.save(pag);
        return "index";
    }
   
    
}
