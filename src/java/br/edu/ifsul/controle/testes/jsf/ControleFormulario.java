
package br.edu.ifsul.controle.testes.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Telmo
 */
@ManagedBean(name = "controleFormulario")
@SessionScoped
public class ControleFormulario {
    
    private String nome;
    private String funcao;
    private Boolean ativo;
    
    public ControleFormulario(){
        
    }

    public String processar(){
        return "dados?faces-redirect=true";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
    
    public String voltar(){
        
        return "formulario";
    }
    
}
