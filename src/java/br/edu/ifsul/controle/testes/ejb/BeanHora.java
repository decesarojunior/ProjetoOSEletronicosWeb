
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

@Stateless // bean sem estado    
public class BeanHora implements Serializable {
    
    public BeanHora(){
        System.out.println("Usou o construtor da classe BeanHora");        
    }
    
    @PostConstruct
    public void iniciar(){
        System.out.println("Usou o método iniciar da classe BeanHora");
    }
    
    @PreDestroy
    public void destruir(){
        System.out.println("Usou o método destruir da classe BeanHora");
    }    
    
    public String getDataHoraServidor(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SSS");
        return sdf.format(Calendar.getInstance().getTime());   
    } 
}
