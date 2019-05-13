
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.PessoaFisicaDAO;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import br.edu.ifsul.modelo.PessoaFisica;
import br.edu.ifsul.util.Util;
import javax.ejb.EJB;

/**
 *
 * @author Telmo
 */
@Named(value = "controlePessoaFisica")
@ViewScoped
public class ControlePessoaFisica implements Serializable {
    
    @EJB
    private PessoaFisicaDAO dao;
    
    private PessoaFisica objeto;
    
    public ControlePessoaFisica(){
        
    }

    public PessoaFisicaDAO getDao() {
        return dao;
    }

    public PessoaFisica getObjeto() {
        return objeto;
    }

    public void setObjeto(PessoaFisica objeto) {
        this.objeto = objeto;
    }
    
    public String listar(){
        return "/privado/pessoafisica/crudpessoafisica?faces-redirect=true";
    }
    
    public void novo(){
        setObjeto(new PessoaFisica());      
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
                if (getObjeto().getNomeUsuario() == null){
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
    
}
