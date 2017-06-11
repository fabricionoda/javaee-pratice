package br.com.fabricionoda.db1.pdi.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

public abstract class Repository<E extends Serializable> implements Serializable {

    private static final long serialVersionUID = -7010202708470973497L;

    @PersistenceContext
    private transient EntityManager em;

    public void save(E entity){
        final Object identifier = em.getEntityManagerFactory()
                .getPersistenceUnitUtil().getIdentifier(entity);
        if (identifier == null) {
            em.persist(entity);

        }
        em.merge(entity);
    }

    public void remove(E entity) {
        if (em.contains(entity)) {
            em.remove(entity);
        } else {
            em.remove(em.merge(entity));
        }
    }
}
