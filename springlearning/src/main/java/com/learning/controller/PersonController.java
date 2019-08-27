package com.learning.controller;

import com.google.gson.JsonObject;
import com.learning.pojo.PersonDTO;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class PersonController {
    /**
     * 自动类型转换
     **/
    @RequestMapping(value = "/add", produces = "text/plain;charset=utf-8")
    public String add(PersonDTO person) {
        System.out.println("do add()");
        return person.getName() + ":" + person.getAge();
    }

    /**
     * 需要 import com.google.gson.Gson（JSON 操作）
     **/
    @RequestMapping(value = "/check", produces = "text/plain;charset=utf-8")
    public String check(@Validated PersonDTO person, BindingResult bindResult) {
        JsonObject result = new JsonObject();
        StringBuilder errmsg = new StringBuilder();
        if (bindResult.hasErrors()) {
            List<ObjectError> errors = bindResult.getAllErrors();
            for (ObjectError error : errors) {
                errmsg.append(error.getDefaultMessage()+"|");
            }
            result.addProperty("status", -1);
        } else {
            result.addProperty("status", 1);
        }
        result.addProperty("errmsg", errmsg.toString());
        return result.toString();
    }

}
