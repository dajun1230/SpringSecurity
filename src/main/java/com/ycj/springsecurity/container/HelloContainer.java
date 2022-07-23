package com.ycj.springsecurity.container;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloContainer {

    @RequestMapping("/hello")
    @PreAuthorize("@ex.hasAuthority('system:dept:list')")
//    @PreAuthorize("hasAnyAuthority('system:dept:list')")
//    @PreAuthorize("hasAnyAuthority('admin', 'test', 'system:dept:list')")
//    @PreAuthorize("hasRole('system:dept:list')")
    public String hello() {
        return "Hello SpringSecurity";
    }


}
