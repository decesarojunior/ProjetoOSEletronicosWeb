
package br.edu.ifsul.dao;

import br.edu.ifsul.converter.ConverterOrdem;
import br.edu.ifsul.modelo.OrdemServico;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author Telmo Junior
 */
@Stateful
public class OrdemServicoDAO extends DAOGenerico<OrdemServico> implements Serializable  {
    
    public OrdemServicoDAO(){
        
        super(OrdemServico.class);
        
        listaOrdem.add(new Ordem("id", "ID", "="));
        listaOrdem.add(new Ordem("pessoaFisica.nome", "Pessoa Fisica", "like"));
        listaOrdem.add(new Ordem("usuario.nome", "Usuário", "like"));
        listaOrdem.add(new Ordem("equipamento.descricao", "Equipamento Descrição", "like"));
        listaOrdem.add(new Ordem("equipamento.numeroSerie", "Equipamento Numero de Serie", "like"));
        listaOrdem.add(new Ordem("Status", "status", "like"));
        // definir qual a ordenação padrão no caso o segundo elemento da lista (indice 1)
        ordemAtual = listaOrdem.get(1);
        // inicializar o conversor com a lista de ordens
        converterOrdem = new ConverterOrdem(listaOrdem);
    }
    
    @Override
    public OrdemServico getObjectById(Object id) throws Exception {
            OrdemServico obj = em.find(OrdemServico.class, id);
            // Deve-se inicializar as coleções para não gerar erro de LazyInicializationException
            obj.getContasReceber().size();
            obj.getItemProdutos().size();
            obj.getItemServicos().size();
            obj.getFotos().size();
            return obj;
    }  
    
    
    
}
