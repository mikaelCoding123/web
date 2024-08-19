package com.mikael.web.bo;


import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Admin {


    @Size(min = 2, max = 5)
    private Integer id;
    private String name;
    private String password;

}
