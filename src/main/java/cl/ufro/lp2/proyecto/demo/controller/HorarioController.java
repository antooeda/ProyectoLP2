/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.lp2.proyecto.demo.controller;

import cl.ufro.lp2.proyecto.demo.dao.HorarioDao;
import cl.ufro.lp2.proyecto.demo.modelo.Horario;
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
public class HorarioController {
    
      @Autowired
    private HorarioDao hDAO;
    
    @GetMapping("/Horario")
    public String crearHorario(Model model){
        model.addAttribute("datoos", "horario");
        model.addAttribute("horario", new Horario());
        return "Horario";
    }
    
     @PostMapping("/crearHorarioForm")
    public String obtenerClase(@ModelAttribute Horario horario){
        
        //System.out.println(sucursal.getNombre());
        
        hDAO.save(horario);
        return "Horario";
    }
    
    
    @GetMapping("/obtenerHorario")
    public String getClasesView(Model model){
        
        List<Horario> horarios = hDAO.findAll();
        
        model.addAttribute("horarios", horarios);
        
        
        return "horarios";
    }
    
}
