package com.learning.pojo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class PersonDTO {

    @NotNull(message = "姓名不能为空")
    private String name;

    @Min(value = 18,message = "年龄不能低于18岁")
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
