
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.PermissaoDAO;
import br.edu.ifsul.dao.UsuarioDAO;
import br.edu.ifsul.modelo.PessoaFisica;
import br.edu.ifsul.modelo.Permissao;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import br.edu.ifsul.modelo.Usuario;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Telmo Junior
 */
@Named(value = "controleUsu")
@ViewScoped
public class ControleUsu implements  Serializable{
    
    @EJB
    private UsuarioDAO dao;
    
    @EJB
    private PermissaoDAO daoPermissao;
    
    private Usuario objeto;
    
    private Permissao permissao;
    
    private Boolean isEdit = false;
    
    public ControleUsu(){                
    }
    
    public String listar(){
        return "/privado/usuario/crudusuario?faces-redirect=true";
    }
    
    public void novo(){
        setObjeto(new Usuario());
        isEdit = false;
    }

    public Usuario getObjeto() {
        return objeto;
    }

    public void setObjeto(Usuario objeto) {
        this.objeto = objeto;
    }

    public UsuarioDAO getDao() {
        return dao;
    }
    
    public void novaPermissao(){
        
        permissao = new Permissao();
    }
    
    public void salvarPermissao(){
        
        if(objeto.getPermissoes() == null){
            objeto.setPermissoes(new HashSet());           
        }
        objeto.getPermissoes().add(permissao);
                
    }
    
    public void alterar(Object id){
             try {
                    setObjeto(dao.getObjectById(id));
                    isEdit = true;
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
            
                if(!getIsEdit()){
                    dao.persist(objeto);
                    Util.mensagemInformacao("Objeto inserido com sucesso!");
                }else{
                    dao.merge(objeto);
                    Util.mensagemInformacao("Objeto alterado com sucesso!");
                }
                    
            } catch(Exception e){
                    Util.mensagemErro("Erro ao persistir objeto: " + 
                                    Util.getMensagemErro(e));
            }
    }
    
    public String verificaTipo(Usuario u){
        
        if((u instanceof Usuario) && (u instanceof PessoaFisica) ){
            return PessoaFisica.class.getSimpleName();
        }else{
            return Usuario.class.getSimpleName();
        }

    }

    public Boolean getIsEdit() {
        return isEdit;
    }

    public PermissaoDAO getDaoPermissao() {
        return daoPermissao;
    }

    public Permissao getPermissao() {
        return permissao;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }
    
}
