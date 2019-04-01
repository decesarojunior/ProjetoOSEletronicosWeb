
package br.edu.ifsul.controle.testes.ejb;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.PostActivate;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Telmo Junior
 */

@Named("controlePrincipal")//gerenciamento via Context and dependency injection (CDI), do pacote javax.inject. As instancias dessa classe passa a ser controladas pelo Container EJB. É uma alternativa em relacao do @ManagedBean
@RequestScoped //escopo de requisicao, a instancia permaneceerá ativa enquanto existir a sessao. Importado de: javax.enterprise.context.
public class ControlePrincipal implements Serializable {
    
    @EJB//sem estado. a instancia será gerenciado pelo Container EBJ
    private BeanHora beanHora;
    
    @EJB//singleton. a instancia será gerenciado pelo Container EBJ
    private BeanAgendador beanAgendador;
      
    @Inject//serve para incluir outro controle JSF. Instancia gerenciado pelo Container EJB   (SessionScoped)
    private ControleUsuario controleUsuario;
    
    public ControlePrincipal(){
        System.out.println("Chamou o construtor da classe ControlePrincipal !!");
        //não é possivel utilizar aqui os atributos EJB pois eles ainda não estão inicializados.
    }

    
    public BeanHora getBeanHora() {      
        return beanHora;
    }

    public BeanAgendador getBeanAgendador() {  
        return beanAgendador;
    }

    public ControleUsuario getControleUsuario() {
        return controleUsuario;
    }
    
    
    
}
