package com.aed.service.cms.impl;

import com.aed.core.bean.ResponseErrorEnum;
import com.aed.core.bean.Result;
import com.aed.core.constants.Constants;
import com.aed.dao.ActiveCodeDao;
import com.aed.dao.AppUserDao;
import com.aed.domain.ActiveCode;
import com.aed.domain.AppUser;
import com.aed.service.cms.ActiveCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by 刘东旭 on 2018/10/15.
 */
@Service
public class ActiveCodeServiceImpl implements ActiveCodeService {

    @Autowired
    private AppUserDao appUserDao;
    @Autowired
    private ActiveCodeDao activeCodeDao;

    @Override
    public Result generateCode(String mobile, int num) {
        AppUser appUser = appUserDao.findByMobile(mobile);
        if (appUser == null) return Result.buildFail(ResponseErrorEnum.NOT_EXIST_APP_USER);
        Set<String> codes = new HashSet<>();
        randomNotRepeat(num, codes);
        List<ActiveCode> activeCodeList = codes.stream().map(s -> {
            ActiveCode activeCode = new ActiveCode();
            activeCode.setAccount(mobile);
            activeCode.setCode(s);
            activeCode.setStatus(Constants.STATUS_OFF);
            activeCode.setCreateTime(new Date());
            return activeCode;
        }).collect(Collectors.toList());
        activeCodeDao.insertAll(activeCodeList);
        return Result.buildOk();
    }

    @Override
    public List<ActiveCode> getCodes(String mobile, int page, int size) {
        Query query = Query.query(Criteria.where("account").is(mobile));
        query.with(Sort.by(Sort.Order.desc("createTime")));
        page = page > 0 ? page : 1;
        int skip = (page - 1) * size;
        return activeCodeDao.findList(query, skip, size);
    }

    @Override
    public long count(String mobile) {
        Query query = Query.query(Criteria.where("account").is(mobile));
        return activeCodeDao.count(query);
    }

    private String randomString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int intVal = (int) (Math.random() * 26 + 97);
            result.append((char) intVal);
        }
        return result.toString();
    }

    private int randomInt() {
        Random random = new Random();
        int x = random.nextInt(899999);
        x = x + 100000;
        return x;
    }

    private void randomNotRepeat(int num, Set<String> set) {
        for (int i = 0; i < num; i++) {
            set.add(String.valueOf(randomInt()));
        }
        int setSize = set.size();
        if (setSize < num) {
            randomNotRepeat(num - setSize, set);
        }
    }


}
