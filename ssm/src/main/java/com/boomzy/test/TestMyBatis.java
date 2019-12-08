package com.boomzy.test;

import com.boomzy.dao.AccountDao;
import com.boomzy.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author boomzy
 * @date 2019/12/8 16:33
 */
public class TestMyBatis {

    /**
     * 测试查询
     *
     * @throws IOException
     */
    @Test
    public void run1() throws IOException {
        // 加载MyBatis配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 使用工厂来创建SqlSession
        SqlSession session = factory.openSession();
        // 获取到代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        // 查询所有账户信息
        List<Account> list = dao.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
        // 关闭资源
        session.close();
        in.close();
    }

    /**
     * 测试保存
     *
     * @throws IOException
     */
    @Test
    public void run2() throws IOException {
        // 加载MyBatis配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 使用工厂来创建SqlSession
        SqlSession session = factory.openSession();
        // 获取到代理对象
        AccountDao dao = session.getMapper(AccountDao.class);

        Account account = new Account();
        account.setName("ww");
        account.setMoney(120d);
        dao.saveAccount(account);
        // 提交事务
        session.commit();
        // 关闭资源
        session.close();
        in.close();
    }
}
