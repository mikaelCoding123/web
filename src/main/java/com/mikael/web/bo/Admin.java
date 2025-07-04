package com.mikael.web.bo;


import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//引入正确的类
//import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Admin {


    private Integer id;
    @Size(min = 2, max = 10, message = "用户名长度在2到20之间")
    private String name;
    @Pattern(regexp = "", message = "不符合要求")
    private String password;

}
