package com.example.demo;

import java.io.Serializable;


import lombok.Data;

@Data
/**
 * @Program: cloud-study
 * @Description: AuthUser 实体类
 * @Author: Sun
 * @Create: 2019-04-19 12:16
 * @Version: 1.0
 */
public class AuthUser implements Serializable {
    private Long id;
    private String name;
    private String account;
    private String pwd;
}