
package br.edu.ifsul.controle;


import br.edu.ifsul.dao.EquipamentoDAO;
import br.edu.ifsul.dao.ServicoDAO;
import br.edu.ifsul.dao.OrdemServicoDAO;
import br.edu.ifsul.modelo.ItemServico;
import br.edu.ifsul.modelo.OrdemServico;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Telmo Junior
 */

@Named(value = "controleOrdemServico")
@ViewScoped
public class ControleOrdemServico implements Serializable {
    
    @EJB
    private OrdemServicoDAO dao;
    
    @EJB
    private EquipamentoDAO daoEquipamento;
    
    private OrdemServico objeto;
    
    @EJB
    private ServicoDAO servicoDao;
    
    private ItemServico itemServico;
    private Boolean novoItemServico;
	
  
    
    public ControleOrdemServico(){
        
    }
    
    public void novoItemServico(){
        setItemServico(new ItemServico());
        novoItemServico = true;
    }    
    public void alterarItemServico(int index){
        setItemServico(objeto.getItemServicos().get(index));
        novoItemServico = false;
    }            
    public void salvarItemServico(){
        if (novoItemServico){
            objeto.adicionarServico(getItemServico());
        }
        Util.mensagemInformacao("Serviço adicionado com sucesso");
    }                
    public void removerItemServico(int index){
        objeto.removerServico(index);
        Util.mensagemInformacao("Serviço removido com sucesso");
    }

    
    public String listar(){
            return "/privado/ordemservico/crudordemservico?faces-redirect=true";
    }

    public void novo(){
            objeto = new OrdemServico();        
    }

    public void alterar(Object id){
            try {
                    objeto = getDao().getObjectById(id);            
            } catch (Exception e){
                    Util.mensagemErro("Erro ao recuperar objeto: " + 
                                    Util.getMensagemErro(e));
            } 
    }

    public void excluir(Object id){
            try {
                    objeto = getDao().getObjectById(id);
                    getDao().remover(objeto);
                    Util.mensagemInformacao("Objeto removido com sucesso!");
            } catch (Exception e){
                    Util.mensagemErro("Erro ao remover objeto: " + 
                                    Util.getMensagemErro(e));
            }
    }

    public void salvar(){
            try {
                    if (objeto.getId() == null){
                            getDao().persist(objeto);
                    } else {
                            getDao().merge(objeto);
                    }
                    Util.mensagemInformacao("Objeto persistido com sucesso!");            
            } catch(Exception e){
                    Util.mensagemErro("Erro ao persistir objeto: " + 
                                    Util.getMensagemErro(e));
            }
    }
    

    public OrdemServico getObjeto() {
        return objeto;
    }

    public void setObjeto(OrdemServico objeto) {
        this.objeto = objeto;
    }

    public OrdemServicoDAO getDao() {
        return dao;
    }

    public void setDao(OrdemServicoDAO dao) {
        this.dao = dao;
    }

    public EquipamentoDAO getDaoEquipamento() {
        return daoEquipamento;
    }

    public void setDaoEquipamento(EquipamentoDAO daoEquipamento) {
        this.daoEquipamento = daoEquipamento;
    }

    public ItemServico getItemServico() {
        return itemServico;
    }

    public void setItemServico(ItemServico itemServico) {
        this.itemServico = itemServico;
    }

    public ServicoDAO getServicoDao() {
        return servicoDao;
    }
    
    
}
