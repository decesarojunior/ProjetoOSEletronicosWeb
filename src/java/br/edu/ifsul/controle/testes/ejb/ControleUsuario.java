
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

@Named("controleUsuario")
@SessionScoped //import javax.enterprise.context.RequestScoped;
public class ControleUsuario implements Serializable{
    
    @EJB
    private BeanUsuario beanUsuario;

    public ControleUsuario() {
        
    }
    
    public BeanUsuario getBeanUsuario() {
        return beanUsuario;
    }

    public void setBeanUsuario(BeanUsuario beanUsuario) {
        this.beanUsuario = beanUsuario;
    }
    
}
