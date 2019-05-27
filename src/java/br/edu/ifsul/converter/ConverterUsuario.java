/*
 * 
 */
package br.edu.ifsul.converter;

import br.edu.ifsul.dao.UsuarioDAO;
import br.edu.ifsul.modelo.Usuario;
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

@Named(value = "converterUsuario")
@RequestScoped
public class ConverterUsuario  implements Serializable, Converter  {
    
    @EJB
    private UsuarioDAO dao; 
    
    public ConverterUsuario(){
        
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        if(value == null || value.equals("Selecione") || value.equals("Selecione um registro")){
            return null;
        }
        
        Usuario pf = null;
        try{
            pf =  dao.getObjectById(value);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return pf;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
         if(value == null){
            return null;
        }
        
        Usuario pf =  (Usuario) value;
        return pf.getNomeUsuario();
    }
    
}
