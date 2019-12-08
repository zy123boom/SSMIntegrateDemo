package com.boomzy.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 账户
 *
 * @author boomzy
 * @date 2019/12/8 10:51
 */

@ToString
@Data
public class Account implements Serializable {
    private Integer id;
    private String name;
    private Double money;
}
