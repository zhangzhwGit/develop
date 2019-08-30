package com.zzw.login.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @name TestController
 * @description
 * @date 2019-08-29
 */
@Controller
@RequestMapping("/service")
public class TestController {


    @RequestMapping("/getAll")
    @RequiresRoles("role_admin")
    public String toGetAll() {
        return "/service/service_admin";
    }

    @RequestMapping("/getAny")
    @RequiresRoles("role_user")
    public String toGetAny() {
        return "service/service_user";
    }

    @RequestMapping("/getService")
    public String toGetService(){
        return "service/service_none";
    }
}
