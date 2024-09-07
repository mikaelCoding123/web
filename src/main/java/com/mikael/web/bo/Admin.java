package com.mikael.web.bo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Admin {


    private Integer id;
    @Size(min = 2, max = 10, message = "用户名长度在2到20之间")
    private String name;
    private String password;

}
