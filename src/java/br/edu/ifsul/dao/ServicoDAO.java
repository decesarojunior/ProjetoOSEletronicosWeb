/*
 * 
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Servico;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author Telmo
 */
@Stateful
public class ServicoDAO extends DAOGenerico<Servico> implements Serializable{
    
    public ServicoDAO(){
        super(Servico.class);
    }
}
