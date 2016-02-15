package com.fabrefrederic.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Generic interface DAO
 *
 * @param <T> Entity
 */
public interface GenericDao<T> extends Serializable {

    /**
     * Gets the class type to manage
     *
     * @return entity bean type
     */
    Class<T> getEntityBeanType();

    /**
     * Sets the class type to manage
     *
     * @param classToSet class to set
     */
    void setClazz(final Class<T> classToSet);

    /**
     * Search for an entity by its id
     *
     * @param id bean id
     * @return bean type
     */
    T findById(final Integer id);

    /**
     * Search for all the entities
     *
     * @return beans list
     */
    List<T> findAll();

    /**
     * Save an entity
     *
     * @param entity the entity to persist
     */
    void save(final T entity);

    /**
     * Update an entity
     *
     * @param entity the persisted entity to update
     */
    void update(final T entity);

    /**
     * Deletes an entity
     *
     * @param entity the en entity to delete
     */
    void delete(final T entity);

    /**
     * Deletes an entity by its id
     *
     * @param entityId entity bean id to delete
     */
    void deleteById(final Integer entityId);

    /**
     * Flush
     */
    void flush();
}