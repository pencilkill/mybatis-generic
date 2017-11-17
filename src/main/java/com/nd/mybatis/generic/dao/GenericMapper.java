/**
 * @copyright Copyright 1999-2016 © 99.com All rights reserved.
 * @license http://www.99.com/about
 */
package com.nd.mybatis.generic.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @author SongDeQiang <mail.song.de.qiang@gmail.com>
 *
 * @param <Q>
 * @param <T>
 */
public interface GenericMapper<Q extends GenericCriteria<?>, T>
{
    int countByExample(Q example);

    int deleteByExample(Q example);

    int insert(T record);

    int insertSelective(T record);

    List<T> selectByExample(Q example);

    int updateByExampleSelective(@Param("record") T record, @Param("example") Q example);

    int updateByExample(@Param("record") T record, @Param("example") Q example);
}
