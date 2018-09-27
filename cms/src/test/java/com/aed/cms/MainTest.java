package com.aed.cms;

import org.apache.shiro.authc.credential.DefaultPasswordService;

import java.io.IOException;

/**
 * @author liudongxu06
 * @date 2018/7/25
 */
public class MainTest {
    public static void main(String[] args) throws IOException {
      DefaultPasswordService s = new DefaultPasswordService();
      String str = s.encryptPassword("admin");
        System.out.println(str);
        System.out.println(s.encryptPassword("admin"));
       boolean f = new DefaultPasswordService().passwordsMatch("admin","$shiro1$SHA-256$500000$QmzJ3gUClLTc8lK2EYEqyg==$n3CHuEYCYjI0a1YQE/F94mHCw7GR8TjRVtfd72UySqQ=");
        System.out.println(f);
    }
}
