/**
 * @copyright Copyright 1999-2015 © 99.com All rights reserved.
 * @license http://www.99.com/about
 */
package com.nd.mybatis.generic.service;

import java.util.List;

import com.nd.mybatis.generic.dao.GenericCriteria;
import com.nd.mybatis.generic.dao.GenericMapper;

/**
 * @author SongDeQiang <mail.song.de.qiang@gmail.com>
 *
 * @param <Q>
 * @param <T>
 */
public abstract class GenericServiceImpl<Q extends GenericCriteria<?>, T> implements GenericService<Q, T>
{
    private GenericMapper<Q, T> mapper;
    
    protected void setMapper(GenericMapper<Q, T> mapper)
    {
        this.mapper = mapper;
    }
    
    /**
     * @param example
     * @return
     */
    @Override
    public List<T> findAll(Q example)
    {
        return mapper.selectByExample(example);
    }

    /**
     * @param example
     * @return
     */
    @Override
    public int count(Q example)
    {
        return mapper.countByExample(example);
    }

    /**
     * @param example
     * @return
     */
    @Override
    public T findOne(Q example)
    {
        List<T> el = mapper.selectByExample(example);
        
        return (el == null || el.isEmpty()) ? null : el.iterator().next();
    }

    /**
     * @param record
     * @return
     */
    @Override
    public int insert(T record)
    {
        return mapper.insertSelective(record);
    }

    /**
     * @param record
     * @param example
     * @return
     */
    @Override
    public int update(T record, Q example)
    {
        return mapper.updateByExampleSelective(record, example);
    }

    /**
     * @param example
     * @return
     */
    @Override
    public int delete(Q example)
    {
        return mapper.deleteByExample(example);
    }
}
