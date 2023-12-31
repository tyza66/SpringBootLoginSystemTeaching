package com.tyza66.logindemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: tyza66
 * Date: 2023/6/19 17:16
 * Github: https://github.com/tyza66
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    Integer id;
    String username;
    String password;
    Integer power;
}
