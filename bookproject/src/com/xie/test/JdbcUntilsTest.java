package com.xie.test;

import com.xie.utils.JdbcUtils;
import org.junit.Test;

/**
 * @author xie
 * @create 2022-11-05
 */
public class JdbcUntilsTest {
    @Test
    public void testJdbc(){
        System.out.println(JdbcUtils.getConnection());
    }
}
