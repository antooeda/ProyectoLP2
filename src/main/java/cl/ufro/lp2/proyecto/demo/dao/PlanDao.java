/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.lp2.proyecto.demo.dao;

import cl.ufro.lp2.proyecto.demo.modelo.Plan;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Antonia
 */
public interface PlanDao extends CrudRepository<Plan, Integer> {

    @Override
    public List<Plan> findAll();

    public Plan findById(int id);
    
    public List<Plan> findByNombrePlan(String nombre);
    
}

