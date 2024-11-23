package com.mikael.web.test.thread.day012;

/**
 * 枚举类似于数据库,保存数据(A,B,C,D中的数据)
 */
public enum PersonEnum {
    A(1, "q"),
    B(2, "w"),
    C(3, "e"),
    D(4, "r");

    int code;
    String neme;

    PersonEnum(int i, String r) {
        this.code = i;
        this.neme = r;
    }

    public static PersonEnum getPersonEnum(int index) {

        PersonEnum[] values = PersonEnum.values();
        for (PersonEnum value : values) {
            //
            if (index == value.getCode()) {

                return value;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNeme() {
        return neme;
    }

    public void setNeme(String neme) {
        this.neme = neme;
    }
}
