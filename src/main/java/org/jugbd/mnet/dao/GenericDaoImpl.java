package org.jugbd.mnet.dao;

import org.jugbd.mnet.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Bazlur Rahman Rokon on 7/5/14.
 */
public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {
    private static final Logger log = LoggerFactory.getLogger(GenericDaoImpl.class);

    protected Class<T> entityClass;

    @PersistenceContext
    protected EntityManager entityManager;

    public GenericDaoImpl() {
        log.debug("GenericDaoImpl()");

        ParameterizedType genericSuperclass = (ParameterizedType) getClass()
                .getGenericSuperclass();

        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }

    @Override
    public T save(T entity) {
        log.debug("save() -{}", entity.toString());

        if (isNew(entity)) {
            log.debug("New entity found. so persisting it");
            this.entityManager.persist(entity);
        } else {
            log.debug("Entity is existing. so merging it");
            this.entityManager.merge(entity);
        }
        return entity;
    }

    @Override
    public T findOne(PK id) {
        log.debug("findOne() by id - {}", id);
        Assert.notNull(id, "The given id must not be null!");

        return this.entityManager.find(entityClass, id);
    }

    @Override
    public void delete(PK id) {
        log.debug("delete() by id - {}", id);
        Assert.notNull(id, "The given id must not be null!");

        T ref = this.entityManager.getReference(entityClass, id);
        this.entityManager.remove(ref);
    }

    @Override
    public long count() {
        log.debug("count()");

        final StringBuffer queryString = new StringBuffer("SELECT count(o) from ");
        queryString.append(entityClass.getSimpleName()).append(" o ");
        log.debug("count() - query ={}", queryString.toString());

        final Query query = entityManager.createQuery(queryString.toString());
        return (Long) query.getSingleResult();
    }

    @Override
    public List<T> findAll() {
        log.debug("findAll() ");

        return entityManager.createQuery("from " + entityClass.getName()).getResultList();
    }

    @Override
    public EntityManager getEntityManager() {
        log.debug("getEntityManager()");
        return entityManager;
    }

    private boolean isNew(T entity) {
        log.debug("isNew()");
        return Utils.isNew(entity);
    }
}
