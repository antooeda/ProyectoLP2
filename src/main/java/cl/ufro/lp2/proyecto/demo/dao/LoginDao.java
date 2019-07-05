/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.lp2.proyecto.demo.dao;


import cl.ufro.lp2.proyecto.demo.modelo.Usuario;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Estefanie
 */
public interface LoginDao extends CrudRepository<Usuario, Integer> {

    @Override
    public List<Usuario> findAll();
      public Usuario findByIdUsuario(int id);
      
}
