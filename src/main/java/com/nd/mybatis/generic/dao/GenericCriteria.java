/**
 * @copyright Copyright 1999-2016 © 99.com All rights reserved.
 * @license http://www.99.com/about
 */
package com.nd.mybatis.generic.dao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SongDeQiang <mail.song.de.qiang@gmail.com>
 *
 * @param <C>
 */
public abstract class GenericCriteria<C>
{
    /**
     * @return
     */
    protected abstract C createCriteriaInternal();
    
    private String groupByClause;
    
    private String orderByClause;

    private boolean distinct;

    private List<C> oredCriteria;

    private int limitStart = -1;

    private int limitEnd = -1;
    
    public GenericCriteria()
    {
        this.oredCriteria = new ArrayList<C>();
    }

    /**
     * @return the groupByClause
     */
    public String getGroupByClause()
    {
        return groupByClause;
    }

    /**
     * @param groupByClause the groupByClause to set
     */
    public void setGroupByClause(String groupByClause)
    {
        this.groupByClause = groupByClause;
    }

    public void setOrderByClause(String orderByClause)
    {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause()
    {
        return orderByClause;
    }

    public void setDistinct(boolean distinct)
    {
        this.distinct = distinct;
    }

    public boolean isDistinct()
    {
        return distinct;
    }

    public List<C> getOredCriteria()
    {
        return oredCriteria;
    }

    public void or(C example)
    {
        oredCriteria.add(example);
    }

    public C or() {
        C criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public C createCriteria() {
        C criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }
    
    public void clear()
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimitStart(int limitStart)
    {
        this.limitStart = limitStart;
    }

    public int getLimitStart()
    {
        return limitStart;
    }

    public void setLimitEnd(int limitEnd)
    {
        this.limitEnd = limitEnd;
    }

    public int getLimitEnd()
    {
        return limitEnd;
    }
    
    public static class Criterion
    {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition()
        {
            return condition;
        }

        public Object getValue()
        {
            return value;
        }

        public Object getSecondValue()
        {
            return secondValue;
        }

        public boolean isNoValue()
        {
            return noValue;
        }

        public boolean isSingleValue()
        {
            return singleValue;
        }

        public boolean isBetweenValue()
        {
            return betweenValue;
        }

        public boolean isListValue()
        {
            return listValue;
        }

        public String getTypeHandler()
        {
            return typeHandler;
        }

        public Criterion(String condition)
        {
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        public Criterion(String condition, Object value, String typeHandler)
        {
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>)
            {
                this.listValue = true;
            }
            else
            {
                this.singleValue = true;
            }
        }

        public Criterion(String condition, Object value)
        {
            this(condition, value, null);
        }

        public Criterion(String condition, Object value, Object secondValue, String typeHandler)
        {
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        public Criterion(String condition, Object value, Object secondValue)
        {
            this(condition, value, secondValue, null);
        }
    }

}
