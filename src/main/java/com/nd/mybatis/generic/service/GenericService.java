/**
 * @copyright Copyright 1999-2015 © 99.com All rights reserved.
 * @license http://www.99.com/about
 */
package com.nd.mybatis.generic.service;

import java.util.List;

import com.nd.mybatis.generic.dao.GenericCriteria;

/**
 * @author SongDeQiang <mail.song.de.qiang@gmail.com>
 *
 * @param <Q>
 * @param <T>
 */
public interface GenericService<Q extends GenericCriteria<?>, T>
{
    /**
     * @param example
     * @return
     */
    public List<T> findAll(Q example);
    
    /**
     * @param example
     * @return
     */
    public int count(Q example);
    
    /**
     * @param example
     * @return
     */
    public T findOne(Q example);
    
    /**
     * @param record
     * @return
     */
    public int insert(T record);
    
    /**
     * @param record
     * @param example
     * @return
     */
    public int update(T record, Q example);
    
    /**
     * @param example
     * @return
     */
    public int delete(Q example);
}
