
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.EstadoDAO;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.util.Util;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Telmo
 */
@Named(value = "controleEstado")
@ViewScoped
public class ControleEstado implements Serializable {

        @EJB
        private EstadoDAO dao;
        
        private Estado objeto;

        public ControleEstado(){

        }

        public String listar(){
                return "/privado/estado/crudestado?faces-redirect=true";
        }

        public void novo(){
                objeto = new Estado();        
        }



        public void alterar(Object id){
                try {
                        objeto = dao.getObjectById(id);            
                } catch (Exception e){
                        Util.mensagemErro("Erro ao recuperar objeto: " + 
                                        Util.getMensagemErro(e));
                } 
        }

        public void excluir(Object id){
                try {
                        objeto = dao.getObjectById(id);
                        dao.remover(objeto);
                        Util.mensagemInformacao("Objeto removido com sucesso!");
                } catch (Exception e){
                        Util.mensagemErro("Erro ao remover objeto: " + 
                                        Util.getMensagemErro(e));
                }
        }

        public void salvar(){
                try {
                        if (objeto.getId() == null){
                                dao.persist(objeto);
                        } else {
                                dao.merge(objeto);
                        }
                        Util.mensagemInformacao("Objeto persistido com sucesso!");            
                } catch(Exception e){
                        Util.mensagemErro("Erro ao persistir objeto: " + 
                                        Util.getMensagemErro(e));
                }
        }

        public EstadoDAO getDao() {
        return dao;
        }

        public Estado getObjeto() {
        return objeto;
        }
    
}
