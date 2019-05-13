
package br.edu.ifsul.dao;

import br.edu.ifsul.converter.ConverterOrdem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Telmo
 */
public class DAOGenerico<TipoGenerics> implements Serializable {

    private List<TipoGenerics> listaObjetos;
    private List<TipoGenerics> listaTodos;
    
    @PersistenceContext(unitName = "ProjetoOSEletronicosWebPU")
    protected EntityManager em; 
    
    private final Class<TipoGenerics> classePersistente;
    
    
    protected String filtro = "";
    protected List<Ordem> listaOrdem = new ArrayList<>();
    protected Ordem ordemAtual;
    protected ConverterOrdem converterOrdem;
    protected Integer maximoObjetos = 8;
    protected Integer posicaoAtual = 0;
    protected Integer totalObjetos = 0;
    
    
    public DAOGenerico(Class<TipoGenerics> clazz) {
       this.classePersistente = clazz;
    }

    public List<TipoGenerics> getListaObjetos() {
       
        String jpql = "from " + classePersistente.getSimpleName();
        String where = "";
        
        // removendo caracteres para proteger de sql injection
        filtro = getFiltro().replaceAll("[';-]", "");
        if (getFiltro().length() > 0) {
            switch (ordemAtual.getOperador()) {
                case "=":
                    if (ordemAtual.getAtributo().equals("id")) {
                        try{
                           //tenta converter para inteiro caso o usuario selecione id e nao passe um inteiro 
                           Integer.parseInt(getFiltro());
                        }catch(NumberFormatException e){
                            filtro = "0";
                        }                        
                    }
                    where += " where " + ordemAtual.getAtributo() + " = '" + getFiltro() + "' ";
                    break;    
                case "like":
                    where += " where upper(" + ordemAtual.getAtributo() + ") like '" + getFiltro().toUpperCase() + "%' ";                   
                break;                
            }             
        }
        jpql += where;
        jpql += " order by " + ordemAtual.getAtributo();
        System.out.println("JPQL: " + jpql);
        totalObjetos = em.createQuery(jpql).getResultList().size();
        
        return em.createQuery(jpql).
                setFirstResult(posicaoAtual).
                setMaxResults(getMaximoObjetos()).getResultList(); 
                
    }
    
    public void primeiro() {
        posicaoAtual = 0;
    }

    public void anterior() {
        posicaoAtual -= getMaximoObjetos();
        if (posicaoAtual < 0) {
            posicaoAtual = 0;
        }
    }

    public void proximo() {
        if (posicaoAtual + getMaximoObjetos() < totalObjetos) {
            posicaoAtual += getMaximoObjetos();
        }
    }

    public void ultimo() {
        int resto = totalObjetos % getMaximoObjetos();
        if (resto > 0) {
            posicaoAtual = totalObjetos - resto;//total - resta da divisao
        } else {
            posicaoAtual = totalObjetos - getMaximoObjetos();//total  menos a quantia por pagina
        }
    }    
    
    public String getMensagemNavegacao() {
        int ate = posicaoAtual + getMaximoObjetos();
        if (ate > totalObjetos) {
            ate = totalObjetos;
        }
        if (totalObjetos > 0) {
            return "Listagem de " + (posicaoAtual + 1) + " até " + ate
                    + " de " + totalObjetos + " registros";
        } else {
            return "Nenhum registro encontrado!";
        }
    }

    public TipoGenerics find(Object id){
     
          return em.find(classePersistente, id);
    }
    
    public List<TipoGenerics> getListaTodos() {
            String jpql = "from " + classePersistente.getSimpleName();
            //  + " order by "+ ordemAtual.getAtributo()
            
            return em.createQuery(jpql).getResultList();
    }

    public void persist(TipoGenerics obj) throws Exception {
            em.persist(obj);
    }

    public void merge(TipoGenerics obj) throws Exception {
            em.merge(obj);
    }

    public TipoGenerics getObjectById(Object id) throws Exception {
            System.out.println("classePersistente: "+classePersistente);
            return (TipoGenerics) em.find(classePersistente, id);
    }

    public void remover(TipoGenerics obj) throws Exception {
            obj = em.merge(obj);
            em.remove(obj);
    }

    public Integer getMaximoObjetos() {
        return maximoObjetos;
    }
    
    public void setMaximoObjetos(Integer maximoObjetos) {
        this.maximoObjetos = maximoObjetos;
    }

    public String getFiltro() {
        return filtro;
    }
    
    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public ConverterOrdem getConverterOrdem() {
        return converterOrdem;
    }
    
    public List<Ordem>  getListaOrdem() {
        return listaOrdem;
    }

    public Ordem getOrdemAtual() {
        return ordemAtual;
    }
    
    public void setOrdemAtual(Ordem ordemAtual) {
       this.ordemAtual = ordemAtual;
    }
}
