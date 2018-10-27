/*
 * Copyright (c) NIT-Software. All Rights Reserved.
 * This software is the confidential and proprietary information of NIT-Software,
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with NIT-Software.
 */
package com.eri.afrosell.service.auth;

import com.eri.afrosell.model.AuthUser;
import com.eri.afrosell.model.User;
import com.eri.afrosell.repositories.RoleRepository;
import com.eri.afrosell.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Quy Duong
 */

@Service
public class AuthUserFactoryImpl implements AuthUserFactory{
    @Autowired
    RoleRepository roleRepository;
    
    @Override
    public AuthUser createAuthUser(User user) {
        return new AuthUser(
                    user.getUserId(),
                    user.getEmail(),
                    user.getPasswordHash(),
                    getUserRoleString(user.getRoleId()),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getStatus() == Constant.STATUS.ACTIVE_STATUS.getValue()
            );
    }
    
    private String getUserRoleString (int roleId){
        try {
            return roleRepository.findOne(roleId).getName();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
