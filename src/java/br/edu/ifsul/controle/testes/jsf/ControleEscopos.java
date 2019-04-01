/*
 * 
Escopo de requisição - o md só existe até que a requisição esteja completa. a cada atualização mostrar que muda a hora da criação, pois a data é pega no construtor
@RequestScoped

Escopo de aplicação: Uma unica instancia do controle por toda a aplicação. Mostrar que não muda mais a hora, mesmo que  abra outra aba ou outro navegador
@ApplicationScoped

Escopo de sessão : dura enquando a sessão estiver ativa. Mostrar abas diferentes para ver as diferentes horas de criação do MB
@SessionScoped

Escopo de visão (para uso com ajax) a instância só dura enquando a tela estiver sendo exibida.
@ViewScoped
*/
package br.edu.ifsul.controle.testes.jsf;

import java.io.Serializable;
import java.util.Calendar;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Telmo
 */
@ManagedBean(name = "controleEscopos")
@RequestScoped//instancia disponivel somente durante a requisicao
public class ControleEscopos implements Serializable{
    
    private String ola;
    private Calendar dataSO;
		
    public ControleEscopos(){
            ola = "Seja bem vindo ao JSF";
            dataSO = Calendar.getInstance();
    }

    public String getOla() {
        return ola;
    }

    public void setOla(String ola) {
        this.ola = ola;
    }

    public Calendar getDataSO() {
        return dataSO;
    }

    public void setDataSO(Calendar dataSO) {
        this.dataSO = dataSO;
    }
    
    
}
