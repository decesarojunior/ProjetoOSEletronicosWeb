/*
 * 
 */
package br.edu.ifsul.converter;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

/**
 *
 * @author Telmo Junior
 */
@Named(value = "converterCalendar") 
@RequestScoped
public class ConverterCalendar implements Serializable, Converter {
    
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");    
    public ConverterCalendar(){}
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {       
        try {
            Calendar retorno = Calendar.getInstance();
            retorno.setTime(sdf.parse(value));
            return retorno;
        } catch (Exception e) {
            return null;
        }
    }
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {        
        if(value == null){
            return null;
        }        
        Calendar c = (Calendar) value;       
        return sdf.format(c.getTime());
        
    }
    
    
    
}
