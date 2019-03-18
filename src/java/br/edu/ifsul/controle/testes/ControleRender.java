/*
 * 
 */
package br.edu.ifsul.controle.testes;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Telmo
 */
@ManagedBean(name = "controleRender")
@ViewScoped        
public class ControleRender implements Serializable {
    
    private Boolean exibir;

    public ControleRender(){
            exibir = true;
    }

    public void mudarExibir(){
            setExibir((Boolean) !getExibir());
    }

    public Boolean getExibir() {
        return exibir;
    }

    public void setExibir(Boolean exibir) {
        this.exibir = exibir;
    }
    
    
}
