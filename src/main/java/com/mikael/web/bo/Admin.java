package com.mikael.web.bo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Admin {

    private Integer id;
    private String name;
    private String password;

}
