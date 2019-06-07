/*
 * 
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.converter.ConverterOrdem;
import br.edu.ifsul.modelo.Usuario;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author Telmo
 */
@Stateful
public class UsuarioDAO extends DAOGenerico<Usuario> implements Serializable{
    
    public UsuarioDAO(){
         super(Usuario.class);
         
        // inicializar as ordenações possiveis        
        listaOrdem.add(new Ordem("nomeUsuario", "Nome Usuário", "="));
        listaOrdem.add(new Ordem("nome", "Nome", "like"));
        // definir qual a ordenação padrão no caso o segundo elemento da lista (indice 1)
        ordemAtual = listaOrdem.get(1);
        // inicializar o conversor com a lista de ordens
        converterOrdem = new ConverterOrdem(listaOrdem);
    }
    /*
    @Override
    public Usuario getObjectById(Object id) throws Exception {
        
      return (Usuario) em.createNamedQuery("getUsuario").setParameter("paramNome", id).getResultList().get(0);
                
    }
    */
}
