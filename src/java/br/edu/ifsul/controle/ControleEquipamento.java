/*
 * 
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.CidadeDAO;
import br.edu.ifsul.dao.EquipamentoDAO;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Equipamento;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Telmo
 */
@Named(value = "controleEquipamento")
@ViewScoped
public class ControleEquipamento implements Serializable {
    
    @EJB
    private EquipamentoDAO dao;
    
    private Equipamento objeto;
    
    public ControleEquipamento(){
        
    }
    
        public String listar(){
        return "/privado/equipamento/crudequipamento?faces-redirect=true";
    }

    public void novo(){
        objeto = new Equipamento();      
    }

 
    
    
    public void alterar(Object id){
                try {
                        setObjeto(dao.getObjectById(id));            
                } catch (Exception e){
                        Util.mensagemErro("Erro ao recuperar objeto: " + 
                                        Util.getMensagemErro(e));
                } 
        }

        public void excluir(Object id){
                try {
                        setObjeto(dao.getObjectById(id));
                        dao.remover(getObjeto());
                        Util.mensagemInformacao("Objeto removido com sucesso!");
                } catch (Exception e){
                        Util.mensagemErro("Erro ao remover objeto: " + 
                                        Util.getMensagemErro(e));
                }
        }

        public void salvar(){
                try {
                        if (getObjeto().getId() == null){
                                dao.persist(getObjeto());
                        } else {
                                dao.merge(getObjeto());
                        }
                        Util.mensagemInformacao("Objeto persistido com sucesso!");            
                } catch(Exception e){
                        Util.mensagemErro("Erro ao persistir objeto: " + 
                                        Util.getMensagemErro(e));
                }
        }

    public EquipamentoDAO getDao() {
        return dao;
    }

    public Equipamento getObjeto() {
        return objeto;
    }

    public void setObjeto(Equipamento objeto) {
        this.objeto = objeto;
    }
    
    
    
    
}
