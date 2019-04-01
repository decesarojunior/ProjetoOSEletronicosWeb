
package br.edu.ifsul.controle.testes.jsf;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Telmo Junior
 */

@ManagedBean(name = "controleAjax")//bean (classe no padrao bean) gerenciada
@ViewScoped /// import javax.faces.bean.ViewScoped;
public class ControleAjax implements Serializable {    
    private String entrada;
    private String saida;
    public ControleAjax(){	  
    }      
    public void processar() {        
        setSaida("you enter " + getEntrada());
        setEntrada("");
    }
    public String getEntrada() {
        return entrada;
    }
    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getSaida() {
        return saida;
    }

    public void setSaida(String saida) {
        this.saida = saida;
    }
    
    
    
}
