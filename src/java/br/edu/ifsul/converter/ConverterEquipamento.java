/*
 * 
 */
package br.edu.ifsul.converter;

import br.edu.ifsul.dao.EquipamentoDAO;
import br.edu.ifsul.modelo.Equipamento;
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
@Named(value = "converterEquipamento")
@RequestScoped
public class ConverterEquipamento   implements Serializable, Converter  {
    
    @EJB
    private EquipamentoDAO dao;
    
    public ConverterEquipamento(){
        
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        if(value == null || value.equals("Selecione") || value.equals("Selecione um registro")){
            return null;
        }
        Equipamento pf =  dao.find(Integer.parseInt(value));
        return pf;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
        if(value == null){
            return null;
        }
        
        Equipamento eqp =  (Equipamento) value;
        return eqp.getId().toString();
    }
    
}
