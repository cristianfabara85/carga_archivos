package ec.com.cefr.carga_archivos.repositories;

import ec.com.cefr.carga_archivos.models.Campania;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class ArchivoRepository  {

    @PersistenceContext(unitName = "campaignPU")
    private EntityManager em;

    public void save(Campania campania){
        em.persist(campania);
    }

    public List<Campania> findAll(Campania campania){
       return em.createQuery("select  c from campania c",Campania.class).getResultList();
    }

    public List<Campania> findById(Integer id){
        return em.createQuery("select  c from campania c where c.codigoCampania =:id",Campania.class).setParameter("id",id).getResultList();
    }

}
