/*
 * 
 */
package br.edu.ifsul.controle.testes.ejb;

import java.io.Serializable;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author Telmo
 */

@Singleton
@Startup///  para inicializar o bean no carregamento da aplicação
public class BeanContador implements Serializable  {
    
    private Integer contador;

    public BeanContador() {
        contador = 0;
    }

    public void incrementaContador(){
        contador++;
    }

    public Integer getContador() {
        return contador;
    }
    
    public void setContador(Integer vlr){
        contador = vlr;
    }
    
    
}
