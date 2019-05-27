/*
 * 
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.converter.ConverterOrdem;
import br.edu.ifsul.modelo.Equipamento;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author Telmo
 */
@Stateful
public class EquipamentoDAO extends DAOGenerico<Equipamento> implements Serializable {
    
    public EquipamentoDAO(){
        
        super(Equipamento.class);
        
        // inicializar as ordenações possiveis        
        listaOrdem.add(new Ordem("id", "ID", "="));
        listaOrdem.add(new Ordem("descricao", "Descrição", "like"));
        // definir qual a ordenação padrão no caso o segundo elemento da lista (indice 1)
        ordemAtual = listaOrdem.get(1);
        // inicializar o conversor com a lista de ordens
        converterOrdem = new ConverterOrdem(listaOrdem);
    }
    
}
