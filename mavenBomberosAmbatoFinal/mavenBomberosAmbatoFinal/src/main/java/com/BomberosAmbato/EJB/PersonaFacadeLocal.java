/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BomberosAmbato.EJB;

import com.BomberosAmbato.Model.Persona;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Dennis Orellana
 */
@Local
public interface PersonaFacadeLocal {

    void create(Persona persona);

    void edit(Persona persona);

    void remove(Persona persona);

    Persona find(Object id);

    List<Persona> findAll();

    List<Persona> findRange(int[] range);

    int count();
    
}
