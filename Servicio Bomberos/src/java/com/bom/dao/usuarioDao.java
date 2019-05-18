
package com.bom.dao;

import com.bom.entidades.Usuarios;

public interface usuarioDao {
    public Usuarios obtenerDatosPorUsuarios(Usuarios usuarios);
    public Usuarios login(Usuarios users);
    
}