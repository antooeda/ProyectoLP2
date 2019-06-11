/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.lp2.proyecto.demo.dao;

import cl.ufro.lp2.proyecto.demo.modelo.Asistencia;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Antonia
 */
public interface AsistenciaDao extends CrudRepository<Asistencia, Integer> {

    @Override
    public List<Asistencia> findAll();
    

}
