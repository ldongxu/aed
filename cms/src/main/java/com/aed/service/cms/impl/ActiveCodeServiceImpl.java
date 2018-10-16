package com.aed.service.cms.impl;

import com.aed.core.bean.ResponseErrorEnum;
import com.aed.core.bean.Result;
import com.aed.core.exception.ApiException;
import com.aed.dao.ActiveCodeDao;
import com.aed.dao.AppUserDao;
import com.aed.domain.ActiveCode;
import com.aed.domain.AppUser;
import com.aed.service.cms.ActiveCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

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
        if (appUser == null) return Result.buildFail(ResponseErrorEnum.NOT_EXIS_APP_USER);
        Set<String> codes = new HashSet<>();
        randomNotRepeat(num,codes);

        return Result.buildOk();
    }

    @Override
    public List<ActiveCode> getCodes(String mobile, int page, int size) {
        return null;
    }

    @Override
    public long count(String mobile) {
        return 0;
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
