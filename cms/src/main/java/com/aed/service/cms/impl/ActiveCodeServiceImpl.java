package com.aed.service.cms.impl;

import com.aed.domain.ActiveCode;
import com.aed.service.cms.ActiveCodeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 刘东旭 on 2018/10/15.
 */
@Service
public class ActiveCodeServiceImpl implements ActiveCodeService {
    @Override
    public int generateCode(String mobile, int num) {
        return 0;
    }

    @Override
    public List<ActiveCode> getCodes(String mobile, int page, int size) {
        return null;
    }

    @Override
    public long count(String mobile) {
        return 0;
    }
}
