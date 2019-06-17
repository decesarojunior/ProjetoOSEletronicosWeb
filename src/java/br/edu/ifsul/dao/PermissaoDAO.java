
package br.edu.ifsul.dao;

import javax.ejb.Stateful;
import br.edu.ifsul.modelo.Permissao;


@Stateful
public class PermissaoDAO extends DAOGenerico<Permissao>{
    
    public PermissaoDAO(){
        
        super(Permissao.class);
    }
    
}
