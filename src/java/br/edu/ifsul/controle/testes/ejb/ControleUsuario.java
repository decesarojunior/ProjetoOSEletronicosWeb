
package br.edu.ifsul.controle.testes.ejb;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Telmo
 */

@Named("controleUsuario")//gerenciado pelo Container EJB
@SessionScoped //import javax.enterprise.context.SessionScoped;
public class ControleUsuario implements Serializable{
    
    @EJB//com estado e tempo pre determinado para ser destruido
    private BeanUsuario beanUsuario;

    public ControleUsuario() {
        
    }
    
    public BeanUsuario getBeanUsuario() {
        return beanUsuario;
    }

    
}
