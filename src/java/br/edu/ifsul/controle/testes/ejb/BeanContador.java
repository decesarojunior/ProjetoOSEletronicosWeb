/*
 * 
 */
package br.edu.ifsul.controle.testes.ejb;

import java.io.Serializable;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author Telmo Junior
 */

@Singleton//apenas uma instância dessa classe
@Startup// inicializa o Bean no momento em que a aplicação é carregada
public class BeanContador implements Serializable  {
    
    private Integer contador;

    public BeanContador() {
        System.out.println("Criou o BeanContador");
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
