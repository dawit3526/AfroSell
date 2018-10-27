/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eri.afrosell.controller;
import com.eri.afrosell.config.AppConfig;
import com.eri.afrosell.model.AuthUser;
import com.eri.afrosell.response.util.ResponseUtil;
import com.eri.afrosell.service.auth.CustomUserAuthService;
import com.eri.afrosell.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * Setting up some stuff using for all API
 *
 */
public abstract class AbstractBaseController {
    
    @Autowired
    private CustomUserAuthService userDetailsService;

    @Autowired
    AppConfig appConfig;

    @Autowired
    protected ResponseUtil responseUtil;
    
    public AuthUser getAuthUserFromSession(HttpServletRequest request) {
        String authToken = request.getHeader(Constant.HEADER_TOKEN);
        // try to load sessio
        AuthUser user = userDetailsService.loadUserByAccessToken(authToken);
        return user;
    }
}
