
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.UsuarioDAO;
import br.edu.ifsul.modelo.Usuario;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Telmo
 */
@Named(value = "controleLogin")
@SessionScoped
public class ControleLogin implements Serializable {
    
    @EJB
    private UsuarioDAO dao;
    
    private Usuario usuarioAutenticado;
        
    private String usuario;
    private String senha;
    
    public ControleLogin(){
        
    }
    
    public String paginaLogin() {
        return "/login?faces-redirect=true";
    }
    
    public String efetuarLogin() {  
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            request.login(this.getUsuario(), this.getSenha());
            if (request.getUserPrincipal() != null) {
                usuarioAutenticado = dao.getObjectById(request.getUserPrincipal().getName());
                Util.mensagemInformacao("Login realizado com sucesso!");
                setUsuario("");
                setSenha("");
            }
            return "/index";
        } catch (Exception e) {
            Util.mensagemErro("Usuário ou senha inválidos!!! " + Util.getMensagemErro(e));
            return "/login";
        }
    }
    
    public String efetuarLogout() {
        try {
            usuarioAutenticado = null;
            HttpServletRequest request = (HttpServletRequest) FacesContext.
                    getCurrentInstance().getExternalContext().getRequest();
            request.logout();
            return "/index";
        } catch (ServletException e) {
            Util.mensagemErro("Erro: " + Util.getMensagemErro(e));
            return "/index";
        }
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario getUsuarioAutenticado() {
        return usuarioAutenticado;
    }
    
    
}
