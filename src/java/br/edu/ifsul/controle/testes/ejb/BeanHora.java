
package br.edu.ifsul.controle.testes.ejb;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

/**
 *
 * @author Telmo
 */

@Stateless // EJB sem estado (não armazena estado), uma única instancia PODE atender chamadas de diversos clientes. Não atende chamadas simultâneas. O container pode criar um pool de instancias.      
public class BeanHora implements Serializable {
    
    private String data_hora_servidor;
    
    public BeanHora(){
        System.out.println("Usou o construtor da classe BeanHora");       
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SSS");
        this.data_hora_servidor = sdf.format(Calendar.getInstance().getTime());  
    }
    
    @PostConstruct
    public void iniciar(){
        System.out.println("Usou o método iniciar da classe BeanHora");
    }
    
    @PreDestroy
    public void destruir(){
        System.out.println("Usou o método destruir da classe BeanHora");
    }    

    public String getData_hora_servidor() {
        return data_hora_servidor;
    }
    

    
}
