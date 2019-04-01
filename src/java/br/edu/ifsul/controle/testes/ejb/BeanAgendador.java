
package br.edu.ifsul.controle.testes.ejb;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author Telmo Junior
 */

@Singleton//apenas uma instância dessa classe
@Startup// inicializa o Bean no momento em que a aplicação é carregada. Pode tentar requisicoes simultaneas
public class BeanAgendador implements Serializable {
    
    @EJB
    private BeanContador beanContador;

    public BeanAgendador() {
        System.out.println("Criou o bean agendador: "
                + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SSS").format(Calendar.getInstance().getTime()));
    }
    
    //agendamento de execução do método zeraContador a cada 3 segundos
    //@Schedule(minute = "*/1", hour = "*")
    @Schedule(minute = "*", hour = "*", second = "3")
    public void zeraContador() {
        System.out.println("Vai zerar......: "
                + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SSS").format(Calendar.getInstance().getTime()));
        getBeanContador().setContador(0);
    }	

    public BeanContador getBeanContador() {
        beanContador.incrementaContador();
        return beanContador;
    }
    
    
    
}
