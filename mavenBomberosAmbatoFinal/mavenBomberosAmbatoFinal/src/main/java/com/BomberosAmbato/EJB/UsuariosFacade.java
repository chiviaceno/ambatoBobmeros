
package com.BomberosAmbato.EJB;



import com.BomberosAmbato.Model.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> implements UsuariosFacadeLocal {

    @PersistenceContext(unitName = "bomberosAmbatoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }
   @Override
    public  Usuarios iniciarSesion(Usuarios us){
        Usuarios usuario = null;
        String consulta;
        
        try {
            consulta = "FROM Usuarios u WHERE u.usuario=?1 and u.password =?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, us.getUsuario( ));
            query.setParameter(2, us.getPassword());
            
            
            List<Usuarios> lista = query.getResultList();
            if (!lista.isEmpty()) {
                usuario = lista.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        
        return usuario;
       
    }
    
    //metodo que me permite verificar si el usuario existe dentro de la base de datos para no dejar crear 
    @Override
    public  Usuarios usuarioExiste(Usuarios us){
        Usuarios usuario = null;
        String consulta;
        
        try {
            consulta = "FROM Usuarios u WHERE u.usuario=?1" ;
            Query query = em.createQuery(consulta);
            query.setParameter(1, us.getUsuario());
                     
            
            List<Usuarios> lista = query.getResultList();
            if (!lista.isEmpty()) {
                usuario = lista.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        
        return usuario;
    }
}
