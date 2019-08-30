package com.zzw.login.controller;

import com.zzw.login.factory.Md5Factory;
import com.zzw.login.pojo.ResponseResult;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginPageController {

    @GetMapping("/login")
    public String toLoginPage() {
        if (SecurityUtils.getSubject().isAuthenticated()) {
            return "redirect:/";
        }
        return "login/login_page";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseResult doPostLogin(String username, String password,
                            HttpServletResponse response, HttpServletRequest request, ModelMap model) {
        if (StringUtils.isBlank(username)) {
            model.addAttribute("loginMsg", "用户名不可为空！");
            return ResponseResult.fail("用户名不可为空！");
        }
        if (StringUtils.isBlank(password)) {
            model.addAttribute("loginMsg", "密码不可为空！");
            return ResponseResult.fail("密码不可为空！");
        }

        UsernamePasswordToken token = Md5Factory.getToken(username, password);
        Subject user = SecurityUtils.getSubject();
        try {
            user.login(token);
        } catch (UnknownAccountException u) {
            model.addAttribute("loginMsg", "用户不存在！");
            return ResponseResult.fail("用户不存在！");
        } catch (IncorrectCredentialsException i) {
            model.addAttribute("loginMsg", "密码错误！");
            return ResponseResult.fail("密码错误！");
        } catch (DisabledAccountException e) {
            model.addAttribute("loginMsg", "账户未启用！");
            return ResponseResult.fail("账户未启用！");
        } catch (RuntimeException e) {
            e.printStackTrace();
            model.addAttribute("loginMsg", "未知错误，请联系管理员！");
            return ResponseResult.fail("未知错误，请联系管理员！");
        }
        return ResponseResult.success();
    }

    @RequestMapping("/home")
    public String toHomePage() {
        return "login/home_page";
    }

    @RequestMapping("logout")
    public String toLogoutPage() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login/login_page";
    }

    @RequestMapping("/error")
    public String toErrorPage() {
        return "common/error_page";
    }

    @RequestMapping("/403")
    public String to403Page() {
        return "common/403";
    }

}
