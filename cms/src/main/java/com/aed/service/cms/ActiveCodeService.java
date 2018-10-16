package com.aed.service.cms;

import com.aed.domain.ActiveCode;

import java.util.List;

/**
 * Created by 刘东旭 on 2018/10/15.
 */
public interface ActiveCodeService {

    int generateCode(String mobile,int num);

    List<ActiveCode> getCodes(String mobile,int page,int size);

    long count(String mobile);

}
