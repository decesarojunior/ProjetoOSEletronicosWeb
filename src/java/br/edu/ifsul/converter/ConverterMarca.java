
package br.edu.ifsul.converter;

import br.edu.ifsul.dao.MarcaDAO;
import br.edu.ifsul.modelo.Marca;
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

@Named(value = "converterMarca") 
@RequestScoped
public class ConverterMarca implements Serializable, Converter {
    
    @EJB
    private MarcaDAO dao;
    
    public ConverterMarca(){
        
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value == null || value.equals("Selecione") || value.equals("Selecione um registro")){
            return null;
        }
       
        return  dao.find(Integer.parseInt(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
               if(value == null){
            return null;
        }
        
        Marca pf =  (Marca) value;
        return pf.getId().toString();
    }
    
    
    
}
