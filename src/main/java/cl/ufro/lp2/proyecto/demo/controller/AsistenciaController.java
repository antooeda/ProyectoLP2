/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.lp2.proyecto.demo.controller;

import cl.ufro.lp2.proyecto.demo.dao.AsistenciaDao;
import cl.ufro.lp2.proyecto.demo.modelo.Asistencia;
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
public class AsistenciaController {
    
    
    @Autowired
    private AsistenciaDao aDAO;
    
    @GetMapping("/inscripcion")
    public String inscripcion(Model model) {
       // List<Asistencia> listaDesplegar =  aDAO.findAll();
        
       // model.addAttribute("listita", listaDesplegar);
       
        return "inscripcion";
    }
    
    @PostMapping("/inscribeAsistencia")
    public String inscribirForm(@ModelAttribute Asistencia asistencia){
        
        System.out.println(asistencia.getIdUsuario());
        
        aDAO.save(asistencia);
        return "index";
    }
}
