package com.mikael.web.bo;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ModeType {

    @NotNull
    @Size(min = 2, max = 10)
    private String modeType;

}
