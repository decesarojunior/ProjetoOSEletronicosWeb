
package br.edu.ifsul.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Telmo
 */
public class DAOGenerico<TIPO> implements Serializable {

    private List<TIPO> listaObjetos;
    private List<TIPO> listaTodos;
    @PersistenceContext(unitName = "ProjetoOSEletronicosWebPU")
    protected EntityManager em;
    protected Class classePersistente;    


    public DAOGenerico() {

    }

    public List<TIPO> getListaObjetos() {
            String jpql = "from " + classePersistente.getSimpleName();      
            return em.createQuery(jpql).getResultList();
    }


    public List<TIPO> getListaTodos() {
            String jpql = "from " + classePersistente.getSimpleName() ;
            return em.createQuery(jpql).getResultList();
    }

    public void persist(TIPO obj) throws Exception {
            em.persist(obj);
    }

    public void merge(TIPO obj) throws Exception {
            em.merge(obj);
    }

    public TIPO getObjectById(Object id) throws Exception {
            return (TIPO) em.find(classePersistente, id);
    }

    public void remover(TIPO obj) throws Exception {
            obj = em.merge(obj);
            em.remove(obj);
    }

}
