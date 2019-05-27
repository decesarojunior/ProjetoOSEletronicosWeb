/*
 * 
 */
package br.edu.ifsul.converter;

import br.edu.ifsul.dao.CidadeDAO;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import br.edu.ifsul.modelo.Cidade;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Telmo
 */

@Named(value = "converterCidade")
@RequestScoped
public class ConverterCidade implements Converter, Serializable {

    @EJB
    private CidadeDAO dao;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        if(value == null || value.equals("Selecione") || value.equals("Selecione um registro")){
            return null;
        }
        return dao.find(Integer.parseInt(value));
        
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null){
            return null;
        }
        Cidade c = (Cidade) value;    
        return c.getId().toString();
        
    }
    
}
