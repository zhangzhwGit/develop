package com.zzw.login.filter;

import com.zzw.login.pojo.SysUser;
import com.zzw.login.service.SysUserManagerService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.List;

/**
 * @name URLPathMatchingFilter
 * @description
 * @date 2019-08-29
 */
@Component
public class URLPathMatchingFilter extends PathMatchingFilter {

    @Autowired
    private SysUserManagerService sysUserManagerService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        String requestURI = getPathWithinApplication(request);
        // 如果没有登录，就跳转到登录页面
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
            WebUtils.issueRedirect(request, response, "/login");
            return false;
        }
        // 看看这个路径权限里有没有维护，如果没有维护，一律放行(也可以改为一律不放行)
        boolean needInterceptor = sysUserManagerService.needInterceptor(requestURI);
        if (!needInterceptor) {
            return true;
        } else {
            SysUser user = (SysUser) subject.getPrincipal();
            List<String> permissionUrls = sysUserManagerService.getMenuListByUserId(user.getUserId());
            if (permissionUrls.contains(requestURI)){
                return true;
            }
            else {
                UnauthorizedException ex = new UnauthorizedException("当前用户没有访问路径 " + requestURI + " 的权限");

                subject.getSession().setAttribute("ex", ex);

                WebUtils.issueRedirect(request, response, "/403");
                return false;
            }
        }

    }
}
