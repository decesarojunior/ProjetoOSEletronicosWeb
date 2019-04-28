/*
 * 
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import java.io.Serializable;
import javax.ejb.Stateful;
/**
 *
 * @author Telmo
 */
@Stateful
public class CidadeDAO extends DAOGenerico<Cidade> implements Serializable {
    
    public CidadeDAO(){
        super(Cidade.class);   
    }
    

    
    
}
