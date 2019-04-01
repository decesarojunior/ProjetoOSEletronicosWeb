
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

@Singleton
@Startup
public class BeanAgendador implements Serializable {
    
    @EJB
    private BeanContador beanContador;

    public BeanAgendador() {
        System.out.println("Criou o bean agendador: "
                + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SSS").format(Calendar.getInstance().getTime()));
    }

    //@Schedule(minute = "*/1", hour = "*")
    @Schedule(minute = "*", hour = "*", second = "3")
    public void zeraContador() {
        System.out.println("Vai zerar......: "
                + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SSS").format(Calendar.getInstance().getTime()));
        beanContador.setContador(0);
    }	
    
}
