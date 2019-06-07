package br.edu.ifsul.controle;

import br.edu.ifsul.dao.ProdutoDAO;
import br.edu.ifsul.util.UtilRelatorios;
import java.io.Serializable;
import java.util.HashMap;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Telmo
 */

@Named(value = "controleProduto")
@ViewScoped
public class ControleProduto implements Serializable {
    
    @EJB
    private ProdutoDAO dao;
    
    public ControleProduto(){
        
    }
    
    
    public void imprimirProdutos() {
        HashMap parametros = new HashMap();
        UtilRelatorios.imprimeRelatorio("Blank_A4", parametros, dao.getListaTodos());
    }
    
    
    
}
