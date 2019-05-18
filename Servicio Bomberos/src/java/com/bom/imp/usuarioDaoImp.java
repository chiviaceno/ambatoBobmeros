
package com.bom.imp;

import com.bom.Auxiliares.incriptarPassword;
import com.bom.HibernateUtil.HibernateUtil;
import com.bom.dao.usuarioDao;
import com.bom.entidades.Usuarios;
import org.hibernate.Query;
import org.hibernate.Session;


public class usuarioDaoImp implements usuarioDao{

    @Override
    public Usuarios obtenerDatosPorUsuarios(Usuarios usuarios) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM usuarios WHERE usuario=:nombreUsuario";
        Query q = session.createQuery(hql);
        q.setParameter("nombreUsuario", usuarios.getUsuario());
        return (Usuarios) q.uniqueResult();
    }

    @Override
    public Usuarios login(Usuarios users) {
      Usuarios usu = this.obtenerDatosPorUsuarios(users);
      if(usu !=null){
          if(!usu.getPassword().equals(incriptarPassword.sha512(users.getPassword()))){
              usu = null;
          }
      }
      return usu;
    }
    
}
