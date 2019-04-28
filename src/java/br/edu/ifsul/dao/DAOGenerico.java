
package br.edu.ifsul.dao;

import java.io.Serializable;
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
            
    public DAOGenerico(Class<TipoGenerics> clazz) {
       this.classePersistente = clazz;
    }

    public List<TipoGenerics> getListaObjetos() {
       
        String jpql = "from " + classePersistente.getSimpleName();
        return em.createQuery(jpql).getResultList();
    }

    public TipoGenerics find(Object id){
     
          return em.find(classePersistente, id);
    }
    
    public List<TipoGenerics> getListaTodos() {
            String jpql = "from " + classePersistente.getSimpleName();
            
            return em.createQuery(jpql).getResultList();
    }

    public void persist(TipoGenerics obj) throws Exception {
            em.persist(obj);
    }

    public void merge(TipoGenerics obj) throws Exception {
            em.merge(obj);
    }

    public TipoGenerics getObjectById(Object id) throws Exception {
            return (TipoGenerics) em.find(classePersistente, id);
    }

    public void remover(TipoGenerics obj) throws Exception {
            obj = em.merge(obj);
            em.remove(obj);
    }

}
