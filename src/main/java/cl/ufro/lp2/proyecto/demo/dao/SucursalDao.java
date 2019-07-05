/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.lp2.proyecto.demo.dao;

import cl.ufro.lp2.proyecto.demo.modelo.Sucursal;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Antonia
 */
public interface SucursalDao extends CrudRepository<Sucursal, Integer> {

    @Override
    public List<Sucursal> findAll();
    
    
    public Sucursal findById(int id);
    
    public List<Sucursal> findByNombre(String nombre);
   
}
