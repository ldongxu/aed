package com.aed.dao;

import com.aed.core.exception.ParamException;
import com.aed.core.util.JsonUtil;
import com.aed.domain.BaseBean;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.apache.commons.lang3.StringUtils;
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

    protected Class<T> getClazz() {
        if (clazz == null)
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
        query.with(new Sort(Sort.Direction.ASC, BaseBean.ID));
        query.skip(skip).limit(limit);
        return mongoTemplate.find(query, getClazz());
    }

    @Override
    public List<T> findByQuery(Query query) {
        return mongoTemplate.find(query, getClazz());
    }

    @Override
    public T findOneByQuery(Query query) {
        return mongoTemplate.findOne(query, getClazz());
    }

    @Override
    public DeleteResult deleteById(String id) {
        Query query = Query.query(Criteria.where(BaseBean.ID).is(id));
        return mongoTemplate.remove(query);
    }

    @Override
    public UpdateResult update(String id, Map<String, Object> params) {
        Query query = Query.query(Criteria.where(BaseBean.ID).is(id));
        Update update = new Update();
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                update.set(key, params.get(key));
            }
        }
        return mongoTemplate.updateFirst(query, update, getClazz());
    }

    @Override
    public UpdateResult update(T updateBean) {
        if (StringUtils.isBlank(updateBean.getId())) {
            logger.error("update ID attribute can not blank");
            throw new ParamException("update ID attribute can not blank");
        }
        Query query = Query.query(Criteria.where(BaseBean.ID).is(updateBean.getId()));
        Update update = toUpdate(updateBean);
        return mongoTemplate.updateFirst(query, update, getClazz());

    }

    @Override
    public UpdateResult upset(T query, T update) {
       return mongoTemplate.upsert(toQuery(query),toUpdate(update),getClazz());
    }

    @Override
    public UpdateResult upset(T update) {
        if (StringUtils.isBlank(update.getId())) {
            logger.error("update ID attribute can not blank");
            throw new ParamException("update ID attribute can not blank");
        }
        Query query = Query.query(Criteria.where(BaseBean.ID).is(update.getId()));
        return mongoTemplate.upsert(query,toUpdate(update),getClazz());
    }

    @Override
    public UpdateResult update(T query, T update) {
        return mongoTemplate.updateFirst(toQuery(query),toUpdate(update),getClazz());
    }

    @Override
    public T findAndModify(T update) {
        if (StringUtils.isBlank(update.getId())) {
            logger.error("update ID attribute can not blank");
            throw new ParamException("update ID attribute can not blank");
        }
        Query query = Query.query(Criteria.where(BaseBean.ID).is(update.getId()));
        return mongoTemplate.findAndModify(query,toUpdate(update),getClazz());
    }

    @Override
    public T findAndModify(T query, T update) {
        return mongoTemplate.findAndModify(toQuery(query),toUpdate(update),getClazz());
    }

    @Override
    public long count(T query) {
        return mongoTemplate.count(toQuery(query),getClazz());
    }

    @Override
    public long count(Query query) {
        return mongoTemplate.count(query,getClazz());
    }

    protected Query toQuery(T queryEntity){
        return toQuery(new Query(),"",queryEntity);
    }

    private Query toQuery(Query query,String parentKey, T queryEntity) {
        String json = JsonUtil.toJson(queryEntity);
        Map<String, Object> map = JsonUtil.toMap(json);
        if (query ==null) query = new Query();
        for (String key:map.keySet()){
            if (map.get(key) instanceof BaseBean){
                toQuery(query,parentKey+key+".", (T) map.get(key));
            }else if (map.get(key) != null){
                query.addCriteria(Criteria.where(parentKey+key).is(map.get(key)));
            }
        }
        return query;
    }

    protected Update toUpdate(T updateEntity) {
        return toUpdate(new Update(),"", updateEntity);
    }

    private Update toUpdate(Update update, String parentKey, T updateEntity) {
        String json = JsonUtil.toJson(updateEntity);
        Map<String, Object> map = JsonUtil.toMap(json);
        if (update == null) update = new Update();
        for (String key : map.keySet()) {
            if ("id".equals(key)) continue;
            if (map.get(key) instanceof BaseBean) {
                toUpdate(update, parentKey + key + ".", (T) map.get(key));
            } else if (map.get(key) != null) {
                update.set(parentKey + key, map.get(key));
            }
        }
        return update;
    }
}
