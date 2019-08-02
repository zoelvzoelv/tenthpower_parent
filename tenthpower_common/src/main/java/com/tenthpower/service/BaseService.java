package com.tenthpower.service;

import java.util.List;

/**
 *
 * @param <V> Vo
 * @param <D> Dao
 */
public interface BaseService<V,D> {

    public List<V> findAll() throws Exception;

    public V findById(String id);

    public void add(V vo);

    public void update(V vo);

    public void deleteById(String id);
}
