
package br.edu.ifsul.controle.testes.ejb;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.PostActivate;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Telmo Junior
 */

@Named("controleBeanHora")
@RequestScoped //import javax.enterprise.context.RequestScoped;
public class ControleBeanHora implements Serializable {
    
   
    @EJB//sem estado
    private BeanHora beanHora;
    
    @EJB
    private BeanContador beanContador;
    
    @EJB
    private BeanAgendador beanAgendador;
    
    
    
    //Usar o @Inject para injetar outro controle do JSF
    @Inject
    private ControleUsuario controleUsuario;
    
    public ControleBeanHora(){
        System.out.println("Chamou o construtor da classe ControleBeanHora !!");
        //não é possivel utilizar aqui os atributos EJB pois eles ainda não estão inicializados.
    }

    

    public BeanHora getBeanHora() {
       
        return beanHora;
    }


    
    
    public BeanContador getBeanContador() {
        beanContador.incrementaContador();
        return beanContador;
    }

    public ControleUsuario getControleUsuario() {
        return controleUsuario;
    }
    
    
    
}
