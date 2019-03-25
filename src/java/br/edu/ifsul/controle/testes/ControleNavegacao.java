
package br.edu.ifsul.controle.testes;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Telmo Junior
 */
@ManagedBean(name = "controleNavegacao")
@SessionScoped//existirá durante a seção
public class ControleNavegacao implements Serializable {
    
    private final String ajax = "testes/ajax";
    private final String volta = "/index";
    private final String primefacesajax = "testes/primefacesajax";
    private final String controlerender = "testes/controlerender";
    private final String escopos = "testes/escopos";    
    private final String formulario = "testes/formulario";
    
    public ControleNavegacao(){
        
    }

    public String ajax() {
        return this.ajax;
    }
    
    public String primefacesajax() {
        return primefacesajax;
    }
    
    public String controlerender() {
        return controlerender;
    }
    
    public String escopos() {
        return escopos;
    }
    
    public String formulario() {
        return formulario;
    }
    
    public String volta(){
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
	// para manter a mensagem mesmo com redirecionamento
        facesContext.getExternalContext().getFlash().setKeepMessages(true); 
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Executou o método inicio", "");
        facesContext.addMessage(null, mensagem);
        
        return volta;
    }




    
}
