/*
 * 
 */
package br.edu.ifsul.controle.testes.ejb;

import java.io.Serializable;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import java.util.concurrent.TimeUnit;
import javax.annotation.PreDestroy;

/**
 *
 * @author Telmo
 */

@Stateful
@StatefulTimeout(unit = TimeUnit.SECONDS,value = 30)
public class BeanUsuario implements Serializable{
    
        private String usuario;
        
        public BeanUsuario(){
            System.out.println("Chamou o construtor do BeanUsuario");
          
        }

        public String getUsuario() {
                return usuario;
        }

        public void setUsuario(String usuario) {
                this.usuario = usuario;
                System.out.println("usuario : "+usuario);
        }

        @PreDestroy   
        public void destruir(){
                System.out.println("Chamou o método de destruir do BeanUsuario");
        }
}
