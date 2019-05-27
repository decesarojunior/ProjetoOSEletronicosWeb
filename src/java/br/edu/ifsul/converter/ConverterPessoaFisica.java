/*
 * 
 */
package br.edu.ifsul.converter;

import br.edu.ifsul.dao.PessoaFisicaDAO;
import br.edu.ifsul.modelo.PessoaFisica;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

/**
 *
 * @author Telmo Junior
 */

@Named(value = "converterPessoaFisica")
@RequestScoped
public class ConverterPessoaFisica implements Serializable, Converter {
    
    @EJB
    private PessoaFisicaDAO dao;
    
    public ConverterPessoaFisica(){
        
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        if(value == null || value.equals("Selecione") || value.equals("Selecione um registro")){
            return null;
        }
        
        PessoaFisica pf =  dao.find(value);
        return pf;
        /*
         String value que o usuário informou no campo de entrada e retorna um objeto que seja compatível com             o tipo da propriedade que está vinculado pelo atributo value do componente
        */
       
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
        if(value == null){
            return null;
        }
        
        PessoaFisica pf =  (PessoaFisica) value;
        return pf.getNomeUsuario();
        
        /*
          a String retornada  será utilizada pelo componente JSF para ser exibida na tela do usuário.       
         */
        
    }
    
}
