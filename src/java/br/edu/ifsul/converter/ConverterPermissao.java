
package br.edu.ifsul.converter;

import br.edu.ifsul.dao.PermissaoDAO;
import br.edu.ifsul.modelo.Permissao;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

/**
 *
 * @author Telmo
 */

@Named(value = "converterPermissao")
@RequestScoped
public class ConverterPermissao  implements Converter, Serializable{
    
    @EJB
    private PermissaoDAO dao;
    
    public ConverterPermissao(){
        
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        if(value == null || value.equals("Selecione um Registro"))
            return null;
        
        Permissao prm = dao.find(value);
        
        return prm;
        
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       
        if(value == null){
            return null;
        }
        
        Permissao prm = (Permissao) value;
        return prm.getNome();
        
    }
    
}
