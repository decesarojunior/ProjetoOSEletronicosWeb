
package br.edu.ifsul.dao; 

import javax.ejb.Stateful;
import br.edu.ifsul.modelo.Estado;
import java.io.Serializable;

@Stateful
public class EstadoDAO extends DAOGenerico<Estado> implements Serializable {

    public EstadoDAO(){
        super(Estado.class);        
    }
}	
