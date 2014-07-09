package org.jugbd.mnet.dao;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Bazlur Rahman Rokon on 7/5/14.
 */
public interface GenericDao<T, PK extends Serializable> {
    /**
     * Saves a given entity and returns the saved entity as the saved entity might have been changed after save operation
     *
     * @param entity
     * @return the saved entity
     */
    T save(T entity);

    /**
     * Retrieves an entity by its id
     *
     * @param id must not be null
     * @return the entity with the given {@code id} or {@literal null} if none found
     * @throws IllegalArgumentException in case the given {@code id} is {@literal null}
     */
    T findOne(PK id);

    /**
     * Deletes the entity with the given id.
     *
     * @param id must not be null
     * @throws java.lang.IllegalArgumentException  in case the given {@code id} is {@literal null}
     */
    void delete(PK id);

    /**
     * Returns the number of entities available.
     *
     * @return  the number of entities
     */
    long count();

    /**
     * Returns all instances of the type.
     *
     * @return all entities
     */
    List<T> findAll();

    /**
     * Returns instance of EntityManager for further use
     *
     * @return  entityManager
     */
    public EntityManager getEntityManager();
}
