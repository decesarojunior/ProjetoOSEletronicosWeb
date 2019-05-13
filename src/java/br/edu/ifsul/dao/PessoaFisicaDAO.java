/*
 * 
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.converter.ConverterOrdem;
import java.io.Serializable;
import br.edu.ifsul.modelo.PessoaFisica;
import javax.ejb.Stateful;

/**
 *
 * @author Telmo
 */
@Stateful
public class PessoaFisicaDAO extends DAOGenerico<PessoaFisica> implements Serializable{
    
    public PessoaFisicaDAO(){
        
        super(PessoaFisica.class);
        
        // inicializar as ordenações possiveis        
        listaOrdem.add(new Ordem("nomeUsuario", "Nome Usuário", "="));
        listaOrdem.add(new Ordem("cpf", "CPF", "="));
        // definir qual a ordenação padrão no caso o segundo elemento da lista (indice 1)
        ordemAtual = listaOrdem.get(1);
        // inicializar o conversor com a lista de ordens
        converterOrdem = new ConverterOrdem(listaOrdem);
    }
    
}
