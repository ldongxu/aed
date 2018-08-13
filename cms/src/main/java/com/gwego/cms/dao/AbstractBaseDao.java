package com.gwego.cms.dao;

import com.gwego.cms.domain.BaseBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

/**
 * @author liudongxu06
 * @date 2018/8/13
 */
public abstract class AbstractBaseDao<T extends BaseBean> implements BaseDao<T> {
    protected Logger logger = LoggerFactory.getLogger(AbstractBaseDao.class);
    @Autowired
    protected MongoTemplate mongoTemplate;

    private Class<T> clazz;

    protected Class<T> getClazz(){
        if (clazz==null)
            clazz = ((Class<T>) (((ParameterizedType) (this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]));
        return clazz;
    }

    @Override
    public void insert(T t) {
        mongoTemplate.insert(t);
    }

    @Override
    public T findById(String id) {
        return mongoTemplate.findById(id, getClazz());
    }

    @Override
    public List<T> findAll() {
        return mongoTemplate.findAll(getClazz());
    }

    @Override
    public List<T> findList(int skip, int limit) {
        Query query = new Query();
        query.with(new Sort(Sort.Direction.ASC,BaseBean.ID));
        query.skip(skip).limit(limit);
        return mongoTemplate.find(query,getClazz());
    }

    @Override
    public List<T> findByQuery(Query query) {
        return mongoTemplate.find(query,getClazz());
    }

    @Override
    public void deleteById(String id) {
        Query query = Query.query(Criteria.where(BaseBean.ID).is(id));
        mongoTemplate.remove(query);
    }

    @Override
    public void update(String id, Map<String, Object> params) {
        Query query = Query.query(Criteria.where(BaseBean.ID).is(id));
        Update update = new Update();
        if (params!=null && !params.isEmpty()){
            for (String key:params.keySet()){
                update.set(key,params.get(key));
            }
        }
        mongoTemplate.updateFirst(query,update,getClazz());
    }
}
