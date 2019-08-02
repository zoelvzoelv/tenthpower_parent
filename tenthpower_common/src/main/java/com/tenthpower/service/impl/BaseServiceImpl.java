package com.tenthpower.service.impl;

import com.tenthpower.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @param <V> Vo
 * @param <D> dao
 * @param <I> IdWorker
 */
@Service
public class BaseServiceImpl<V,D,I> implements BaseService<V,D,I> {


    @Override
    public List<V> findAll() throws Exception {
        return null;
    }

    @Override
    public V findById(String id) {
        return null;
    }

    @Override
    public void add(V vo) {

    }

    @Override
    public void update(V vo) {

    }

    @Override
    public void deleteById(String id) {

    }
}
