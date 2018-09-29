package com.aed.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liudongxu06
 * @date 2018/6/19
 */
public class BaseBean implements Serializable{
    public static final String ID = "_id";

    @Id
    private String id;

    /**
     * 以下属性做扩展字段使用，数据库中不保存
     */
    @Transient
    private Map<String,Object> extMap;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, Object> getExtMap() {
        return extMap;
    }

    public void setExtMap(Map<String, Object> extMap) {
        this.extMap = extMap;
    }

    /**
     * 注意不是线程安全
     */
    public Object getExtVal(String key){
        return extMap!=null?extMap.get(key):null;
    }

    /**
     * 注意不是线程安全
     */
    public void setExtVal(String key,Object val){
        if (extMap==null){
            extMap = new HashMap<>();
        }
        extMap.put(key,val);
    }
}
