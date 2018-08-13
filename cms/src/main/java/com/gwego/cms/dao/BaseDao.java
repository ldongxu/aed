package com.gwego.cms.dao;

import com.gwego.cms.domain.BaseBean;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.Map;

/**
 * @author liudongxu06
 * @date 2018/8/13
 */
public interface BaseDao<T extends BaseBean> {

    void insert(T t);

    T findById(String id);

    List<T> findAll();

    List<T> findList(int skip,int limit);

    List<T> findByQuery(Query query);

    void deleteById(String id);

    void update(String id, Map<String,Object> params);





}
