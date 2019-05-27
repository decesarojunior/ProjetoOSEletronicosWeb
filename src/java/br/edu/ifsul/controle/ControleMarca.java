/*
 * 
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.MarcaDAO;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Telmo
 */
@Named(value = "controleMarca")
@ViewScoped
public class ControleMarca implements Serializable {
    
    @EJB
    private MarcaDAO dao;
    
    public ControleMarca(){
        
    } 

    public MarcaDAO getDao() {
        return dao;
    }
    
    
    
}
