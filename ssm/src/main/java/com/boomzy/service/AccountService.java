package com.boomzy.service;

import com.boomzy.domain.Account;

import java.util.List;

/**
 * @author boomzy
 * @date 2019/12/8 11:06
 */
public interface AccountService {
    /**
     * 查询所有账户信息
     *
     * @return
     */
    public List<Account> findAll();

    /**
     * 保存账户信息
     *
     * @param account
     */
    public void saveAccount(Account account);
}
