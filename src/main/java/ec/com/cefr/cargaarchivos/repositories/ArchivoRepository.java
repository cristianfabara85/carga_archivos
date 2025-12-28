package ec.com.cefr.cargaarchivos.repositories;

import ec.com.cefr.cargaarchivos.models.Campania;
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

    public List<Campania> findAll(){
       return em.createQuery("select  c from Campania c",Campania.class).getResultList();
    }

    public List<Campania> findById(Integer id){
        return em.createQuery("select  c from Campania c where c.codigoCampania =:id",Campania.class).setParameter("id",Long.valueOf(id)).getResultList();
    }

}
