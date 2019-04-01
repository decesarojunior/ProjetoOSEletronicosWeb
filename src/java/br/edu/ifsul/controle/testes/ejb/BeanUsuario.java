
package br.edu.ifsul.controle.testes.ejb;

import java.io.Serializable;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import java.util.concurrent.TimeUnit;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

/**
 *
 * @author Telmo
 */

@Stateful//mantem o estado conversacional. utilizado para associar com sessão do usuario.
//@StatefulTimeout(unit = TimeUnit.SECONDS,value = 30)//defini o tempo de duração.
public class BeanUsuario implements Serializable{
    
        private String usuario;
        
        public BeanUsuario(){
            System.out.println("##Chamou o construtor do BeanUsuario");
          
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
