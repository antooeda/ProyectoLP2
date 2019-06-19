/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.lp2.proyecto.demo.controller;

import cl.ufro.lp2.proyecto.demo.dao.ClaseDao;
import cl.ufro.lp2.proyecto.demo.modelo.Clase;
import java.util.List;
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
public class ClaseController {
    
    @Autowired
    private ClaseDao cDAO;
    
    @GetMapping("/crearClase")
    public String crearClase(Model model){
        model.addAttribute("datos", "clase");
        model.addAttribute("clase", new Clase());
        return "crearClase";
    }
    
     @PostMapping("/crearClaseForm")
    public String obtenerClase(@ModelAttribute Clase clase){
        
        //System.out.println(sucursal.getNombre());
        clase.getCantMaxalumnos();
        cDAO.save(clase);
        return "SucursalConcepcion";
    }
    
    
    @GetMapping("/obtenerClase")
    public String getClasesView(Model model){
        
        List<Clase> clases = cDAO.findAll();
        
        model.addAttribute("clases", clases);
        
        
        return "clases";
    }
  
    
}
