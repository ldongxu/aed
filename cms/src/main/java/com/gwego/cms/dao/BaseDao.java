package com.gwego.cms.dao;

import com.gwego.cms.domain.BaseBean;
import com.mongodb.client.result.UpdateResult;
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

    T findOneByQuery(Query query);

    void deleteById(String id);

    UpdateResult upset(T query,T update);

    UpdateResult upset(T update);

    UpdateResult update(String id, Map<String,Object> params);

    UpdateResult update(T updateBean);

    UpdateResult update(T query,T update);

    T findAndModify(T update);

    T findAndModify(T query,T update);

    long count(T query);

    long count(Query query);


}
